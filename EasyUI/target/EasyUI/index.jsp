<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <div id="d1">
        <form id="admin_login">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input name="aname" class="easyui-textbox"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="apwd" class="easyui-passwordbox"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script>
    $("#d1").dialog({
        width:245,
        height:200,
        buttons:[{
            text:'登陆',
            handler:function(){
                $.messager.progress();
                $("#admin_login").form('submit',{
                    url:'/EasyUI_1/adminController/login',
                    onsubmit:function () {
                    },
                    success:function (data) {
                        $.messager.progress('close');
                        $("#d1").dialog('close')
                        $.messager.show({
                            title:'登陆成功',
                            msg:'消息将在3秒后关闭。',
                            timeout:3000,
                            showType:'slide'
                        });

                    }
                });
            }
        },{
            text:'关闭',
            handler:function(){
                $("#d1").dialog('close')
            }
        }]
    });

</script>


