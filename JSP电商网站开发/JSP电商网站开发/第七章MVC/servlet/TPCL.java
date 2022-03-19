package 第七章MVC.servlet;

import 第七章MVC.dao.投票DaoImpl;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TPCL", value = "/TPCL")
public class TPCL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] items = request.getParameterValues("items");
        for (int i=0;i<items.length;i++){
            String item = items[i];
            int id = Integer.parseInt(item);
            Integer integer = new 投票DaoImpl().add投票(id);
        }
        response.sendRedirect("TPJG.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
