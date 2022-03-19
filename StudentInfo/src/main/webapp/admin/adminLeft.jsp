<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#">学生信息管理系统</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto" >

			<li><a href="/StudentInfo/AdminHandler/findAllStudent"><strong>学生管理</strong></a>
		
			<li><a href="/StudentInfo/AdminHandler/findAllTeacher"><strong>教师管理</strong></a>

			<li><a href="/StudentInfo/CourseHandler/findAllCourse"><strong>课程管理</strong></a>
			
			<li><a href="/StudentInfo/admin/addStudent.jsp"><strong>添加学生</strong></a>
			
			<li><a href="/StudentInfo/admin/addTeacher.jsp"><strong>添加教师</strong></a>
			
			<li><a href="/StudentInfo/admin/addCourse.jsp"><strong>添加课程</strong></a>
		</ul>
 
	<p class="navbar-text navbar-right">你好！ ${sessionScope.aname} &nbsp;管理员<a href="/StudentInfo/LoginHandler/adminlogout" class="navbar-link" href="#">注销</a></p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->



