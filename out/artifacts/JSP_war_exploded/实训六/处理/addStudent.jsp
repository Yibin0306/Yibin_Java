<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<form action="addStudent" method="post">
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>添加学生信息</caption>
        <tr>
            <td>用户名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>修改操作</td>
        </tr>
        <tr>
            <td><input type="text" name="sname"></td>
            <td><input type="text" name="sage"></td>
            <td><input type="radio" name="ssex" value="男">男<br>
                <input type="radio" name="ssex" value="女">女
            </td>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
