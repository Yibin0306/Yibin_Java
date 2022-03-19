<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="/Person/newp" method="get">
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>添加</caption>
        <tr>
            <td>ID</td>
            <td>名字</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <tr>
            <td><input type="text" name="id"></td>
            <td><input type="text" name="name"></td>
            <td><input type="text" name="mobile"></td>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
