package com.ui.controller;

import com.ui.entity.Admin;
import com.ui.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/adminController")
public class AdminContoller {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(Admin admin){
        if(admin.getAname().equals("tom") && admin.getApwd().equals("123")){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("findAll")
    public Map<String, Object> findAll(Integer page,Integer rows){
        Integer total = adminService.getTotal();
        List<Admin> all = adminService.findAll((page - 1) * rows, rows);
        Map<String, Object> ma = new HashMap<>();
        ma.put("total",total);
        ma.put("rows",all);
        return ma;
    }

}
