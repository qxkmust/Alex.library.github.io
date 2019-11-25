package library.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Description
 * @Date 2019/11/3 18:02
 * @Author Alex
 * @Version 1.0
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(!StringUtils.isEmpty(loginUser)){
//            用户已登录，放行
            return true;
        }
//        未登录，跳转登录页
        request.setAttribute("msg","没有权限，请先登录!");
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        /*
        * 拦截器会拦截一切资源请求（除一些静态资源外），非常不灵活，而切面技术可以拦截到具体的某个方法，见MyAspect自定义类
        *
        * */

//        try {
//            if(!(handler instanceof ParameterizableViewController ||
//                    handler instanceof ResourceHttpRequestHandler ||
//                    handler instanceof DefaultServletHttpRequestHandler)){
//                Log log = new Log();
//                String addr = RequestUtil.getIpAddr(request);
//                User loginUser = (User)request.getSession().getAttribute("loginUser");
//                DateTime dateTime = new DateTime(localTime.get());
//                long endTime = System.currentTimeMillis();
//                if(loginUser != null)
//                {
//                    log.setsUsername(loginUser.getsUsername());
//                }
//                log.setsIp(addr);
//                log.setsLogTime(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
//                log.setiTimespan(endTime - localTime.get());
//                HandlerMethod handlerMethod = (HandlerMethod) handler;
//                Class clazz = handler.getClass();
//                if(handlerMethod.getMethod().isAnnotationPresent(MethodAnnotation.class)
//                        && handlerMethod.getBean().getClass().isAnnotationPresent(ClassAnnotation.class)){
//                    String classAnnotationMsg = handlerMethod.getBean().getClass().getAnnotation(ClassAnnotation.class).msg();
//                    MethodAnnotation methodAnnotation = handlerMethod.getMethodAnnotation(MethodAnnotation.class);
//                    String format = methodAnnotation.msg();
//                    String keys = methodAnnotation.keys();
//                    String methodAnnotationMsg = MessageFormat.format(format, keys);
//                    log.setsLogDetail(classAnnotationMsg+" - "+methodAnnotationMsg);
//                    logService.saveLog(log);
//                }
//            }
//        } catch (Exception e) {
//        }
    }
}
