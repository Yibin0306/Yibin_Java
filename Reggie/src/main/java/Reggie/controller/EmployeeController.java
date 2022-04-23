package Reggie.controller;

import Reggie.common.R;
import Reggie.entity.Employee;
import Reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping(value = "/login")
    public R<Employee> login(HttpServletRequest request , @RequestBody Employee employee){
        //1、将页面握交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2、根据页面提交的用户名username查询数据库
        //3、如果没有查询到则返回登录失败结果
        //4、密码比对，如果不一致则返回登录失败结果
        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        //6、登录成功，将员工id存入Session并返回登录成功结果
        return null;
    }
}
