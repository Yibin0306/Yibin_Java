<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.NewsDao" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.NewsDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.News" %>
<%
    request.setCharacterEncoding("utf-8");
    NewsDao newsDao=new NewsDaoImpl();
    List<News> list=newsDao.getAllnews();
    session.setAttribute("list",list);
    response.sendRedirect("../newspages/admin.jsp");
%>

