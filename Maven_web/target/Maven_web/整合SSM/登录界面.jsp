<%@ page import="工具.RandomValidateCode" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/11/18
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script src="JS_jar/jquery-1.4.2.min(1).js"></script>
</head>
<body>
    <form>
        <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
            <caption>登录界面</caption>
            <tr>
                <td>用户名ID</td>
                <td><input type="text" id="uname"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password" id="upwd"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" id="yzm" placeholder="验证码" style="width: 110px;height: 23px;vertical-align:middle;">
                    <img src="/Maven_1/controller/checkCode"  id="checkCode" title="看不清，点击换一张" alt="" width="50" height="36" class="passcode" style="height:20px;cursor:pointer;vertical-align: middle" onclick="getPic()">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="text-align: center;vertical-align:middle;">
                    <input type="button" onclick="login()" value="登陆">
                    <input type="button" onclick="regist()" value="注册">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
<script>
    function getPic(){
        $("#checkCode").attr("src","/Maven_1/controller/checkCode?flag="+Math.random());
    };
    <!--登录功能后台业务-->
    function login() {
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        var yzm = $("#yzm").val();
        if (uname == "" || upwd == "") {
            alert("用户名或密码为空!");
            return false;
        } else {
            $.ajax({
                type: "post",
                data: {code: $("#yzm").val()},
                url: "/Maven_1/controller/checkVerify",
                success: function (s) {
                    if (s == "ture") {
                        $.ajax({
                            type: "post",
                            data: {uname: uname, upwd: upwd},
                            url: "/Maven_1/controller/login",
                            success: function (r) {
                                if (r == "true") {
                                    window.location.href = "/Maven_1/user/findAll"
                                    return true;
                                } else if (r == "false") {
                                    alert("用户名或密码错误!");
                                    return false;
                                }
                            }
                        });
                    } else {
                        alert("验证码错误!")
                        return false;
                    }
                }
            })
        }
    }
    function regist(){
        window.location.href="注册表.jsp"
    }

</script>