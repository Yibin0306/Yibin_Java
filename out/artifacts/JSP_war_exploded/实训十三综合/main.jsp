<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="第十三章论坛短消息.dao.业务处理DaoImpl" %>
<%@ page import="第十三章论坛短消息.entit.账号信息" %>
<%@ include file="elements/head.jsp"  %>
<script>
	function change(a){
		window.location="index.jsp?uname="+a;
	}
</script>
<body>
<div id="main">
	<div class="mainbox">
		<div class="title myMessage png"></div>
		<div class="menu">
			<%
				List<账号信息> allUser = new 业务处理DaoImpl().findAllUser();
				session.setAttribute("allUser",allUser);
			%>
			<select name="newUser" onchange="change(this.value)">
					<option>---切换用户---</option>
				<c:forEach var="user" items="${allUser}">
					<c:if test="${user.uname != loginuser}">
						<option value="${user.uname}">${user.uname}</option>
					</c:if>
				</c:forEach>
			</select>
			<span>当前用户：<a href=${"MsgServlet"}>${sessionScope.loginuser}</a></span>
<%--			<span><img src="images/TX.png" width="50px" height="50px"></span>--%>
			<span><a href="UserServlet?action=findUsers">发短消息</a></span>
			<span><a href="UserServlet?action=logout">退出</a></span>
		</div>
		<div id="error">${error}</div>
		<div class="content messageList">
			<ul>
				<c:forEach var="msg" items="${msgs}">
				<c:if test="${msg.slate == 0}">
				<li class="unReaded">
					</c:if>
					<c:if test="${msg.slate == 1}">
				<li>
					</c:if>
					<em><c:out value="${msg.datetime}" /></em>
					<c:if test="${msg.username != loginuser}">
						<em><a href=${"newMsg.jsp?sendto="}${msg.username}>回信</a></em>
					</c:if>
					<em><a href=${"MsgServlet?action=del&msgid="}${msg.msgid}>删除</a></em>
					<p>
						<strong><a href=${"MsgServlet?action=read&msgid="}${msg.msgid}${"&state="}${msg.slate}><c:out value="${msg.title}"/></a></strong>
						<c:if test="${fn:length(msg.conter) > 8}">
							<c:out value="${fn:substring(msg.conter,0,7)}"/>....
						</c:if>
						<c:if test="${fn:length(msg.conter) <= 8}">
							<c:out value="${msg.conter}"/>
						</c:if>
					</p>
					</c:forEach>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
