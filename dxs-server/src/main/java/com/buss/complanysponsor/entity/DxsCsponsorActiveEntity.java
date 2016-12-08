package com.buss.complanysponsor.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_csponsor_active
 * @author onlineGenerator
 * @date 2016-07-23 16:07:09
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_csponsor_active", schema = "")

public class DxsCsponsorActiveEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**用户id*/
    private java.lang.String userId;
    /**活动id*/
    private java.lang.String activeId;
    /**赞助商的id*/
    private java.lang.String csponsorId;
    /**创建时间*/
    private java.util.Date createTime;
    /**更新时间*/
    private java.util.Date updateTime;
    /**删除标志*/
    private java.lang.Integer isDelete;

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=32)
    public java.lang.String getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(java.lang.String id){
        this.id = id;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  用户id
     */
    @Column(name ="USER_ID",nullable=true,length=32)
    public java.lang.String getUserId(){
        return this.userId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  用户id
     */
    public void setUserId(java.lang.String userId){
        this.userId = userId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  活动id
     */
    @Column(name ="ACTIVE_ID",nullable=true,length=32)
    public java.lang.String getActiveId(){
        return this.activeId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  活动id
     */
    public void setActiveId(java.lang.String activeId){
        this.activeId = activeId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  赞助商的id
     */
    @Column(name ="CSPONSOR_ID",nullable=true,length=32)
    public java.lang.String getCsponsorId(){
        return this.csponsorId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  赞助商的id
     */
    public void setCsponsorId(java.lang.String csponsorId){
        this.csponsorId = csponsorId;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  创建时间
     */
    @Column(name ="CREATE_TIME",nullable=true)
    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建时间
     */
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新时间
     */
    @Column(name ="UPDATE_TIME",nullable=true)
    public java.util.Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新时间
     */
    public void setUpdateTime(java.util.Date updateTime){
        this.updateTime = updateTime;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  删除标志
     */
    @Column(name ="IS_DELETE",nullable=true,length=3)
    public java.lang.Integer getIsDelete(){
        return this.isDelete;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  删除标志
     */
    public void setIsDelete(java.lang.Integer isDelete){
        this.isDelete = isDelete;
    }
}
