package 第一章Mybatis.entity;

import java.util.List;

public class 用户部门 {
    private Integer depid;
    private String depname;
    private String depLocation;
    private List<用户> 用户s;

    @Override
    public String toString() {
        return "用户部门{" +
                "depid=" + depid +
                ", depname='" + depname + '\'' +
                ", depLocation='" + depLocation + '\'' +
                ", 用户s=" + 用户s +
                '}';
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getDepLocation() {
        return depLocation;
    }

    public void setDepLocation(String depLocation) {
        this.depLocation = depLocation;
    }

    public List<用户> get用户s() {
        return 用户s;
    }

    public void set用户s(List<用户> 用户s) {
        this.用户s = 用户s;
    }

    public 用户部门(Integer depid, String depname, String depLocation, List<用户> 用户s) {
        this.depid = depid;
        this.depname = depname;
        this.depLocation = depLocation;
        this.用户s = 用户s;
    }

    public 用户部门() {
    }
}
