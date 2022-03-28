package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    //给前端当前页的数据（学生列表，page值）
    @GetMapping(value = "/StudentList")
    public ServicePost StudentList(PageHelp pageHelp){
        return userService.StudentList(pageHelp);
    }

}
