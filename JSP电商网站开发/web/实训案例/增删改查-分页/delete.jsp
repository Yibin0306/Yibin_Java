<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/27
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int sid = Integer.parseInt(request.getParameter("sid"));
        Integer integer = new StudentDaoImpl().deleteStudent(sid);
        response.sendRedirect("ZJM.jsp");
    %>
</body>
</html>
