<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.News" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.NewsDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.TopicsDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.Topic" %>
<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/23
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" />
    <title>中国新闻网</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script>
        function check(){
            var username =  document.getElementById("uname");
            var upwd =  document.getElementById("upwd");
            if (username.value == ""){
                alert("用户名不能为空！请重新输入！");
                username.focus();
                return false;
            }else if (upwd.value == ""){
                alert("密码不能为空！请重新输入！");
                upwd.focus();
                return false;
            }
            return true;
        }
        function focusOnLogin(){
            var username = document.getElementById("uname");
            username.focus();
        }
    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">
    <div id="top_login">
        <form action="util/do_login.jsp" method="post" onsubmit="return check()">
            <label> 登录名 </label>
            <input type="text" name="uname" value="" class="login_input" />
            <label> 密&#160;&#160;码 </label>
            <input type="password" name="upwd" value="" class="login_input">
            <input type="submit" class="login_sub" value="登录" />
            <label id="error"> </label>
            <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
        </form>
    </div>
    <div id="nav">
        <div id="logo"><img src="images/logo.jpg" alt="中国新闻网" /></div>
        <div id="a_b01"><img src="images/a_b01.gif" /></div>
    </div>
</div>
<div id="container">
    <div class="sidebar">
        <%------------------------左侧3类新闻---------------------------%>
        <h1><img src="images/title_1.gif" alt="国内新闻"/></h1>
        <div class="side_list">
            <ul>
                <%
                    int[]arr = {1};
                    for (int i=0;i<arr.length;i++){
                        List<News> allnewsByTID = new NewsDaoImpl().getAllnewsByTID(arr[i]);
                        for (News n:allnewsByTID){
                            out.print("<li> <a href='#'><b>"+n.getNtitle()+"</b></a> </li>");
                        }
                    }
                %>
            </ul>
        </div>
        <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
        <div class="side_list">
            <ul>
                <%
                    int[]arr1 = {2};
                    for (int i=0;i<arr1.length;i++){
                        List<News> allnewsByTID = new NewsDaoImpl().getAllnewsByTID(arr1[i]);
                        for (News n:allnewsByTID){
                            out.print("<li> <a href='#'><b>"+n.getNtitle()+"</b></a> </li>");
                        }
                    }
                %>
            </ul>
        </div>
        <h1> <img src="images/title_3.gif" alt="娱乐新闻"> </h1>
        <div class="side_list">
            <ul>
                <%
                    int[]arr2 = {5};
                    for (int i=0;i<arr2.length;i++){
                        List<News> allnewsByTID = new NewsDaoImpl().getAllnewsByTID(arr2[i]);
                        for (News n:allnewsByTID){
                            out.print("<li> <a href='#'><b>"+n.getNtitle()+"</b></a> </li>");
                        }
                    }
                %>
            </ul>
        </div>
    </div>


    <div class="main">
        <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
        <div class="content">
            <%-----------------------新闻类别列表----------------------------%>
            <ul class="class_date">
                <%
                    TopicsDaoImpl topicsDao = new TopicsDaoImpl();
                    List<Topic> allTopics = topicsDao.getAllTopics();
                    for (Topic t:allTopics){
                        out.print("<a href='#'><b>"+t.getTname()+"</b></a>&nbsp;&nbsp;");
                    }
                %>
            </ul>
            <ul class="classlist">
                <%-- 未引导 --%>
                <%
                    List<News> allnews = new NewsDaoImpl().getAllnews();
                    int i = 0;
                    for (News news:allnews) {
                        out.print("<li><a href='#?nid=" + news.getNid() + "'>" + news.getNtitle() + "</a><span>" + news.getNcreatedate() + "</span></li>");
                        i++;
                        if (i % 3 == 0) {
                            out.print("<li class='space'></li>");
                        }
                    }
                %>
                <p align="right"> 当前页数：[1/2]&nbsp; <a href="#">下一页</a> <a href="#">尾页</a> </p>
            </ul>
            <%--------------------------------------------%>
        </div>
        <%@include file="ZJM-elements/ZJM_rightbar.html"%>
    </div>
    <%@include file="ZJM-elements/ZJM_bottom.html"%>
</div>
</body>
</html>