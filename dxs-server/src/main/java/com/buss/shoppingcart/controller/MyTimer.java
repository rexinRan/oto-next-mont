package com.buss.shoppingcart.controller;

import com.buss.common.service.SysServiceI;
import com.buss.orderitems.entity.OrderItemsEntitys;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by HongXinGuoJi-yzg on 2016/12/13.
 */
public class MyTimer extends TimerTask{


    @Autowired
    private SysServiceI sysServiceI;
    @Autowired
    private QueryAndUpdateProduct queryAndpdateProduct;



    @Override
    public void run() {
        queryAndpdateProduct.OverdueOrderProductUpdateNum();
    }
}
