package com.buss.account.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/6/23.
 *
 * 面向切面配置鸿鑫币
 *
 */

@Aspect
@Component
public class Money {


//    @Pointcut("execution(* com.buss.common.controller.FileUploadController.signDay(..))")
//    @Pointcut("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
//    @Pointcut("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
//    public void anyMethod(){}//定义一个切入点

//    @Before("anyMethod() && args(name)")
//    public void doAccessCheck(String name){
//        System.out.println(name);
//        System.out.println("前置通知");
//    }
//
//    @AfterReturning("anyMethod()")
//    public void doAfter(){
//        System.out.println("后置通知");
//    }
//
//    @After("anyMethod()")
//    public void after(){
//        System.out.println("最终通知");
//    }
//
//    @AfterThrowing("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
//    public void doAfterThrow(){
//        System.out.println("例外通知");
//    }

    @Around("execution(* com.buss.common.controller.FileUploadController.signDay(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }



}
