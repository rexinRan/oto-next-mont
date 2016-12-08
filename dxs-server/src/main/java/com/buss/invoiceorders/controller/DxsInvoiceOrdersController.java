package com.buss.invoiceorders.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.invoice.entity.DxsInvoiceEntity;
import com.buss.invoiceorders.entity.DxsInvoiceOrdersEntity;
import com.buss.invoiceorders.trans.form.DxsInvoiceOrdersSearchForm;
import com.buss.invoiceorders.trans.vo.DxsInvoiceOrdersVO;
import com.buss.invoices.entity.DxsInvoicesEntity;
import com.buss.invoices.trans.vo.DxsInvoicesVO;
import com.buss.orderitems.entity.OrderItemsEntity;
import com.buss.orderitems.trans.vo.OrderItemsVo;
import com.buss.orders.entity.OrdersEntity;
import com.buss.orders.trans.vo.OrdersVo;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.internal.CriteriaImpl;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @Title: Controller
 * @Description: dxs_invoice_orders
 * @author onlineGenerator
 * @date 2016-09-23 15:00:45
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/InvoiceOrders")
public class DxsInvoiceOrdersController  {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode invoiceOrderspageList(DxsInvoiceOrdersSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);
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

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<DxsInvoiceOrdersEntity> invoiceOrders = mode.getResult();

        List<Map> invoiceOrdersVOs = new ArrayList<>();

        for (DxsInvoiceOrdersEntity invoiceOrdersEntity:invoiceOrders) {
            Map map = new HashMap();
            map.put("productName",null);
            map.put("orderTime",null);
            map.put("orderTime",null);
            DxsInvoiceOrdersVO invoiceOrdersVO = new DxsInvoiceOrdersVO();
            invoiceOrdersVO.copyEntity(invoiceOrdersEntity);
            String orderId = invoiceOrdersVO.getOrderId();
            String invoiceId = invoiceOrdersVO.getInvoiceId();
            OrdersEntity ordersEntity = this.sysService.get(OrdersEntity.class,orderId);
            OrderItemsEntity orderItemsEntity = new OrderItemsEntity();
            orderItemsEntity.setIsDelete(0);
            orderItemsEntity.setOrderId(orderId);
            List<OrderItemsEntity> orderItemList = this.sysService.findByExample(OrderItemsEntity.class.getName(),orderItemsEntity);
            if(orderItemList!=null&&orderItemList.size()!=0){
                OrderItemsEntity orderItems = orderItemList.get(0);
                map.put("productName",orderItems.getProductName());
                Date date = orderItems.getOrderTime();
                if(date!=null){

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                    String newdate = simpleDateFormat.format(date);
                    map.put("orderTime",newdate);
                }
            }

            DxsInvoicesEntity dxsInvoiceEntity = this.sysService.get(DxsInvoicesEntity.class,invoiceId);
            map.put("invoiceHead",dxsInvoiceEntity.getInvoiceHeader());
            map.put("price",ordersEntity.getOrderAll());
            map.put("id",invoiceOrdersVO.getId());
            map.put("collectionType",invoiceOrdersVO.getCollectionType());
            Integer invoiceStatus = Integer.parseInt(invoiceOrdersVO.getInvoiceStatus());
            if(invoiceStatus==0){

                map.put("invoiceStatus","申请成功，待开发票");
            }else {
                map.put("invoiceStatus","已开发票");
            }
            invoiceOrdersVOs.add(map);

        }

        mode.setResult(invoiceOrdersVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/invoiceOrdersById.do")
    @ResponseBody
    public ReplyDataMode invoiceOrdersById(DxsInvoiceOrdersSearchForm searchForm,HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<DxsInvoiceOrdersEntity> invoiceOrders = this.sysService.list(criteriaQuery);
        List<Map> invoiceOrdersVOs = new ArrayList<>();

        for (DxsInvoiceOrdersEntity invoiceOrdersEntity:invoiceOrders) {
            Map map = new HashMap();
            DxsInvoiceOrdersVO invoiceOrdersVO = new DxsInvoiceOrdersVO();
            invoiceOrdersVO.copyEntity(invoiceOrdersEntity);
            String orderId = invoiceOrdersVO.getOrderId();
            String invoiceId = invoiceOrdersVO.getInvoiceId();
            OrdersEntity ordersEntity = this.sysService.get(OrdersEntity.class,orderId);
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.copyEntity(ordersEntity);
            OrderItemsEntity orderItemsEntity =  new OrderItemsEntity();
            orderItemsEntity.setIsDelete(0);
            orderItemsEntity.setOrderId(orderId);
            List<OrderItemsEntity> oList =this.sysService.findByExample(OrderItemsEntity.class.getName(),orderItemsEntity);
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(ordersEntity.getUserId());
            List<UserDetailEntity> uList =this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            UserDetailEntity userDetail = uList.get(0);
            UserDetailVO userDetailVO = new UserDetailVO();
            userDetailVO.copyEntity(userDetail);
            OrderItemsEntity orderItems = oList.get(0);
            OrderItemsVo orderItemsVo = new OrderItemsVo();
            orderItemsVo.copyEntity(orderItems);
            DxsInvoicesEntity dxsInvoiceEntity = this.sysService.get(DxsInvoicesEntity.class,invoiceId);
            DxsInvoicesVO dxsInvoicesVO = new DxsInvoicesVO();
            dxsInvoicesVO.copyEntity(dxsInvoiceEntity);
            map.put("ordersVo",ordersVo);
            map.put("orderItemsVo",orderItemsVo);
            map.put("userDetailVO",userDetailVO);
            map.put("dxsInvoicesVO",dxsInvoicesVO);
            map.put("invoiceOrdersVO",invoiceOrdersVO);
            invoiceOrdersVOs.add(map);

        }
        replyDataMode.setData(invoiceOrdersVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/save.do")
    @ResponseBody
    public ReplyDataMode save(String orderIds,DxsInvoiceOrdersSearchForm searchForm, HttpServletRequest request){
        String []orderIdss = orderIds.split(",");
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

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
        for(String orderId:orderIdss){
            DxsInvoicesEntity dxsInvoiceEntity = new DxsInvoicesEntity();
            dxsInvoiceEntity.setIsDelete(0);
            dxsInvoiceEntity.setUserId(user.getId());
            List<DxsInvoicesEntity> iList = this.sysService.findByExample(DxsInvoicesEntity.class.getName(),dxsInvoiceEntity);
            if(iList==null||iList.size()==0){
                replyDataMode.setData("请先完善发票信息");
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
                return replyDataMode;
            }
            searchForm.setInvoiceId(iList.get(0).getId());
            Date date = new Date();
            searchForm.setInvoiceStatus("0");
            DxsInvoiceOrdersEntity dxsInvoiceOrdersEntity = new DxsInvoiceOrdersEntity();
            dxsInvoiceOrdersEntity = (DxsInvoiceOrdersEntity) searchForm.toEntity();
            dxsInvoiceOrdersEntity.setApplyTime(date);
            dxsInvoiceOrdersEntity.setCreateTime(date);

            try {
                dxsInvoiceOrdersEntity.setOrderId(orderId);
                this.sysService.saveOrUpdate(dxsInvoiceOrdersEntity);
                OrdersEntity ordersEntity = this.sysService.get(OrdersEntity.class,orderId);
                ordersEntity.setOrderStatus(2);
                this.sysService.saveOrUpdate(ordersEntity);

            }catch (Exception e){
                replyDataMode.setData("操作失败");
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);

                return replyDataMode;
            }
        }


        replyDataMode.setData("操作成功");
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

}
