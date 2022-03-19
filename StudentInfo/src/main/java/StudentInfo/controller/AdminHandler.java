package StudentInfo.controller;

import StudentInfo.entity.*;
import StudentInfo.service.StudentService;
import StudentInfo.service.TeacherService;
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
@RequestMapping("AdminHandler")
public class AdminHandler {
    @Autowired
    public StudentService studentService;
    @Autowired
    public TeacherService teacherService;
    //学生选择课程
    String[] arr_belongcoll = {"计算机学院","建筑学院","外国语学院","人文学院"};
    String[][] arr_belongpro = {
            {"网络工程","软件工程","物联网","信息管理"},
            {"土木工程","测绘工程","工程造价", "城市规划"},
            {"英语", "日语", "俄语", "西班牙语"},
            {"汉语言", "历史", "新闻", "网络新媒体"}
    };
    String[][][] arr_belongcla = {
            {
                    {"网络B151","网络B152","网络B161","网络B162","网络B171","网络B172"},
                    {"软件B151","软件B152","软件B161","软件B162","软件B171","软件B172"},
                    {"物联B151","物联B152","物联B161","物联B162","物联B171","物联B172"},
                    {"信管B151","信管B152","信管B161","信管B162","信管B171","信管B172"}
            },
            {
                    {"土木B151","土木B152","土木B161","土木B162","土木B171","土木B172"},
                    {"测绘B151","测绘B152","测绘B161","测绘B162","测绘B171","测绘B172"},
                    {"造价B151","造价B152","造价B161","造价B162","造价B171","造价B172"},
                    {"规划B151","规划B152","规划B161","规划B162","规划B171","规划B172"}
            },
            {
                    {"英语B151","英语B152","英语B161","英语B162","英语B171","英语B172"},
                    {"日语B151","日语B152","日语B161","日语B162","日语B171","日语B172"},
                    {"俄语B151","俄语B152","俄语B161","俄语B162","俄语B171","俄语B172"},
                    {"牙语B151","牙语B152","牙语B161","牙语B162","牙语B171","牙语B172"}
            },
            {
                    {"汉语B151","汉语B152","汉语B161","汉语B162","汉语B171","汉语B172"},
                    {"历史B151","历史B152","历史B161","历史B162","历史B171","历史B172"},
                    {"新闻B151","新闻B152","新闻B161","新闻B162","新闻B171","新闻B172"},
                    {"网媒B151","网媒B152","网媒B161","网媒B162","网媒B171","网媒B172"}
            }
    };
    //查询全部学生方法
    @RequestMapping("findAllStudent")
    public String findAllstudent(HttpServletRequest request){
        //分页思路
        PageInfo pageInfo = new PageInfo();
        pageInfo.setHasNextPage(true);
        pageInfo.setHasPreviousPage(true);
        pageInfo.setTotal(100);
        pageInfo.setPages(5);
        pageInfo.setPageNum(1);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        pageInfo.setNavigatepageNums(integers);

        //查询所有学生
        List<Student> allstudent = studentService.findAllstudent();
        request.setAttribute("slist", allstudent);
        request.setAttribute("pageInfo", pageInfo);
        return "admin/queryStudent";
    }
    //添加学生信息
    @RequestMapping("addStudent")
    public String addStudent(Student student, Model model,HttpSession session){
        int col = Integer.parseInt(student.getCollege());
        int pro = Integer.parseInt(student.getProfession());
        int cla = Integer.parseInt(student.getClassr());
        //总感觉前端js写的有问题。
        student.setCollege(arr_belongcoll[pro]);
        student.setProfession(arr_belongpro[pro][col]);
        student.setClassr(arr_belongcla[pro][col][cla]);

        Integer addStudent = studentService.addStudent(student);
        if (addStudent!=0){
            session.setAttribute("msg","添加学生信息成功！");
            model.addAttribute("student", student);
            return "success";
        }else{
            session.setAttribute("msg","添加学生信息失败！");
            return "fail";
        }
    }
    //删除学生信息
    @RequestMapping("delete")
    public String deleteStudent(String sid,HttpSession session){
        Integer deleteStudent = studentService.deleteStudent(sid);
        if (deleteStudent!=0){
            session.setAttribute("msg","删除学生信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","删除学生信息失败！");
            return "fail";
        }
    }
    //根据id跳转到修改学生界面
    @RequestMapping("moditystu")
    public String moditystu(String sid,HttpServletRequest request) {
        List<Student> oneStudent = studentService.findOneStudent(sid);
        request.setAttribute("studentList",oneStudent);
        return "admin/modiStudent";
    }
    //修改学生信息
    @RequestMapping("moditystud/{sid}")
    public String update(Student student, Model model,HttpSession session){
        int col = Integer.parseInt(student.getCollege());
        int pro = Integer.parseInt(student.getProfession());
        int cla = Integer.parseInt(student.getClassr());
        //总感觉前端js写的有问题。
        student.setCollege(arr_belongcoll[pro]);
        student.setProfession(arr_belongpro[pro][col]);
        student.setClassr(arr_belongcla[pro][col][cla]);

        Integer updateStudent = studentService.updateStudent(student);
        if (updateStudent != 0){
            session.setAttribute("msg","修改学生信息成功！");
            model.addAttribute("student", student);
            return "success";
        }else {
            session.setAttribute("msg","修改学生信息失败！");
            return "fail";
        }
    }
    //多条件查询学生信息
    @RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
    public String query(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request) {
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);
        if (serc.equals("all")){
            List<Student> allstudent = studentService.findAllstudent();
            request.setAttribute("slist", allstudent);
            return "admin/queryStudent";
        }else if (serc.equals("sid")){
            List<Student> IdStudent = studentService.findOneStudent(condition);
            request.setAttribute("slist",IdStudent);
            return "admin/queryStudent";
        }
        else if (serc.equals("col")){
            List<Student> CollegeStudent = studentService.findCollegeStudent(condition);
            request.setAttribute("slist",CollegeStudent);
            return "admin/queryStudent";
        }else if (serc.equals("pro")){
            List<Student> professionStudent = studentService.findProfessionStudent(condition);
            request.setAttribute("slist",professionStudent);
            return "admin/queryStudent";
        }else{
            List<Student> classrStudent = studentService.findClassrStudent(condition);
            request.setAttribute("slist",classrStudent);
            return "admin/queryStudent";
        }

    }



    //查询所有教师信息
    @RequestMapping("findAllTeacher")
    public String findAllTeacher(HttpServletRequest request){
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        request.setAttribute("teacherList",allTeacher);
        return "admin/queryTeacher";
    }
    //添加教师信息
    @RequestMapping("addTeacher")
    public String addTeacher(Teacher teacher,HttpSession session){
        Integer addTeacher = teacherService.addTeacher(teacher);
        if (addTeacher!=0){
            session.setAttribute("msg","添加教师信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","添加教师信息失败！");
            return "fail";
        }
    }
    //删除教师信息
    @RequestMapping("deleteTea")
    public String deleteTeacher(String tid,HttpSession session){
        Integer deleteTeacher = teacherService.deleteTeacher(tid);
        if (deleteTeacher!=0){
            session.setAttribute("msg","删除教师信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","删除教师信息失败！");
            return "fail";
        }
    }
    //根据id跳转到修改老师界面
    @RequestMapping("modityTea")
    public String modityTea(String tid,HttpServletRequest request) {
        List<Teacher> oneTeacher = teacherService.findOneTeacher(tid);
        request.setAttribute("teacherList",oneTeacher);
        return "admin/modiTeacher";
    }
    //修改教师信息
    @RequestMapping("modityTeac/{tid}")
    public String update(Teacher teacher,HttpSession session){
        Integer updateTeacher = teacherService.updateTeacher(teacher);
        if (updateTeacher != 0){
            session.setAttribute("msg","修改教师信息成功！");
            return "success";
        }else {
            session.setAttribute("msg","修改教师信息失败！");
            return "fail";
        }
    }
    //多条件查询教师信息
    @RequestMapping(value = "/queryTea/{pn}", method = RequestMethod.GET)
    public String queryTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request) {
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);
        if (serc.equals("all")){
            List<Teacher> allTeacher = teacherService.findAllTeacher();
            request.setAttribute("teacherList",allTeacher);
            return "admin/queryTeacher";
        }else {
            List<Teacher> IDTeacher = teacherService.findOneTeacher(condition);
            request.setAttribute("teacherList", IDTeacher);
            return "admin/queryTeacher";
        }
    }

}
