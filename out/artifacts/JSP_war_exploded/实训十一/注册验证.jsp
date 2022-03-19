<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/14
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2" style="margin: auto;font-family: 楷体; border-color: aquamarine;">
        <tr>
            <td>输入注册的用户名</td>
            <td>判断是否可用</td>
        </tr>
        <tr>
            <td><input type="text" name="name" onblur="checkName(this.value)" ></td><!--onblur 失去焦点时调取方法-->
            <td><span id="sp"></span></td>
    </table>
</body>
</html>
<script>
    var xhr;
    /*当文本框失去焦点时，获取对应的value值*/
    function checkName(name){
        //获取XMLHttpRequest对象
        xhr = createXHR();
        //readayState改变使用调用,callback方法
        xhr.onreadystatechange = callback;//请求成功后的回调函数
        //指定 get：请求方式，   请求地址，  是否异步true  否 false
        xhr.open("GET","checkName?name="+name,true);//请求方式，请求地址，是否异步
        //发送请求
        xhr.send(null);

    }
    /*获取XMLHttpRequest对象*/
    function createXHR() {
        try {
            return new XMLHttpRequest();
        }catch (e){
            return  new ActiveXObject("Microsoft.XMLHttp");
        }
    }
    /*回调函数*/
    function callback(){
        //判断状态 和 readyState
        if (xhr.readyState == 4 && xhr.status == 200){
            //获取服务器响应内容
            var res = xhr.responseText;
            if (res == 1){
                //修改 id为sp 标签元素内部的html代码
                document.getElementById("sp").innerHTML="该用户名已注册，不可用";
            }else {
                //修改 id为sp 标签元素内部的html代码
                document.getElementById("sp").innerHTML="该用户名可用";
            }
        }
    }
</script>