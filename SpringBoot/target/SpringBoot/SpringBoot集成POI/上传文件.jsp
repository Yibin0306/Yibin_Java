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
    <input type="file" name="file">
    <br><br>
    <input type="submit" value="提交">
</form>
</body>
</html>