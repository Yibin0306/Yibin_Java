package SpringMVC框架;

import java.util.List;

public class User1 {
    private Integer id;
    private String name;
    private String bir;
    List<String> sex;
    List<String> hobby;
    private Integer age;

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bir='" + bir + '\'' +
                ", sex=" + sex +
                ", hobby=" + hobby +
                ", age=" + age +
                '}';
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    public User1(String bir) {
        this.bir = bir;
    }

    public List<String> getSex() {
        return sex;
    }

    public void setSex(List<String> sex) {
        this.sex = sex;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public User1(List<String> sex, List<String> hobby) {
        this.sex = sex;
        this.hobby = hobby;
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

    public User1(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User1() {
    }
}
