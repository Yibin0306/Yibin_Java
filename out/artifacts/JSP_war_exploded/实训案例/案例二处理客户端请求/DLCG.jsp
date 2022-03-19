<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/16
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
    欢迎
        <%
            //取值是空?
            String name = request.getParameter("name");
            out.print(name);
        %>
    登录
</body>
</html>
