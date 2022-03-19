package 第六章Servlet技术.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addStudent", value = "/addStudent")
public class addStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String sname = request.getParameter("sname");
        Integer sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        Student student = new Student();
        student.setSname(sname);
        student.setSage(sage);
        student.setSsex(ssex);
        //调用dao方法
        Integer integer = new StudentDaoImpl().addStudent(student);
        //页面跳转
        response.sendRedirect("FindAllStudent");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
