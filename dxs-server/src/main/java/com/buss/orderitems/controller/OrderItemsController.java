package com.buss.orderitems.controller;


import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.orderitems.entity.OrderItemsEntity;
import com.buss.orderitems.trans.from.OrderItemsFrom;
import com.buss.orderitems.trans.vo.OrderItemsVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: dxs_order_items
 * @author onlineGenerator
 * @date 2016-09-18 14:19:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/OrderItems")
public class OrderItemsController {

    @Resource
    private SysServiceI sysService;
    
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode orderItemspageList(OrderItemsFrom searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user==null){

            String message = "请先登录";
            replyDataMode.setData(message);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
            return replyDataMode;

        }
        searchForm.setUserId(user.getId());
        searchForm.setOrderStatus("1");

        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<OrderItemsEntity> orderItems = mode.getResult();

        List<OrderItemsVo> orderItemsVos = new ArrayList<OrderItemsVo>();

        for (OrderItemsEntity orderItemsEntity:orderItems) {
            OrderItemsVo orderItemsVo = new OrderItemsVo();
            orderItemsVo.copyEntity(orderItemsEntity);
            orderItemsVos.add(orderItemsVo);

        }

        mode.setResult(orderItemsVos);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

}
