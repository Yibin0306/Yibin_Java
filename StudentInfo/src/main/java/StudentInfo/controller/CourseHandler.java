package StudentInfo.controller;

import StudentInfo.entity.Course;
import StudentInfo.entity.Teacher;
import StudentInfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("CourseHandler")
public class CourseHandler {
    @Autowired
    public CourseService courseService;

    // 添加课程信息
    @RequestMapping("addCourse")
    public String addCourse(Course course, Model model, HttpSession session) {
        Integer addCourse = courseService.addCourse(course);
        if (addCourse != 0) {
            session.setAttribute("msg","添加课程信息成功！");
            model.addAttribute("course", course);
            return "success";
        } else {
            session.setAttribute("msg","添加课程信息失败！");
            return "fail";
        }
    }
    //查询所有课程信息
    @RequestMapping("findAllCourse")
    public String findAllCourse(HttpServletRequest request){
        List<Course> allCourse = courseService.findAllCourse();
        request.setAttribute("courseList",allCourse);
        return "admin/queryCourse";
    }
    //删除课程信息
    @RequestMapping("delete")
    public String deleteCourse(String cid,HttpSession session){
        Integer deleteCourse = courseService.deleteCourse(cid);
        if (deleteCourse!=0){
            session.setAttribute("msg","删除课程信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","删除课程信息失败！");
            return "fail";
        }
    };
    //根据id跳转到修改课程界面
    @RequestMapping("moditystu")
    public String editPre(String cid,HttpServletRequest request) {
        List<Course> oneCourse = courseService.findOneCourse(cid);
        request.setAttribute("courseList", oneCourse);
        return "admin/modiCourse";
    }
    //修改课程信息
    @RequestMapping("moditystud/{cid}")
    public String update(Course course,HttpSession session){
        Integer updateCourse = courseService.updateCourse(course);
        if (updateCourse != 0){
            session.setAttribute("msg","修改课程信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","修改课程信息失败！");
            return "fail";
        }
    }
    //多条件查询课程信息
    @RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
    public String queryTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition, HttpServletRequest request) {
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);
        if (serc.equals("all")){
            List<Course> allCourse = courseService.findAllCourse();
            request.setAttribute("courseList",allCourse);
            return "admin/queryCourse";
        }else if (serc.equals("sid")){
            List<Course> IDCourse = courseService.findOneCourse(condition);
            request.setAttribute("courseList",IDCourse);
            return "admin/queryCourse";
        }else if (serc.equals("nam")){
            List<Course> cnameCourse = courseService.findCnameCourse(condition);
            request.setAttribute("courseList",cnameCourse);
            return "admin/queryCourse";
        }else if (serc.equals("col")){
            List<Course> belongcollCourse = courseService.findBelongcollCourse(condition);
            request.setAttribute("courseList",belongcollCourse);
            return "admin/queryCourse";
        }else {
            List<Course> typeCourse = courseService.findTypeCourse(condition);
            request.setAttribute("courseList",typeCourse);
            return "admin/queryCourse";
        }
    }
}
