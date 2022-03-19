package 课上练习;

public class 客户信息表 {
    private int 客户id;
    private String 客户名称;
    private String 客户密码;
    private String 客户电话;
    private String 客户邮箱;
    private String 客户地址;
    private int 客户余额;

    public 客户信息表() {
    }

    public 客户信息表(int 客户id, String 客户名称, String 客户密码, String 客户电话, String 客户邮箱, String 客户地址, int 客户余额) {
        this.客户id = 客户id;
        this.客户名称 = 客户名称;
        this.客户密码 = 客户密码;
        this.客户电话 = 客户电话;
        this.客户邮箱 = 客户邮箱;
        this.客户地址 = 客户地址;
        this.客户余额 = 客户余额;
    }

    public int get客户id() {
        return 客户id;
    }

    public void set客户id(int 客户id) {
        this.客户id = 客户id;
    }

    public String get客户名称() {
        return 客户名称;
    }

    public void set客户名称(String 客户名称) {
        this.客户名称 = 客户名称;
    }

    public String get客户密码() {
        return 客户密码;
    }

    public void set客户密码(String 客户密码) {
        this.客户密码 = 客户密码;
    }

    public String get客户电话() {
        return 客户电话;
    }

    public void set客户电话(String 客户电话) {
        this.客户电话 = 客户电话;
    }

    public String get客户邮箱() {
        return 客户邮箱;
    }

    public void set客户邮箱(String 客户邮箱) {
        this.客户邮箱 = 客户邮箱;
    }

    public String get客户地址() {
        return 客户地址;
    }

    public void set客户地址(String 客户地址) {
        this.客户地址 = 客户地址;
    }

    public int get客户余额() {
        return 客户余额;
    }

    public void set客户余额(int 客户余额) {
        this.客户余额 = 客户余额;
    }

    @Override
    public String toString() {
        return "客户信息表{" +
                "客户id=" + 客户id +
                ", 客户名称='" + 客户名称 + '\'' +
                ", 客户密码='" + 客户密码 + '\'' +
                ", 客户电话='" + 客户电话 + '\'' +
                ", 客户邮箱='" + 客户邮箱 + '\'' +
                ", 客户地址='" + 客户地址 + '\'' +
                ", 客户余额=" + 客户余额 +
                '}';
    }
}

