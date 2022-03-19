package StudentInfo.controller;

import StudentInfo.entity.Admin;
import StudentInfo.entity.Student;
import StudentInfo.entity.Teacher;
import StudentInfo.service.AdminService;
import StudentInfo.service.StudentService;
import StudentInfo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("LoginHandler")
public class LoginHandler {
    @Autowired
    public AdminService adminService;
    @Autowired
    public StudentService studentService;
    @Autowired
    public TeacherService teacherService;

    //管理员登陆方法
    @RequestMapping("adminlogin")
    public String adminlogin(Admin admin,HttpSession httpSession){
        Admin login = adminService.login(admin);
        if(login==null){
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return "fail";
        }else{
            httpSession.setAttribute("aname", admin.getAname());
            return "admin/adminFace";
        }
    }
    // 管理员退出登录
    @RequestMapping("adminlogout")
    public ModelAndView adminLogout(HttpSession httpSession) {
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("couList");
        return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
    }

    //学生登陆方法
    @RequestMapping("studentlogin")
    public ModelAndView studentlogin(Student student, HttpSession httpSession){
        student = studentService.loginStudent(student);
        if(student==null){
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return new ModelAndView(new RedirectView("../fail.jsp"));
        }else{
            httpSession.setAttribute("sid",student.getSid());
            httpSession.setAttribute("sname",student.getSname());
            return new ModelAndView(new RedirectView("../student/studentFace.jsp"));
        }
    }
    // 学生退出登录
    @RequestMapping("studentlogout")
    public ModelAndView studentLogout(HttpSession httpSession) {
        httpSession.removeAttribute("sid");
        httpSession.removeAttribute("sname");
        httpSession.removeAttribute("courseList");
        httpSession.removeAttribute("ssrList");
        httpSession.removeAttribute("sesList");
        return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
    }

    //教师登陆方法
    @RequestMapping("teacherlogin")
    public ModelAndView teacherlogin(Teacher teacher,HttpSession httpSession,String name){
        teacher = teacherService.loginTeacher(teacher);
        if(teacher==null){
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return new ModelAndView(new RedirectView("../fail.jsp"));
        }else{
            httpSession.setAttribute("tid",teacher.getTid());
            httpSession.setAttribute("tname",teacher.getTname());
            return new ModelAndView(new RedirectView("../teacher/teacherFace.jsp"));
        }
    }

    //教师退出登录
    @RequestMapping("teacherlogout")
    public ModelAndView teacherLogout(HttpSession httpSession) {
        httpSession.removeAttribute("tid");
        httpSession.removeAttribute("tname");
        httpSession.removeAttribute("couList");
        httpSession.removeAttribute("sesList");
        httpSession.removeAttribute("lookList");
        return new ModelAndView(new RedirectView("/StudentInfo/index.jsp"));
    }
}

