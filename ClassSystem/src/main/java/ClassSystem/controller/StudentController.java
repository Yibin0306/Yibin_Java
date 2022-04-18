package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.entity.User;
import ClassSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //给前端当前页的数据（学生列表，page值）
    @GetMapping(value = "/list")
    public ServicePost StudentList(PageHelp pageHelp){
        return studentService.StudentList(pageHelp);
    }

    //查询框查询学生
    @PostMapping(value = "/find")
    public ServicePost searchStudent(User user){
        return studentService.searchStudent(user);
    }

    //添加学生信息
    @PostMapping(value = "/add")
    public ServicePost addStudent(User user){
        return studentService.addStudent(user);
    }

    //修改学生信息
    @PutMapping(value = "/edit")
    public ServicePost editStudent(User user){
        return studentService.updateStudent(user);
    }

    //删除单个学生信息
    @DeleteMapping(value = "/delete")
    public ServicePost CenterData(String username){
        return studentService.DeleteStudent(username);
    }

}
