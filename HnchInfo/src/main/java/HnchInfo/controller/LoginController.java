package HnchInfo.controller;

import HnchInfo.entity.Employee;
import HnchInfo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;

    //访问主界面
    @RequestMapping("login")
    public String logins(){
        return "login";
    }

    //登录验证
    @RequestMapping("employee/login")
    public String login(Employee employee){
        Employee login = loginService.login(employee);
        if(login==null){
//            return "账号或密码不正确，登录失败!";
            return "login";
        }else{
//            httpSession.setAttribute("aname", admin.getAname());
            return "self";
        }
    }
}
