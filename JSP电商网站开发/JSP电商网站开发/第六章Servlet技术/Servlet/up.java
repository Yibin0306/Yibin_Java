package 第六章Servlet技术.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "up", value = "/up")
public class up extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pages = request.getParameter("pages");
        if (Integer.parseInt(pages)==1){
            response.sendRedirect("FindAllStudent");
        }else {
            int i = Integer.parseInt(pages)-1;
            session.setAttribute("pages",i);
            response.sendRedirect("FindAllStudent");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
