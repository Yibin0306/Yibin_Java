package 整合MybatisSpring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import 整合MybatisSpring.entity.User;
import 整合MybatisSpring.service.UserService;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("整合MS/Spring.xml");
        UserService userService =(UserService) context.getBean("userService");
        //查询所有用户
//        List<User> all = userService.findAll();
//        System.out.println(all);
        //添加用户
//        Integer tom = userService.add(new User(4, "tom", "123"));
//        System.out.println(tom);
        //修改用户名
//        Integer yibin = userService.update(new User(4, "tom","12dsa3"));
//        System.out.println(yibin);
        //删除用户
//        Integer delete = userService.delete(4);
//        System.out.println(delete);

    }
}
