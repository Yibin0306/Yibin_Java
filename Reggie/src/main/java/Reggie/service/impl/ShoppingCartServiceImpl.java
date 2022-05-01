package Reggie.service.impl;

import Reggie.entity.ShoppingCart;
import Reggie.mapper.ShoppingCartMapper;
import Reggie.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
