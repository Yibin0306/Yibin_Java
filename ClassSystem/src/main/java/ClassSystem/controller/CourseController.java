package ClassSystem.controller;

import ClassSystem.entity.PageHelp;
import ClassSystem.entity.ServicePost;
import ClassSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //给前端当前页的数据（未选课程列表，page值）
    @GetMapping(value = "/getCourseNotSelectionList")
    public ServicePost getCourseNotSelectionList(PageHelp pageHelp){
        return courseService.CourseNotList(pageHelp);
    }

    //给前端当前页的数据（已选课程列表，page值）
    @GetMapping(value = "/getCourseSelectionList")
    public ServicePost getCourseSelectionList(PageHelp pageHelp){
        return courseService.CourseList(pageHelp);
    }

}
