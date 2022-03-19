package 第一章Mybatis.作业.dao;

import 第一章Mybatis.entity.用户部门;
import 第一章Mybatis.作业.entity.Department;

public interface DepartmentDao {
    //查询部门内员工
    Department findDepartmentOne(Integer deptid);
}
