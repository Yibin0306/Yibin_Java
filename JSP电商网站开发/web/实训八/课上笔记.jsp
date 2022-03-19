<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.logging.SimpleFormatter" %><%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/10/9
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--        &lt;%&ndash;EL表达式&ndash;%&gt;--%>
<%--            <%--%>
<%--                request.setAttribute("name","tom");--%>
<%--            %>--%>
<%--            脚本:<%=request.getAttribute("name")%>  <br>--%>
<%--            EL:${name}  , ${requestScope.name}--%>
<%--        &lt;%&ndash;获取对象类型&ndash;%&gt;--%>
<%--            <%--%>
<%--                Student student = new Student(1,"tom",23,"男");--%>
<%--                request.setAttribute("stu",student);--%>
<%--            %>--%>
<%--            脚本:<%= ((Student)request.getAttribute("stu")).getSname() %>--%>
<%--            EL:${stu},${stu.sname},${stu.ssex}--%>
<%--        &lt;%&ndash;获取数组，集合类型&ndash;%&gt;--%>
<%--            <%--%>
<%--                String[] names = {"tom","jerry","yibin"};--%>
<%--                session.setAttribute("n",names);--%>

<%--                ArrayList<Student> students = new ArrayList<>();--%>
<%--                students.add(new Student(1001,"tom",23,"男"));--%>
<%--                students.add(new Student(1002,"tom",24,"男"));--%>
<%--                students.add(new Student(1003,"tom",25,"男"));--%>
<%--                students.add(new Student(1004,"tom",26,"男"));--%>
<%--                application.setAttribute("list",students);--%>

<%--                Map<String,String> map = new HashMap<>();--%>
<%--                map.put("商丘","2002");--%>
<%--                map.put("郑州","0306");--%>
<%--                request.setAttribute("map",map);--%>
<%--            %>--%>
<%--            数组:${n[3]}   ,  ${n[1]}  <br>--%>
<%--            list:${list[0].sid},${list[3]}<br>--%>
<%--            map:${map["郑州"]},${map["商丘"]}--%>
<%--        &lt;%&ndash;运算&ndash;%&gt;--%>
<%--            <%--%>
<%--                int num = 10;--%>
<%--                request.setAttribute("num",num);--%>
<%--            %>--%>
<%--            算数：${num+5}  ,  ${num%2} <br>--%>
<%--            比较：${num>5}  ,  ${num<90}  ,  ${num<5} <br>--%>
<%--            逻辑：${num>5 && num<5}  ,  ${!(num<5)} <br>--%>
<%--            非空：${empty num}--%>


<%--        <%--%>
<%--            List<Student> students = new ArrayList<>();--%>
<%--            students.add(new Student(1001,"tom",23,"男"));--%>
<%--            students.add(new Student(1002,"tom",24,"男"));--%>
<%--            students.add(new Student(1003,"tom",25,"男"));--%>
<%--            students.add(new Student(1004,"tom",26,"男"));--%>
<%--            application.setAttribute("list",students);--%>
<%--        %>--%>
<%--        <table border="2">--%>
<%--            <c:forEach var="stu" items="${list}" varStatus="s" step="1" begin="0" end="3">--%>
<%--                <tr>--%>
<%--                    <td>${stu.sid},${s.index},${s.count}</td>--%>
<%--                    <td>${stu.sname}</td>--%>
<%--                    <td>${stu.sage}</td>--%>
<%--                    <td>${stu.ssex}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>


<%--        <%--%>
<%--            request.setAttribute("num",10);--%>
<%--            session.setAttribute("date",new Date());--%>
<%--        %>--%>
<%--判断--%>
<%--        <c:if test="${num>10}">--%>
<%--            hello--%>
<%--        </c:if>--%>
<%--        <c:if test="${num>5}">--%>
<%--            world--%>
<%--        </c:if>--%>

<%--多判断--%>
<%--        <c:choose>--%>
<%--            <c:when test="${num>0&&num<=25}">--%>
<%--                青年人--%>
<%--            </c:when>--%>
<%--            <c:when test="${num>25&&num<=50}">--%>
<%--                中年人--%>
<%--            </c:when>--%>
<%--            <c:when test="${num>50}">--%>
<%--                老年人--%>
<%--            </c:when>--%>
<%--        </c:choose>--%>

<%--打印时间--%>
<%--        <f:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss"></f:formatDate>--%>

<%--URL重写--%>
        <a href="<c:url value="课上笔记.jsp"></c:url> ">超链接</a>

</body>
</html>
