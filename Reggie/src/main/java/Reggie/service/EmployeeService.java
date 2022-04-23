package Reggie.service;

import Reggie.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

//继承mybatis-plus提供的IService<加对应实体类>
public interface EmployeeService extends IService<Employee> {
}
