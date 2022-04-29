package Reggie.service.impl;

import Reggie.common.CustomException;
import Reggie.dto.DishDto;
import Reggie.dto.SetmealDto;
import Reggie.entity.Dish;
import Reggie.entity.DishFlavor;
import Reggie.entity.Setmeal;
import Reggie.entity.SetmealDish;
import Reggie.mapper.SetmealMapper;
import Reggie.service.SetmealDishService;
import Reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐，同时插入套餐对应的菜品数据，需要操作两张表：setmeal setmeal_Dish
     * @param setmealDto
     */
    @Transactional
    public void savaWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息到套餐表setmeal，进行insert操作
        this.save(setmealDto);
        //将setmeal表中mealId赋值给setmeal_Dish表中SetmealId
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((itme)->{
            itme.setSetmealId(setmealDto.getId());
            return itme;
        }).collect(Collectors.toList());
        //保存菜品数据到套餐菜品表setmeal_Dish，进行insert操作
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 根据id查询套餐的基本信息和对应的菜品信息，查询操作两张表：setmeal setmeal_Dish
     * @param id
     * @return
     */
    @Override
    public SetmealDto getByIdWithDish(Long id) {
        //查询套餐基本信息，从setmeal表中查询
        Setmeal setmeal = this.getById(id);
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal,setmealDto);
        //查询套餐的菜品信息，从setmeal_Dish表中查询
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> setmealDishList = setmealDishService.list(queryWrapper);
        setmealDto.setSetmealDishes(setmealDishList);
        return setmealDto;
    }

    /**
     * 修改套餐的基本信息和对应的菜品信息，修改操作两张表：setmeal setmeal_Dish
     * @param setmealDto
     */
    @Override
    @Transactional
    public void upDateWithDish(SetmealDto setmealDto) {
        //更新setmeal表的基本信息
        this.updateById(setmealDto);
        //先清理套餐对应的菜品 --- setmeal_Dish进行delete操作
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SetmealDish::getSetmealId,setmealDto.getId());
        setmealDishService.remove(queryWrapper);
        //在添加当前提交过来的菜品信息 --- setmeal_Dish进行insert操作
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes = setmealDishes.stream().map((itme)->{
            itme.setSetmealId(setmealDto.getId());
            return itme;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 根据id删除套餐的基本信息和对应的菜品信息，删除操作两张表：setmeal setmeal_Dish
     * @param ids
     */
    @Override
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态，确定是否可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        //如果不能删除，抛出一个业务异常
        int count = this.count(queryWrapper);
        if (count>0){
            throw new CustomException("套餐在售卖中，不能删除呢~");
        }
        //如果可以删除，先清理套餐对应的菜品 --- setmeal_Dish进行delete操作
        LambdaQueryWrapper<SetmealDish> queryWrappers = new LambdaQueryWrapper<>();
        queryWrappers.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(queryWrappers);
        //删除dish表的基本信息
        this.removeByIds(ids);
    }
}
