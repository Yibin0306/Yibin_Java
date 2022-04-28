package Reggie.service.impl;

import Reggie.common.CustomException;
import Reggie.dto.DishDto;
import Reggie.entity.Dish;
import Reggie.entity.DishFlavor;
import Reggie.mapper.DishMapper;
import Reggie.service.DishFlavorService;
import Reggie.service.DishService;
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
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish dish_flavor
     * @param dishDto
     */
    //事务控制
    @Transactional
    public void savaWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到菜品表dish
        this.save(dishDto);
        //菜品的id
        Long dishId = dishDto.getId();
        //菜品的口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
           item.setDishId(dishId);
           return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);

    }

    /**
     * 根据id查询菜品的基本信息和对应的口味信息，查询操作两张表：dish dish_flavor
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {
        //查询菜品基本信息，从dish表中查询
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        //查询菜品的口味信息，从dish_flavor表中查询
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);

        return dishDto;
    }

    /**
     * 改菜品，同时更新菜品对应的口味数据，需要操作两张表：dish dish_flavor
     * @param dishDto
     */
    @Override
    @Transactional
    public void upDateWithFlavor(DishDto dishDto) {
        //更新dish表的基本信息
        this.updateById(dishDto);
        //先清理菜品对应的口味 --- dish_flavor进行delete操作
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(queryWrapper);
        //在添加当前提交过来的口味信息 --- dish_flavor进行insert操作
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 删除菜品，同时删除菜品对应的口味数据，需要操作两张表：dish dish_flavor
     * @param ids
     */
    @Override
    public void removeWithFlavor(List<Long> ids) {
        //查询菜品状态，确定是否可以删除
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Dish::getId,ids);
        queryWrapper.eq(Dish::getStatus,1);
        //如果不能删除，抛出一个业务异常
        int count = this.count(queryWrapper);
        if (count>0){
            throw new CustomException("菜品在售卖中，不能删除呢~");
        }
        //如果可以删除，先清理菜品对应的口味 --- dish_flavor进行delete操作
        LambdaQueryWrapper<DishFlavor> queryWrappers = new LambdaQueryWrapper<>();
        queryWrappers.in(DishFlavor::getDishId,ids);
        dishFlavorService.remove(queryWrappers);
        //删除dish表的基本信息
        this.removeByIds(ids);
    }
}
