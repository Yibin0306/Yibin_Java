package Reggie.service.impl;

import Reggie.entity.Employee;
import Reggie.mapper.EmployeeMapper;
import Reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
//继承mybatis-plus提供的BaseMapper<加对应Mapper,实体类>后implements到Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{
}