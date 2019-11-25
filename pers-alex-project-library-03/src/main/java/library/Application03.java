package library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName Application03
 * @Description
 * @Date 2019/11/2 11:19
 * @Author Alex
 * @Version 1.0
 **/
@MapperScan("library.mapper")
@SpringBootApplication
public class Application03 {
    public static void main(String[] args) {
        SpringApplication.run(Application03.class,args);
    }
}
