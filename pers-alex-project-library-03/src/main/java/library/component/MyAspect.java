package library.component;

import entities.RestSet;
import entities.User;
import library.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import utils.MethodAnnotation;
import utils.PermissionAnnotation;
import utils.RequestUtil;
import entities.Log;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @ClassName MyAspect
 * @Description
 * @Date 2019/11/19 23:30
 * @Author Alex
 * @Version 1.0
 **/
@Component
@Aspect
public class MyAspect {
    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request;
//    现场安全的时间对象，用于记录日志
    private final NamedThreadLocal<Long> localTime = new NamedThreadLocal<Long>("locateTime");
//    日志对象
    private final NamedThreadLocal<Log> LOG = new NamedThreadLocal<Log>("log");

    //切入点，带有MethodAnnotation注解
    @Pointcut("@annotation(utils.MethodAnnotation)")
    public void logPointCut(){};

    @Before("logPointCut()")
    public void before(JoinPoint joinPoint) throws Throwable{
//          开始记录日志时间
        Log log = new Log();
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if(loginUser != null)
        {
            log.setsUsername(loginUser.getsUsername());
        }
        Long beginTime = System.currentTimeMillis();
        log.setsLogTime(new DateTime(beginTime).toString("yyyy-MM-dd HH:mm:ss"));
        localTime.set(beginTime);
        LOG.set(log);
    }

    @After("logPointCut()")
    public void after(JoinPoint joinPoint){
        //获取方法签名
        MethodSignature  methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取目标方法
        Method method = methodSignature.getMethod();
        //获取方法上的注解
        MethodAnnotation methodAnnotation = method.getDeclaredAnnotation(MethodAnnotation.class);
        //得到el表达式
        String[] el = methodAnnotation.keys();
        String[] values = new String[el.length];
        //解析el表达式，将#var等替换为参数值
        for(int j = 0;j < el.length; j++) {
            ExpressionParser expressionParser = new SpelExpressionParser();
            Expression expression = expressionParser.parseExpression(el[j]);
            EvaluationContext context = new StandardEvaluationContext();
            String[] parameterNames = methodSignature.getParameterNames();
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < parameterNames.length; i++) {
                context.setVariable(parameterNames[i], args[i]);
            }
            String key = expression.getValue(context).toString();
            values[j] = key;
        }
//        后置方法
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        Log log = LOG.get();
        if(loginUser != null)
        {
            log.setsUsername(loginUser.getsUsername());
        }
        //如果会话过期，无效操作不会记录到日志
        if(log.getsUsername() != null && log.getsUsername() != ""){
            String addr = RequestUtil.getIpAddr(request);
            log.setsIp(addr);
            log.setsLogDetail(MessageFormat.format(methodAnnotation.msg(), Arrays.asList(values)));
            Long endTime = System.currentTimeMillis();
            log.setiTimespan(endTime-localTime.get());
            logService.saveLog(log);
        }
    }

/*
* 以下用于鉴权
* */
    @Pointcut("@annotation(utils.PermissionAnnotation)")
    public void authcPointCut(){};
    //环绕通知，包含前置通知和后置通知，相当于同时使用@Before和@After
    @Around("authcPointCut()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        //获取方法签名
        MethodSignature  methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取目标方法
        Method method = methodSignature.getMethod();
        //获取方法上的注解
        PermissionAnnotation annotation = method.getDeclaredAnnotation(PermissionAnnotation.class);
        if(annotation.permission()){
            return "main/error";
        }
        Object o = joinPoint.proceed();//在此之前都是前置方法，后置方法在后
        return o;
    }

}
