package ClassSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ClassSystem.*")
public class ClassSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassSystemApplication.class, args);
    }

}
