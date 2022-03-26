package ClassSystem.controller;

import ClassSystem.entity.Message;
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

    //登录操作验证
    @PostMapping(value = "/login")
    public ServicePost login(User user){
        return userService.login(user);
    }

}
