package 第一章Mybatis.作业.entity;

import java.util.List;

public class Department {
    private Integer deptid;
    private String deptname;
    private String deptmanager;
    private List<Employee> employees;

    @Override
    public String toString() {
        return "department{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", deptmanager='" + deptmanager + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptmanager() {
        return deptmanager;
    }

    public void setDeptmanager(String deptmanager) {
        this.deptmanager = deptmanager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(Integer deptid, String deptname, String deptmanager, List<Employee> employees) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptmanager = deptmanager;
        this.employees = employees;
    }

    public Department() {
    }
}
