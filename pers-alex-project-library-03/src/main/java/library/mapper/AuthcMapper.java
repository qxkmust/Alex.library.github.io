package library.mapper;

import entities.Log;
import entities.User;

/**
 * @ClassName AuthcMapper
 * @Description
 * @Date 2019/11/2 22:42
 * @Author Alex
 * @Version 1.0
 **/
public interface AuthcMapper {
    User login(User user);
    Integer repwd(User user);
    Integer saveLog(Log log);
}
