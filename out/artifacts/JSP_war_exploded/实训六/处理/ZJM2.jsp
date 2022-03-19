<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="第六章Servlet技术.entit.DLJM" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/27
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息界面</title>
</head>
<body>
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>学生信息列表</caption>
        <tr>
            <td colspan="6">
                <a style="text-decoration: none; font-family: 楷体; color: pink; margin: auto" href="处理/addStudent.jsp">添加</a>
            </td>
        </tr>
        <tr>
            <td>Sid</td>
            <td>Sname</td>
            <td>Sage</td>
            <td>Ssex</td>
            <td>操作一</td>
            <td>操作二</td>
        </tr>
        <%
            List<Student> student = (List<Student>) request.getAttribute("Student");
            for (Student s:student){
        %>
        <tr>
            <td><%=s.getSid()%></td>
            <td><%=s.getSname()%></td>
            <td><%=s.getSage()%></td>
            <td><%=s.getSsex()%></td>
            <td><a href="处理/updateStudent.jsp?sid=<%=s.getSid()%>" style="text-decoration: none;font-family: 楷体;color: pink;">修改</a></td>
            <td><a href="delete?sid=<%=s.getSid()%>" style="text-decoration: none;font-family: 楷体;color: pink;">删除</a></td>
        </tr>
        <%
            }
        %>
        <%
            int pageDB=0;
            Integer pages = (Integer) session.getAttribute("pages");
            if(pages==null){
                pageDB=1;
                session.setAttribute("pages",pageDB);
            }else{
                pageDB = (Integer)session.getAttribute("pages");
            }
        %>
        <tr>
            <td colspan="3"><a href="up?pages=<%=pageDB%>" style="text-decoration: none;font-family: 楷体;color: pink;">上一页</a></td>
            <td colspan="3"><a href="down?pages=<%=pageDB%>" style="text-decoration: none;font-family: 楷体;color: pink;">下一页</a></td>
        </tr>
    </table>

</body>
</html>
