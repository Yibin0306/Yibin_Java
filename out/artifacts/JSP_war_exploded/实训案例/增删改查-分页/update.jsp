<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/27
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息界面</title>
</head>
<body>
    <%
        String sid = request.getParameter("sid");
        //考虑,daoimpl方法是Integer类型
        int i = Integer.parseInt(sid);
        Student oneStudent = new StudentDaoImpl().findOneStudent(i);
    %>
    <form action="update1.jsp">
        <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
            <caption>修改学生信息</caption>
            <tr>
                <td>Sid</td>
                <td>Sname</td>
                <td>Sage</td>
                <td>Ssex</td>
                <td>修改操作</td>
            </tr>
            <tr>
                <td><input readonly="readonly" name="sid" type="text" value="<%=oneStudent.getSid()%>"></td>
                <td><input type="text" name="sname" value="<%=oneStudent.getSname()%>"></td>
                <td><input type="text" name="sage" value="<%=oneStudent.getSage()%>"></td>
                <td><input type="text" name="ssex" value="<%=oneStudent.getSsex()%>"></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
