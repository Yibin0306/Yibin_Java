package 第八章集合框架;

//第七章：回顾
//        1.抽象关键字： abstract
//    2.定义抽象类: public abstract class Person{}
//    3.定义抽象方法: study ---> public abstract void study();
//        4.抽象类能否实例化(创建对象)  不能
//        5.final修饰属性，方法，类 各自的特点
//        属性：只能初始化一次
//        方法：不能重写
//        类：  不能继承
//        6.如何定义接口
//        USB---->public interface USB{}
//    7.类和类的继承--单继承
//            8.类和接口的实现 --多实现
//            9.接口和接口的继承--多继承

//      第八章  集合
//            集合：可变长度的数组，存储对象（引用，基本）
//            数组：把相同数据类型的一组数
//            int[] i = new int[10];
//            1.集合的分类
//            顶层父接口：Collection
//            -有序 子接口 List
//            -类 ArrayList  底层基于数组 值可以重复
//            优点：查询快
//            缺点：增删慢
//            使用：
//            1.集合创建
//            ArrayList list = new ArrayList();
//            List list = new ArrayList();
//            Collection list = new ArrayList();
//            2.添加元素
//            add(E e); Element 元素
//            list.add(1);
//            list.add(1,1)
//            3.删除元素
//            Object o = list.remove(下标)
//            boolean b = list.remove("tom")
//            4.获取元素
//            Object o = list.get(下标);
//            5.元素个数
//            int i = list.size();
//            6.判断集合中是否存在某个元素
//            boolean b = list.contains("tom")
//            7.遍历
//            7.1 基于下标  get()
//            7.2 foreach
//
//            -类 LinkedList 底层基于链表
//
//            优点：增删快
//            缺点：查询慢
//            -无序 子接口 Set
//            -类 HashSet  值不能重复
//            -队列 队列  Queue
//            2.List集合的使用
//            3.Set集合的使用
//            4.Map集合的使用  元素形式：  key-value
//            -类 HashMap  key键不能重复，添加重复：把值覆盖掉
//
//            1.创建一个ArrayList集合对象，变量类型用List
//            List list = new ArrayList();
//            2.在list中添加如下元素：  1,2,"tom","jerry","eric",true,false,4.44
//            3.获取list中下标为4的元素的值并打印
//            4.在list下标为4的位置添加元素 33
//            5.从list删除 false
//            6.遍历list集合用两种方式：1.下标遍历  2.foreach遍历
//            ------------------------------------------------------------
//            8.创建一个HashMap集合
//            Map map = new HashMap();
//            9.在map中添加 "name":"tom","age":23,"sex":"男" 三个键值对
//            10.获取map中key为age的元素的值
//            11.遍历map集合，分别打印 key 和 value
//            12.删除key为sex的键值对
//            13.List,Set,Map三者的区别？
//            14.ArrayList和LinkedList的区别？
