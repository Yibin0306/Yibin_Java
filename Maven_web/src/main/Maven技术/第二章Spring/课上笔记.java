package 第二章Spring;

public class 课上笔记 {
}
/*
    1.spring
        1.管理项目中各个组件
          dao,service，servlet..

    2.声明周期
        1.初始化:
            <bean id="获取对象时用到ID属性对应的值" class="第二章Spring.text" init-method="init" destroy-method="destroy"/>

    3.导jar，顺序
        comment-logging
        spring-core
        spring-beans
        spring-aop
        spring-context
        spring-expression
        spring-context-support

    回顾：
        1.是一个开源的，轻量级管理项目组件的框架
        2.作用:管理组件（类 bean）提供了spring容器，工厂，维护组件之间的关系
        3.spring环境搭建
            1.引入架包
                comment-logging
                spring-core
                spring-beans
                spring-aop
                spring-context
                spring-expression
                spring-context-support
        4.hello world案例
        5.spring核心思想
            1.IOC
                控制权翻转，把new对象的权力交给spring容器
            2.DI
                依赖注入 维护组件之间的关系
        6.依赖注入
            1.构造注入，借助构造方法注入(基本类型)
            2.数组，list，map.....
            3.注入引用类型
            4.注意：构建注入用的非常少，了解注入语法
        7.Setter注入
            String,list.....用value    引用用：ref
        8.自动注入
            1.ByName
                <!--自动注入-->
                <bean autowire="byName" class="第二章Spring.自动注入" id="自动注入"></bean>
                <!--byName-->
                <bean class="第二章Spring.Student" id="student1"></bean>
            2.ByType
                <!--自动注入-->
                <bean autowire="byName" class="第二章Spring.自动注入" id="自动注入"></bean>
                <!--byType-->
                <bean class="第二章Spring.Student"></bean>
        9.bean声明周期
            <bean class="第二章Spring.HelloWorld" id="app" init-method="init" destroy-method="destroy"/>
            1.初始化的节点：开启容器的时候
            2.销毁：关闭工厂    spring.registerShutdownHook();
        10.bean创建的模式(默认单例，多例)
            <bean class="第二章Spring.HelloWorld" id="app" init-method="init" destroy-method="destroy" scope="singleton"/>
            scope="singleton"：创建是单例
            scope="prototype"：创建是多例
            注意：spring容器不负责多例bean的销毁
        11.bean对象的创建原理
            try {
                Class<Setter注入> aClass = (Class<Setter注入>) Class.forName("第二章Spring.Setter注入");
                Setter注入 Setter注入 = aClass.newInstance();
            }catch (Exception e){
                e.printStackTrace();
            }
        12.AOP面向切面编程
            通知概念：
                1.切点
                2.切面
                前置：MethodBeforeAdvice
                后置：AfterReturningAdvice
                环绕：MethodInterceptor







*/