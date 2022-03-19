<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/17
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <%
        //读取所有的cookies，返回cookie数组
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies){
            if (c.getName().equals("uname")){
                out.print("欢迎登录："+c.getValue());
            }
        }
    %>

</body>
</html>