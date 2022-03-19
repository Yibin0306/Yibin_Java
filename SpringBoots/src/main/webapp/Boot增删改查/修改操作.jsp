<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/9
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>修改</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String mobile = request.getParameter("mobile");
%>
    <form action="/Person/update" method="get">
        <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
            <caption>修改</caption>
            <tr>
                <td>用户名ID</td>
                <td>名字</td>
                <td>电话</td>
                <td>修改</td>
            </tr>
            <c:forEach var="person" items="${listPerson}">
            <tr>
                <td><input readonly="readonly" name="id" value="${person.id}"></td>
                <td><input name="name" value="${person.name}"></td>
                <td><input name="mobile" value="${person.mobile}"></td>
                <td><input type="submit" value="修改"></td>
            </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
