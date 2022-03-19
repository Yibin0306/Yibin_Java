package 第八章集合框架;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class person {
    public String name;
    public String sex;
    public int age;
    String pwd;

    public person(String name, String sex, int age, String pwd) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

public class 案例 extends person {
    private String courierId;
    private String name1;
    private String sex1;
    private int age1;
    private String pwd1;

    public 案例(String name, String sex, int age, String pwd, String courierId, String name1, String sex1, int age1, String pwd1) {
        super(name1, sex1, age1, pwd1);
        this.courierId = courierId;
        this.name1 = name1;
        this.sex1 = sex1;
        this.age1 = age1;
        this.pwd = pwd1;
    }

    public 案例(String courierId, String name1, String sex1, int age1, String pwd1) {
        super(name1,sex1,age1,pwd1);
        this.courierId = courierId;
        this.name1 = name1;
        this.sex1 = sex1;
        this.age1 = age1;
        this.pwd = pwd1;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    @Override
    public String toString() {
        return "快递员信息[编号="+courierId+",姓名="+super.getName()+",性别=" +super.getSex()+",年龄=" + super.getAge() +"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        案例 案例 = (案例) o;
        return age1 == 案例.age1 && Objects.equals(courierId, 案例.courierId) && Objects.equals(name1, 案例.name1) && Objects.equals(sex1, 案例.sex1) && Objects.equals(pwd1, 案例.pwd1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courierId, name1, sex1, age1, pwd1);    }

    public static void main(String[] args) {
        案例 guo = new 案例("a1", "小郭", "男", 22, "上海");
        案例 huang = new 案例("a2", "小黄", "男", 22, "上海");
        案例 ana = new 案例("a3", "ana", "女", 22, "上海");
        案例 mu = new 案例("a4", "穆大姐", "女", 33, "上海");

        List list = new ArrayList();
        list.add(guo);
        list.add(huang);
        list.add(ana);

        list.add(1,mu);

        System.out.println("总共有"+list.size()+"个快递员");

        for (int i=0;i<list.size();i++){
            案例 c = (案例)list.get(i);
            System.out.println(c.getCourierId()+"\t"+c.getName());
        }
    }
}
