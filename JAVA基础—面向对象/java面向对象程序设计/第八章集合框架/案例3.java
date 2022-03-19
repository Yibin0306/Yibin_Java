package 第八章集合框架;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 案例3 {
    private static class Node{
        int data;
        Node next;
    }
    public static void main(String[] args) {
        案例 guo = new 案例("a1", "小郭", "男", 22, "上海");
        案例 huang = new 案例("a2", "小黄", "男", 22, "上海");
        案例 ana = new 案例("a3", "ana", "女", 22, "上海");
        案例 mu = new 案例("a4", "穆大姐", "女", 33, "上海");

        LinkedList list = new LinkedList();
        list.add(guo);
        list.add(huang);

        list.addFirst(ana);
        list.addLast(mu);

        案例 frist =(案例)list.getFirst();
        System.out.println("第一个快递员是："+frist.getName());

        案例 last =(案例)list.getLast();
        System.out.println("最后一个快递员是："+last.getName());

        list.removeFirst();
        list.removeLast();

        System.out.println("删除后共有"+list.size()+"个快递员\n分别是：");

        for (int i=0;i<list.size();i++){
            案例 c =(案例)list.get(i);
            System.out.println(c.getCourierId()+"\t"+c.getName());
        }
    }
}
