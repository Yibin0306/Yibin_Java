<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--suppress ALL-->
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <!--    引入外部资源-->
    <link rel="stylesheet" type="text/css" href="../css/login.css"></link>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>我是登陆界面</p>
<h1>${name}</h1>
<div>
    <form action="">
        账号：<input type="text"><br>
        密码：<input type="password">
    </form>
</div>
</body>
</html>