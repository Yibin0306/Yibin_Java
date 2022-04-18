package ClassSystem.entity;

public class Course {
    private int id;
    private String name;
    private String content;
    private String createtime;
    private String createby;
    private String credit;
    private String upper;
    private String token;
    private int roleid;
    private int start;
    private int end;
    private int page;

    public Course() {
    }

    public Course(int id, String name, String content, String createtime, String createby, String credit, String upper, String token, int roleid, int start, int end, int page) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createtime = createtime;
        this.createby = createby;
        this.credit = credit;
        this.upper = upper;
        this.token = token;
        this.roleid = roleid;
        this.start = start;
        this.end = end;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getUpper() {
        return upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
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
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", createby='" + createby + '\'' +
                ", credit='" + credit + '\'' +
                ", upper='" + upper + '\'' +
                ", token='" + token + '\'' +
                ", roleid=" + roleid +
                ", start=" + start +
                ", end=" + end +
                ", page=" + page +
                '}';
    }
}
