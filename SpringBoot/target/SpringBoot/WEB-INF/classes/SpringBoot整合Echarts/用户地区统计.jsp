<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  @program: SpringBoot_01
  @description: echarts测试页面
  @author: wyh
  @createDate: 2021-05-10 21:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入echarts的js-->
<script src=""></script>
<html>
<head>
    <title>echarts测试</title>
</head>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
</body>
<script type="text/javascript">

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [15, 20, 36, 10, 10, 20]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    // 处理点击事件并且跳转到相应的百度搜索页面
    myChart.on('click', function (params) {
        alert(params.name)
    });
</script>
</html>

