package 第二章Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class 自动注入 {
    Student student1;

    public void test自动注入(){
        student1.a();
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("第二章Spring/spring.xml");
        自动注入 自动注入 = (第二章Spring.自动注入) spring.getBean("自动注入");
        自动注入.test自动注入();
    }
}
