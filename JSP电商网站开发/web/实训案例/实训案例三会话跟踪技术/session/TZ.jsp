<%@ page import="第三章会话跟踪技术.session.entit.Entit" %>
<%@ page import="第三章会话跟踪技术.session.dao.DaoImp" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转界面</title>
</head>
<body>
    <%
        String name = request.getParameter("name").trim();
        String pwd = request.getParameter("pwd").trim();
        Entit entit = new Entit(name,pwd);
        if (new DaoImp().selectEntitByNameAndPwd(entit)){
            session.setAttribute("CG",entit.getName());
            session.setMaxInactiveInterval(10);
            response.sendRedirect("CG.jsp");
        }else {
            response.sendRedirect("DL.jsp");
        }
    %>
</body>
</html>
