<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/9
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--suppress ALL-->
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>信息列表</caption>
        <tr>
            <td colspan="2">
                <a style="text-decoration: none; font-family: 楷体; color: pink" href="/Boot增删改查/添加操作.jsp">添加用户</a>
            </td>
            <td colspan="3">
                <a style="text-decoration: none; font-family: 楷体; color: pink" href="/Person/export">下载用户信息</a>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>名字</td>
            <td>电话</td>
            <td>删除</td>
            <td>修改</td>
        </tr>
    <c:forEach var="person" items="${list}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.mobile}</td>
            <td><a href="/Person/delete?id=${person.id}" style="text-decoration: none;font-family: 楷体;color: pink;">删除</a></td>
            <td><a href="/Person/findOne?id=${person.id}" style="text-decoration: none;font-family: 楷体;color: pink;">修改</a></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
