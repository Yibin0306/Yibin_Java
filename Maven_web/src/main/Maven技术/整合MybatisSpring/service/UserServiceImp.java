package 整合MybatisSpring.service;

import 整合MybatisSpring.dao.UserDao;
import 整合MybatisSpring.entity.User;

import java.util.List;

public class UserServiceImp implements UserService{
    public UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Integer add(User user) {
        return userDao.add(user);
    }

    @Override
    public Integer update(User user) {
        return userDao.update(user);
    }

    @Override
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }
}
