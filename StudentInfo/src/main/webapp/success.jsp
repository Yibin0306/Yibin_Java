<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
	<meta charset="UTF-8">
	<title>操作成功</title>
	<!-- Loading Bootstrap -->
	<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
	<!-- Loading Flat UI Pro -->
	<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
	<!-- Loading Flat UI JS -->
	<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>
	<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>
<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<br>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-info">
				<h3>操作成功!</h3>
				<h5>${sessionScope.msg}</h5>
			</div>

			<a class="btn btn-default" href="javascript:" onclick="self.location=document.referrer;">点击返回</a>
		</div>
	</div>
</div>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>