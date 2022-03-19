<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/15
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <form action="/Maven_1/user/add" method="get">
        <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
            <caption>添加员工</caption>
            <tr>
                <td>用户名ID</td>
                <td>名字</td>
                <td>年龄</td>
                <td>性别</td>
                <td>修改操作</td>
            </tr>
            <tr>
                <td><input type="text" name="id"></td>
                <td><input type="text" name="name"></td>
                <td><input type="text" name="age"></td>
                <td><input type="text" name="sex"></td>
                <td><input type="submit" value="添加"></td>
            </tr>
        </table>
    </form>
</body>
</html>
