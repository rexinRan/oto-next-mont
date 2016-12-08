package com.buss.shoppingcart.controller;

import com.alibaba.druid.util.StringUtils;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.redis.ConnectJedis;
import com.buss.common.service.SysServiceI;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.buss.shoppingcart.interfaces.Contants;
import com.buss.shoppingcart.trans.vo.Cart;
import com.buss.shoppingcart.trans.vo.ShoppingItme;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/22.
 */
@Controller
@RequestMapping("cart")
public class CartControoler {


    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 加入购物车
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "shoppingCart.do")
    @ResponseBody
    public ReplyDataMode shoppingCart(ShoppingItme shoppingItme , HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        /**
         *  ObjectMapper是requestbody和responesbody的入口
         *   将object转为字符串设置 到cookie中
         */
        ObjectMapper objectMapper = new ObjectMapper();

        // 去掉null值
        objectMapper.setSerializationInclusion(Include.NON_NULL);

        /*非登陆
        1：获取Cookie中的购物车
        2：没有，创建购物车对象
        3：将当前款商品追加到购物车
        4：保存购物车到Cookie中
        5：Cookie写回浏览器  24小时
                重定向*/

        // 1.获取Cookie
        Cookie[] cookies = request.getCookies();

        // 定义购物车对象
        Cart cart = null;

        // 2.判断cookie是否为空
        if (cookies != null && cookies.length > 0){
            // 获取每一个cookie
            for (Cookie cookie : cookies) {
                // 2、判断Cookie中是否有购物车    SHOPPING_CART:是在接口中定义的一个常量(购物车的名称)
                if (Contants.SHOPPING_CART.equals(cookie.getName())){
                    /**
                     * 将cookie中的value(购物车)取出
                     * 因为从cookie中取出value为json字符串,因为购物车是一个对象,所以需将字符串转为object,该对象为购物车
                     * 读:将字符串转为对象,该过程是读的过成程 写:将对象转为json字符串(从内存中写到磁盘中的过程)
                     */
                    cart = objectMapper.readValue(cookie.getValue(), Cart.class);

                    // 跳出循环
                    break;
                }
            }
        }

        // 3、没有 创建购物车
        if (cart == null) {
            // 创建对象
            cart = new Cart();
        }

        // 4、追加当前款商品 判断库的id和商品数量是否为null
        if (!StringUtil.isEmpty(shoppingItme.getOutId()) && !StringUtil.isEmpty(shoppingItme.getNum())
                && !StringUtil.isEmpty(shoppingItme.getName()) && !StringUtil.isEmpty(shoppingItme.getPrice())
                && !StringUtil.isEmpty(shoppingItme.getType())){

            // 将购物项添加到购物车中
            cart.addItem(shoppingItme);
        }
        // 5.判断用户是否登录
        if (user != null){
            // 将商品追加到redis中,同时将Cookie清空
            this.addCartRedisAndClearCookie(cart,user.getId(),response);

        }else {
            // 4：保存购物车到Cookie中
            Writer writer = new StringWriter();
            objectMapper.writeValue(writer,cart);
            Cookie cookie = new Cookie(Contants.SHOPPING_CART,writer.toString());
            cookie.setPath("/");
            // -1  0   >0  秒
            cookie.setMaxAge(60*60*24);
            // 5：Cookie写回浏览器
            response.addCookie(cookie);
        }

        replyDataMode.setStatusCode("加入购物车成功!");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }


    /**
     * 去购物车
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "toCart.do")
    @ResponseBody
    public ReplyDataMode toCart(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ReplyDataMode replyDataMode = new ReplyDataMode();
        /**
         * 因为不是从形参中@requestBody中 ObjectMapper是requestbody和responesbody的入口
         * 将object转为字符串设置 到cookie中
         */

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ObjectMapper om = new ObjectMapper();

        // 去掉为null的值
        om.setSerializationInclusion(Include.NON_NULL);

        /**
         * 未登录状态
         */
        // 1、获取Cookie
        Cookie[] cookies = request.getCookies();

        // 定义购物车对象
        Cart cart = null;

        // 判断cookie是否为空
        if (cookies != null && cookies.length > 0) {
            // 那么遍历cookie获取每一个cookie
            for (Cookie cookie : cookies) {
                // 2、判断Cookie中是否有购物车 BUYER_CART是定义的一个常量cookie的名称
                if (Contants.SHOPPING_CART.equals(cookie.getName())) {
                    /**
                     * 将cookie中的value(购物车)取出
                     * 因为从cookie中取出value为json字符串,所以需转为object,该对象为购物车
                     * 读:将字符串转为对象,该过程是读的过成程 写:将对象转为json字符串
                     */
                    cart = om.readValue(cookie.getValue(), Cart.class);

                    // 跳出循环
                    break;
                }
            }
        }

        // 判断是否登陆
        if (user != null){
            // 2.将购物车保存到redis中
            if (cart != null){

                // 将商品追加到redis中,同时将Cookie清空
                this.addCartRedisAndClearCookie(cart,user.getId(),response);
            }

            // 3、获取Redis中的购物车
            cart = this.selectCartAllRedis(user.getId());
        }

        // 4：没有 创建购物车 （不是null 购物车是空车子）
        if(null == cart){
            cart = new Cart();
        }

        // 5、跳转购物车页面
        replyDataMode.setData(cart);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 删除购物车中指定的商品
     * @param outId
     * @return
     */
    @RequestMapping(value = "deleteShoppingItem")
    @ResponseBody
    public ReplyDataMode deleteShoppingItem(String outId){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            if (!StringUtil.isEmpty(outId)){

                List<String> productId = new ArrayList<String>();
                boolean foal = outId.contains(",");

                if (!foal){
                    productId.add(outId);
                }else {
                    // 切割outId
                    String[] arr = outId.split(",");
                    productId = Arrays.asList(arr);
                }

                this.del(user.getId(),productId);

                replyDataMode.setStatusCode("删除成功!");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("请选择删除商品!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 将商品追加到redis,同时清空Cookie
     * @param cart
     * @param userId
     * @param response
     * @throws Exception
     */
    public void addCartRedisAndClearCookie(Cart cart,String userId,HttpServletResponse response) throws Exception {
        // 5、将购物车中所有的商品追加到Redis中
        this.insertCartToRedis(cart,userId);

        // 6、清空Cookie   0:马上
        Cookie cookie = new Cookie(Contants.SHOPPING_CART, null);
        cookie.setPath("/");  // 设置路径
        cookie.setMaxAge(0);  // 立即销毁
        response.addCookie(cookie);  // 将cookie返回给浏览器
    }



    /**
     * 将购物车中所有的商品追加到Redis中
     * @param cart
     * @param userId
     * @throws Exception
     */
    public void insertCartToRedis(Cart cart, String userId) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        Writer writer = new StringWriter();
        Jedis jedis = ConnectJedis.getJedis();

        // 判断cart是否为空
        if (cart != null) {
            // 获取购物项
            List<ShoppingItme> shoppingItmes = cart.getShoppingItmes();
            // 判断购物项是否大于0 如果不判断,可能为空,那么在遍历的时候可定会报错
            if (shoppingItmes.size() > 0) {
                // 遍历购物车中的购物项
                for (ShoppingItme item : shoppingItmes) {
                    // 判断是否存在
                    if (jedis.hexists("shoppingCart:" + userId, String.valueOf(item.getOutId()))) {
                        // 如果存在在原来的基础上增加多少
                        jedis.hincrBy("shoppingCart:" + userId, item.getOutId(), Long.parseLong(item.getNum()));
                    } else {
                        // 如果不存在直接添加(数量)
                        jedis.hset("shoppingCart:" + userId, item.getOutId(),item.getNum());
                        // 将对象转为json串
                        objectMapper.writeValue(writer,item);
                        // 添加(数据)
                        jedis.hset("dataCart:" + userId,item.getOutId(),writer.toString());
                    }
                }
            }
        }
    }

    /**
     * 获取Redis中的购物车
     * @param userId
     * @return
     * @throws Exception
     */
    public Cart selectCartAllRedis(String userId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        Writer writer = new StringWriter();

        Jedis jedis = ConnectJedis.getJedis();

        // 创建购物车
        Cart cart = new Cart();

        // 通过用户id+购物车名称
        Map<String, String> hgetAll = jedis.hgetAll("shoppingCart:" + userId);

        // 判断hgetAll是否为空
        if (hgetAll != null) {
            // 获取entrySet对象
            Set<Map.Entry<String, String>> entrySet = hgetAll.entrySet();

            // 遍历
            for (Map.Entry<String, String> entry : entrySet) {

                // 设置orderItemsFrom中的outId
//                shoppingItme.setOutId(entry.getKey());
                Map<String,String> dataAll = jedis.hgetAll("dataCart:" + userId);
                for (Map.Entry<String,String> dataShoppintItmeEntry : dataAll.entrySet()){
                    if (entry.getKey().equals(dataShoppintItmeEntry.getKey())){
                        // 创建购物项对象
                        ShoppingItme shoppingItme = new ShoppingItme();

                        // 通过指定的key获取到指定的json数据串(购物项)
                        String dataShoppingItme = jedis.hget("dataCart:" + userId,entry.getKey());

                        // 将json串转为指定对象
                        shoppingItme = objectMapper.readValue(dataShoppingItme,ShoppingItme.class);

                        // 设置商品数量
                        shoppingItme.setNum(entry.getValue());

                        // 将每一个购物项放到购物车中
                        cart.addItem(shoppingItme);
                    }
                }
            }
        }
        // 返回购物车
        return cart;
    }


    /**
     * 取出Redis中购物车指定的商品
     * @param productId   所选商品的ID
     * @param userId      当前用户的ID
     * @return
     */
    public Cart selectCartRedis(List<String> productId,String userId) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        Writer writer = new StringWriter();

        Jedis jedis = ConnectJedis.getJedis();

        Cart Cart = new Cart();
        // 获取所选商品的数量
        Map<String, String> hgetAll = jedis.hgetAll("shoppingCart:" + userId);
        // 获取所选商品的详细信息
        Map<String, String> dataHgetAll = jedis.hgetAll("dataCart:" + userId);

        if(null != hgetAll && hgetAll.size() > 0){
            // 遍历 所选商品的数量保存到购物车
            Set<Map.Entry<String, String>> entrySet = hgetAll.entrySet();
            // 遍历 所有商品的详细信息保存到购物车
            Set<Map.Entry<String, String>> dataEntrySet = dataHgetAll.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                for (String outId : productId) {
                    if(outId.equals(entry.getKey())){
                        // 遍历购物车的所有商品
                        for (Map.Entry<String, String> dataEntry : dataEntrySet){
                            ShoppingItme shoppingItme = new ShoppingItme();
                            /*
                             * 判断所选商品和map(dataCart+userId)中的哪个key相等,
                             * 如果相等将相等的key所对应的value(购物车中的购物项)拿出
                             */
                            if (outId.equals(dataEntry.getKey())){
                                shoppingItme = objectMapper.readValue(dataEntry.getValue(),ShoppingItme.class);

                                // 设置购物车的数量
                                shoppingItme.setNum(entry.getValue());

                                // 将购物项放到购物车中
                                Cart.addItem(shoppingItme);
                            }
                        }
                    }
                }
            }
        }
        // 将购物车返回
        return Cart;
    }

    /**
     * 清空指定的购物项
     * @param userId
     */
    public void del(String userId,List<String> productId){
        Jedis jedis = ConnectJedis.getJedis();

        if (!StringUtils.isEmpty(userId) && productId != null && productId.size() > 0){
            for (String outId : productId){
                // 数量
                jedis.hdel("shoppingCart:" + userId,outId);
                // 购物项
                jedis.hdel("dataCart:" + userId,outId);
            }
        }
    }


    /**
     * 查询当前用户购物车商品的总数
     * @return
     */
    @RequestMapping(value = "queryCartcNum")
    @ResponseBody
    public ReplyDataMode queryCartcNum() {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        Jedis jedis = ConnectJedis.getJedis();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null) {
            Map<String,String> map = jedis.hgetAll("shoppingCart:" + user.getId());

            if (map != null && map.size() > 0){
                Set<Map.Entry<String,String>> set = map.entrySet();
                int tmp = 0;
                for (Map.Entry<String, String> entry : set) {
                    tmp += Integer.parseInt(entry.getValue());
                }

                replyDataMode.setData(tmp);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return replyDataMode;
    }
}
