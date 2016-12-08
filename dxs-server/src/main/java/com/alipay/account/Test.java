package com.alipay.account;

import com.buss.common.service.SysServiceI;
import com.buss.paymentnotice.entity.PaymentNoticeEntity;
import com.buss.paymentnotice.trans.form.PaymentNoticeForm;
import org.apache.commons.beanutils.BeanUtils;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JSADKFJ on 2016/11/19.
 */
@Controller
@RequestMapping("/test")
public class Test {


    @Autowired
    private SysServiceI sysServiceI;

    @RequestMapping(value = "demo")
    @ResponseBody
    public ReplyDataMode demo(String[] arge) throws InvocationTargetException, IllegalAccessException {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        PaymentNoticeForm paymentNoticeForm = new PaymentNoticeForm();

        Map map = new HashMap();
        map.put("trade_no","tradeNo");
        map.put("buyer_id","buyerId");
        map.put("exterface","exterface");
        map.put("body","body");
        map.put("subject","subject");
        map.put("notify_time","dddddddddddddddddddd");
        map.put("sign_type",123456);
        BeanUtils.populate(paymentNoticeForm,map);
        PaymentNoticeEntity paymentNoticeEntity = (PaymentNoticeEntity) paymentNoticeForm.toEntity();

        this.sysServiceI.saveOrUpdate(paymentNoticeEntity);

        System.out.print(paymentNoticeForm.toString());


        return replyDataMode;
    }
}
