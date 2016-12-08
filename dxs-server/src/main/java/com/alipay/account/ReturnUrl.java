package com.alipay.account;

import java.io.IOException;
import java.util.*;
import java.util.Map;
import com.alipay.util.*;
import com.alipay.config.*;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.orders.entity.OrdersEntity;
import com.buss.paymentnotice.entity.PaymentNoticeEntity;
import com.buss.paymentnotice.trans.form.PaymentNoticeForm;
import com.sun.xml.internal.xsom.impl.ListSimpleTypeImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* *
 功能：支付宝页面跳转同步通知页面
 版本：3.2
 日期：2011-03-17
 说明：
 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 //***********页面功能说明***********
 该页面可在本机电脑测试
 可放入HTML等美化页面的代码、商户业务逻辑程序代码
 TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
 TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
 //********************************
 * */
@Controller
@RequestMapping("/returnUrl")
public class ReturnUrl {

    @Autowired
    private SysServiceI sysServiceI;

    @RequestMapping(value = "returnUrlInfo.do")
    public String returnUrlInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//        ServletOutputStream out = null;
        // 设置头信息,将信息表单写到客户端
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-type", "text/html;charset=utf-8");
        try {
            //获取支付宝GET过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            if (requestParams != null && requestParams.size() > 0){
                for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                    String name = (String) iter.next();
                    String[] values = (String[]) requestParams.get(name);
                    String valueStr = "";
                    for (int i = 0; i < values.length; i++) {
                        valueStr = (i == values.length - 1) ? valueStr + values[i]
                                : valueStr + values[i] + ",";
                    }
                    //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                    valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                    params.put(name, valueStr);
                }

                //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
                //商户订单号

                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号

                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //交易状态
                String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

                //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

                //计算得出通知验证结果
                boolean verify_result = AlipayNotify.verify(params);

                if(verify_result){//验证成功
                    //////////////////////////////////////////////////////////////////////////////////////////
                    //请在这里加上商户的业务逻辑程序代码

                    try {
                        /**
                         * 将支付后的返回参数保存
                         */
                        PaymentNoticeForm paymentNoticeForm = new PaymentNoticeForm();
                        BeanUtils.populate(paymentNoticeForm,params);
                        if (user != null){
                            paymentNoticeForm.setUserId(user.getId());
                        }
                        paymentNoticeForm.setWhetherSuccessful("1");
                        paymentNoticeForm.setIsDelete("0");
                        PaymentNoticeEntity paymentNoticeEntity = (PaymentNoticeEntity) paymentNoticeForm.toEntity();
                        paymentNoticeEntity.setCreateTime(new Date());

                        sysServiceI.saveOrUpdate(paymentNoticeEntity);

                        // 更新订单表的支付状态
                        List<OrdersEntity> ordersEntityList = this.sysServiceI.findByProperty(OrdersEntity.class,"orderNum",out_trade_no);
                        if (ordersEntityList != null && ordersEntityList.size() > 0){
                            if (paymentNoticeEntity.getTrade_status().equals("TRADE_SUCCESS"));

                            // 订单状态:0到付,3待付款,9已付款,9待退款,12退款成功,15退款失败
                            OrdersEntity ordersEntity = ordersEntityList.get(0);
                            ordersEntity.setOrderStatus(9);

                            // 更新
                            this.sysServiceI.saveOrUpdate(ordersEntity);
                        }

                        // 更新购商品的库存




                    }catch (Exception e){
                        e.printStackTrace();

                        /*replyDataMode.setStatusCode("支付成功,但更新订单表中的数据失败!");
                        replyDataMode.setSuccess(false);
                        return replyDataMode;*/
                    }

                    //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
                    if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
                        //判断该笔订单是否在商户网站中已经做过处理
                        //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                        //如果有做过处理，不执行商户的业务程序
                    }

                    //该页面可做页面美工编辑
//                out.println("验证成功<br />");
                    //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

//                out = response.getOutputStream();
//                out.write("验证成功<br />".getBytes("UTF-8"));
                    /*replyDataMode.setStatusCode("验证成功:Return_Url");
                    replyDataMode.setSuccess(true);*/

                    //////////////////////////////////////////////////////////////////////////////////////////
                }else{
                    //该页面可做页面美工编辑
//                out.println("验证失败");
//                out = response.getOutputStream();
//                out.write("验证失败".getBytes("UTF-8"));

                    PaymentNoticeForm paymentNoticeForm = new PaymentNoticeForm();
                    BeanUtils.populate(paymentNoticeForm,params);
                    if (user != null){
                        paymentNoticeForm.setUserId(user.getId());
                    }
                    paymentNoticeForm.setWhetherSuccessful("0");
                    paymentNoticeForm.setIsDelete("0");
                    PaymentNoticeEntity paymentNoticeEntity = (PaymentNoticeEntity) paymentNoticeForm.toEntity();
                    paymentNoticeEntity.setCreateTime(new Date());

                    sysServiceI.saveOrUpdate(paymentNoticeEntity);

                    replyDataMode.setStatusCode("验证失败:Return_Url");
                    replyDataMode.setSuccess(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }/*finally {
            if (out != null){
                out.close();
            }
        }*/
        // 重定向
        return "redirect:http://www.csee-china.com/paythree.html";
    }
}
