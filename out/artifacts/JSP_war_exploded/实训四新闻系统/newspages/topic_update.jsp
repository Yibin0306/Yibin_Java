<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.Topic" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.TopicsDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改主题--管理后台</title>
    <link href="../css/admin.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        function check(){
            var tname = document.getElementById("tname");

            if(tname.value == ""){
                alert("请输入主题名称！！");
                tname.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
    <div id="opt_area">
        <h1 id="opt_type"> 修改主题： </h1>
        <form action="../util/topic_update1.jsp?opr=update" method="post" onsubmit="return check()">
            <p>
                <label> 修改前的主题名称： </label>
            <select name="ntid">
                <%
                    List<Topic> allTopics = new TopicsDaoImpl().getAllTopics();
                    for(Topic t:allTopics){
                        out.print("<option value='"+t.getTid()+"'>"+t.getTname()+"</option>");
                    }
                %>
            </select>
            </p>
            <p>
                <label> 修改后的主题名称： </label>
                <input name="tname" type="text" class="opt_input" id="tname"/>
            </p>
            <input name="action" type="hidden" value="addtopic"/>
            <input type="submit" value="提交" class="opt_sub" />
            <input type="reset" value="重置" class="opt_sub" />
        </form>
    </div>
</div>
<div id="footer">
    <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
