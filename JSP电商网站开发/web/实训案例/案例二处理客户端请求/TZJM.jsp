<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/16
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>跳转界面</title>
</head>
<body>
    <%
        //乱码处理
        request.setCharacterEncoding("utf-8");
        //获得用户名，密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //如果name，pwd  ==  equals（“值”）  -----> 跳转登陆成功
        if (name.equals("Yibin") && password.equals("0306")){
            request.getRequestDispatcher("DLCG.jsp").forward(request,response);
        }else {
            response.sendRedirect("DLJM.jsp");
        }
    %>
</body>
</html>
