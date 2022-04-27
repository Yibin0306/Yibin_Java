package Reggie.service;

import Reggie.dto.DishDto;
import Reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish dish_flavor
    public void savaWithFlavor(DishDto dishDto);

    //根据id查询菜品的基本信息和对应的口味信息，查询操作两张表：dish dish_flavor
    public DishDto getByIdWithFlavor(Long id);

    //修改菜品，同时更新菜品对应的口味数据，需要操作两张表：dish dish_flavor
    public void upDateWithFlavor(DishDto dishDto);

    //删除菜品，同时删除菜品对应的口味数据，需要操作两张表：dish dish_flavor
    public void remove(Long id);
}
