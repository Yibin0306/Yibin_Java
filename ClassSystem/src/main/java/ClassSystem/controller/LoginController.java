package ClassSystem.controller;

import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserService userService;

//    登录操作验证
    @PostMapping(value = "/login")
    public ServicePost login(User user){
        ServicePost servicePost = new ServicePost();
        User login = userService.login(user);
        if (login!=null){
            servicePost.setMsg("欢迎您，亲爱的小公主~");
            servicePost.setCode(200);
        }else{
            servicePost.setMsg("账号或密码错误呢~");
            servicePost.setCode(101);
        }
        return servicePost;
    }

}
