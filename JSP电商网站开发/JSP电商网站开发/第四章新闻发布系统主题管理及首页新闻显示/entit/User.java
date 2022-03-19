package 第四章新闻发布系统主题管理及首页新闻显示.entit;


/*
 * �û� ʵ����
 * @author
 */


public class User {

    private String uid;
    private String uname;
    private String upwd;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUpwd() {
        return upwd;
    }
}

