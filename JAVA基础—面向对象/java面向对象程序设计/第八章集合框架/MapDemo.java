package 第八章集合框架;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map map = new HashMap();
        //添加
        map.put("name","tom");
        map.put("age",23);
        map.put("sex","男");
        //遍历
        //获得键的集合  map.keySet();
        Set set = map.keySet();
        for(Object s:set){
            System.out.println(s+","+map.get(s));
        }


        //修改
//        map.put("name","jerry");
        //获取value
//        Object name = map.get("name");
//        System.out.println(name);
        //删除
        /*Object age = map.remove("age");
        System.out.println(age);
        Object age1 = map.get("age");
        System.out.println(age1)*/;


    }
}