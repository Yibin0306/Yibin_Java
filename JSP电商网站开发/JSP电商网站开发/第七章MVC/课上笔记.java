package 第七章MVC;

public class 课上笔记 {
}

/*
    1.model1：web里写java代码，一个web界面 前端 带 后端
        缺点：1.流程在页面中，嵌套大量java代码
             2.jsp主要责任写数据，和前端
             3.页面量增多，降低维护性，可扩展性
    2.MVC模式：是一种经验（概念，理论，设计规范）
        众所周知，经过分类编目，被反复使用的代码设计经验的总结

        M（model）:模型  dao
            用于访问，控制和修改这些数据的业务规则
        V（view）:视图  jsp
            用户看到的交互界面，他从模型中获得数据并指定这些数据应该如何表现
        C（controller）:控制器  servlet
            控制器负责转发请求，对请求进行处理

        优点：
            各司其职，互补干涉
            利于分工
            利用重用和扩展
        缺点：
            没有明确的定义，完全理解mvc并不容易
            开发者将一个应用程序分成三部件，工作量增加
            mvc设计模式是一个很好的创建软件的途径，他所提倡的一些原则，增加了额外的工作和复杂度

    3.model2：jsp+servlet
*/