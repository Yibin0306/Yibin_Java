package 第八章集合框架;

import java.util.HashMap;
import java.util.Map;

public class 案例5 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("CCTV","中央电视台");
        map.put("BTV","北京电视台");
        map.put("HNTV","河南电视台");
        map.put("TVB","翡翠台");

        String tvValue = (String) map.get("CCTV");

        System.out.println("元素共有"+map.size()+"个");

        System.out.println("map中包含cctv的键吗？"+map.containsKey("CCTV"));

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map);

        map.clear();
        if (map.isEmpty()){
            System.out.println("已清空map中的数据");
        }

    }
}
