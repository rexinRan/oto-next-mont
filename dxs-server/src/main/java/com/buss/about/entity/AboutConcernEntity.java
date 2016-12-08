package com.buss.about.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * @Title: Entity
 * @Description: dxs_about_concern
 * @author dq
 * @date 2016-07-16 13:28:35
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_about_concern", schema = "")
@SuppressWarnings("serial")
public class AboutConcernEntity implements java.io.Serializable {
    /**主键*/
    private String id;
    /**缩略图*/
    private String concernImg;
    /**内容*/
    private String concernContent;
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
     *@return: java.lang.String  缩略图
     */
    @Column(name ="CONCERN_IMG",nullable=true,length=255)
    public String getConcernImg(){
        return this.concernImg;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  缩略图
     */
    public void setConcernImg(String concernImg){
        this.concernImg = concernImg;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  内容
     */
    @Column(name ="CONCERN_CONTENT",nullable=true,length=65535)
    public String getConcernContent(){
        return this.concernContent;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  内容
     */
    public void setConcernContent(String concernContent){
        this.concernContent = concernContent;
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