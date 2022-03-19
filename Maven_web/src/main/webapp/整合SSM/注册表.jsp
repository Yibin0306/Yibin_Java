<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/18
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script src="JS_jar/jquery-1.4.2.min(1).js"></script>
</head>
<script>
    <!--验证用户名业务-->
    var username;
    function checkName(aa) {
        var uname = $("#uname").val();
            $.ajax({
                type:"get",
                url:"/Maven_1/controller/checkName",
                data:{uname:aa},
                success:function (r) {
                    if (uname==""){
                        $("#sp").html("名字不能为空").css("color","red").css("font-size","5px");
                        username = false;
                    }else if(r == "false"){
                        $("#sp").html("名字已被注册").css("color","red").css("font-size","5px");
                        username = false;
                    }else {
                        $("#sp").html("√").css("color","green");
                        username = true;
                    }
                }
            });
        }
    <!--验证密码业务-->
    var password;
    function checkPwd(){
        var upwd = $("#upwd").val();
        if (upwd==""){
            $("#sp1").html("密码不能为空").css("color","red").css("font-size","5px");
            password = false;
        }else {
            $("#sp1").html("√").css("color","green");
            password = true;
        }
    }
    <!--验证邮箱业务-->
    var useremail;
    function checkEmail(){
        var email = $("#email").val();
        var email1 = document.getElementById("email");
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (email==""){
            $("#sp2").html("邮箱不能为空").css("color","red").css("font-size","5px");
            useremail = false;
        }else if(!myreg.test(email1.value)) {
            $("#sp2").html("邮箱格式不正确").css("color","red").css("font-size","5px");
            useremail = false;
        }else {
            $("#sp2").html("√").css("color","green");
            useremail = true;
        }
    }
    <!--注册功能业务-->
    function regist() {
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        var sex = $('input[name="sex"]:checked').val();
        var email = $("#email").val();
        if (($("input:radio:checked").is(':checked') == false)){
            alert("性别不能为空");
            return false;
        }else if (username&&password&&useremail) {
            $.ajax({
                type: "get",
                url: "/Maven_1/controller/regist",
                data: {uname: uname, upwd: upwd, sex: sex, email:email},
                success: function (res) {
                    if (res == "true") {
                        alert("注册成功")
                        window.location.href="登录界面.jsp"
                        return true;
                    }else {
                        return false;
                    }
                },
            });
        }else {
            alert("表单有误无法提交");
            return false;
        }
    }
</script>
<body>
    <form>
        <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
            <caption>注册界面</caption>
            <tr>
                <td>用户名</td>
                <td><input type="text" id="uname" onblur="checkName(this.value)"><span id="sp"></span></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password" id="upwd" onblur="checkPwd(this.value)"><span id="sp1"></span></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio" name="sex" value="男" id="sex">男
                    <input type="radio" name="sex" value="女" id="sex1">女</td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" id="email" onblur="checkEmail(this.value)"><span id="sp2"></span></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="text-align: center;vertical-align:middle;">
                    <input type="button" value="注册" onclick="regist()">
                    <input type="reset" value="重置">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>