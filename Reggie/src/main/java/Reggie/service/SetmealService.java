package Reggie.service;

import Reggie.dto.DishDto;
import Reggie.dto.SetmealDto;
import Reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface SetmealService extends IService<Setmeal> {
    //新增套餐，同时插入套餐对应的菜品数据，需要操作两张表：setmeal setmeal_Dish
    public void savaWithDish(SetmealDto setmealDto);

    //根据id查询套餐的基本信息和对应的菜品信息，查询操作两张表：setmeal setmeal_Dish
    public SetmealDto getByIdWithDish(Long id);
}
