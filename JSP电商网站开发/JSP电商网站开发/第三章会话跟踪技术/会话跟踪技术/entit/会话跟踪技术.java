package 第三章会话跟踪技术.会话跟踪技术.entit;

import java.util.Objects;

public class 会话跟踪技术 {
    private String name;
    private String pwd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        会话跟踪技术 会话跟踪技术 = (会话跟踪技术) o;
        return name.equals(会话跟踪技术.name) && pwd.equals(会话跟踪技术.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public 会话跟踪技术(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public 会话跟踪技术() {
    }

    @Override
    public String toString() {
        return "会话跟踪技术{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
