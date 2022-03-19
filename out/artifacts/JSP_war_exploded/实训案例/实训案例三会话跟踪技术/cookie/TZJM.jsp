<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示" %>
<%@ page import="第一章idea集成tomcat及信息列表展示.信息列表展示.dao.信息列表展示DaoImpl" %>
<%@ page import="第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术" %>
<%@ page import="第三章会话跟踪技术.会话跟踪技术.dao.会话跟踪技术DaoImp" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/17
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转界面</title>
</head>
<body>
    <%
        //乱码处理
        request.setCharacterEncoding("utf-8");
        //获得用户名，密码,登录选项
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String zddl = request.getParameter("zddl");
        会话跟踪技术 会话跟踪技术 = new 会话跟踪技术(name,pwd);

        第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术 会话跟踪技术1 = new 会话跟踪技术DaoImp().select会话跟踪技术ByNameAndPwd(会话跟踪技术);

        //out.print(会话跟踪技术1!=null);
        if (会话跟踪技术1!=null){//对帐号密码进行判断
            if (zddl!=null){//如果用户选中了两周内自动登录,写入cookie
                Cookie cookie = new Cookie("uname", name);//对应登录界面的用户名
                cookie.setMaxAge(60*60*24*14);//设置cookie有效期时间
                response.addCookie(cookie);//吧cookie写入客户端
                response.sendRedirect("DLCG.jsp");
                return;
            }
        }else {
            response.sendRedirect("DLJM.jsp");//密码错误重回登录界面
        }
    %>
</body>
</html>
