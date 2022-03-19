package springboot之数据存储;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "springboot之数据存储.*")
@MapperScan("springboot之数据存储.dao")
public class Test数据存储 {
    public static void main(String[] args) {
        SpringApplication.run(Test数据存储.class,args);
    }
}