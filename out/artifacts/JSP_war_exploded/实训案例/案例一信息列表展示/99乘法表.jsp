<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/13
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
  <head>
    <title>九九乘法表</title>
  </head>
  <body>
      <%
        String s =" ";
        for (int i = 1; i <= 9; i++) {
          for (int j = 1; j <= i; j++) {
            s += i + "*" + j + "=" + i * j + "\t";
          }
          s+="<br>";
        }

      %>
      <%=s%>
    </body>
</html>
