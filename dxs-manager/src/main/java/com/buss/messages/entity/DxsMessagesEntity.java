package com.buss.messages.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_messages
 * @author onlineGenerator
 * @date 2016-09-20 10:18:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_messages", schema = "")
@SuppressWarnings("serial")
public class DxsMessagesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**发信id(预留)*/
	@Excel(name="发信id(预留)")
	private String userId;
	/**标题内容*/
	@Excel(name="标题内容")
	private String title;
	/**提交时间*/
	@Excel(name="提交时间",format = "yyyy-MM-dd")
	private Date commitTime;
	/**类型(预留)*/
	@Excel(name="类型(预留)")
	private String catalog;
	/**内容*/
	@Excel(name="内容")
	private String content;
	/**是否已读(预留)*/
	@Excel(name="是否已读(预留)")
	private Integer isRead;
	/**是否放到回收站*/
	@Excel(name="是否放到回收站")
	private Integer isRubbish;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
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
	 *@return: java.lang.String  发信id(预留)
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发信id(预留)
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题内容
	 */
	@Column(name ="TITLE",nullable=true,length=200)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题内容
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  提交时间
	 */
	@Column(name ="COMMIT_TIME",nullable=true)
	public Date getCommitTime(){
		return this.commitTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  提交时间
	 */
	public void setCommitTime(Date commitTime){
		this.commitTime = commitTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类型(预留)
	 */
	@Column(name ="CATALOG",nullable=true,length=50)
	public String getCatalog(){
		return this.catalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类型(预留)
	 */
	public void setCatalog(String catalog){
		this.catalog = catalog;
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
	 *@return: java.lang.Integer  是否已读(预留)
	 */
	@Column(name ="IS_READ",nullable=true,length=3)
	public Integer getIsRead(){
		return this.isRead;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否已读(预留)
	 */
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否放到回收站
	 */
	@Column(name ="IS_RUBBISH",nullable=true,length=3)
	public Integer getIsRubbish(){
		return this.isRubbish;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否放到回收站
	 */
	public void setIsRubbish(Integer isRubbish){
		this.isRubbish = isRubbish;
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
