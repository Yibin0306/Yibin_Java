package 第八章集合框架;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 课上练习 {
    public static void main(String[] args) {
        //1..创建一个ArrayList集合对象，变量类型用List
        List list = new ArrayList();
        //2.在list中添加如下元素：  1,2,"tom","jerry","eric",true,false,4.44
        list.add(1);
        list.add(2);
        list.add("tom");
        list.add("jerry");
        list.add("eric");
        list.add(true);
        list.add(false);
        list.add(4.44);
        //3.获取list中下标为4的元素的值并打印
        Object o = list.get(4);
        System.out.println(o);
        //4.在list下标为4的位置添加元素 33
        list.add(4,33);
        //5.从list删除 false
        boolean remove = list.remove(false);
        System.out.println(remove);
        //6.遍历list集合用两种方式：1.下标遍历  2.foreach遍历
        System.out.println("下标遍历...");
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("foreach遍历..");
        for (Object o1:list){
            System.out.println(o1);
        }
//-------------------------------------------------------------------------------
        //8.创建一个HashMap集合
        Map map = new HashMap();
        //9.在map中添加 "name":"tom","age":23,"sex":"男" 三个键值对
        map.put("name","tom");
        map.put("age",23);
        map.put("sex","男");
        //10.获取map中key为age的元素的值
        Object age = map.get("age");
        System.out.println(age);
        //11.遍历map集合，分别打印 key 和 value
        for (Object o2:map.keySet()){
            System.out.println("key:"+o2+" , value:"+map.get(o2));
        }
        //12.删除key为sex的键值对
        Object sex = map.remove("sex");
        System.out.println(sex);
    }
    //13.List,Set,Map三者的区别？
/* 1.list和Set都是Collection子接口 Map不是
   2.list元素是有顺序的  set的元素是无序的  map的元素是一键值对形式
   3.list元素的值可以重复   set元素的值不能重复  map的key不能重复，值可以重复
   4.list元素的值能为空  set的元素可以为空但只能有一个  map的键可以为空但只能有一个，值可以为空并且可以多个
 */

    //14.ArrayList和LinkedList的区别？:
/*ArrayList和LinkedList的区别
-类 ArrayList  底层基于数组 值可以重复
优点：查询快
缺点：增删慢
-类 LinkedList 底层基于链表
优点：增删快
缺点：查询慢*/
}
