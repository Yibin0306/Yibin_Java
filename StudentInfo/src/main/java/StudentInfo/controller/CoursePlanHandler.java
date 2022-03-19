package StudentInfo.controller;


import StudentInfo.entity.Course;
import StudentInfo.entity.CoursePlan;
import StudentInfo.service.CourseService;
import StudentInfo.service.CourseplanService;
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
@RequestMapping("CoursePlanHandler")
public class CoursePlanHandler {
    @Autowired
    public CourseService courseService;
    @Autowired
    public CourseplanService courseplanService;

    //跳转到教师选课界面
    @RequestMapping("/addquery/{pn}")
    public String addquery(Course course, HttpSession session){
        List<Course> allCourse = courseService.findAllCourse();
        session.setAttribute("courseList",allCourse);
        return "teacher/addCou";
    }
    //多条件查询课程信息
    @RequestMapping(value = "/queryy/{pn}", method = RequestMethod.GET)
    public String queryTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition, HttpSession session) {
        session.setAttribute("serc", serc);
        session.setAttribute("condition", condition);
        if (serc.equals("all")){
            List<Course> allCourse = courseService.findAllCourse();
            session.setAttribute("courseList",allCourse);
            return "teacher/addCou";
        }else if (serc.equals("sid")){
            List<Course> IDCourse = courseService.findOneCourse(condition);
            session.setAttribute("courseList",IDCourse);
            return "teacher/addCou";
        }else if (serc.equals("nam")){
            List<Course> cnameCourse = courseService.findCnameCourse(condition);
            session.setAttribute("courseList",cnameCourse);
            return "teacher/addCou";
        }else if (serc.equals("col")){
            List<Course> belongcollCourse = courseService.findBelongcollCourse(condition);
            session.setAttribute("courseList",belongcollCourse);
            return "teacher/addCou";
        }else {
            List<Course> typeCourse = courseService.findTypeCourse(condition);
            session.setAttribute("courseList",typeCourse);
            return "teacher/addCou";
        }
    }
    //根据课程编号查询该课程，用于查询是否有有安排课程
    @RequestMapping("querycouplan/{cid}")
    public String querycouplan(@PathVariable(value = "cid") String cid, HttpSession session, Model model){
        CoursePlan oneCoursePlan = courseplanService.findOneCoursePlan(cid);
        if (oneCoursePlan!=null){
            session.setAttribute("msg", "该课程已经有老师代课，无法选择此课程！");
            return "fail";
        }else{
            model.addAttribute("cid", cid);
            return "teacher/doAddCou";
        }
    }
    //添加个人教师课程信息
    @RequestMapping("doaddcouplan/{tid}")
    public ModelAndView doaddcouplan(CoursePlan coursePlan, Model model, HttpSession session){
        Integer addCoursePlan = courseplanService.addCoursePlan(coursePlan);
        if (addCoursePlan != 0){
            model.addAttribute("coursePlan", coursePlan);
            return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/managecou/{tid}/1"));
        }else {
            session.setAttribute("msg", "添加课程失败！");
            return new ModelAndView(new RedirectView("/StudentInfo/fail.jsp"));
        }
    }
    //根据排课班级名跳转到修改课程信息信息界面
    @RequestMapping("modicouplan/{courseclass}")
    public String modicouplan(@PathVariable(value = "courseclass") String courseclass,HttpSession session){
        List<CoursePlan> oneTeaCoursePlan = courseplanService.findOneTeaCoursePlan(courseclass);
        session.setAttribute("cPlanList",oneTeaCoursePlan);
        return "teacher/modCouPlan";
    }

    //修改教师个人课程信息
    @RequestMapping("moditycouplan/{tid}")
    public String moditycouplan(@PathVariable(value = "tid") String tid, CoursePlan coursePlan,HttpSession session){
        Integer updateCoursePlan = courseplanService.updateCoursePlan(coursePlan);
        if (updateCoursePlan!=null){
            session.setAttribute("msg","修改课程信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","修改课程信息失败！");
            return "fail";
        }
    }
    //删除教师个人课程信息
    @RequestMapping("delcouplan/{courseclass}/{tid}")
    public String delcouplan(@PathVariable(value = "courseclass") String courseclass,HttpSession session){
        Integer deleteCoursePlan = courseplanService.deleteCoursePlan(courseclass);
        if (deleteCoursePlan!=0){
            session.setAttribute("msg","删除课程信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","删除课程信息失败！");
            return "fail";
        }
    }
}
