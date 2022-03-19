package SpringBoot注册功能.controller;

import SpringBoot注册功能.entity.Manager;
import SpringBoot注册功能.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Manager")
public class ManagerController {
    @Autowired
    public ManagerService managerService;

    //跳转到前端注册界面
    @RequestMapping("TZ")
    public String test() {
        return "SpringBoot注册功能/注册表";
    }

    //注册功能
    @RequestMapping("regist")
    @ResponseBody
    public String regist(Manager manager) {
        Integer i = managerService.regist(manager);
        if(i>0){
            return "true";
        }else{
            return "false";
        }
    }
    //验证重复名
    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(String name){
        Integer integer = managerService.checkName(name);
        if(integer>0){
            return "false";
        }else{
            return "true";
        }
    }
}
