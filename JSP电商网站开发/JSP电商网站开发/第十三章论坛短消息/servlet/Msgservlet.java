package 第十三章论坛短消息.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import 第十三章论坛短消息.dao.MsgDaoImpl;
import 第十三章论坛短消息.entit.Msg;
import 第十三章论坛短消息.service.MsgServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Msgservlet", value = "/Msgservlet")
public class Msgservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action==null){
                List<Msg> all = new MsgServiceImpl().findAll();
                request.setAttribute("msgs",all);
                request.getRequestDispatcher("main.jsp").forward(request,response);
            }else {
                switch (action){
                    case "del":
                        int msgid = Integer.parseInt(request.getParameter("msgid"));
                        Integer integer = new MsgDaoImpl().deleteMsg(msgid);
                        response.sendRedirect("MsgServlet");
                        break;
                    case "send":
                        String toUser = request.getParameter("toUser");
                        String loginuser = (String)request.getSession().getAttribute("loginuser");
                        String title = request.getParameter("title");
                        String conter = request.getParameter("conter");
                        Date date = new Date();
                        String date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                        Msg msg = new Msg(null, title, loginuser, date1, 0, conter, toUser);
                        boolean b = new MsgServiceImpl().addMes(msg);
                        if (b){
                            response.sendRedirect("MsgServlet");
                        }
                        break;
                    case "read":
                        String msgid1 = request.getParameter("msgid");
                        int i2 = Integer.parseInt(msgid1);
                        String state = request.getParameter("state");
                        int i3 = Integer.parseInt(state);
                        if(i3==0){
                            new MsgDaoImpl().updateMsg(i2);
                        }
                        Msg findone = new MsgServiceImpl().findone(i2);
                        ArrayList<Msg> msgs = new ArrayList<>();
                        msgs.add(findone);
                        request.setAttribute("msg",msgs);
                        request.getRequestDispatcher("readMsg.jsp").forward(request,response);
                        break;
                }
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
