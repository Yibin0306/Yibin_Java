package Reggie.service;

import Reggie.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface UserService extends IService<User> {
}
