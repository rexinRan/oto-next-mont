package com.buss.shoppingcart.controller;


import com.buss.common.service.impl.SysServiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by HongXinGuoJi-yzg on 2016/12/14.
 */
public class TimedTask {

    private SysServiceImpl sysService;

    public SysServiceImpl getSysService() {
        return sysService;
    }

    public void setSysService(SysServiceImpl sysService) {
        this.sysService = sysService;
    }

    public void execute(){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        SessionFactory factory=wac.getBean(SessionFactory.class);
        Session session=factory.openSession();
//        Query query = session.createQuery("from User");
//        List<User> userlist=query.list();
        session.close();
        /*QueryAndUpdateProduct queryAndUpdateProduct = new QueryAndUpdateProduct(sysService);
        queryAndUpdateProduct.OverdueOrderProductUpdateNum();*/

        System.out.println("已执行!");
    }

}
