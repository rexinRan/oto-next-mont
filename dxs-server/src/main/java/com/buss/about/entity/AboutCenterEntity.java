package com.buss.about.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/7/16.
 */

/**
 * @Title: Entity
 * @Description: dxs_about_center
 * @author onlineGenerator
 * @date 2016-07-16 13:29:04
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_about_center", schema = "")
public class AboutCenterEntity implements java.io.Serializable {
    /**主键*/
    private String id;
    /**标题*/
    private String title;
    /**发表时间*/
    private java.util.Date publishTime;
    /**内容*/
    private String content;
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
     *@return: java.lang.String  标题
     */
    @Column(name ="TITLE",nullable=true,length=200)
    public String getTitle(){
        return this.title;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  标题
     */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  发表时间
     */
    @Column(name ="PUBLISH_TIME",nullable=true)
    public java.util.Date getPublishTime(){
        return this.publishTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  发表时间
     */
    public void setPublishTime(java.util.Date publishTime){
        this.publishTime = publishTime;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  内容
     */
    @Column(name ="CONTENT",nullable=true,length=65535)
    public String getContent(){
        return this.content;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  内容
     */
    public void setContent(String content){
        this.content = content;
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