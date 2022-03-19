package 第三章会话跟踪技术.session.entit;

import java.util.Objects;

public class Entit {
    private String name;
    private String pwd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entit entit = (Entit) o;
        return Objects.equals(name, entit.name) && Objects.equals(pwd, entit.pwd);
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

    public Entit(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Entit() {
    }

    @Override
    public String toString() {
        return "entit{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
