package 第二章Spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
    //初始化方法
    public void init(){
        System.out.println("bean被初始化");
    }
    //销毁
    public void destroy(){
        System.out.println("bean销毁...");
    }
    //text
    public static void text() {
        System.out.println("hello world");
    }
    //调用方法
    public static void main(String[] args) {
//        new text().text();
        //1.开启spring的容器、工厂
        AbstractApplicationContext spring = new ClassPathXmlApplicationContext("第二章Spring/spring.xml");
        HelloWorld app = (HelloWorld) spring.getBean("app");
        app.text();
        //bean 单例  销毁    多例 不销毁
        spring.registerShutdownHook();
    }
}
