package 第二章Spring;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 构造注入 {
    String name;
    Integer age;
    Date day;
    List<String> names;
    Set<Integer> ages;
    Map<String,String> map;
    int[] ints;

    Student student;

    public 构造注入(String name, Integer age, Date day, List<String> names, Set<Integer> ages, Map<String, String> map, int[] ints, Student student) {
        this.name = name;
        this.age = age;
        this.day = day;
        this.names = names;
        this.ages = ages;
        this.map = map;
        this.ints = ints;
        this.student = student;
    }
}
