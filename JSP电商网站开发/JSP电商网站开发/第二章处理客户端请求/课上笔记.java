package 第二章处理客户端请求;

public class 课上笔记 {
}

/*
    1.常见错误  404  ：tomcat没有启动   项目没有启动   url写错  页面放错位置（不能放web inf）
    2.没有关联tomcat
        如何关联tomcat
            模块依赖内添加tomcat
    3.  设置请求字符集，一定放在获取数据之前
        request.setCharacterEncoding("utf-8");
        获取用户名输入框中的数据 username； 输入框name属性的值
        String username = request.getParameter("username");
        获取密码输入框中的数据 pwd； 输入框pwd属性的值
        String pwd = request.getParameter("pwd");
        获取复选框输入框中的数据 channel； 复选框属性的值
        String[] channels = request.getParameterValues("channel");
    4.请求数据可以理解为存放在request作用域，request是生命周期（重发送-->响应）
            A界面---->B界面-- 重定向--request作用域失效-->C界面
      如何解决丢失问题：
      1.用转发取代重定向
        1.1重定向：response.senRedirect（“welcomg.jsp”）；
        1.2转发：request.getRequestDispatcher（“welcomg.jsp”）.forward（request,response）；
*/