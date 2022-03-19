<%@ page import="第三章会话跟踪技术.session.entit.Entit" %>
<%@ page import="javax.xml.namespace.QName" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/18
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
   <%@include file="TZ1.jsp"%>
    <%
        String name = (String) session.getAttribute("CG");
        out.print("欢迎登录："+name);
    %>

</body>
</html>
