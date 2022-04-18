package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //给前端当前页的数据（老师列表，page值）
    @GetMapping(value = "/List")
    public ServicePost TeacherList(PageHelp pageHelp){
        return teacherService.TeacherList(pageHelp);
    }

    //查询框查询教师
    @PostMapping(value = "/search")
    public ServicePost searchTeacher(User user){
        return teacherService.searchTeacher(user);
    }

    //删除单个老师信息
    @GetMapping(value = "/delete")
    public ServicePost deleteTeacher(String username){
        return teacherService.DeleteTeacher(username);
    }

}
