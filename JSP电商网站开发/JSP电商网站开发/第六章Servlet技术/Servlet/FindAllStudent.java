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
//import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllStudent", value = "/FindAllStudent")
public class FindAllStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int pageDB=0;
        Integer pages = (Integer) session.getAttribute("pages");
        if(pages==null){
            pageDB=1;
            session.setAttribute("pages",pageDB);
        }else{
            pageDB = (Integer)session.getAttribute("pages");
        }
        List<Student> allStudent = new StudentDaoImpl().findAllstudent(pageDB);
        //把allStudent绑定到request中
        request.setAttribute("Student",allStudent);
        request.getRequestDispatcher("处理/ZJM2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
