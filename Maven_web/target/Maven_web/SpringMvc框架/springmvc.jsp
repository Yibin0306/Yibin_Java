<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/13
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function check(){
            var id = document.getElementById("id");
            var name = document.getElementById("name");
            var bir = document.getElementById("bir");
            var sex = document.getElementById("sex");
            var hobby = document.getElementById("hobby");
            var age = document.getElementById("age");


            if(id.value == ""){
                alert("用户ID不能为空！");
                return false;
            }else if(name.value == "") {
                alert("名字不能为空！");
                return false;
            }else if(bir.value == ""){
                alert("生日不能为空！");
                return false;
            }else if(sex.value == ""){
                alert("性别不能为空！");
                return false;
            }else if(hobby.value == ""){
                alert("爱好不能为空！");
                return false;
            }else if (age.value == ""){
                alert("年龄不能为空！");
                return false;
            }
            return true;
        }
    </script>
    <title>Title</title>
</head>
<body>
<!--
    基本：String Interger Date...
    不是基本：自定义类对象类型
-->
<a href="/Maven_1/helloController/hello1?age=23&name=tom&bir=2001/10/10">跳转1</a><br>

<a href="/Maven_1/helloController/hello2?id=11&name=jerry&age=23">跳转2</a><br>

<a href="/Maven_1/helloController/hello3?a=tom&a=jerry&a=3">跳转3</a><br>

<form action="/Maven_1/helloController/hello4" method="post">
    id:<input type="text" name="id"><br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<!--如果表单控件，有空，没选，无法提交表单-->
<form onsubmit="return check()" action="/Maven_1/helloController/hello5" method="get">
    id:<input type="text" name="id" id="id"><br>
    name:<input type="text" name="name" id="name"><br>
    bir:<input type="date" name="bir" id="bir"><br>
    sex:<input type="radio" name="sex" value="男" id="sex">男
        <input type="radio" name="sex" value="女" >女
    <br>
    爱好:<input type="checkbox" name="hobby" value="篮球" id="hobby">篮球
    <input type="checkbox" name="hobby" value="足球">足球
    <input type="checkbox" name="hobby" value="乒乓球">乒乓球
    <input type="checkbox" name="hobby" value="LOL">LOL
    <br>
    age:<input type="number" name="age" id="age"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
