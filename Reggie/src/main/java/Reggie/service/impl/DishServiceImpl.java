package Reggie.service.impl;

import Reggie.entity.Dish;
import Reggie.mapper.DishMapper;
import Reggie.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
