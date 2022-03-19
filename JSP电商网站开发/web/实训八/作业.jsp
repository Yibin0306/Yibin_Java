<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/11
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>作业练习</title>
</head>
<body>
        <%
            List<Student> students = new ArrayList<>();
            students.add(new Student(1001,"Jerry",23,"男"));
            students.add(new Student(1002,"tom",24,"男"));
            students.add(new Student(1003,"yibin",19,"男"));
            students.add(new Student(1004,"eric",26,"男"));
            application.setAttribute("list",students);
        %>
        1.遍历出2-3行数据
        <table border="2">
            <c:forEach var="stu" items="${list}" varStatus="s" step="1" begin="1" end="2">
                <tr>
                    <td>${stu.sid}</td>
                    <td>${stu.sname}</td>
                    <td>${stu.sage}</td>
                    <td>${stu.ssex}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        2.遍历出奇数行数据
        <table border="2">
            <c:forEach var="stu" items="${list}" varStatus="s" step="2" begin="0" end="3">
            <tr>
                <td>${stu.sid}</td>
                <td>${stu.sname}</td>
                <td>${stu.sage}</td>
                <td>${stu.ssex}</td>
            </tr>
            </c:forEach>
        </table>
        <br>
        3.遍历出所有行数据及下标
        <table border="2">
            <c:forEach var="stu" items="${list}" varStatus="s" step="1" begin="0" end="3">
                <tr>
                    <td>${stu.sid},${s.index}</td>
                    <td>${stu.sname}</td>
                    <td>${stu.sage}</td>
                    <td>${stu.ssex}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
------------------------------------------------------------------------------
        <br>
        <%
            request.setAttribute("num",10);
        %>
        判断：age输出青年，中年，老年
        <br>
        判断结果：
        <c:choose>
            <c:when test="${num>0&&num<=25}">
                青年人
            </c:when>
            <c:when test="${num>25&&num<=50}">
                中年人
            </c:when>
            <c:when test="${num>50}">
                老年人
            </c:when>
        </c:choose>
        <br>
------------------------------------------------------------------------------
        <br>
        <%
             session.setAttribute("date",new Date());
        %>
        输出时间:<br>
        <f:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss"></f:formatDate>
</body>
</html>
