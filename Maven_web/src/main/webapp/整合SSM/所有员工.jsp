<%@ page import="java.util.List" %>
<%@ page import="整合SSM.entity.员工" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/15
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
    <caption>员工信息列表</caption>
    <tr>
        <td colspan="6">
            <a style="text-decoration: none; font-family: 楷体; color: pink; margin: auto" href="/Maven_1/整合SSM/添加员工.jsp">添加</a>
        </td>
    </tr>
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    <%
        List<员工> emps = (List<员工>)request.getAttribute("all");
        for(员工 e:emps){
    %>
    <tr>
        <td><%=e.getId()%></td>
        <td><%=e.getName()%></td>
        <td><%=e.getAge()%></td>
        <td><%=e.getSex()%></td>
        <td><a href="/Maven_1/user/delete?id=<%=e.getId()%>" style="text-decoration: none;font-family: 楷体;color: pink;">删除</a></td>
        <td><a href="/Maven_1/整合SSM/修改员工.jsp?id=<%=e.getId()%>&name=<%=e.getName()%>&age=<%=e.getAge()%>&sex=<%=e.getSex()%>" style="text-decoration: none;font-family: 楷体;color: pink;">修改</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>