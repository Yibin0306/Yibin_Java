<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            String pages = request.getParameter("pages");
            if (Integer.parseInt(pages)==1){
                response.sendRedirect("ZJM.jsp");
            }else {
                int i = Integer.parseInt(pages)-1;
                session.setAttribute("pages",i);
                response.sendRedirect("ZJM.jsp");
            }
        %>
</body>
</html>
