<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/27
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        Integer sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        Student student = new Student(sid, sname, sage, ssex);
        Integer integer = new StudentDaoImpl().updateStudent(student);
        if (integer>0){
            response.sendRedirect("ZJM.jsp");
        }
    %>
</body>
</html>
