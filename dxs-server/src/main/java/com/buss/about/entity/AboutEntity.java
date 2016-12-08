package com.buss.about.entity;

/**
 * Created by Administrator on 2016/7/16.
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_about
 * @author dq
 * @date 2016-07-16 13:29:33
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_about", schema = "")
@SuppressWarnings("serial")
public class AboutEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**公司简介*/
    private java.lang.String companyIntroduce;
    /**公司信息*/
    private java.lang.String companyInfo;
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
     *@return: java.lang.String  公司简介
     */
    @Column(name ="COMPANY_INTRODUCE",nullable=true,length=255)
    public java.lang.String getCompanyIntroduce(){
        return this.companyIntroduce;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  公司简介
     */
    public void setCompanyIntroduce(java.lang.String companyIntroduce){
        this.companyIntroduce = companyIntroduce;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  公司信息
     */
    @Column(name ="COMPANY_INFO",nullable=true,length=255)
    public java.lang.String getCompanyInfo(){
        return this.companyInfo;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  公司信息
     */
    public void setCompanyInfo(java.lang.String companyInfo){
        this.companyInfo = companyInfo;
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