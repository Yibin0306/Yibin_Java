<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/30
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="DLCL" method="post">
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>用户登录界面</caption>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>操作一</td>
        </tr>
        <tr>
            <td><input type="text" name="name"></td>
            <td><input type="password" name="pwd" /></td>
            <td><input value="登录" type="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>
