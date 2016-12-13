package com.buss.shoppingcart.controller;

import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.common.service.SysServiceI;
import com.buss.shoppingcart.trans.vo.Cart;
import com.buss.shoppingcart.trans.vo.ShoppingItme;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import com.buss.trainoutlinecourse.entity.TrainOutlineCourseEntity;
import com.sun.tools.javah.InternalError;
import org.antlr.analysis.NonLLStarDecisionException;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/25.
 */
@Controller
@RequestMapping("UpdateProduct")
public class QueryAndUpdateProduct {


    @Autowired
    private SysServiceI sysServiceI;


    /**
     * 提交订单后更新商品的数量
     * @param id        商品的ID
     * @param type      产品的类型
     * @param num       商品的数量
     * @return
     */
    @RequestMapping("updataProductNumber")
    @ResponseBody
    public ReplyDataMode updataProductNumber(String id,String type,String num){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // >产品类型所对应的码:    活动=1    线上课程=5   线下课程=7     鸿鑫币=10(鸿鑫币的id(固定值)=4451a52a68a503cd8061)
        if (!StringUtil.isEmpty(id) && !StringUtil.isEmpty(type) && !StringUtil.isEmpty(num)){
            // 活动
            if ("1".equals(type)) {
                ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class, id);
                if (activessEntity != null) {
                    // 报名人数
                    Integer i = activessEntity.getRegNumbers() + Integer.parseInt(num);
                    activessEntity.setRegNumbers(i);
                    this.sysServiceI.saveOrUpdate(activessEntity);
                }else {
                    replyDataMode.setStatusCode("没有该商品!");
                    replyDataMode.setSuccess(false);
                }
            // 线上课程
            }else if ("5".equals(type)){
//                this.sysServiceI.get()
            }


        }
        return replyDataMode;
    }

    /**
     * 查询商品的详细信息
     * @param outId
     * @param type
     * @param hxbNum
     * @param paymentAttribute
     * @return
     */
    public Object queryProductInfo(String outId,String type,String hxbNum,String paymentAttribute){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 产品类型所对应的码:    活动=1    课程=5    鸿鑫币=10(鸿鑫币的id(固定值)=4451a52a68a503cd8061)
        ShoppingItme shoppingItme = new ShoppingItme();
        Cart cart = new Cart();

        // 活动
        if (type.equals("1")){
            List<ActivessEntity> activessEntities = this.sysServiceI.findByProperty(ActivessEntity.class,"id",outId);
            if (activessEntities != null && activessEntities.size() > 0){
                ActivessEntity activessEntity = activessEntities.get(0);
                shoppingItme.setOutId(activessEntity.getId());
                shoppingItme.setName(activessEntity.getActiveTitle());
                // 1:全款   2:定金
                if (!StringUtil.isEmpty(paymentAttribute) && paymentAttribute.equals("2")){
                    shoppingItme.setPrice(String.valueOf(activessEntity.getActivePrice() * 0.4));
                }else {
                    shoppingItme.setPrice(String.valueOf(activessEntity.getActivePrice()));
                }
                shoppingItme.setNum("1");
                shoppingItme.setPrices(String.valueOf(activessEntity.getActivePrice() * 1));
                shoppingItme.setType("1");
                // >后续完善
                shoppingItme.setIsHave("true");
                cart.addItem(shoppingItme);
                return cart;
            }
            // 线上课程
        }else if (type.equals("5")){
            List<TrainOnlineCourseEntity> trainOnlineCourseEntities = this.sysServiceI.findByProperty(TrainOnlineCourseEntity.class,"id",outId);

            if (trainOnlineCourseEntities != null && trainOnlineCourseEntities.size() > 0){

                return trainOnlineCourseEntities.get(0);
            }
            // 线下课程
        } else if (type.equals("7")){
            List<TrainOutlineCourseEntity> trainOutlineCourseEntitys = this.sysServiceI.findByProperty(TrainOutlineCourseEntity.class,"id",outId);

            // 鸿鑫币
        }else if (!StringUtil.isEmpty(hxbNum) && type.equals("10")){
            shoppingItme.setOutId("4451a52a68a503cd8061");
            shoppingItme.setName("鸿鑫币");
            shoppingItme.setNum(hxbNum);
            BigDecimal bigDecimal = new BigDecimal("0.01");
            BigDecimal bigDecimal1 = new BigDecimal(hxbNum + "");
            shoppingItme.setPrices(String.valueOf(bigDecimal.multiply(bigDecimal1)));
            shoppingItme.setPrice("0.01");
            shoppingItme.setType("10");
            shoppingItme.setIsHave("true");
            cart.addItem(shoppingItme);

            return cart;
        }

        return null;
    }


    public static void main(String arge[]){

        BigDecimal bigDecimal = new BigDecimal("0.01");
        BigDecimal bigDecimal2 = new BigDecimal("10");



        System.out.println(Float.valueOf(bigDecimal.multiply(bigDecimal2).toString()));
    }
}
