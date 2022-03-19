<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/6
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息界面</title>
</head>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
        <h1 style="text-align: center">学生信息查询</h1>
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;">
        <a id="btn">学生信息</a>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
        <table id="dg"></table>
    </div>
</body>
    <script>
        $('#btn').linkbutton({
            iconCls: 'icon-search',
            onClick:function (){
                $('#dg').datagrid({
                    url:'/EasyUI_1/StudentContoller/findAll',
                    pageNumber:1,
                    pageSize:5,
                    pageList:[3,5,7,9,11,13],
                    pagination:true,
                    columns:[[
                        {field:'id',title:'编号',width:200},
                        {field:'name',title:'名字',width:200},
                        {field:'age',title:'年龄',width:200},
                        {field:'sex',title:'性别',width:200},
                        {field:'pwd',title:'密码',width:200},
                        {field:'sid',title:'学号',width:200,align:'right'},
                    ]]
                });
            }
        });
    </script>
</html>
