package 整合MybatisSpring.service;

import 整合MybatisSpring.entity.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> findAll();
    //添加用户
    Integer add(User user);
    //修改用户
    Integer update(User user);
    //删除用户
    Integer delete(Integer id);
}

