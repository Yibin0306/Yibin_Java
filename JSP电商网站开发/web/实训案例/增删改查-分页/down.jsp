<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/29
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <%
          String pages = request.getParameter("pages");
          Integer pages1 = new StudentDaoImpl().getpages();
          if (Integer.parseInt(pages)<pages1){
              int i = Integer.parseInt(pages)+1;
              session.setAttribute("pages",i);
              response.sendRedirect("ZJM.jsp");
          }else {
              response.sendRedirect("ZJM.jsp");
          }

      %>

</body>
</html>
