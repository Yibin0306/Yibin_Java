package 第十三章论坛短消息.entit;

public class 账号信息 {
    private Integer id;
    private String uname;
    private String upwd;
    private String email;


    public 账号信息(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public 账号信息(String uname, String upwd, String email) {
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
    }

    @Override
    public String toString() {
        return "账号信息{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public 账号信息(Integer id, String uname, String upwd, String email) {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
        this.email = email;
    }

    public 账号信息() {
    }
}
