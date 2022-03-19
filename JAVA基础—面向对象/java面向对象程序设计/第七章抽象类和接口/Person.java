package 第七章抽象类和接口;

public class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + "]";
    }
}

class text{
    public static void main(String[] args) {
        final Person lisi = new Person("李四");
        lisi.setName("张三");
        System.out.println(lisi.toString());
    }
}
