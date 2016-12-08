package com.buss.about.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_about_location
 * @author onlineGenerator
 * @date 2016-07-16 13:24:58
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_about_location", schema = "")
@SuppressWarnings("serial")
public class AboutLocationEntity implements java.io.Serializable {
    /**主键*/
    private String id;
    /**地址图片*/
    private String addressImg;
    /**所在地*/
    private String addressName;
    /**编号*/
    private Integer sort;
    /**创建时间*/
    private java.util.Date createTime;
    /**更新时间*/
    private java.util.Date updateTime;
    /**删除标志*/
    private Integer isDelete;

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=32)
    public String getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  地址图片
     */
    @Column(name ="ADDRESS_IMG",nullable=true,length=255)
    public String getAddressImg(){
        return this.addressImg;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  地址图片
     */
    public void setAddressImg(String addressImg){
        this.addressImg = addressImg;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  所在地
     */
    @Column(name ="ADDRESS_NAME",nullable=true,length=255)
    public String getAddressName(){
        return this.addressName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  所在地
     */
    public void setAddressName(String addressName){
        this.addressName = addressName;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  编号
     */
    @Column(name ="SORT",nullable=true,length=10)
    public Integer getSort(){
        return this.sort;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  编号
     */
    public void setSort(Integer sort){
        this.sort = sort;
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
    public Integer getIsDelete(){
        return this.isDelete;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  删除标志
     */
    public void setIsDelete(Integer isDelete){
        this.isDelete = isDelete;
    }
}
