package 整合SSM.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import 整合SSM.entity.员工;
import 整合SSM.service.员工service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class 员工controller {

    @Autowired
    private 员工service 员工service;

    @RequestMapping("add")
    public String add(员工 员工){
        Integer add = 员工service.add(员工);
        return "forward:findAll";
    }

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request){
//        Jedis je = new Jedis("localhost", 6379);
//        String s = je.get("all");
//        List<员工> all = JSONObject.parseArray(s,员工.class);
//        System.out.println(all+"---------------");
//        if(all==null){
//            List<员工> all1 = 员工service.findAll();
//            System.out.println("================");
//            je.set("all",JSONObject.toJSONString(all1));
//        }
        List<员工> all = 员工service.findAll();
        request.setAttribute("all",all);
        return  "整合SSM/所有员工";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        Integer delete = 员工service.delete(id);
        return "forward:findAll";
    }

    @RequestMapping("update")
    public String update(员工 员工){
        Integer update = 员工service.update(员工);
        return "forward:findAll";
    }
}
