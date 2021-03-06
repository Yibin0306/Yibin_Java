<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学士后 短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="scripts/DD_belatedPNG.js"></script>
<script type="text/javascript">DD_belatedPNG.fix('.png');</script>
<![endif]-->
<script type="text/javascript">
$(function(){
	$(".btn-reg").bind("click", function(){
		window.location.href = "register.jsp";
	});
});

function check(){
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var error = document.getElementById("error");
	if(username.value == ""){
		alert("账号不能为空！");
		return false;
	}else if(password.value == ""){
		alert("密码不能为空！");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div id="loginTitle" class="png"></div>
<div id="loginForm" class="userForm png">
	<form method="post" name="loginform" action="UserServlet?action=login" onsubmit = "return check()">		
		<dl>
			<div id="error">${error}</div>
			<dt>用户名：</dt>
			<% request.setAttribute("uname",request.getParameter("uname")); %>
			<dd><input value="${uname}" type="text" name="username" id="username" /></dd>
			<dt>密　码：</dt>
			<dd><input type="password" name="password" id="password" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-login png" type="submit" name="submit" value=" " /><input class="btn-reg png" type="button" name="register" value=" " />
		</div>		
	</form>
</div>
</body>
</html>