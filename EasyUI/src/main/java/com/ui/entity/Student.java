package com.ui.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String pwd;
    private Integer sid;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sid=" + sid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Student(Integer id, String name, Integer age, String sex, String pwd, Integer sid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pwd = pwd;
        this.sid = sid;
    }

    public Student() {
    }
}
