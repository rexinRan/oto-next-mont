package com.alipay.account;

import com.alipay.config.*;
import com.alipay.util.*;
import com.buss.common.service.SysServiceI;
import com.buss.orders.entity.OrdersEntity;
import com.buss.shoppingcart.controller.Order;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 *功能：即时到账交易接口接入页
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *************************注意*****************
 *如果您在接口集成过程中遇到问题，可以按照下面的途径来解决
 *1、开发文档中心（https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.KvddfJ&treeId=62&articleId=103740&docType=1）
 *2、商户帮助中心（https://cshall.alipay.com/enterprise/help_detail.htm?help_id=473888）
 *3、支持中心（https://support.open.alipay.com/alipay/support/index.htm）
 *如果不想使用扩展功能请把扩展功能参数赋空值。
 **********************************************
 */

@Controller
@RequestMapping("/alipayapi")
public class Alipayapi {


    @Autowired
    private SysServiceI sysServiceI;

    @RequestMapping(value = "submitOrderDefrayal.do")
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletOutputStream out = null;
        try {
            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes(),"UTF-8");

            //商品名称，必填
            String subject = new String(request.getParameter("WIDsubject").getBytes(),"UTF-8");

            //付款金额，必填
            String total_fee = new String(request.getParameter("WIDtotal_fee").getBytes(),"UTF-8");//"ISO-8859-1"

            //商品描述，可空
            String body = new String(request.getParameter("WIDbody").getBytes(),"UTF-8");



            //////////////////////////////////////////////////////////////////////////////////

            // 查询订单的金额,然后和客户端传过来的订单金额比较
            List<OrdersEntity> ordersEntityList = this.sysServiceI.findByProperty(OrdersEntity.class,"orderNum",out_trade_no);
            if (ordersEntityList != null && ordersEntityList.size() > 0){
                OrdersEntity ordersEntity = ordersEntityList.get(0);
                // 比较金额是否相等
                if (Float.parseFloat(total_fee) == Float.parseFloat(ordersEntity.getOrderAll())){
                    //把请求参数打包成数组
                    Map<String, String> sParaTemp = new HashMap<String, String>();
                    sParaTemp.put("service", AlipayConfig.service);
                    sParaTemp.put("partner", AlipayConfig.partner);
                    sParaTemp.put("seller_id", AlipayConfig.seller_id);
                    sParaTemp.put("_input_charset", AlipayConfig.input_charset);
                    sParaTemp.put("payment_type", AlipayConfig.payment_type);
                    sParaTemp.put("notify_url", AlipayConfig.notify_url);
                    sParaTemp.put("return_url", AlipayConfig.return_url);
                    sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
                    sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
                    sParaTemp.put("out_trade_no", out_trade_no);
                    sParaTemp.put("subject", subject);
                    sParaTemp.put("total_fee", total_fee);
                    sParaTemp.put("body", body);
                    //其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
                    //如sParaTemp.put("参数名","参数值");

                    //建立请求
                    String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");

                    // 设置头信息,将from表单写到客户端
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-type", "text/html;charset=utf-8");
                    out = response.getOutputStream();
                    out.write(sHtmlText.getBytes("UTF-8"));
                }else {
                    Exception exception = new Exception();
                    throw exception;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (out != null){

                out.close();
            }
        }
    }
}
