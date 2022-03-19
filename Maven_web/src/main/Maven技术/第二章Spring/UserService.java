package 第二章Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {
    public void add(){
        System.out.println("添加事物中");
    }

    public void update(){
        System.out.println("修改事物中");
    }

    public void delete(){
        System.out.println("删除事物中");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("第二章Spring/spring.xml");
        UserService userService =(UserService) context.getBean("userService");
        userService.update();
    }
}
