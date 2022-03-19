<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/17
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<%
    String name = "";
    Cookie[] cookies = request.getCookies();//读取所有cookie，返回cookie数组
    if (cookies !=null){//遍历cookies数组
        for (Cookie c:cookies){
            if (c.getName().equals("uname")){
                response.sendRedirect("DLCG.jsp");
                return;
            }
        }
    }
%>
<form action="TZJM.jsp" method="post">
    <table style="margin: auto">
        <caption>用户登录</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="pwd" /></td>
        </tr>
        <tr>
            <td><input type="checkbox" name="zddl" value="123" />两周内自动登录</td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="取消" /></td>
        </tr>
    </table>
</form>
</body>
</html>
