<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/16
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <!-- 引入jquery-3.1.1.min.js文件 -->
    <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
    <!-- 引入省份js -->
    <script src="../js/province.js" type="text/javascript" charset="utf-8"></script>
</head>
<body onload='getProvince()'>
<form>
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>Manager注册界面</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" id="uname" onblur="checkName(this.value)">
                <span id="sp" style="color: silver;font-size: 5px">4-12个英文字符</span>
            </td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="password" id="upwd" onblur="checkPwd(this.value)">
                <span id="sp1" style="color: silver;font-size: 5px">8-16个字符，1个大写和小写,1个数字</span>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="email" id="email" onblur="checkEmail(this.value)">
                <span id="sp2" style="color: silver;font-size: 5px">例如:12345678@163.com</span>
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="男" id="sex">男
                <input type="radio" name="sex" value="女" id="sex1">女</td>
        </tr>
        <tr>
            <td>居住地</td>
            <td>
                <input type="text" id="Living" onblur="checkLiving(this.value)"><span id="sp3"></span>
                <br>
                <a onchange="Choice()">
                    <select id="province" onchange="chooseProvince(this)">
                        <option value="1">请选择省</option>
                    </select>
                </a>
                <a onchange="ChoiceOne()">
                    <select id="city" onchange="chooseCity(this)">
                        <option value="2">请选择市</option>
                    </select>
                </a>
                <a onchange="ChoiceTwo()">
                    <select id="area">
                        <option value="3">请选择区</option>
                    </select>
                </a>
            </td>
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
    <script>
        <!--验证用户名业务-->
        var username;
        function checkName(aa) {
            var uname = $("#uname").val();
            var uname1 = document.getElementById("uname");
            var uPattern = /^[a-zA-Z0-9_-]{4,12}$/;
            $.ajax({
                type:"get",
                url:"checkName",
                data:{name:aa},
                success:function (r) {
                    if (uname==""){
                        $("#sp").html("名字不能为空").css("color","red").css("font-size","5px");
                        username = false;
                    }else if (!uPattern.test(uname1.value)){
                        $("#sp").html("4-12个英文字符").css("color","red").css("font-size","5px");
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
            var upwd1 = document.getElementById("upwd");
            var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[^]{8,16}$/
            if (upwd==""){
                $("#sp1").html("密码不能为空").css("color","red").css("font-size","5px");
                password = false;
            }else if (!reg.test(upwd1.value)){
                $("#sp1").html("8-16个字符，1个大写和小写,1个数字").css("color","red").css("font-size","5px");
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
        <!--验证地区业务-->
        var usereLiving;
        function checkLiving(){
            var Living = $("#Living").val();
            if (Living==""){
                $("#sp3").html("地区不能为空").css("color","red").css("font-size","5px");
                $("#Living").focus();
                usereLiving = false;
            } else {
                $("#sp3").html("√").css("color","green");
                usereLiving = true;
            }
        }
        <!--下拉框的值返回到文本框中-->
        function Choice(){
            var province = $("#province option:selected").text();//选中省份内容
            inputValue = $("#Living").val(province+"省,");//将内容返回到指定的文本框中
        }
        function ChoiceOne(){
            var city = $("#city option:selected").text();//选中市内容
            inputValue1 = $("#Living").val(inputValue.val()+city+",");//将内容返回到指定的文本框中
        }
        function ChoiceTwo(){
            var area = $("#area option:selected").text();//选中区内容
            inputValue2 = $("#Living").val(inputValue1.val()+area);//将内容返回到指定的文本框中
        }
        <!--注册功能业务-->
        function regist() {
            var uname = $("#uname").val();
            var upwd = $("#upwd").val();
            var sex = $('input[name="sex"]:checked').val();
            var email = $("#email").val();
            var Living = $("#Living").val();
            if (($("input:radio:checked").is(':checked') == false)){
                alert("性别不能为空");
                return false;
            }else if (username&&password&&useremail&&usereLiving) {
                $.ajax({
                    type: "get",
                    url: "regist",
                    data: {name: uname, pwd: upwd, salt: upwd, email:email, sex: sex, address: Living },
                    success: function (res) {
                        if (res == "true") {
                            alert("注册成功")
                            return true;
                        }else {
                            alert("注册失败")
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
</html>