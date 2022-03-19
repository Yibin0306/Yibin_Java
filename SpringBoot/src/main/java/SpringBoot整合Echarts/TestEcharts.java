package SpringBoot整合Echarts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("SpringBoot整合Echarts.dao")
public class TestEcharts {
    public static void main(String[] args) {
        SpringApplication.run(TestEcharts.class,args);
    }
}