package 第一章Mybatis.作业.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import 第一章Mybatis.作业.dao.DepartmentDao;
import 第一章Mybatis.作业.dao.EmployeeDao;
import 第一章Mybatis.作业.entity.Department;
import 第一章Mybatis.作业.entity.Employee;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class 测试 {
    public static void main(String[] args) {
        try {
            //读取mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("第一章Mybatis/作业/mybatis.xml");
            //SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //生产SqlSession  默认事务是手动提交
            SqlSession sqlSession = factory.openSession();
            //获得接口对象
            EmployeeDao EmployeeDao = sqlSession.getMapper(EmployeeDao.class);
            DepartmentDao DepartmentDao = sqlSession.getMapper(DepartmentDao.class);
//            1.通过员工编号查询员工信息
//            Employee employee = EmployeeDao.EmployeeOne(1);
//            System.out.println(employee);
            //2.查询员工姓名中李的员工信息
//            List<Employee> employees = EmployeeDao.EmployeeAll();
//            System.out.println(employees);
            //3.通过员工编号批量删除员工
//            ArrayList<Integer> integers = new ArrayList<>();
//            integers.add(6);
//            integers.add(7);
//            Integer integer = EmployeeDao.deleteEmployeeId(integers);
//            System.out.println(integer);
//            sqlSession.commit();
//            4.通过员工编号查询员工信息，带部门经理
//            List<Employee> employees = EmployeeDao.EmployeeOnes(2);
//            System.out.println(employees);
            //5.通过部门编号查询该部门所有员工信息
//            Department departmentOne = DepartmentDao.findDepartmentOne(1);
//            System.out.println(departmentOne);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
