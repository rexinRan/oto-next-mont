package com.buss.about.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * @Title: Entity
 * @Description: dxs_about_duty
 * @author dq
 * @date 2016-07-16 13:26:05
 * @version V1.0
 *
 */

@Entity
@Table(name = "dxs_about_duty", schema = "")
public class AboutDutyEntity implements java.io.Serializable {
    /**主键*/
    private String id;
    /**缩略图id*/
    private String imgFid;
    /**图片地址*/
    private String imgUrl;
    /**概述*/
    private String summary;
    /**发布时间*/
    private Date publishTime;
    /**作者*/
    private String author;
    /**出处*/
    private String articleFrom;
    /**标题*/
    private String title;
    /**内容*/
    private String content;
    /**编号*/
    private Integer sort;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
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
     *@return: java.lang.String  缩略图id
     */
    @Column(name ="IMG_FID",nullable=true,length=32)
    public String getImgFid(){
        return this.imgFid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  缩略图id
     */
    public void setImgFid(String imgFid){
        this.imgFid = imgFid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  图片地址
     */
    @Column(name ="IMG_URL",nullable=true,length=255)
    public String getImgUrl(){
        return this.imgUrl;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  图片地址
     */
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  概述
     */
    @Column(name ="SUMMARY",nullable=true,length=255)
    public String getSummary(){
        return this.summary;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  概述
     */
    public void setSummary(String summary){
        this.summary = summary;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  发布时间
     */
    @Column(name ="PUBLISH_TIME",nullable=true)
    public Date getPublishTime(){
        return this.publishTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  发布时间
     */
    public void setPublishTime(Date publishTime){
        this.publishTime = publishTime;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  作者
     */
    @Column(name ="AUTHOR",nullable=true,length=255)
    public String getAuthor(){
        return this.author;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  作者
     */
    public void setAuthor(String author){
        this.author = author;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  出处
     */
    @Column(name ="ARTICLE_FROM",nullable=true,length=100)
    public String getArticleFrom(){
        return this.articleFrom;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  出处
     */
    public void setArticleFrom(String articleFrom){
        this.articleFrom = articleFrom;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  标题
     */
    @Column(name ="TITLE",nullable=true,length=255)
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
     *方法: 取得java.lang.String
     *@return: java.lang.String  内容
     */
    @Column(name ="CONTENT",nullable=true,length=16777215)
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
    public Date getCreateTime(){
        return this.createTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建时间
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新时间
     */
    @Column(name ="UPDATE_TIME",nullable=true)
    public Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新时间
     */
    public void setUpdateTime(Date updateTime){
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

