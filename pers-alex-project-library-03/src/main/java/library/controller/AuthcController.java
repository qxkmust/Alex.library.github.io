package library.controller;

import entities.RestSet;
import entities.User;
import library.mapper.AuthcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import utils.ClassAnnotation;
import utils.MethodAnnotation;
import utils.PermissionAnnotation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName AuthcController
 * @Description
 * @Date 2019/11/2 22:38
 * @Author Alex
 * @Version 1.0
 **/
@Controller
@ClassAnnotation(msg = "权限业务控制层")
public class AuthcController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AuthcMapper authcMapper;

    /*
    * 登录验证
    * */
    @PostMapping("/login")
    @MethodAnnotation(msg = "用户登录")
    public String login(HttpSession session,
                        @RequestParam(name="username", required = true) String username,
                        @RequestParam(name="password", required = true) String password,
                        @RequestParam(name="identity", required = true) Integer identity,
                        @RequestParam(name="rememberme",required = true, defaultValue = "") String rememberme,
                        Map<String, Object> mp){
        User loginUser = authcMapper.login(new User(username, password, identity));
        if(loginUser != null) {
            if(!StringUtils.isEmpty(rememberme)){
                loginUser.setiRemember(true);
            }
            session.setAttribute("loginUser", loginUser);
            return "redirect:/main.html";
        }
        mp.put("msg","用户名或密码错误!");
        return "main/login.html";
    }

    /*
    * 前往修改密码页面
    * */
    @GetMapping("/password")
    @PermissionAnnotation(permission = true)
    public String password(){
        return "main/password";
    }

    /*
    *校验原密码
    * */
    @ResponseBody
    @GetMapping("/password/{oldPassword}")
    public Boolean password(@PathVariable("oldPassword")String oldPassword){
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            if(oldPassword.equals(loginUser.getsPwd())){
                return true;
            }
        }
        return false;
    }

    /*
    * 修改密码
    * */
    @PutMapping("/password")
    @MethodAnnotation(msg = "修改密码")
    public String repassword(User user){
        authcMapper.repwd(user);
        return "redirect:/logout";
    }

    /*
    * 登出系统
    * */
    @GetMapping("/logout")
    @MethodAnnotation(msg = "用户退出系统")
    public String logout(HttpSession session){
//        清空session中的用户登录信息
        session.removeAttribute("loginUser");
//        销毁session
        session.invalidate();
        return "redirect:/login.html";
    }
}
