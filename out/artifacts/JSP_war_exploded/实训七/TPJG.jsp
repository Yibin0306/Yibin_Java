<%@ page import="第七章MVC.dao.投票DaoImpl" %>
<%@ page import="第七章MVC.entit.投票" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/8
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票结果</title>
</head>
    <style>
        #a1{
            border: 1px black solid;
            border-radius: 10px;
            background-color: #DCDCDC;
            margin: auto;
            width: 200px;
            height: 180px;
        }
    </style>
<body>
    <div id="a1">
        <table>
            <tr><td>调查结果</td></tr>
            <tr><td></td></tr>
            <table>
                <%
                    List<投票> 投票s = new 投票DaoImpl().selectAll投票();
                    for (投票 s:投票s){
                %>
                <tr>
                    <td width="10%"> <%=s.getItem()%>: </td>
                    <td><div style="width:<%=s.getTimes()%>0px;height:20px;background-color:red;"></div></td>
                </tr>
                <%
                    }
                %>
                <tr><td></td></tr>
                <td><a style="text-decoration: none; color: #6495ED;" href="TPJM.jsp">重新选票</a></td>
            </table>
        </table>
    </div>
</body>
</html>
