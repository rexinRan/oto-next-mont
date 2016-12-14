package com.buss.shoppingcart.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HongXinGuoJi-yzg on 2016/12/14.
 */
public class TaskExecutionLisener extends HttpServlet implements ServletContextListener{

    /**
     * 监听开始
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


        // 当监听开始执行时,设置一个TIME
        Timer timer = new Timer();

        MyTimer myTimer = new MyTimer();
        timer.scheduleAtFixedRate(myTimer,60000,60000);

    }

    /**
     * 监听开始销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
