package ClassSystem.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisTemplateUtil {

    @Autowired
    private StringRedisTemplate template;

    public String setValue(String key,String value){
        template.opsForValue().set(key, value);
        return "保存成功";
    }

    public String getValue(String key){
        if (!template.hasKey(key)){
            return "key不存在，请先保存数据";
        }else {
            String value = template.opsForValue().get(key);//根据key获取缓存中的val
            return value;
        }
    }

    public String deleteValue(String key){
        if (template.hasKey(key)){
            template.delete(key);
            return "数据删除成功";
        }
        return "key不存在，无需删除";
    }
}