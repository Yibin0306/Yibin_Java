package springboot整合rides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    //字符串
    @Autowired
    private StringRedisTemplate template;

    //1.获取redis中数据的方法
    @RequestMapping("getValue")
    public String getValue(String key){
        if (!template.hasKey(key))
        {
            return "key不存在，请先保存数据";
        }
        String value = template.opsForValue().get("Name");
        return "获取到redis中的数据：name："+value;
    }

    //2.向redis中存储数据
    //同一个key上面只能存一个值，并且都是以最后一次存储的为主
    @RequestMapping("setValue")
    public String setValue(String key,String value){
        if (!template.hasKey(key)){
            //存储数据用append方法
            template.opsForValue().append(key, value);
            return "redis数据保存成功";
        }else {
            //template.opsForValue().append(key, value);
            template.opsForValue().set(key, value);
            return "key已经存在，但是数据被覆盖数据";
        }
    }
    //3.redis中删除数据
    //通过key进删除
    @RequestMapping("deleteValue")
    public String deleteValue(String key){
        if (template.hasKey(key)){
            template.delete(key);
            return "删除key成功";
        }
        return "key值不存在,无需删除";
    }
}
