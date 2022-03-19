<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/18
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>时间失效</title>
</head>
<body>
    <%
        String cg = (String)session.getAttribute("CG");
        if (cg==null){
            response.sendRedirect("DL.jsp");
            return;
        }
    %>

</body>
</html>
