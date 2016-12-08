package com.buss.paymentnotice.trans.vo;

import com.buss.paymentnotice.entity.PaymentNoticeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by JSADKFJ on 2016/11/19.
 */
@Mapping(entityClass = PaymentNoticeEntity.class)
public class PaymentNoticeVo extends BaseVO{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户ID*/
    @Mapping
    private java.lang.String userId;
    /**买家支付宝账户号*/
    @Mapping
    private java.lang.String buyer_id;
    /**支付宝交易号*/
    @Mapping
    private java.lang.String trade_no;
    /**商品描述*/
    @Mapping
    private java.lang.String body;
    /**接口名称*/
    @Mapping
    private java.lang.String exterface;
    /**通知时间*/
    @Mapping
    private java.lang.String notify_time;
    /**商品名称*/
    @Mapping
    private java.lang.String subject;
    /**签名方式*/
    @Mapping
    private java.lang.String sign_type;
    /**通知类型*/
    @Mapping
    private java.lang.String notify_type;
    /**商户网站唯一订单号*/
    @Mapping
    private java.lang.String out_trade_no;
    /**交易状态*/
    @Mapping
    private java.lang.String trade_status;
    /**签名*/
    @Mapping
    private java.lang.String sign;
    /**买家支付宝账号*/
    @Mapping
    private java.lang.String buyer_email;
    /**成功标识*/
    @Mapping
    private java.lang.String is_success;
    /**交易金额*/
    @Mapping
    private java.lang.String total_fee;
    /**卖家支付宝账户号*/
    @Mapping
    private java.lang.String seller_id;
    /**通知校验ID*/
    @Mapping
    private java.lang.String notify_id;
    /**卖家支付宝账号*/
    @Mapping
    private java.lang.String seller_email;
    /**支付类型*/
    @Mapping
    private java.lang.String payment_type;
    /**支付是否成功*/
    @Mapping
    private java.lang.String whetherSuccessful;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**是否删除*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExterface() {
        return exterface;
    }

    public void setExterface(String exterface) {
        this.exterface = exterface;
    }

    public String getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getIs_success() {
        return is_success;
    }

    public void setIs_success(String is_success) {
        this.is_success = is_success;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getWhetherSuccessful() {
        return whetherSuccessful;
    }

    public void setWhetherSuccessful(String whetherSuccessful) {
        this.whetherSuccessful = whetherSuccessful;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
