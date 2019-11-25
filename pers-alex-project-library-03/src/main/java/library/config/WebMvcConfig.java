package library.config;

import library.component.MyLocaleResolver;
import library.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义视图解析器
 * @ClassName WebMvcConfig
 * @Description
 * @Date 2019/11/2 23:01
 * @Author Alex
 * @Version 1.0
 **/
@Configuration
@ComponentScan("library.interceptor")
public class WebMvcConfig {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Bean
    public WebMvcConfigurer getWebMvcConfig(){
        return new WebMvcConfigurer() {
            /*
            * 自定义拦截器
            * */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(loginInterceptor)
//                        拦截所有请求
                        .addPathPatterns("/**")
                        // 排除不需要拦截的请求
                        .excludePathPatterns("/login","/login.html")
                        .excludePathPatterns("/css/*","/img/*","/js/*");
            }

            /*
            * 添加视图控制
            * */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/login.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }
        };
    }
    // 需要替换mvc自动配置类中区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
