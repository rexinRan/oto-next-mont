package com.buss.orders.controller;


import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.mail.MailParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Title: Controller
 * @Description: dxs_orders
 * @author onlineGenerator
 * @date 2016-09-18 14:14:28
 * @version V1.0
 */
@Controller
@RequestMapping("/Orders")
public class OrdersController {

    @RequestMapping(value = "test")
    @ResponseBody
    public ReplyDataMode test(String name,String age) throws UnsupportedEncodingException {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (!StringUtil.isEmpty(name)){
          name = new String(name.getBytes("iso-8859-1"),"UTF-8");

        }

        System.out.println("name = " + name + ";age = " + age);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        map.put("age",age);

        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }
}
