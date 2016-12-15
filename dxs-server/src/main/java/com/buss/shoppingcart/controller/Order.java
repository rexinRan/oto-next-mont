package com.buss.shoppingcart.controller;

import com.buss.actives.entity.ActivessEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.common.util.IDUtils;
import com.buss.orderitems.entity.OrderItemsEntitys;
import com.buss.orderitems.trans.from.OrderItemsFrom;
import com.buss.orderitems.trans.from.OrderItemsFroms;
import com.buss.orderitems.trans.vo.OrderItemsVos;
import com.buss.orders.entity.OrdersEntity;
import com.buss.orders.trans.from.OrdersFrom;
import com.buss.shoppingcart.trans.vo.Cart;
import com.buss.shoppingcart.trans.vo.ShoppingItme;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/23.
 */
@Controller
@RequestMapping("/order")
public class Order {

    @Autowired
    private SysServiceI sysServiceI;

    @Autowired
    private CartControoler cartControoler;

    @Autowired
    private QueryAndUpdateProduct queryAndUpdateProduct;


    /**
     * 去结算
     * @param outId 所有提交商品的id(是数组>outId="1,2,3,4,5,6")
     * @param type  商品类型
     * @param frontMoney    预付定金(活动)
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "settleAccounts")
    @ResponseBody
    public ReplyDataMode settleAccounts(String outId,String type,String frontMoney,String hxbNum) throws Exception {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){

            if(!StringUtil.isEmpty(outId)){

                // 判断是否是一键购买或者点击购物车去结算
                if (!StringUtil.isEmpty(type)){
                    // 根据type判断是那种商品,再根据id产寻商品的详细信息

                    if (type.equals("1")){
                        // 活动的预付定金
                        List<ActivessEntity> activessEntities = this.sysServiceI.findByProperty(ActivessEntity.class,"id",outId);
                        if (activessEntities != null && activessEntities.size() > 0){
                            ActivessEntity activessEntity = activessEntities.get(0);
                            if (activessEntity.getActivePrice() != null){
                                Cart cart = (Cart)queryAndUpdateProduct.queryProductInfo(outId,type,hxbNum,null);

                                replyDataMode.setData(cart);
                                replyDataMode.setStatusCode("200");
                                replyDataMode.setSuccess(true);
                                return replyDataMode;
                            }
                        }
                    }else if (type.equals("10")){   // 鸿鑫币
                        if (!StringUtil.isEmpty(hxbNum)){
                            Cart cart = (Cart) queryAndUpdateProduct.queryProductInfo(outId,type,hxbNum,null);

                            replyDataMode.setData(cart);
                            replyDataMode.setStatusCode("200");
                            replyDataMode.setSuccess(true);
                            return replyDataMode;
                        }else {
                            replyDataMode.setStatusCode("请输入购买数量!");
                            replyDataMode.setSuccess(false);
                            return replyDataMode;
                        }
                    }
                }

                List<String> produceId = new ArrayList<String>();
                boolean foal = outId.contains(",");

                if (!foal){
                    produceId.add(outId);
                }else {
                    // 切割outId
                    String[] arr = outId.split(",");
                    produceId = Arrays.asList(arr);
                }
                if (produceId != null && produceId.size() > 0){
                    // 1、	购物车必须有商品   没有商品：1）原购物车页面刷新 （购物车页面就有 没有商品的提示）
                    // 3：取出Redis中购物车
                    Cart cart = cartControoler.selectCartRedis(produceId, user.getId());
                    List<ShoppingItme> items = cart.getShoppingItmes();
                    if(items.size() > 0){
                        //购物车中有商品
                        Boolean flag = true;

                        // 2、	购物车中商品必须有库存 购买大于库存数量时，视认为无货   提示：购物车原页面不动。。有货改为无货（可加红提醒）
                        for (ShoppingItme item : items) {
                            // 校验库存
                            /**
                             * 注:还没有校验
                             * 商品库存>例如活动:通过outId(产品id)和type(产品类别)查询活动以报名人数和
                             * 限报人数,然后现报人数(item.getNum())+以报人数 是否(>) 限报人数
                             */
                            /*if(item.getNum() > item.getOutId()){
                                //无货
                                item.setIsHave(false);
                                flag = false;
                            }*/
                        }
                        // 无货
                        if(!flag){
                            //有某个商品  无货  提 示：购物车原页面不动。。有货改为无货
                            replyDataMode.setData(cart);
                            replyDataMode.setSuccess(false);
                        }else {
                            replyDataMode.setData(cart);
                            replyDataMode.setStatusCode("200");
                            replyDataMode.setSuccess(true);
                        }

                    }else{
                        // 购物车中没有商品
                        replyDataMode.setStatusCode("您的购物车还没有产品,选择商品加入!");
                        replyDataMode.setSuccess(false);
                        return replyDataMode;
                    }
                }

            }else {
                replyDataMode.setStatusCode("请选择商品!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 提交订单
     * @param ordersFrom
     * @param outIds        商品的id
     * @param type          商品类型
     * @param paymentAttribute  是否支付的是商品的定金 1:全款 2:定金
     * @param hxbNum            鸿鑫币数量
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "submitOrder")
    @ResponseBody     // outIds
    public ReplyDataMode submitOrder(OrdersFrom ordersFrom, String outIds,String type,String paymentAttribute,String hxbNum) throws Exception {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        // 订货日期
        Date date = new Date();

        if (user != null){

            // 装所有购买商品的id
            List<String> productId = new ArrayList<String>();
            // 用于订单提交成功后的数据返回的容器
            Map<String,Object> map = new HashMap<String,Object>();
            if (!StringUtil.isEmpty(outIds)){

                Cart cart = new Cart();
                List<ShoppingItme> shoppingItmes = null;

                boolean foal = outIds.contains(",");

                if (!foal){
                    productId.add(outIds);
                }else {
                    // 切割outId
                    String[] arr = outIds.split(",");
                    productId = Arrays.asList(arr);
                }

                // 订单编号
                final String orderNums = IDUtils.getUUID();
                // 订单表的id
                String orderId = null;

                // 查询该订单是否存在
                List<OrdersEntity> ordersEntityList = this.sysServiceI.findByProperty(OrdersEntity.class,"orderNum",orderNums);
                if (ordersEntityList != null || ordersEntityList.size() <= 0){
                    ordersFrom.setOrderNum(orderNums);
                    ordersFrom.setUserId(user.getId());
                    //0到付,3待付款,9已付款,9待退款,12退款成功,15退款失败
                    ordersFrom.setOrderStatus("3");
                    ordersFrom.setIsDelete("0");

                    if (!StringUtil.isEmpty(type) || !StringUtil.isEmpty(paymentAttribute)){

                        // ActivessEntity activessEntity = (ActivessEntity) queryAndUpdateProduct.queryProductInfo(outIds,type,hxbNum,paymentAttribute);
                        /*ShoppingItme shoppingItme = new ShoppingItme();
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
                        cart.addItem(shoppingItme);*/
                        cart = (Cart) queryAndUpdateProduct.queryProductInfo(outIds,type,hxbNum,paymentAttribute);
                        shoppingItmes = cart.getShoppingItmes();


                    }else {
                        //取购物车
                        cart = cartControoler.selectCartRedis(productId,user.getId());
                        // 取出所有的订单项
                        shoppingItmes = cart.getShoppingItmes();
                    }
                    try {

                        // 保存订单&订单详情
                        if(shoppingItmes.size() > 0){

                            OrdersEntity ordersEntity = (OrdersEntity) ordersFrom.toEntity();
                            ordersEntity.setCreateTime(date);
                            // 订单总金额
                            ordersEntity.setOrderAll(String.valueOf(cart.getTotalPrice()));
                            // 订单总数量
                            ordersEntity.setRegNum(String.valueOf(cart.getProductAmount()));
                            //                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            //                    ordersFrom.setCreateTime(simpleDateFormat.format((Date) ordersEntity.getCreateTime()));
                            ordersEntity.setOrderTime(date);
                            this.sysServiceI.saveOrUpdate(ordersEntity);

                            // 查询刚才存储的订单
                            List<OrdersEntity> list = this.sysServiceI.findByProperty(OrdersEntity.class,"orderNum",orderNums);

                            if (list != null && list.size() > 0){
                                orderId = list.get(0).getId();
                            }

                            List<String> productName = new ArrayList<String>();
                            for (ShoppingItme item : shoppingItmes) {
                                OrderItemsFroms orderItemsFrom = new OrderItemsFroms();
                                // 订单ID
                                orderItemsFrom.setOrderId(orderId);
                                orderItemsFrom.setUserId(user.getId());
                                orderItemsFrom.setOutId(item.getOutId());
                                orderItemsFrom.setOutCatalog(item.getType());
                                orderItemsFrom.setProductName(item.getName());
                                orderItemsFrom.setPrice(item.getPrice());
                                orderItemsFrom.setNum(item.getNum());
                                orderItemsFrom.setIsDelete("0");
                                OrderItemsEntitys orderItemsEntity = (OrderItemsEntitys) orderItemsFrom.toEntity();
                                orderItemsEntity.setOrderTime(date);

                                //保存
                                this.sysServiceI.saveOrUpdate(orderItemsEntity);

                                // 更新订单项中商品的信息(商品数量)
                                queryAndUpdateProduct.updataProductNumber(item.getOutId(),item.getType(),item.getNum());

                                productName.add(item.getName());
                            }
                            // 所有商品名称
                            map.put("productName",productName);
                            // 订单编号
                            map.put("orderNums",orderNums);
                            // 用户的预留电话
                            // map.put("phone",ordersFrom.getPhone());
                            // 商品数量
                            map.put("productNum",cart.getProductAmount());
                            // 支付金额
                            map.put("totalPrice",cart.getTotalPrice());

                            replyDataMode.setData(map);
                            replyDataMode.setStatusCode("200");
                            replyDataMode.setSuccess(true);
                        }else {
                            replyDataMode.setStatusCode("购物车中没有该商品!");
                            replyDataMode.setSuccess(true);
                        }

                        //清空Redis中的购物车
                        cartControoler.del(user.getId(),productId);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else {
                    replyDataMode.setStatusCode("您已提交!");
                    replyDataMode.setSuccess(false);
                }
            }else {
                replyDataMode.setStatusCode("请选择商品!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 根据订单编号查询订单详细信息
     * @param orderNum
     * @return
     */
    @RequestMapping(value = "queryOrderInfo.do")
    @ResponseBody
    public ReplyDataMode queryOrderInfo(String orderNum){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 商品名称
        String productName = "";
        // 订单时间
        String orderTime = "";
        // 订单金额
        Float orderPrices = 0f;
        // 商品数量
        Integer productNum = 0;
        // 订单编号
        String orderNumber;
        
        if (!StringUtil.isEmpty(orderNum)){
            List<OrdersEntity> ordersEntityList = this.sysServiceI.findByProperty(OrdersEntity.class,"orderNum",orderNum);

            if (ordersEntityList != null && ordersEntityList.size() > 0){
                List<OrderItemsEntitys> orderItemsEntityses = this.sysServiceI.findByProperty(OrderItemsEntitys.class,
                        "orderId",ordersEntityList.get(0).getId());
                if (orderItemsEntityses != null && orderItemsEntityses.size() > 0){
                    Map<String,Object> map = new HashMap<String,Object>();
                    for (OrderItemsEntitys itemsEntityse : orderItemsEntityses) {
                        if (!StringUtil.isEmpty(itemsEntityse.getProductName()) && 
                                !StringUtil.isEmpty(String.valueOf(itemsEntityse.getOrderTime())) &&
                                !StringUtil.isEmpty(itemsEntityse.getPrice()) &&
                                !StringUtil.isEmpty(itemsEntityse.getProductName())){
                            
                            productName += itemsEntityse.getProductName() + ",";
                            orderTime = String.valueOf(itemsEntityse.getOrderTime());
                            // 有问题
                            BigDecimal bigDecimal = new BigDecimal(itemsEntityse.getPrice());
                            BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(itemsEntityse.getNum()));

                            orderPrices += Float.valueOf(bigDecimal.multiply(bigDecimal2).toString());
                            productNum += itemsEntityse.getNum();
                        }
                    }
                    productName = productName.substring(0,productName.length()-1);
                    map.put("productName",productName);
                    map.put("orderTime",orderTime);
                    map.put("orderPrices",orderPrices);
                    map.put("orderNumber",orderNum);
                    map.put("productNum",productNum);

                    replyDataMode.setData(map);;
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }
            }else {
                replyDataMode.setStatusCode("没有该订单!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请传递订单号!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }
}
