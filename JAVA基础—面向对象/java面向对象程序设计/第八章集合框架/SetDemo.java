package 第八章集合框架;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set set = new HashSet();//hash值 hashcode码
        set.add("tom");
        set.add(1);
        set.add(2);
        set.add(false);
        set.add(true);
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        set.add("jerry");
        Collection list = new ArrayList();
        list.add(1);
        list.add(2);

        set.remove("tom");
        set.removeAll(list);

        for(Object obj:set){
            System.out.println(obj);
        }



    }
}
