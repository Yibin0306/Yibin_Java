package HnchInfo.controller;

import HnchInfo.entity.Employee;
import HnchInfo.service.LoginService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    @ResponseBody
    public String login(Employee employee, HttpSession httpSession){
//        Employee employee1 = new Employee();
        Employee login = loginService.login(employee);
        if(login==null){
//            return "账号或密码不正确，登录失败!";
            return "false";
        }else{
//            httpSession.setAttribute("myself", employee1);
            return "true";
        }
    }
}
