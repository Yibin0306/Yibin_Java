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

<table id="dg"></table>



</body>
<script>

    $('#dg').datagrid({
        pageNumber:3,
        pageSize:5,
        pageList:[2,4,5,8],
        pagination:true,
        url:'/EasyUI_1/adminController/findAll',
        columns:[[
            {field:'aid',title:'编号',width:100},
            {field:'aname',title:'名字',width:100},
            {field:'apwd',title:'密码',width:100,align:'right'}
        ]]
    });


</script>


