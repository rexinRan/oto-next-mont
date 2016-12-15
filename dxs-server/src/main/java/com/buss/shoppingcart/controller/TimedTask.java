package com.buss.shoppingcart.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.common.service.impl.SysServiceImpl;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.orderitems.entity.OrderItemsEntitys;
import com.buss.orders.entity.OrdersEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCoursesEntity;
import com.buss.trainoutlinecourse.entity.TrainOutlineCoursesEntity;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.protobuf.UnmodifiableLazyStringList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * quartz定时器
 * Created by HongXinGuoJi-yzg on 2016/12/14.
 */
public class TimedTask {

    /**
     * 定时任务
     *   更新过期订单项中商品的数量
     */
    public void execute() {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        SessionFactory factory = wac.getBean(SessionFactory.class);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        //0到付,3待付款,9已付款,9待退款,12退款成功,15退款失败
        //0到付,3待付款,9已付款,9待退款,12退款成功,15退款失败
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = simpleDateFormat.format(date);

        String sql = "SELECT\n" +
                "\to.id\n" +
                "FROM\n" +
                "\tdxs_orders o\n" +
                "WHERE\n" +
                "\to.is_delete = 0\n" +
                "AND o.order_status = 3\n" +
                "AND TIMESTAMPDIFF(\n" +    // 计算两个时间的差函数
                "\tMINUTE,\n" +             // 返回时间差为分钟
                "\to.create_time,\n" +
                "\t'" + dates + "'\n" +
                ") >= '120'";

        try {
            // 过期的订单
            Query query = session.createSQLQuery(sql);
            List<String> orderList = query.list();

            if (orderList != null && orderList.size() > 0) {
                for (String s : orderList) {
                    // 查询订单项
                    String orderItemSql = "SELECT\n" +
                            "\toi.id,\n" +
                            "\toi.out_id,\n" +
                            "\toi.num,\n" +
                            "\toi.out_catalog\n" +
                            "FROM\n" +
                            "\tdxs_order_items oi\n" +
                            "WHERE\n" +
                            "\toi.order_id ='"+ s +"'";
                    Query query1 = session.createSQLQuery(orderItemSql);
                    List<Object[]> orderItems = query1.list();
                    if (orderItems != null && orderItems.size() > 0) {

                        for (Object[] orderItem : orderItems) {
                            Object[] obj = orderItem;
                            String itmeId = (String)obj[0];
                            String outId = (String)obj[1];
                            Integer num = (Integer)obj[2];
                            String type = (String)obj[3];

                            if (num != null) {
                                String productNum = String.valueOf(num);

                                // 更新数量
                                // >产品类型所对应的码:    活动=1    线上课程=5   线下课程=7     鸿鑫币=10(鸿鑫币的id(固定值)=4451a52a68a503cd8061)
                                if (!StringUtil.isEmpty(outId) &&
                                        !StringUtil.isEmpty(type) &&
                                        !StringUtil.isEmpty(productNum)) {

                                    // 活动
                                    if ("1".equals(type)) {
                                        ActivessEntity activessEntity= (ActivessEntity) session.get(ActivessEntity.class,outId);
                                        if (activessEntity != null) {
                                            // 报名人数
                                            if (activessEntity.getRegNumbers() != null && activessEntity.getRegNumbers() > 0){
                                                Integer i = activessEntity.getRegNumbers() - Integer.parseInt(productNum);
                                                activessEntity.setRegNumbers(i);
                                                session.update(activessEntity);
                                                tx.commit();
                                            }
                                        }
                                        // 线上课程
                                    } else if ("5".equals(type)) {
                                        TrainOnlineCoursesEntity trainOnlineCourses =
                                                (TrainOnlineCoursesEntity) session.get(TrainOnlineCoursesEntity.class, outId);

                                        if (trainOnlineCourses != null) {
                                            if (trainOnlineCourses.getRegNumbers() != null && trainOnlineCourses.getRegNumbers() > 0){
                                                Integer i = trainOnlineCourses.getRegNumbers() - Integer.parseInt(productNum);
                                                trainOnlineCourses.setRegNumbers(i);
                                                session.update(trainOnlineCourses);
                                                tx.commit();
                                            }
                                        }
                                        // 线下课程
                                    } else if ("7".equals(type)) {
                                        TrainOutlineCoursesEntity trainOutline =
                                                (TrainOutlineCoursesEntity) session.get(TrainOutlineCoursesEntity.class, outId);
                                        if (trainOutline != null) {
                                            if (trainOutline.getRegNumbers() != null && trainOutline.getRegNumbers() > 0){
                                                Integer i = trainOutline.getRegNumbers() - Integer.parseInt(productNum);
                                                trainOutline.setRegNumbers(i);
                                                session.update(trainOutline);
                                                tx.commit();
                                            }
                                        }
                                    }

                                }
                            }
                            // 删除指定的订单项
                            String deleteOrderItme = "DELETE\n" +
                                    "FROM\n" +
                                    "\tdxs_order_items\n" +
                                    "WHERE\n" +
                                    "\tid = '"+ itmeId +"'";
                            Query query2 = session.createSQLQuery(deleteOrderItme);
                            query2.executeUpdate();
                        }
                    }
                    // 删除指定的订单
                    String deleteOrder = "DELETE\n" +
                            "FROM\n" +
                            "\tdxs_orders\n" +
                            "WHERE\n" +
                            "\tid = '"+ s +"'";
                    Query query2 = session.createSQLQuery(deleteOrder);
                    query2.executeUpdate();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}
