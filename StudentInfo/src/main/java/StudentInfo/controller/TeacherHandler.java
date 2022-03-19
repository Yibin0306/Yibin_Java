package StudentInfo.controller;

import StudentInfo.entity.Course;
import StudentInfo.entity.CoursePlan;
import StudentInfo.entity.Teacher;
import StudentInfo.service.CourseService;
import StudentInfo.service.CourseplanService;
import StudentInfo.service.TeacherService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("TeacherHandler")
public class TeacherHandler {
    @Autowired
    public TeacherService teacherService;
    @Autowired
    public CourseplanService courseplanService;
    //根据ID跳转到课程界面
    @RequestMapping("queryvita")
    public String queryVita(Teacher teacher,String tid, HttpServletRequest request) {
        teacher = teacherService.findTeacher(tid);
        request.setAttribute("tid", teacher.getTid());
        request.setAttribute("tname", teacher.getTname());
        request.setAttribute("tpassword", teacher.getTpassword());
        request.setAttribute("tsex", teacher.getTsex());
        request.setAttribute("introduction", teacher.getIntroduction());
        return "teacher/queryVita";
    }
    //根据教师ID查询所有课程信息界面
    @RequestMapping("managecou/{tid}/{pn}")
    public String managecou(@PathVariable(value = "tid") String tid, HttpSession httpSession){
        List<CoursePlan> allCoursePlan = courseplanService.findAllCoursePlan(tid);
        httpSession.setAttribute("coursePlanList",allCoursePlan);
        return "teacher/manageCourse";
    }
}
