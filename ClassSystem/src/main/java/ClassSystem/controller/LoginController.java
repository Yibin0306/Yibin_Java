package ClassSystem.controller;

import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @PostMapping(value = "/login")
    public ServicePost login(User user){
        ServicePost servicePost = new ServicePost();
        servicePost.setMsg("登录成功！！！");
        servicePost.setCode(200);
        System.out.println(servicePost);
        return servicePost;
    }
}
