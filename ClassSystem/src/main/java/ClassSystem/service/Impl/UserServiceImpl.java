package ClassSystem.service.Impl;

import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.UserMapper;
import ClassSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //登录验证
    @Override
    public ServicePost login(User user) {
        User login = userMapper.login(user);
        if (login!=null){
            return ServicePost.CreateTrueCodMsg("欢迎您，娇贵的小公主~");
        }else{
            return ServicePost.CreateErrorCodMsg("账号或密码错误呢~");
        }
    }
}
