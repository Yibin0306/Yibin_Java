package 第七章抽象类和接口;

public class ExcellentStudent extends Student{
    public ExcellentStudent(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void study() {
        System.out.println("多读书，多总结，少吃零食，按时睡觉");
    }
}
