package ClassSystem.service.Impl;

import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.mapper.UserMapper;
import ClassSystem.service.UserService;
import ClassSystem.utility.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ServicePost servicePost;

    //登录验证
    @Override
    public ServicePost login(User user) {
        User login = userMapper.login(user);
        if (login!=null){
            servicePost.setMsg("欢迎您，娇贵的小公主~");
            servicePost.setCode(Const.true_200);
        }else{
            servicePost.setMsg("账号或密码错误呢~");
            servicePost.setCode(Const.false_101);
        }
        return servicePost;
    }
}
