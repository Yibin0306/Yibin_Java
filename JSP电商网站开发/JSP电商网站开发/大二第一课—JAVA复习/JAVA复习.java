/*第一周：OOP   面向对象
    1.计算机的对象   new Student();   对象 -- 开辟内存空间
    2.类：是模板，统称的概念    对象：具体的存在
    3.类的组成：
        3.1  属性   全局变量  实例的变量
            语法：  数据类型  属性名 = 初始化值：String name = "tom";
            默认值：byte short int long    0
                  double float  0.0
                  char  单个字符快
                  boolean  false
                  String Object    null
            局部变量：使用范围 （从定义行开始，到所在大括号）

        3.2  方法（函数）
            3.2.1：组成  访问修饰符 返回值类型 方法名（形参列表）{}  方法体
                    public int getAge(int age){ return age+5; }
        3.3  方法的重载  Overload
                3.3.1：概念：在一个类中有多个方法名相同的方法
                3.3.2:要求：形参任一不同 （个数 顺序 类型）
                3.3.3：返回值类型没有要求
        3.4  构造方法
                1.方法名和类名保持一致   2.没有返回值类型   3.默认存在一个无参构造方法，一旦手写构造方法，无参构造方法就不存在了
                功能：创建对象 new 构造方法方法名（）；
                        给属性赋值
    4.对象
        1.创建对象 语法 ： 类名 对象名 = new 构造方法名（）；
        2.调用对象 属性 方法  test.name；  test.getAge（）  ； .：的
        3.创建对象的过程：
                Test test = new Test("tom");
                1.new:开辟空间，属性赋值，默认值
                2.初始化属性：初始值
                3.调用构造方法：第三次给属性赋值  this.name = "tom";
        4.this 关键字  用在构造方法，普通方法都可以用
                代表：this.name；当前对象的name属性  this.getAge();  不能用在静态（static）修饰的方法
        5.this()   本类的无参构造方法
                this("tom")  本类要一个String参数构造方法
                this(23)   本类要一个int参数构造方法
        6.super  关键字   父类对象   super.name；
        7.super()  调用父类的无参构造   super(23)
    5.封装   private   私有
        好处：对数据起到保护作用
        封装：类的边界
        专业：属性私有化，提供公开的get/set方法
    6.继承    extends
        概念：类和类的 is-a的关系  student is a person
        student：子类 ，派生类   Person：父类 超类 基类
        子类能继承父类哪些？  非私有的属性，普通方法
    7.继承
        类和类：单继承
        接口和接口：多继承
    8.子类对象的创建过程
        1.开辟空间（父类+子类）给所有属性默认值
        2.递归创建父类对象（）
        3.初始化本类的属性
        4.调用本类的构造方法
    9.多态
        1.多态：一种事物的多种形态，父类的引用指向子类对象
            语法：父类类型 引用名 = 子类对象；
            Person p1 = new Student();
            Person p2 = new Person();
            Person p3 = new Teacher();
            父类的引用 可以指向不同的子类对象，从而导致
            父类引用的多种形态
        2.类型相互转换
            向上：子类型->父类型
            person p = new Teacher（）；
            向下：父类型->子类型
            Teacher t = (Teacher)p;
            类型的判断
        3.instanceof
            if (p instanceof Teacher){
                  Teacher t = (Teacher)p;
                }
        4.多态使用的场景
            1.方法的形参
            public void test1(Person p){
                    System.out.println(p);
                }

            public static void main(String[] args) {
                Student student = new Student();
                student.test1(new Person());
                student.test1(new Student());
                student.test1(new Teacher());
            }
            2.方法的返回值
                public Person test2(){

            //        return new Person();
             //        return new Teacher();
                    return new Student();
                }
            3.对于使用者而言，屏蔽因参数，返回值不同而带来的改变
                使方法调用简单，通用，灵活
    10.抽象
        关键字：abstract
        1.抽象方法
            1.抽象方法：方法只有声明部分
            访问修饰符 返回值类型 方法名 形参
            public abstract void test();
            2.抽象方法只能定义在抽象类中
        2.抽象类
            1.实例化，创建对象（不能）
            2.被继承 可以
            3.可以用多态的语法
    11.关键字：static
        1.属性
            静态变量，被该类的所有对象共享。
        2.方法
            静态方法
            调用：类名.方法（）；
        3.代码块
            static{
                类加载时执行，执行一次
            }
        4.类加载
            概念：JVM第一次用到某个类时，类加载只加载一次，
                 static修饰属性类加载的时候执行
                 类加载的时机：第一次用到这个类的时候
            1.创建对象的过程
                1.父类静态成员（静态属性、方法）
                2.子类的静态成员
                3.递归对父类 类加载1次
                4.子类 类加载1次
                5.分配空间
                6.递归的创建父类对象
                7.调用构造方法
         5.final  最终的，不可变的
            问题：final能修饰抽象方法吗？
                A true    B false 1
            1.修饰类
                最终类：不能被继承
                方法默认都是final,最终方法
            2.方法
                最终方法：不能被重写或覆盖
            3.属性，全局变量
                1.声明时必须要赋值
                2.变量值赋值一次，不允许修改
          6.问题
            1.private  abstract 能一起使用吗？
            A 能     B 不能 1
            2.static abstract 能一起使用吗?
            A 能     B 不能 1
            3.final abstract 能一起使用吗？
            A 能    B 不能 1
    12.接口    规范 没有具体的功能
        1.是特殊的抽象类，纯抽象
        2.面试：接口和抽象类有什么区别？
            1.编译  共同点：都会生成.class
            2.实例化  共同点：不能创建对象，实例化。
                     生成引用（多态）
            3.内部元素：
                接口：方法（抽象）
                抽象类：方法（抽象，非抽象）
        3.类，抽象类，接口的关系
            1.类和类？抽象类的关系    单继承关系
            2.类和接口的关系     多实现关系
            3.接口和接口的关系    多继承关系
    13.包装类
        问题： int a = 10；把int a = 10转成String"10"
        byte Byte short Short  int Integer long Long
        float Float  double Double
        char Character
        boolean Boolean
    14.类型转换
        1.Integer-->String  int i = 10;
            String s =  Integer.toString(Integer i);
            String s2 = i+"";
        2.String-->Integer
        3.jdk1.5之后:自动拆箱，装箱（基本类型和包装类类型自动转换）
    15.字符串 String StringBuffer StringBuilder
        1.String 不可变的字符串
            String name = ”tom“；  //创建一个对象，串池中，共享字符串
            String age = new String（”23“）；  //创建了2个对象，一个在堆空间，一个在串池
        2.StringBuffer StringBuilder
            可变字符串
            StringBuffer; 效率低，线程安全
            StringBuilder; 效率搞，线程不安全
    16.集合
        Collection：容器，存任意对象
        1.方法：
            boolean add(Object o)://成功：true  失败：false
            boolean addAll(Collection c);
            void clear(); isEmpty() remove()
            contains();  size();
            containsAll(); toArray();
        List
            特点：存任意的对象，有顺序，有下标，可以重复
            方法：
            boolean add(Object o)://成功：true  失败：false
            boolean addAll(Collection c);
            void clear(); isEmpty() remove()
            contains();  size();
            containsAll(); toArray();
            遍历：
            下标遍历
            System.out.println("下标遍历...");
            for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            }
            问题：List集合可以用下标遍历吗？可以
        set
            特点：存任意的对象，没有顺序，没有下标，不可以重复
        Map 接口
            1.特点：存key-value对
                key：唯一，没下标
                value：可重复
            2.方法
                get（Object key）
                put（key，value）；
                Object remove（key）；返回key对应的值
            3.遍历
                1.键遍历
                2.值遍历
                3.键值遍历
            4.实现类
                1.HashMap
                    特点：效率高，线程不安全
                2.HashTable
                    特点：效率低，线程安全
    17.异常
        1.分类
            Throwable
            错误：Error
            异常：Exception
                 运行
                 RuntimeException
                 IndexOutOfrBoundsException
                 NullPointException
                 ClassCastException
                 NumberFormatException
                 非运行
                 IOException
                 FileNotFoundException
                 SQLException
            产生：
                 自动产生
                 手动抛出
            处理：
                 1.消极处理 在当前位置不处理 抛出去 上抛

                 2.积极：try-catch-finally{//无论是否捕捉到异常，代码始终会执行}
    18.线程：
        Thread
        1.线程的组成
            CPU
            数据
                对象  堆空间
                变量  栈空间
        2.功能代码
            一.
                1.继承Thread
                MyTread1  extends Thread
                2.重写、覆盖run（）；
                {核心的业务代码}
                3.创建线程对象
                Thread t1 = new MyThread1（）；
                4.启动：
                问题1：启动线程调用方法
                A start
            二.
               1.实现Runnable接口
               MyTread2 implements Runnable
               2.实现，run()
               3.创建线程对象
               4.创建自定义线程对象
               MyThread2 m2 = new MyThread2（）；
               5.创建线程对象
               new Thread（m2）；
               Thread2 m2 = new Thread2（）；
               6.启动 t2.start（）；
        3.线程状态
                                                     时间到进入就绪状态    ||  等待结束进入就绪状态
                                        wait（ms）join（ms）sleep（ms）  ||  无限期等待
                                                            限期等待    ||   join（）   wait（）
            new 初始状态 --start()--> ready 就绪 <--时间片到期--获得cpu时间片--> running 运行 --运行结束--> 结束
                                                                           synchronized锁
                                                                           进入阻塞状态Blocked
                                                                           获得锁标记进入就绪状态

            1.问题一：线程从就绪-->运行的条件
                    a：start  b：run  c：获得时间片1
            2.问题二：线程在运行结束前时间片到期会进入哪种状态？
                    a：结束   b：阻塞   c：等待  d：就绪1
            3.问题三：线程有几个状态？
                    b，7
        作业：
             1.分别用继承和实现两种方式创建线程
                核心业务：打印99乘法表
            实现方法：class cfb implements Runnable{
                      public void run(){
                       int i = 0;
                       int j = 0;
                        for (i=1;i<=9;i++){
                          for (j=1;j<=i;j++){
                              System.out.println(i+"*"+j+"="+i*j+"\t");
                           }
                            System.out.println();
                        }
                      }
                    }

                    public class 多线程练习{
                      public static void main(String[] args) {
                          cfb cfb1 = new cfb();
                            cfb1.run();
                      }
                    }

            继承方法：class cfb extends Thread{
                      public void run(){
                      int i = 0;
                      int j = 0;
                         for (i=1;i<=9;i++){
                            for (j=1;j<=i;j++){
                               System.out.println(i+"*"+j+"="+i*j+"\t");
                           }
                            System.out.println();
                     }
                  }
                }

                    public class 多线程练习{
                     public static void main(String[] args) {
                        cfb cfb1 = new cfb();
                            cfb1.run();
                          }
                    }
        */