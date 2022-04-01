package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.PersonNum;
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

    //首页获取平台数据
    @GetMapping(value = "/CenterData")
    public ServicePost CenterData(PersonNum personNum){
        return userService.PersonNum(personNum);
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

    //添加学生信息
    @PostMapping(value = "/addStudent")
    public ServicePost addStudent(User user){
        return userService.addStudent(user);
    }

    //修改学生信息
    @PostMapping(value = "/editStudent")
    public ServicePost editStudent(User user){
        return userService.updateStudent(user);
    }

    //删除单个学生信息
    @GetMapping(value = "/deleteStudent")
    public ServicePost CenterData(String username){
        return userService.DeleteStudent(username);
    }

    //给前端当前页的数据（老师列表，page值）
    @GetMapping(value = "/TeacherList")
    public ServicePost TeacherList(PageHelp pageHelp){
        return userService.TeacherList(pageHelp);
    }

    //查询框查询教师
    @PostMapping(value = "/searchTeacher")
    public ServicePost searchTeacher(User user){
        return userService.searchTeacher(user);
    }

    //删除单个老师信息
    @GetMapping(value = "/deleteTeacher")
    public ServicePost deleteTeacher(String username){
        return userService.DeleteTeacher(username);
    }

}
