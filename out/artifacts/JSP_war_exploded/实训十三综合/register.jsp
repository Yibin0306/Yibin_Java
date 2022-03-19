<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学士后 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<script type="text/javascript">
	function check(){
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		var affirm = document.getElementById("affirm");
		var email = document.getElementById("email");
		if(username.value == ""){
			alert("用户名不能为空！");
			return false;
		}else if(password.value == ""){
			alert("密码不能为空！");
			return false;
		}else if(password.value != affirm.value){
			alert("两次密码不同！");
			return false;
		}else if(email.value == ""){
			alert("邮箱不能为空！");
			return false;
		}
		return true;
	}

	function checkName(a){
		$.ajax({
			url:"UserServlet",
			type:"get",
			data:{action:"checkName",username:a},
			success:function (data){
				if (data==1){
					alert("用户名已存在，不可用");
					$("#username").val("");
				}
			}
		});
	}
</script>
<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">
	<form action="UserServlet?action=regist" onsubmit = "return check()" method="post">
		<dl>
		    <div id="error"> ${error }</div>
			<dt>用 户 名：</dt>
			<dd><input onblur="checkName(this.value)" type="text" name="username" id="username" /><span id="sp"></span></dd>
			<dt>密　　码：</dt>
			<dd><input type="password" name="password" id="password" /></dd>
			<dt>确认密码：</dt>
			<dd><input type="password" name="affirm" id="affirm" /></dd>
			<dt>邮　　箱：</dt>
			<dd><input type="text" name="email" id="email" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="submit" name="register" value=" " /><input class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div class="goback"><a href="index.jsp" class="png">返回登录页</a></div>
	</form>
</div>
</body>
</html>
