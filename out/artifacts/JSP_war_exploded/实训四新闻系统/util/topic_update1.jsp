
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.TopicsDao" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.dao.impl.TopicsDaoImpl" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.entit.Topic" %>
<%
    request.setCharacterEncoding("utf-8");
    String opr = request.getParameter("opr");
    TopicsDao topicsDao=new TopicsDaoImpl();

    if(opr.equals("list")){
        List<Topic> list4=topicsDao.getAllTopics();
        session.setAttribute("list4",list4);
        response.sendRedirect("../newspages/topic_list.jsp");
    }else if(opr.equals("update")){//修改主题
        String tname = request.getParameter("tname");
        Topic topic=topicsDao.findTopicByName(tname);
        if(topic==null){
            topicsDao.addTopic(tname);
            List<Topic> list4 = topicsDao.getAllTopics();
            session.setAttribute("list4",list4);//所有的主题
%>
<script type="text/javascript">
    alert("当前主题修改成功，点击确认返回主题列表！");
    location.href="topic_update1.jsp?opr=list";
</script>
<%
}else{%>
<script type="text/javascript">
    alert("当前主题已存在，请输入不同的主题！");
    location.href="../newspages/topic_update.jsp";
</script>
<%
        }
    }
%>
