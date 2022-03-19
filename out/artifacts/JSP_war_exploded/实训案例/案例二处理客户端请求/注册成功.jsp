<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/16
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
    <%
        //设置请求字符集，一定放在获取数据之前
        request.setCharacterEncoding("utf-8");
        //获取用户名输入框中的数据 username； 输入框name属性的值
        String username = request.getParameter("username");
        //获取密码输入框中的数据 pwd； 输入框pwd属性的值
        String pwd = request.getParameter("pwd");
        //获取复选框输入框中的数据 channel； 复选框属性的值
        String[] channels = request.getParameterValues("channel");
    %>
    <%--
    1.没有关联tomcat
    2.如何关联tomcat
        模块依赖内添加tomcat
    --%>
    <table>
        <caption>用户信息</caption>
        <tr>
            <td>用户名：</td>
            <td><% out.print(username); %></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><% out.print(pwd); %></td>
        </tr>
        <tr>
        <td>信息来源：</td>
        <td><%
            for (String s:channels){
                out.print(s+" ");
            }
        %></td>
         </tr>
    </table>
</body>
</html>
