<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/15
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String sex = request.getParameter("sex");
        %>
        <form action="/Maven_1/user/update" method="get">
            <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
                <caption>修改员工</caption>
                <tr>
                    <td>用户名ID</td>
                    <td>名字</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>修改操作</td>
                </tr>
                <tr>
                    <td><input readonly="readonly" name="id" value="<%=id%>"></td>
                    <td><input name="name" value="<%=name%>"></td>
                    <td><input name="age" value="<%=age%>"></td>
                    <td><input name="sex" value="<%=sex%>"></td>
                    <td><input type="submit" value="修改"></td>
                </tr>
            </table>
        </form>
</body>
</html>