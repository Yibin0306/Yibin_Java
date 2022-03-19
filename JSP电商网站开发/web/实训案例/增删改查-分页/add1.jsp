<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/27
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //获取参数
        String sname = request.getParameter("sname");
        Integer sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        Student student = new Student();
        student.setSname(sname);
        student.setSage(sage);
        student.setSsex(ssex);
        //调用dao方法
        Integer integer = new StudentDaoImpl().addStudent(student);
        //页面跳转
        response.sendRedirect("ZJM.jsp");
    %>
</body>
</html>
