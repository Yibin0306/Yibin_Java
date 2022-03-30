package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
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

    //查询框查询学生
    @PostMapping(value = "/searchStudent")
    public ServicePost searchStudent(User user){
        return userService.searchStudent(user);
    }

    //删除学生信息
    @DeleteMapping(value = "/CenterData")
    public ServicePost CenterData(String username){
        return userService.DeleteStudent(username);
    }

    //给前端当前页的数据（老师列表，page值）
    @GetMapping(value = "/TeacherList")
    public ServicePost TeacherList(PageHelp pageHelp){
        return userService.TeacherList(pageHelp);
    }
}
