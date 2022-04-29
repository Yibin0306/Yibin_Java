package Reggie.service.impl;

import Reggie.entity.User;
import Reggie.mapper.UserMapper;
import Reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的ServiceImpl<加对应Mapper,实体类>后implements到Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
