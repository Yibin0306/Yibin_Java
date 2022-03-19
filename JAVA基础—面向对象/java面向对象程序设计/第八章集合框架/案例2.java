package 第八章集合框架;

import java.util.ArrayList;
import java.util.List;

public class 案例2 {
    public static void main(String[] args) {
        案例 guo = new 案例("a1", "小郭", "男", 22, "上海");
        案例 huang = new 案例("a2", "小黄", "男", 22, "上海");
        案例 ana = new 案例("a3", "ana", "女", 22, "上海");
        案例 mu = new 案例("a4", "穆大姐", "女", 33, "上海");

        List list = new ArrayList();
        list.add(guo);
        list.add(huang);
        list.add(ana);

        list.add(1,mu);

        System.out.println("删除前共有"+list.size()+"个快递员");

        //删除第一个快递员和mu
        list.remove(0);
        list.remove(mu);

        System.out.println("删除后共有"+list.size()+"个快递员\n分别是：");

        for (int i=0;i<list.size();i++){
            案例 c = (案例)list.get(i);
            System.out.println(c.getCourierId()+"\t"+c.getName());
        }

        for (int i=0;i<list.size();i++){
            if (list.contains(guo)){
                System.out.println("集合中包含小郭的信息");
            }else {
                System.out.println("集合中不包括小郭的信息");
            }
        }
    }
}
