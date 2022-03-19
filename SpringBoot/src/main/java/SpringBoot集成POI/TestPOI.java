package SpringBoot集成POI;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("SpringBoot集成POI.dao")
public class TestPOI {
    public static void main(String[] args) {
        SpringApplication.run(TestPOI.class,args);
    }
}