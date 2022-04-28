package Reggie.service.impl;

import Reggie.entity.SetmealDish;
import Reggie.mapper.SetmealDishMapper;
import Reggie.service.SetmealDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
