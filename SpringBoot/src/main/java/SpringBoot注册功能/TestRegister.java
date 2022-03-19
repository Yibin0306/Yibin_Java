package SpringBoot注册功能;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("SpringBoot注册功能.dao")
public class TestRegister {
    public static void main(String[] args) {
        SpringApplication.run(TestRegister.class,args);
    }
}