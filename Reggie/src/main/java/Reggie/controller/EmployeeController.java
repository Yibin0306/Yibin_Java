package Reggie.controller;

import Reggie.common.R;
import Reggie.entity.Employee;
import Reggie.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

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
        //包装成一个查询对象
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        //数据库内是索引唯一的用户名数据 所以调用getOne
        Employee emp = employeeService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if (emp == null){
            return R.error("此用户没有注册呢~");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if (!emp.getPassword().equals(password)){
            return R.error("密码错误呢~");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if (emp.getStatus() == 0){
            return R.error("用户账号被禁用了呢~");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * 员工退出操作
     * @param request
     * @return
     */
    @PostMapping(value = "/logout")
    public R<String> logout(HttpServletRequest request){
        //清理Session中保存的当前登录员工的id
        request.getSession().removeAttribute("employee");
        return R.success("欢迎下次登录呢~");
    }
}
