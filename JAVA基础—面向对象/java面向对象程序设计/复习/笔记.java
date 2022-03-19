package 复习;



//1. Java类型
//        (1) 数据类型
//        1 8大基本数据类型
//        1) 整数
//        a. Byte   -2^7 ---    +2^7-1
//        b. Short  -2^15   +2^15-1
//        c. Int    -2^31    +2^31-1
//        d. Long  -2^63   +2^63-1
//        2) 浮点型
//        a. Double    16
//        b. Float      8
//        3) 字符
//        a. Char
//        4) 布尔
//        a. Boolean   值： true  false
//        2 引用类型/对象类型
//        2. 变量
//        (2) 局部变量  在方法内
//        (3) 全局变量  在方法外
//        (4) 变量名命名规范：驼峰命名法 helloWorld
//        (5) 声明：   数据类型  变量名   int age;
//        (6) 赋值：  赋值符号：=         age=23;
//        (7) 变量的使用规范：必须先声明，再赋值，才使用
//        3. 方法
//        (1) 组成：
//        1 访问修饰符  private 不写 protected  public
//    2 返回值类型  8大基本，引用类型
//            3 方法名：驼峰命名法 getSum
//            4 形参列表(int a,double b,String c)
//            5 方法体   {    }
//// 声明一个getMin方法，接收三个整型参数，放回三个中最小值
//            Public int getMin(int a1,int b1,int c1){
////返回值
//            Return 最小;
//            }
////void: 空的
//            Public void test(){
//            }
//            方法：
//            书
//            1. java三大特性
//            (1) 封装：第三章
//            1 封装：why 保护代码的私密性
//            2 封装的步骤：
//            1) 属性私有化  属性前加上  private 访问修饰符
//        2) 提供公开的getter/setter方法
//        3) 可以在getter/setter设置条件
//        4) 快速生成get/set方法 alt+insert
//
//        5) .访问修饰符
//        a. Private  同一个类
//        b. 不写    同一类，同包
//        c. Protected  同类，同包，子类
//        d. Public  所有地方
//        6) 构造方法
//        a. 特点：
//        a) 没有返回值类型
//        b) 方法名和类名相同
//        c) 类中默认存在一个无参构造方法
//        d) 如果你写啦一个构造方法，那个无参的就不存在啦
//        b. 使用节点：new 关键字 创建对象时使用到
//        c. 属性的默认值：
//        a) String  null
//        b) Int byte short long   0
//        c) Char 字节占位符
//        d) Double  0.0
//        e) Boolean false
//
//        d. 方法：
//        (2) 继承：第四章
//        (3) 多态：第五章
//        2. 异常
//        (1) 第六章
//        3. 抽象类和接口
//        (1) 第七章
//        4. 集合
//        (1) Collection  接口 子接口 List  Set  |  Map 第八章
//        5. 泛型
//        (1) 第九章
//        6. I/O 流  输入输入流
//        (1) 第十章
//        7. 线程
//        (1) 第十一章