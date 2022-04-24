package Reggie.service.impl;

import Reggie.common.CustomException;
import Reggie.entity.Category;
import Reggie.entity.Dish;
import Reggie.entity.Setmeal;
import Reggie.mapper.CategoryMapper;
import Reggie.service.CategoryService;
import Reggie.service.DishService;
import Reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishQueryWrapper.eq(Dish::getCategoryId,id);
        int dishCount = dishService.count(dishQueryWrapper);
        //查询分类是否关联菜品，如果关联，抛出一个业务异常
        if (dishCount>0){
            //已经关联了菜品，抛出一个业务异常
            throw new CustomException("该菜品分类下有菜品了呢~");
        }

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        setmealQueryWrapper.eq(Setmeal::getCategoryId,id);
        int setmealCount = setmealService.count(setmealQueryWrapper);
        //查询分类是否关联套餐，如果关联，抛出一个业务异常
        if (setmealCount>0){
            //已经关联了套餐，抛出一个业务异常
            throw new CustomException("该套餐分类下有菜品了呢~");
        }

        //正常删除分类 super应该是本类service方法
        super.removeById(id);
    }
}
