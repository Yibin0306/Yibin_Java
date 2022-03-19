<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/8
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票界面</title>
</head>
<style>
    #a1{
        margin: auto;
        background-color: coral;
        width: 200px;
        height: 209px;
        border-radius: 5px;
        border: 1px black solid;
    }
    #a2{
        background-color: #DCDCDC;
        width: 200px;
        height: 170px;
        position: relative;
        top: 15px;
        border-radius: 5px;
        border-top: 1px black solid;

    }
    #b1{
        color: white;
        font-family: "楷体";
        font-size: 20px;
        position: relative;
        top: 8px;
        left: 60px;
    }
    #b2{
        font-family: "楷体";
        font-size: 18px;
        position: relative;
        top: 13px;
    }
</style>
<body>
<div id="a1">
    <a id="b1">热点调查</a>
    <div id="a2">
        <form method="post" action="TPCL">
            <table>
                <tr>
                    <td id="b2">你对哪种技术最感兴趣<br>
                        <input type="radio" name="items" value="1">Java<br>
                        <input type="radio" name="items" value="2">.net<br>
                        <input type="radio" name="items" value="3">Android<br>
                        <input type="radio" name="items" value="4">PHP<br>
                        <input type="submit" value="提交">
                        <a style="text-decoration: none; color: #6495ED;" href="TPJG.jsp">查看结果</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</body>
</html>
