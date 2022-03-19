package 第六章Servlet技术.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import 第六章Servlet技术.dao.DLJMDaoImpl;
import 第六章Servlet技术.entit.DLJM;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DLCL", value = "/DLCL")
public class DLCL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //调用dao方法
        DLJM dljm = new DLJM();
        dljm.setName(name);
        dljm.setPwd(pwd);
        DLJM dljm1 = new DLJMDaoImpl().login(dljm);
        //响应
        System.out.println(dljm1);
        if (dljm1!=null){
            request.setAttribute("dljm",dljm1);
            request.getRequestDispatcher("FindAllStudent").forward(request,response);
        }else {
            response.sendRedirect("DLSB.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
