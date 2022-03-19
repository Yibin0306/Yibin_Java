package 第十二章使用Jquery实现Ajax;

public class 课上笔记 {
}

/*
    1.$.get  get提交
      $.post   post提交
      $.ajax   所有
    2.$.get()方法作用是使用 GET 方式发送异步请求，它的方法声明为:
      jQuery.get(url,[data],[callback],[type])  顺序不可变
      $.post 和get一样
    3.$.ajax   所有  顺序可变

    笔记：
    基于JQuery发送ajax页面引入jquery.xx.js <script src="xxx.js地址"><
    方法:
        $.get( url,data,func,type );顺序:请求地址，数据，回调函数，相应类型
        $.post( url,data,func,type );顺序:请求地址，数据，回调函数，相应类型
        $.ajax({
        data:{key:value}，
        success:function(){
        url:"",
        error:fun(){}
        })
*/