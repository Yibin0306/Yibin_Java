package springboot整合rides.controller;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@RestController
public class Redis常用类型 {
    @Autowired
    private StringRedisTemplate Template;

    //一.Hash数据类型
    //1.获取Hash中的数据
    @RequestMapping("getHash")
    public String getName(String key){
        if (!Template.hasKey(key))
        {
            return "key不存在，请先保存数据";
        }
        return "获取到Redis中的数据：Hash："+Template.opsForHash().entries("Map");
    }
    //2.Hash数据添加
    @RequestMapping("addHash")
    public String addHash(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "伊斌");
        map.put("age", "20");
        map.put("sex", "男");
        Template.opsForHash().putAll("Map", map);
        //使用entries获取整个user对象
        return "添加Map数据成功";
    }

    //二.List数据类型
    //1.获取List中的数据
    @RequestMapping("getList")
    public String getList(String key){
        if (!Template.hasKey(key))
        {
            return "key不存在，请先保存数据";
        }
//        return "获取到redis中的数据：List："+Template.opsForList().rightPop(key);
//        return "获取到redis中的数据：List："+Template.opsForList().leftPop(key);
        return "获取到Redis中的数据：List："+Template.opsForList().range(key,0,-1);
    }
    //2.List数据添加
    @RequestMapping("addList")
    public String addList(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("伊斌");
        list.add("20");
        list.add("男");
//        Template.opsForList().rightPush("list", String.valueOf(list));
        Template.opsForList().leftPush("list", String.valueOf(list));
        return "添加List数据成功";
    }

    //三.Set数据类型
    //1.获取Set中的数据
    @RequestMapping("getSet")
    public String getSet(String key){
        if (!Template.hasKey(key))
        {
            return "key不存在，请先保存数据";
        }
        return "获取到Redis中的数据：Set："+Template.opsForSet().members(key);
    }
    //2.Set数据添加
    @RequestMapping("addSet")
    public String addSet(){
        HashSet<Object> Set = new HashSet<>();
        Set.add("伊斌");
        Set.add("20");
        Set.add("男");
        Template.opsForSet().add("Set", String.valueOf(Set));
        return "添加Set数据成功";
    }

    //删除Key值操作
    @RequestMapping("deleteAll")
    public String deleteHash(String key){
        if (Template.hasKey(key)){
            Template.delete(key);
            return "删除key成功";
        }
        return "key值不存在,无需删除";
    }
}
