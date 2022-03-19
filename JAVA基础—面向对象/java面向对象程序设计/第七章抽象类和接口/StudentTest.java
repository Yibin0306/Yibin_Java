package 第七章抽象类和接口;

public class StudentTest {
    public static void main(String[] args) {
        Student zhangsan = new ExcellentStudent("张三", "男", 22);
        zhangsan.eat();
        zhangsan.study();


        GeneralStudent lisi = new GeneralStudent("李四", "男", 22);
        lisi.eat();
        lisi.study();
    }
}
