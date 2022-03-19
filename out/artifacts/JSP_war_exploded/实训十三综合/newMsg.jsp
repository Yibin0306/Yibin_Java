<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="第十三章论坛短消息.entit.账号信息" %>
<%@ include file="elements/head.jsp"  %>
<script type="text/javascript">
  function check(){
			var title = document.getElementById("title");
			var content = document.getElementById("content");
			if(title.value == ""){
				alert("标题不能为空！");
				return false;
			}else if(content.value == ""){
				alert("内容不能为空！");
				return false;
			}
			return true;
	}
</script>
  
 <body>
 <form action="MsgServlet?action=send" method="post" onsubmit="return check()">
	 <div id="main">
		 <div class="mainbox">
			 <div class="menu">
				 <span>当前用户：<a href=${"MsgServlet"}>${sessionScope.loginuser}</a></span>
				 <span><a href="UserServlet?action=findUsers">发短消息</a></span>
				 <span><a href="UserServlet?action=logout">退出</a></span>
			 </div>
			 <div class="content">
				 <div class="message">

					 <div class="tmenu">
						 <ul class="clearfix">
							 <%
								 String sendto = request.getParameter("sendto");
								 request.setAttribute("sendto",sendto);
							 %>
							 <li>
								 <select name="toUser">
									 <c:if test="${sendto == null}">
									 <c:forEach var="user" items="${users}">
										 <option value="${user.uname}">${user.uname}</option>
									 </c:forEach>
									 </c:if>
									 <c:if test="${sendto != null}">
										 <option value="${sendto}">${sendto}</option>
									 </c:if>
								 </select>
							 </li>
							 <li>标题：<input type="text" name="title" id="title"/></li>
						 </ul>
					 </div>
					 <div class="view">
						 <textarea name="conter" id="content"></textarea>
						 <div class="send"><input type="submit" name="submit" value=" " /></div>
					 </div>
				 </div>
			 </div>
		 </div>
	 </div>
 </form>
</body>
</html>
