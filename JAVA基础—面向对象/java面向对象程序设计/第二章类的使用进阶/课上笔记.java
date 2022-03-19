package 第二章类的使用进阶;

// 1.object
//   1.object类是所有类的父类
//   2.自定义的类默认继承object
//   3.object类中常用的方法
//      1.equals 比较基础类型是否相等，对象是否相等
//      2.tostring 通过对象的 hashcode 码进行16进制运算得到的值，通常称为对象的地址
// 2.构造方法
//   1.构造方法的特点
//      1.没有返回值
//      2.方法名和类名一样
//      3.如果一个构造方法都不写，会默认存在一个无参的构造方法
//      4.如果写了一个构造方法，会默认的无参方法就不存在了
//   2.构造方法的执行节点
//      1.用new关键字创建对象时会调用构造方法
// 3.方法的重载   两个或多个方法名相同的方法
//   1.发生的位置
//      1.在同一个类里
//      2.方法名必须相同
//      3.形参的列表不一样(参数类型不同，参数个数不同，参数顺序不同)
// 4.static关键字
//   1.修饰属性
//      1.多个对象共有的
//   2.修饰方法
//      1.调用     本类：直接  方法名（）      异类：  类名.方法
//   3.修饰静态代码块
//      1.类加载的时候执行，第一次用到类的时候，会发生类加载
// 5.new对象的过程
//     1.静态代码块
//     2.静态变量
//     3.代码块
//     4.变量
//     5.构造方法

public class 课上笔记 {
    static {
        System.out.println(".....");
    }
    public 课上笔记(){
        System.out.println("666");
    }

    // 属性
    // static修饰的属性，在类加载的时候初始化，而且只会初始化一次
    // 类加载：第一次用到类的时候方法类加载
    static int count = 100;
    // 方法
    public static void sale(){
        count=count-1;
    }

    public static void main(String[] args) {

        new 课上笔记();
        new 课上笔记();
        new 课上笔记();



        //创建对象 new 类名 （）
//        课上笔记 sc = new 课上笔记();
//        sc.sale();
//        课上笔记 sc2 = new 课上笔记();
//        sc2.sale();

//        sale();
//        System.out.println(count);


//        课上笔记 sc = new 课上笔记();
//        Class<? extends 课上笔记> aClass = sc.getClass();
//        System.out.println(aClass);

//        int i = sc.hashCode();
//        System.out.println(i);

//        System.out.println("1".hashCode());
//        System.out.println("aaaa".equals("aaaa"));

//        System.out.println(sc.toString());


    }
}
