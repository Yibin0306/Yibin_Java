package 第六章Servlet技术.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "down", value = "/down")
public class down extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pages = request.getParameter("pages");
        Integer pages1 = new StudentDaoImpl().getpages();
        if (Integer.parseInt(pages)<pages1){
            int i = Integer.parseInt(pages)+1;
            session.setAttribute("pages",i);
            response.sendRedirect("FindAllStudent");
        }else {
            response.sendRedirect("FindAllStudent");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
