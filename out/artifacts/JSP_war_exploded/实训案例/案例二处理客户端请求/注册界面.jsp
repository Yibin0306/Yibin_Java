<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/16
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<form action="注册成功.jsp" method="post">
        <table style="margin: auto">
            <caption>请输入注册信息</caption>
            <tr>
                <td>用户名：</td>
                <td ><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td ><input type="password" name="pwd" /></td>
            </tr>
            <tr>
                <td>信息来源：</td>
                <td >
                    <input name="channel" type="checkbox" value="报刊" />报刊
                    <input name="channel" type="checkbox" value="电视" />电视<br>
                    <input name="channel" type="checkbox" value="网络" />网络
                    <input name="channel" type="checkbox" value="朋友推荐" />朋友推荐
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><input type="reset" value="取消"></td>
            </tr>
        </table>
</form>
</body>
</html>
