﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ include file="initialization.jsp"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--
<%
	String userinsession = (String)session.getAttribute("loginuser");
	request.setCharacterEncoding("GBK");
	if(userinsession == null){
%>
<script>
    alert("您没有登录或者已经退出，请重新登录!");
    open("index.jsp","_self");
</script>
<%
	}
%>--%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<title>学士后 在线短信平台</title>
	<link type="text/css" rel="stylesheet" href="css/sms.css" />
	<script type="text/javascript" src="scripts/jquery.js"></script>
</head>

