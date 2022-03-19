package 第二章Spring;

import java.util.List;

public class Setter注入 {
    String name;
    List<String> names;
    Student student;


    public void setName(String name) {
        this.name = name;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public static void main(String[] args) {
        try {
            Class<Setter注入> aClass = (Class<Setter注入>) Class.forName("第二章Spring.Setter注入");
            Setter注入 Setter注入 = aClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
