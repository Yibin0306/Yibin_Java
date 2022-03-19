<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.UserDao" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.UserDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.User" %>
<%
    String uname = request.getParameter("uname");
    String password = request.getParameter("upwd");
    UserDao userDao=new UserDaoImpl();
    User user =userDao.findUser(uname,password);
    if(user==null){
%>
<script type="text/javascript">
    alert("用户名密码错误，请重新登录");
    open("../ZJM1.jsp","_self");
</script>
<%
    }else{
        session.setAttribute("admin",uname);
        response.sendRedirect("do_news_list.jsp");
    }
%>
