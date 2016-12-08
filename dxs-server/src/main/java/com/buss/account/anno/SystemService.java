package com.buss.account.anno;

/**
 * Created by Administrator on 2016/6/23.
 */
import java.lang.annotation.*;

/**
 *自定义注解 拦截service
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface SystemService {

    String description()  default "";


}
