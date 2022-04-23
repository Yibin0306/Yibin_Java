package Reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//输出日志
@Slf4j
@SpringBootApplication
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class, args);
        //输出日志
        log.info("\n" +
                "  ┏┓　　 ┏┓\n" +
                " ┏┛┻━━━━┛┻┓\n" +
                " ┃　　　　　┃\n" +
                " ┃　　　━　　┃\n" +
                " ┃　┳┛　┗┳   ┃\n" +
                " ┃　　　　　　  ┃\n" +
                " ┃　　　┻　　  ┃\n" +
                " ┃　　　　　  ┃\n" +
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