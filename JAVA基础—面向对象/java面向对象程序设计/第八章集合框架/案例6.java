package 第八章集合框架;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 案例6 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("CCTV","中央电视台");
        map.put("BTV","北京电视台");
        map.put("HNTV","河南电视台");
        map.put("TVB","翡翠台");

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("KEY="+entry.getKey()+",值="+entry.getValue());
        }
    }
}
