package 第十三章论坛短消息.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import 第十三章论坛短消息.dao.业务处理DaoImpl;
import 第十三章论坛短消息.entit.Msg;
import 第十三章论坛短消息.entit.账号信息;
import 第十三章论坛短消息.service.MsgServiceImpl;
import 第十三章论坛短消息.service.账号信息ServiceImpl;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "账号信息servlet", value = "/账号信息servlet")
public class 账号信息servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        账号信息 账号信息 = new 账号信息(username, password, email);
        switch (action){
            case "regist":
                Integer i = new 账号信息ServiceImpl().regist(账号信息);
                if (i>0){
                    response.sendRedirect("index.jsp");
                }else {
                    response.sendRedirect("register.jsp");
                }
                break;
            case  "login":
                String username1 = request.getParameter("username");
                String password1 = request.getParameter("password");
                第十三章论坛短消息.entit.账号信息 账号信息2 = new 账号信息();
                账号信息2.setUname(username1);
                账号信息2.setUpwd(password1);
                boolean login = new 账号信息ServiceImpl().login(账号信息2);
                if(login){
                    request.getSession().setAttribute("loginuser",账号信息2.getUname());
                    response.sendRedirect("MsgServlet");
                }else{
                    response.sendRedirect("DLSB.jsp");
                }
                break;
            case "checkName":
                String userName = request.getParameter("username");
                Integer i1 = new 账号信息ServiceImpl().checkName(userName);
                response.getWriter().print(i1);
                break;
            case "logout":
                request.getSession().removeAttribute("loginuser");
                response.sendRedirect("index.jsp");
                break;
            case "findUsers":
                List<账号信息> all = new 账号信息ServiceImpl().findAllUser();
                request.setAttribute("users",all);
                request.getRequestDispatcher("newMsg.jsp").forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
