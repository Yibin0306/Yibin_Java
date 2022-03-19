package 第七章抽象类和接口;

public class GeneralStudent extends Student{
    public GeneralStudent(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void study() {
        System.out.println("努力学习，赶超第一");
    }
}
