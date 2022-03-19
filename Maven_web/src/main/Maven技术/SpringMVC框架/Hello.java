package SpringMVC框架;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/*
    localhost:8080/xxx/helloController/hello
    @Controller
    1.用在类上
    2.把这个类交给spring工厂来管理
    3.把类构建成Controller组件
*/
@Controller
@RequestMapping("helloController")
public class Hello {
//    <a href="/Maven_1/hello/hello1?age=23&name=tom&bir=2001/10/10">跳转</a>
    @RequestMapping("hello1")
    public String hello1(Integer age,String name,Date bir) {
        System.out.println("名字="+name+"年龄="+age+"生日="+bir);
        return "SpringMvc框架/springmvc";
    }
//    <a href="/Maven_1/hello/hello2?id=11&name=jerry&age=23">跳转</a>
    @RequestMapping("hello2")
    public String hello2(User user){
        System.out.println(user);
        return "SpringMvc框架/springmvc";
    }
//  如果传集合  手动封装一个集合类
    @RequestMapping("hello3")
    public String hello3(ListObj a){
        for (String i:a.a){
            System.out.println(i);
        }
        return "SpringMvc框架/springmvc";
    }
//  提交表单
    @RequestMapping("hello4")
    public String hello4(User user){
        System.out.println(user);
        return "SpringMvc框架/springmvc";
    }

    //  提交表单
    @RequestMapping("hello5")
    public String hello5(User1 user1){
        System.out.println(user1);
        return "SpringMvc框架/springmvc";
    }
}
