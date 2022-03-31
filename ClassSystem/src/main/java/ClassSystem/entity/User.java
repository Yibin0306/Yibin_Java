package ClassSystem.entity;

public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String dorm;
    private String address;
    private String token;
    private int roleid;
    private int start;
    private int end;
    private int page;

    public User() {
    }

    public User(String username, String password, String name, String phone, String dorm, String address, String token, int roleid, int start, int end, int page) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.dorm = dorm;
        this.address = address;
        this.token = token;
        this.roleid = roleid;
        this.start = start;
        this.end = end;
        this.page = page;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dorm='" + dorm + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                ", roleid=" + roleid +
                ", start=" + start +
                ", end=" + end +
                ", page=" + page +
                '}';
    }
}
