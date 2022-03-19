package 第一章Mybatis.作业.dao;

import 第一章Mybatis.entity.用户;
import 第一章Mybatis.作业.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    //查询单个用户
    Employee EmployeeOne(Integer eid);
    //查询所有用户
    List<Employee> EmployeeAll();
    //foreach批量删除用户
    Integer deleteEmployeeId(List<Integer> eids);
    //查询单个用户带经理
    List<Employee> EmployeeOnes(Integer sid);
}
