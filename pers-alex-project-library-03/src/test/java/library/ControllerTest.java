package library;

import library.config.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @ClassName DatasourceTest
 * @Description
 * @Date 2019/11/21 0:08
 * @Author Alex
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void dataSource(){
        System.out.println(dataSource.getClass());
    }

    @Test
    public void IOCTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WebMvcConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for(String n : names){
            System.out.println(n);
        }
    }
}
