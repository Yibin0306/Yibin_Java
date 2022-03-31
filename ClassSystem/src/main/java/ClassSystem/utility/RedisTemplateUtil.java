package ClassSystem.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class RedisTemplateUtil {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping(value = "/setValue")
    public String setValue(String key,String value){
        template.opsForValue().append(key, value);
        return "保存成功";
    }

    @RequestMapping(value = "/getValue")
    public String getValue(String key){
        if (!template.hasKey(key)){
            return "key不存在，请先保存数据";
        }else {
            String value = template.opsForValue().get(key);//根据key获取缓存中的val
            System.out.println(value);
            return "获取到缓存中的数据：value="+value;
        }
    }
}