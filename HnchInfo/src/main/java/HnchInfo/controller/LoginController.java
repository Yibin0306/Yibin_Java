package HnchInfo.controller;

import HnchInfo.entity.Claim_voucher_item;
import HnchInfo.entity.Department;
import HnchInfo.entity.Employee;
import HnchInfo.service.LoginService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    public LoginService loginService;

    //访问主界面
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    //登录验证
    @RequestMapping("employee/login")
    @ResponseBody
    public String login(Employee employee, HttpSession httpSession){
//        Employee employee1 = new Employee();
        Employee login = loginService.login(employee);
        if(login==null){
            return "false";
        }else{
//            httpSession.setAttribute("myself", employee1);
            return "true";
        }
    }
    //top  个人信息
    @RequestMapping("self")
    public String self(){
        return "self";
    }
    //top  修改密码
    @RequestMapping("to_change_password")
    public String to_change_password(){
        return "change_password";
    }
    //top  退出登录
    @RequestMapping("quit")
    public String quit(){
        return "login";
    }
    //top  待处理报销单
    @RequestMapping("/claim_voucher/deal")
    public String claim_voucher_deal(){
        return "claim_voucher_deal";
    }
    //top  个人报销单
    @RequestMapping("/claim_voucher/self")
    public String claim_voucher_self(){
        return "claim_voucher_self";
    }
    //top  填写报销单
    @RequestMapping("/claim_voucher/to_add")
    public String claim_voucher_add(Claim_voucher_item abc , Model model){
        model.addAttribute("info", abc);
        return "claim_voucher_add";
    }
    //top  所有员工
    @RequestMapping("/employee/list")
    public String employee_list(){
        return "employee_list";
    }
    //top  添加员工
    @RequestMapping("/employee/to_add")
    public String employee_add(Employee abc , Model model){
        model.addAttribute("employee", abc);
        return "employee_add";
    }
    //top  所有部门
    @RequestMapping("/department/list")
    public String department_list(){
        return "department_list";
    }
    //top  添加部门
    @RequestMapping("/department/to_add")
    public String department_add(Department abc , Model model){
        model.addAttribute("department", abc);
        return "department_add";
    }

}
