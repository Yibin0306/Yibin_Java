package 第八章EL;

public class 课上笔记 {
}

/*
    一.EL表达式（Expression Language）表达式语言
        1.概念：获取作用域中的数据（page request session application）
        2.作用：替换输出脚本：<%=%>
        3.使用：   request 作用域中  “name”：“tom”
            语法：${xxxxScope.key}
                ${requestScope.name}----->value:"tom"
                ${sessionScope.name}
                ${pageScope.name}
                ${applicationScope.name}
                ${name}  //没有指定作用域，从小到大一一排查
                    用列
        4.区别：
                <%--EL表达式--%>
            <%
                request.setAttribute("name","tom");
            %>
            脚本:<%=request.getAttribute("name")%>  <br>
            EL:${name}  , ${requestScope.name}
            返回值不同：如果未找到对应的key   脚本是null，EL是“ ”空字符串
        5.获取对象类型
                <%--获取对象类型--%>
            <%
                Student student = new Student(1,"tom",23,"男");
                request.setAttribute("stu",student);
            %>
            脚本:<%= ((Student)request.getAttribute("stu")).getSname() %>
            EL:${stu},${stu.sname},${stu.ssex}
        6.获取数组，集合list map
                    <%--获取数组，集合类型--%>
            <%
                String[] names = {"tom","jerry","yibin"};
                session.setAttribute("n",names);

                ArrayList<Student> students = new ArrayList<>();
                students.add(new Student(1001,"tom",23,"男"));
                students.add(new Student(1002,"tom",24,"男"));
                students.add(new Student(1003,"tom",25,"男"));
                students.add(new Student(1004,"tom",26,"男"));
                application.setAttribute("list",students);

                Map<String,String> map = new HashMap<>();
                map.put("商丘","2002");
                map.put("郑州","0306");
                request.setAttribute("map",map);
            %>
            数组:${n[3]}   ,  ${n[1]}  <br>
            list:${list[0].sid},${list[3]}<br>
            map:${map["郑州"]},${map["商丘"]}
        7.运算
            算数 + - * % /
            逻辑 && || ！
            比较 <lt  <=le  >=ge  >gt  ==eq  !=ne
            特殊 empty非空
            <%--运算--%>
            <%
                int num = 10;
                request.setAttribute("num",num);
            %>
            算数：${num+5}  ,  ${num%2} <br>
            比较：${num>5}  ,  ${num<90}  ,  ${num<5} <br>
            逻辑：${num>5 && num<5}  ,  ${!(num<5)} <br>
            非空：${empty num}

    二.JSTP
        1.标签库，对EL获取数据
        使用：
            引入jar
            页面引入标签库
        2.标签
            1.forEach内  var：临时变量
                       items：遍历的容器，数组，集合
                       varStatus：临时变量的状态
                       step：步长
                       begin：开始下标
                       end：结束下标

            2.判断 if内  test=“结果（true，false）”
                    true：显示标签内容
                    false：不显示标签内容

            3.多条件判断
                    <c:choose>
                    <c:when test="${num>0&&num<=25}">
                        青年人
                    </c:when>
                    <c:when test="${num>25&&num<=50}">
                        中年人
                    </c:when>
                    <c:when test="${num>50}">
                        老年人
                    </c:when>
                    </c:choose>

            4.时间打印
                    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
                    <%
                        session.setAttribute("date",new Date());
                    %>
                    <f:formatDate value="${date}" pattern="yyyy/MM/dd HH:mm:ss"></f:formatDate>

            5.超链接
                    <%--URL重写--%>
                    <a href="<c:url value="课上笔记.jsp"></c:url> ">超链接</a>







 */