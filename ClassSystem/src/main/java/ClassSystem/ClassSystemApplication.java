package ClassSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("ClassSystem.mapper")
public class ClassSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassSystemApplication.class, args);
    }

}
