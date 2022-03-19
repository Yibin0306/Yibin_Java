package 第一章Mybatis.作业.entity;

import java.util.Date;
import java.util.List;

public class Employee {
    private Integer eid;
    private String ename;
    private Date edate;
    private Date ebirthday;
    private Integer deptid;
    private List<Department> departments;


    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", edate=" + edate +
                ", ebirthday=" + ebirthday +
                ", deptid=" + deptid +
                ", departments=" + departments +
                '}';
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Employee(List<Department> departments) {
        this.departments = departments;
    }



    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Date getEbirthday() {
        return ebirthday;
    }

    public void setEbirthday(Date ebirthday) {
        this.ebirthday = ebirthday;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Employee(Integer eid, String ename, Date edate, Date ebirthday, Integer deptid) {
        this.eid = eid;
        this.ename = ename;
        this.edate = edate;
        this.ebirthday = ebirthday;
        this.deptid = deptid;
    }

    public Employee() {
    }
}
