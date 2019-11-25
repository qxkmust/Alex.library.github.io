package library;

import entities.User;
import library.mapper.AuthcMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName AuthcControllerTest
 * @Description
 * @Date 2019/11/3 14:48
 * @Author Alex
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthcControllerTest {
    Logger LOG = LoggerFactory.getLogger(AuthcControllerTest.class);
    @Autowired
    AuthcMapper authcMapper;
    @Test
    public void testLogin(){
//        User user = new User("2019704101", "1", "1");
//        User login = authcMapper.login(user);
//        LOG.info(login.toString());
    }
}
