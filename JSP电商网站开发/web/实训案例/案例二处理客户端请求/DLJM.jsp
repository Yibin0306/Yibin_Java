<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/16
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="TZJM.jsp" method="post">
    <table style="margin: auto">
        <caption>用户登录</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="取消" /></td>
        </tr>
    </table>
</form>
</body>
</html>
