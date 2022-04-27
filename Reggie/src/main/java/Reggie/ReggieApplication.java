package Reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//输出日志
@Slf4j
@SpringBootApplication
//扫描过滤器
@ServletComponentScan
//开启事物的支持
@EnableTransactionManagement
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class, args);
        //输出日志
        log.info("\n" +
                "  ┏┓　　 ┏┓\n" +
                " ┏┛┻━━━━┛┻┓\n" +
                " ┃　　　　　┃\n" +
                " ┃　　 ━　  ┃\n" +
                " ┃　┳┛　┗┳  ┃\n" +
                " ┃　　　　　 ┃\n" +
                " ┃　　　┻　　┃\n" +
                " ┃　　　　　 ┃\n" +
                " ┗━┓　　　┏━┛\n" +
                "   ┃　　　┃ 神兽保佑\n" +
                "   ┃　　　┃ 代码无BUG！\n" +
                "   ┃　　　┗━━━┓\n" +
                "   ┃　　　　　　┣┓\n" +
                "   ┃　　　　　┏┛\n" +
                "   ┗┓┓┏━┳┓┏┛\n" +
                "    ┃┫┫　┃┫┫\n" +
                "    ┗┻┛　┗┻┛\n");
    }
}