<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/13
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="第一章idea集成tomcat及信息列表展示.信息列表展示.dao.信息列表展示DaoImpl" %>
<%@ page import="第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示" %>
<html>
  <head>
    <title>信息列表展示</title>
  </head>
  <body>
    <%--展示所有用户信息，先拿到list<>--%>
    <table border="1" style="margin: auto">
      <caption>用户列表</caption>
    <%
      信息列表展示DaoImpl 信息列表展示Dao = new 信息列表展示DaoImpl();
      List<信息列表展示> 信息列表展示s = 信息列表展示Dao.selectAll信息列表展示();
      for (信息列表展示 u:信息列表展示s){
    %>
      <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getPwd()%></td>
        <td><%=u.getEmail()%></td>
      </tr>
    <%
      }
    %>
    </table>
  </body>
</html>
