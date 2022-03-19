<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/22
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <%
        Integer count = (Integer) application.getAttribute("count");
        if (count != null){
            count=count+1;
        }else {
            count = 1;
        }

        application.setAttribute("count",count);

        Object count1 = application.getAttribute("count");
        out.print("你好，你是第"+count1+"位访问本界面的");
    %>

</body>
</html>
