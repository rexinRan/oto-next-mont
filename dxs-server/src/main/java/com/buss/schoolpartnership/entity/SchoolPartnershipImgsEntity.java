package com.buss.schoolpartnership.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_school_partnership_imgs
 * @author dq
 * @date 2016-07-27 13:37:24
 * @version V1.0
 */
@Entity
@Table(name = "dxs_school_partnership_imgs", schema = "")
public class SchoolPartnershipImgsEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**合作院校id*/
    private java.lang.String spId;
    /**图片文件id*/
    private java.lang.String spImgFid;
    /**图片访问地址*/
    private java.lang.String spImgUrl;
    /**创建时间*/
    private java.util.Date createTime;
    /**更新时间*/
    private java.util.Date updateTime;
    /**删除标志*/
    private java.lang.String isDelete;

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
     *@return: java.lang.String  合作院校id
     */
    @Column(name ="SP_ID",nullable=true,length=32)
    public java.lang.String getSpId(){
        return this.spId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  合作院校id
     */
    public void setSpId(java.lang.String spId){
        this.spId = spId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  图片文件id
     */
    @Column(name ="SP_IMG_FID",nullable=true,length=32)
    public java.lang.String getSpImgFid(){
        return this.spImgFid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  图片文件id
     */
    public void setSpImgFid(java.lang.String spImgFid){
        this.spImgFid = spImgFid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  图片访问地址
     */
    @Column(name ="SP_IMG_URL",nullable=true,length=255)
    public java.lang.String getSpImgUrl(){
        return this.spImgUrl;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  图片访问地址
     */
    public void setSpImgUrl(java.lang.String spImgUrl){
        this.spImgUrl = spImgUrl;
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
     *方法: 取得java.lang.String
     *@return: java.lang.String  删除标志
     */
    @Column(name ="IS_DELETE",nullable=true,length=2)
    public java.lang.String getIsDelete(){
        return this.isDelete;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  删除标志
     */
    public void setIsDelete(java.lang.String isDelete){
        this.isDelete = isDelete;
    }
}
