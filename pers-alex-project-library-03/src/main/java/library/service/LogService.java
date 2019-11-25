package library.service;

import entities.Log;
import library.mapper.AuthcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LogService
 * @Description
 * @Date 2019/11/19 13:28
 * @Author Alex
 * @Version 1.0
 **/
@Service
public class LogService {
    @Autowired
    AuthcMapper authcMapper;

    public Integer saveLog(Log log){
        return authcMapper.saveLog(log);
    }
}
