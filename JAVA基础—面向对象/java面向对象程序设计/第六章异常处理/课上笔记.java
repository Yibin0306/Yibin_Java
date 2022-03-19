package 第六章异常处理;

//回顾：    多态
//        1.概念： 1. 一种事务的多种形态
////              2. 父类的引用指向子类的对象
//        2.常用的写法
//        父类类型 变量名 = 子类对象;  Person 父   Hero 子类
//        Person p = new Hero();
//        3.多态使用场景
//        1.形参  test1(Person p)  -->Hero --->Person
//        2.返回值 Person test2(){ return }
//        4.转型
//        1.向上  子类--》父类
//        父类型 变量名 = 子类对象;
//        2.向下  父类--》子类
//        Animal a1 = new Cat();
//        Animal a2 = new Dog();
//        ? a1---->Dog？
//        Dog a3 = (Dog)a1;
//        子类类型 变量名 = （子类类型）父类对象;
//        异常：ClassCaseException  类型转换异常
//        进行类型判断：  instanceof
//        if(a1 instanceof Dog){}
//        第六章 异常
//        1.异常分类
//       interface Serializable
//       类：存抽象类--》接口 抽象：不清楚，不完整，不具体
//        Throwable:
//        - Error  错误
//        - Exception  异常

//        - CheckedException   检查时异常

//        -IOException   IO 文件操作
//        -ServletException  前后端请求
//        -ClassNotFoundException  找不到类异常
//        ..........
//        - UncheckedException 非检查时异常

//        -ClassCastException 类型转化异常
//        -NullPointerException 空指针异常
//        ..........
//        2.异常的处理
//        1. 上抛： 形参列表后加上 throws  异常类 Exception
//        2.
//        try{
//        //异常代码
//        }catch(异常类){
//        //异常信息
//        }finally{
//        //无论是否出现异常，都会执行
//        }
//        3.自定义异常
//        1.当输入年龄不合法：
//        自定义异常类：
//        1.继承 Exception    checkedException
//        2.继承 RuntimeException   uncheckedException

public class 课上笔记 {
}
