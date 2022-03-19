<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/18
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="TZ.jsp" method="get">
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
                <td><input type="submit" value="登录"></td>
                <td><input type="reset" value="取消" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
