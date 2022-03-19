<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/12/9
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<!--引入echarts.min.js文件  -->
<script src="../echarts-5.2.2/dist/echarts.min.js"></script>
<!-- 引入jquery-3.1.1.min.js文件 -->
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<html>
<head>
    <title>游戏玩家统计图</title>
</head>
<body style="height: 100%; margin: 0;">
<div id="container" style="height: 90%"></div>

<!--代码编辑区  -->
<script type="text/javascript">
    //发送请求（get请求）
    $.get("/stat/loadUserAreaStatJosn",function(data){
        var dom = document.getElementById("container");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        option = {
            title : {
                text: '游戏玩家占比',
                subtext: '真实有效',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                //数据
                data: data
            },
            series : [
                {
                    name: '用户数量(占比)',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    //数据
                    data:data,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    })
</script>
</body>
</html>

