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
 * Timer定时器
 * Created by HongXinGuoJi-yzg on 2016/12/14.
 */
public class TaskExecutionLisener extends HttpServlet implements ServletContextListener{


    /*
    在web.xml中加载该监听器,同servlet一起启动

    <!--定时任务-->
    <!--<listener>
    <listener-class>com.buss.shoppingcart.controller.TaskExecutionLisener</listener-class>
    </listener>-->
    */


    /**
     * 监听开始
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


        // 当监听开始执行时,设置一个TIME
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            // 定时的任务
            @Override
            public void run() {
                System.out.println("执行的任务!");
            }
        }, 60000, 60000);

    }

    /**
     * 监听开始销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
