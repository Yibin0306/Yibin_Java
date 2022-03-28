package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //给前端当前页的数据（学生列表，page值）
    @GetMapping(value = "/StudentList")
    public ServicePost StudentList(PageHelp pageHelp){
        return studentService.StudentList(pageHelp);
    }
}
