package ClassSystem.controller;

import ClassSystem.entity.*;
import ClassSystem.service.UserService;
import ClassSystem.utility.RedisTemplateUtil;
import ClassSystem.utility.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    //身份验证
    @GetMapping(value = "/isSign")
    public ServicePost isSign() {
        //session中获取token
        String token1 = UserRequest.getCurrentToken("token");
        //redis中获取token
        final String token2 = redisTemplateUtil.getValue("token");
        //判断token是否为空&&相同
        if (token1!=null&&token1.equals(token2)) {
            return ServicePost.CreateTrueCodMsg("身份验证成功");
        }
        return ServicePost.CreateErrorToken("身份验证失败");
    }

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

    //给前端当前页的数据（班级列表，page值）
    @GetMapping(value = "/ClassNameList")
    public ServicePost ClassNameList(ClassList classList){
        return userService.ClassList(classList);
    }

    //查询框查询学生
    @PostMapping(value = "/searchStudent")
    public ServicePost searchStudent(User user){
        return userService.searchStudent(user);
    }

    //添加学生信息
    @PostMapping(value = "addStudent")
    public ServicePost addStudent(User user){
        return userService.addStudent(user);
    }

    //修改学生信息
    @PostMapping(value = "editStudent")
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
