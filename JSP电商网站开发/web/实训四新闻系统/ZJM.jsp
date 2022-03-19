<%--
  Created by IntelliJ IDEA.
  User: 沐霖
  Date: 2021/9/23
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" />
    <title>中国新闻网</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script>
        function check(){
            var username =  document.getElementById("uname");
            var upwd =  document.getElementById("upwd");
            if (username.value == ""){
                alert("用户名不能为空！请重新输入！");
                username.focus();
                return false;
            }else if (upwd.value == ""){
                alert("密码不能为空！请重新输入！");
                upwd.focus();
                return false;
            }
            return true;
        }
        function focusOnLogin(){
            var username = document.getElementById("uname");
            username.focus();
        }
    </script>
</head>
<body onload="focusOnLogin()">
    <div id="header">
        <div id="top_login">
            <form action="">  <%-- 未引导 --%>
                <label> 登录名 </label>
                <input type="text" name="uname" value="" class="login_input" />
                <label> 密&#160;&#160;码 </label>
                <input type="password" name="upwd" value="" class="login_input">
                <input type="submit" class="login_sub" value="登录" />
                <label id="error"> </label>
                <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
            </form>
        </div>
        <div id="nav">
            <div id="logo"><img src="images/logo.jpg" alt="中国新闻网" /></div>
            <div id="a_b01"><img src="images/a_b01.gif" /></div>
        </div>
    </div>
    <div id="container">
        <div class="sidebar">
            <h1><img src="images/title_1.gif" alt="国内新闻"/></h1>
            <div class="side_list">
                <ul>
                    <li> <a href="#"><b> 景区，如何让不再依靠门票收入 </b></a> </li>
                    <li> <a href="#"><b> 高考期间中东部地区将现大范围降雨 </b></a> </li>
                    <li> <a href="#"><b> 山西离柳焦煤集团井下人行车发生事故6人死亡 </b></a> </li>
                </ul>
            </div>
            <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
            <div class="side_list">
                <ul>
                    <li> <a href="#"><b> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </b></a> </li>
                    <li> <a href="#"><b> 普京逮捕铁腕市长展示肌肉向世人表明克宫仍大权所握 </b></a> </li>
                    <li> <a href="#"><b> 潘基文祝贺赖斯被任命为美国国家安全顾问 </b></a> </li>
                    <li> <a href="#"><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b></a> </li>
                </ul>
            </div>
            <h1> <img src="images/title_3.gif" alt="娱乐新闻"> </h1>
            <div class="side_list">
                <li> <a href="#"><b> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </b></a> </li>
                <li> <a href="#"><b> 《新恋爱时代》登东方卫视 《非诚》元素遭删除 </b></a> </li>
                <li> <a href="#"><b> 《海角七号》导演新片开机 吴宇森等出席 </b></a> </li>
                <li> <a href="#"><b> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </b></a> </li>
            </div>
        </div>
        <div class="main">
            <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
            <div class="content">
                <ul class="class_date">
                    <li id="class_month"> <a href="#"><b> 国内 </b></a> <a href="#"> <b> 国际 </b> </a> <a href="#">
                        <b> 军事 </b></a> <a href="#"><b> 体育 </b></a> <a href="#"><b> 娱乐 </b></a> <a href="#">
                        <b> 社会 </b></a> <a href="#"><b> 财经 </b></a> <a href="#"><b> 科技 </b></a> <a href="#">
                        <b> 健康 </b></a> <a href="#"><b> 汽车 </b></a> <a href="#"><b> 教育 </b></a> </li>
                    <li id="class_month"> <a href="#"><b> 房产 </b></a> <a href="#"><b> 家具 </b></a> <a href="#">
                        <b> 旅游 </b></a> <a href="#"><b> 文化 </b></a> <a href="#"><b> 其它 </b></a></li>
                </ul>
                <ul class="classlist">
                    <li><a href="" > 深足教练组说：我们买球是侮辱 朱广沪常暗中支招</a>    <%-- 未引导 --%>
                        <span> 2013-06-06 01:03:52.0 </span>
                    </li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <li class="space"></li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <li class="space"></li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <li class="space"></li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <li class="space"></li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <li class="space"></li>
                    <li><a href="#"> 习近平在墨国会发表演讲：朋友要老 好酒要陈 </a> <span> 2013-06-06 01:03:19.0 </span></li>
                    <li><a href="#"> 《致命黑兰》左伊坐拥7种武器 暴力登录全国院线 </a> <span> 2013-06-06 01:02:39.0 </span></li>
                    <li><a href="#"> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </a> <span> 2013-06-06 01:02:14.0 </span></li>
                    <li><a href="#"> 步行者崩盘主要原因在哪 解决3问题能发起更强挑战 </a> <span> 2013-06-06 01:01:49.0 </span></li>
                    <p align="right"> 当前页数：[1/2]&nbsp; <a href="#">下一页</a> <a href="#">尾页</a> </p>
                </ul>
            </div>
            <%@include file="ZJM-elements/ZJM_rightbar.html"%>
        </div>
            <%@include file="ZJM-elements/ZJM_bottom.html"%>
    </div>
</body>
</html>
