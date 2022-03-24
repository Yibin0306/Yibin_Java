package ClassSystem.service.Impl;

import ClassSystem.entity.User;
import ClassSystem.mapper.UserMapper;
import ClassSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
