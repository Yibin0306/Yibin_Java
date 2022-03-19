package 第七章抽象类和接口;

//回顾 第六章  异常处理
//        1.异常的分类
//        顶层父类：Throwable
//        错误：Error
//        异常: Exception
//        1.非运行时异常
//        IOException
//        ServletException
//        ClassNotFoundException
//        2.运行时异常
//        ClassCastException
//        ArrayIndexOutOfBoundsException
//        NullPointerException
//        ArithmeticException
//        异常处理
//        1.不处理：上抛  方法的形参的后：throws 异常类1,异常类2
//        2.try...catch
//        try{
//        //异常代码
//        }catch(异常类 变量名){
//        //打印异常信息
//        }finally{
//        //无论是否捕捉到异常，都会执行
//        }
//        自定义异常类：
//        1.非运行是异常
//class Ex extends Exception
//                2.运行时异常
//class Ex extends RuntimeException
//                3.如何手动抛出一个异常
//                        throw 异常类的对象
//                        throw new Ex();


//       第七章  抽象类和接口
//                        1.抽象
//                        1.1：形容词：不清楚，不完整，不具体，宽泛
//                        1.2：动词： 形成类的过程，把具有相同属性和方法的事务抽象抽一类 Animal
//                        2.抽象类
//                        2.1 这个类的描述：不清楚，不完整，不具体，宽泛
//                        2.2 抽象类关键字：abstract
//            语法：public abstract class 类名{}
//        2.3 不完整体现在：内部的抽象方法
//                2.3.1 抽象方法
//                抽象方法：不是一个完整的方法，只有声明部分，没有实现部分
//                声明部分: 访问修饰符 返回值类型 方法名 形参列表
//                实现部分：方法体 {     }
//                2.4 声明抽象方法
//public abstract void test1();
//        2.5 抽象类中都可有哪些方法？
//        1.普通方法
//        2.抽象方法
//        3.抽象类中至少写一个抽象方法
//        2.6 抽象可以被继承
//        2.6.1 抽象方法-普通方法（方法的实现）
//        继承了一个抽象类，必须实现父类内的所有抽象方法
//        2.7 抽象类不能实例化对象
//        3.修饰符：final 最终
//        final不能修饰抽象类
//        3.1 修饰类
//        特点:不能被继承
//        3.2 修饰方法
//        不能重写
//        3.3 对象变量
//        变量的值只能初始化一次，值不能更新。
//        4.接口  是一个纯抽象类  只有抽象方法
//        4.1 定义接口  关键字：interface
//        4.2 接口定义的方法：让你在实现类中用。
//                4.3 接口和类的关系  ：实现关系 implements
//                4.4 一个类实现接口：必须实现父接口的所有抽象方法。
//                4.5 实现父接口方法的快捷键  alt+enter
//                4.6 接口和接口：继承关系 extends 多继承
//                4.7 接口内没有构造方法

public class 课上笔记 {
}
