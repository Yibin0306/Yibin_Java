<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>欢迎使用河南测绘职业学院OA</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="../assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="../assets/img/favicon.ico">
    <script type="text/javascript" src="../js/jquery-1.4.2.min(1).js"></script>
    <script type="text/javascript">
        function login() {
            //获取用户名和密码表单中的值
            var uname=$("#sn").val();
            var password=$("#password").val();
            console.log(uname+"   "+password);
            if(uname==''||uname==null)
            {
                alert("用户名不能为空");
                return;
            }
            if(password==""||password==null)
            {
                alert("密码不能为空");
                return;
            }
            //发送ajax请求 ，传入用户名和密码
            $.ajax({
                type:"GET",
                url:"employee/login",
                data:{sn:uname,password:password},
                success:function (res) {
                    if (res == "true") {
                        location.href="/self.jsp";
                        return true;
                    }else {
                        alert("账号或密码错误")
                        return false;
                    }
                }
            })
        }
    </script>
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1> 河南测绘职业学院OA</h1>
                    <p class="lead">欢迎使用河南测绘职业学院自动化管理系统</p>
                </div>
                <div class="panel mt30 mb25">
                    <form id="contact">
                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="sn" class="field-label text-muted fs18 mb10">工号</label>
                                <label for="sn" class="field prepend-icon">
                                    <input type="text" name="sn" id="sn" class="gui-input" placeholder="请输入工号...">
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password" class="field prepend-icon">
                                    <input type="password" name="password" id="password" class="gui-input" placeholder="请输入密码...">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <button type="button" onclick="login()" class="button btn-primary mr10 pull-right">登陆</button>
                            <label class="switch ib switch-primary mt10">
                                <input type="checkbox" name="remember" id="remember" checked="true">
                                <label for="remember" data-on="是" data-off="否"></label>
                                <span>记住我</span>
                            </label>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </section>
</div>
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>
