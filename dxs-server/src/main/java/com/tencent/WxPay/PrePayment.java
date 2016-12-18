package com.tencent.WxPay;

import com.tencent.WXPay;
import com.tencent.common.Util;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by JSADKFJ on 2016/12/17.
 */
@Controller
@RequestMapping("/prePayment")
public class PrePayment {


    /**
     * 统一下单(初始化参数)
     * @param body 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
     * @param attach 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
     * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
     * @param totalFee 订单总金额，单位为“分”，只能整数
     * @param productId 商品ID
     */
    @RequestMapping(value = "wxPay")
    @ResponseBody
    public ReplyDataMode wxPay(String body, String attach, String outTradeNo, int totalFee, String productId, HttpServletRequest request) throws Exception {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 客户端IP
        String spbillCreateIp = "";

        spbillCreateIp = request.getHeader("x-forwarded-for");
        if(spbillCreateIp == null || spbillCreateIp.length() == 0 || "unknown".equalsIgnoreCase(spbillCreateIp)) {
            spbillCreateIp = request.getHeader("Proxy-Client-IP");
        }
        if(spbillCreateIp == null || spbillCreateIp.length() == 0 || "unknown".equalsIgnoreCase(spbillCreateIp)) {
            spbillCreateIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if(spbillCreateIp == null || spbillCreateIp.length() == 0 || "unknown".equalsIgnoreCase(spbillCreateIp)) {
            spbillCreateIp = request.getRemoteAddr();
        }

        Calendar nowTime = Calendar.getInstance();
        // 订单生成时间
        // 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
        String timeStart = Util.dateFormat(nowTime.getTime(),"yyyyMMddHHmmss");

        // 订单失效时间(格式同上)
        String timeExpire = Util.dateFormat(nowTime.getTime(),"yyyyMMddHHmmss");

        // 有参构造初始化参数
        ScanPayReqDatas scanPayReqData = new ScanPayReqDatas(body,attach,outTradeNo,totalFee,
                spbillCreateIp,productId,timeStart,timeExpire);

        // 请求支付
        String result = WXPay.requestScanPayService(scanPayReqData);

        List<String> list = new ArrayList<String>();
        list.add(result);

        replyDataMode.setData(list);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    public static void main(String[] arge){
        Calendar nowTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(nowTime.getTime());
        System.out.println(date);
    }
}
