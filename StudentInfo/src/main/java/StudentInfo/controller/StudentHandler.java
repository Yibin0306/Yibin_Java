package StudentInfo.controller;

import StudentInfo.entity.Course;
import StudentInfo.entity.Grade;
import StudentInfo.entity.Student;
import StudentInfo.service.CourseService;
import StudentInfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("StudentHandler")
public class StudentHandler {
    @Autowired
    public StudentService studentService;
    @Autowired
    public CourseService courseService;

    //根据ID跳转到个人管理界面
    @RequestMapping("queryvitastu")
    public String queryvitastu(Student student, String sid, HttpServletRequest request){
        student = studentService.findStudent(sid);
        request.setAttribute("sid", student.getSid());
        request.setAttribute("sname", student.getSname());
        request.setAttribute("sidcard", student.getSidcard());
        request.setAttribute("ssex", student.getSsex());
        request.setAttribute("spassword", student.getSpassword());
        request.setAttribute("sage", student.getSage());
        request.setAttribute("classr", student.getClassr());
        request.setAttribute("profession", student.getProfession());
        request.setAttribute("college", student.getCollege());
//        request.setAttribute("credits", oneStudent);
        return "student/queryVitaStu";
    }
    //根据id跳转到修改密码界面
    @RequestMapping("moditypwstu")
    public String moditypwstu(String sid,HttpServletRequest request) {
        List<Student> oneStudent = studentService.findOneStudent(sid);
        return "student/modityPwStu";
    }
    //修改学生密码
    @RequestMapping("moditypasswordstu/{sid}")
    public String moditypasswordstu(Student spassword,HttpSession session) {
        Integer updateStudentPwd = studentService.updateStudentPwd(spassword);
        if (updateStudentPwd!=0){
            System.out.println("成功");
            return "success";
        }else {
            System.out.println("失败");
            return "fail";
        }
    }
    //跳转到学生选课界面
    @RequestMapping("/selqueryy/{pn}")
    public String selqueryy(Course course,HttpServletRequest request){
        List<Course> allCourse = courseService.findAllCourse();
        request.setAttribute("courseList",allCourse);
        return "student/selCourse";
    }

    //多条件查询课程信息
    @RequestMapping(value = "/queryy/{pn}", method = RequestMethod.GET)
    public String queryTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition, HttpServletRequest request) {
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);
        if (serc.equals("all")){
            List<Course> allCourse = courseService.findAllCourse();
            request.setAttribute("courseList",allCourse);
            return "student/selCourse";
        }else if (serc.equals("sid")){
            List<Course> IDCourse = courseService.findOneCourse(condition);
            request.setAttribute("courseList",IDCourse);
            return "student/selCourse";
        }else if (serc.equals("nam")){
            List<Course> cnameCourse = courseService.findCnameCourse(condition);
            request.setAttribute("courseList",cnameCourse);
            return "student/selCourse";
        }else if (serc.equals("col")){
            List<Course> belongcollCourse = courseService.findBelongcollCourse(condition);
            request.setAttribute("courseList",belongcollCourse);
            return "student/selCourse";
        }else {
            List<Course> typeCourse = courseService.findTypeCourse(condition);
            request.setAttribute("courseList",typeCourse);
            return "student/selCourse";
        }
    }

}
