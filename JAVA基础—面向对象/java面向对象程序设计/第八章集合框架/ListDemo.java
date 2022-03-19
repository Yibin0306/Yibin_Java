package 第八章集合框架;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //集合的创建
        /*List list = new ArrayList();
        ArrayList arrayList = new ArrayList();
        List list1 = new ArrayList();
        //添加元素
        list1.add(1);
        list1.add("tom");
        list1.add(true);
        list1.add(3.14);
        list1.add(3,"jerry");*/
        //集合的遍历 基于下标
        /*for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));
        }*/
        //集合的遍历 foreach遍历
        /*for(Object obj:list1){
            System.out.println(obj);
        }*/
        //判断集合是否存在某个值
        /*boolean aaa = list1.contains("jerry");
        System.out.println(aaa);*/
        //获取元素的个数
        /*int size = list1.size();
        System.out.println(size);*/
        //如何获取数组元素
        /*Object o = list1.get(4);
        System.out.println(o);*/
        //删除
        /*Object o1 = list1.remove(12);
        System.out.println(o1);*/
        /*boolean b = list1.remove("tom123");
        System.out.println(b);*/
        /**
         * LinkedList
         */
        //创建集合对象
        List list = new LinkedList();
        list.add(1);
        list.add(1,"tom");

        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);

        list.addAll(list1);
        System.out.println(list.size());
        for(Object o:list){
            System.out.println(o);
        }


    }
}