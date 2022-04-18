package ClassSystem.controller;

import ClassSystem.entity.ClassList;
import ClassSystem.entity.PersonNum;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/system")
public class SystemController {
    @Autowired
    private SystemService systemService;

    //登录操作验证
    @PostMapping(value = "/login")
    public ServicePost login(User user){
        return systemService.login(user);
    }

    //身份验证
    @GetMapping(value = "/isSign")
    public ServicePost isSign() {
        return systemService.isSign();
    }

    //首页获取平台数据
    @GetMapping(value = "/CenterData")
    public ServicePost CenterData(PersonNum personNum){
        return systemService.PersonNum(personNum);
    }

    //给前端当前页的数据（班级列表，page值）
    @GetMapping(value = "/getClassList")
    public ServicePost ClassNameList(ClassList classList){
        return systemService.ClassList(classList);
    }

}
