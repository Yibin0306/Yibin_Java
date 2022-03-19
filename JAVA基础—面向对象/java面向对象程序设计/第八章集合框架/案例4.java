package 第八章集合框架;

import java.util.HashSet;
import java.util.Iterator;

public class 案例4 {
    public static void main(String[] args) {
        案例 guo = new 案例("a1", "小郭", "男", 22, "上海");
        案例 guo2 = new 案例("a1", "小黄", "男", 22, "上海");
        案例 ana = new 案例("a3", "ana", "女", 28, "郑州");

        HashSet set = new HashSet();
        set.add(guo);
        set.add(ana);
        set.add(guo2);

        //迭代遍历  iterator 迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            案例 c =(案例)iterator.next();
            System.out.println(c);
        }
    }
}
