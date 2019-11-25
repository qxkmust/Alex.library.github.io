package utils;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PermissionAnnotation {
    public boolean permission() default false;//是否需要鉴权，一般针对增删改业务需要鉴权，值为true
}
