package Reggie.service.impl;

import Reggie.entity.Category;
import Reggie.mapper.CategoryMapper;
import Reggie.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
