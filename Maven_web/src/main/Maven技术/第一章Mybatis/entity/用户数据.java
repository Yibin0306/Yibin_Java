package 第一章Mybatis.entity;

public class 用户数据 {
    private Integer id;
    private String number;
    private Integer userid;

    private 用户 用户;

    @Override
    public String toString() {
        return "用户数据{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", userid=" + userid +
                ", 用户=" + 用户 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public 第一章Mybatis.entity.用户 get用户() {
        return 用户;
    }

    public void set用户(第一章Mybatis.entity.用户 用户) {
        this.用户 = 用户;
    }

    public 用户数据(Integer id, String number, Integer userid, 第一章Mybatis.entity.用户 用户) {
        this.id = id;
        this.number = number;
        this.userid = userid;
        this.用户 = 用户;
    }

    public 用户数据() {
    }
}
