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

@WebServlet(name = "updateStudent", value = "/updateStudent")
public class updateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer sid1 = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        Integer sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        Student student = new Student(sid1, sname, sage, ssex);
        Integer integer = new StudentDaoImpl().updateStudent(student);
        if (integer>0){
            response.sendRedirect("FindAllStudent");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
