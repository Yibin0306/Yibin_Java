package Spring集合Redis;

import SpringMVC框架.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

public class JedisDemo {
    public static void main(String[] args) {
        //首先启动 redis 服务    java连结redis
        Jedis localhost = new Jedis("localhost", 6379);

        //存入string
//        String age = localhost.set("age", "23");
//        String age1 = localhost.get("age");
//        System.out.println(age+age1);
        User user = new User(3, "tom", 12);

        // java对象--》字符串  JSONObject类
        String s = JSONObject.toJSONString(user);
        localhost.set("user", s);
        String s1 = localhost.get("user");
        System.out.println(s1);

        //字符串---对象
        User user1 = JSONObject.parseObject(s1, User.class);

    }
}
