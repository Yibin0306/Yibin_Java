<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
<form action="/api/excel/import" enctype="multipart/form-data" method="post">

    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <caption>添加数据</caption>
        <tr>
            <td colspan="2">
                <a style="text-decoration: none; font-family: 楷体; color: pink" href="/api/excel/export">下载信息</a>
            </td>
        </tr>
        <tr>
            <td>上传信息</td>
            <td>操作</td>
        </tr>
        <tr>
            <td><input type="file" name="file"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>

</form>
</body>
</html>