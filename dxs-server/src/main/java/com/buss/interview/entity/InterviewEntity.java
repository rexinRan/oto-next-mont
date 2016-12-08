package com.buss.interview.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.resumeuser.entity.ResumeUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**   
 * @Title: Entity
 * @Description: dxs_interview
 * @author onlineGenerator
 * @date 2016-06-25 09:20:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_interview", schema = "")
@SuppressWarnings("serial")
public class InterviewEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**投送简历的id*/
	private java.lang.String resumeUserId;
	/**标题*/
	private java.lang.String title;
	/**内容*/
	private java.lang.String content;
	/**面试邀请结果*/
	private java.lang.Integer result;
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
	 *@return: java.lang.String  投送简历的id
	 */
	@Column(name ="RESUME_USER_ID",nullable=true,length=32)
	public java.lang.String getResumeUserId(){
		return this.resumeUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投送简历的id
	 */
	public void setResumeUserId(java.lang.String resumeUserId){
		this.resumeUserId = resumeUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=100)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=255)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试邀请结果
	 */
	@Column(name ="RESULT",nullable=true,length=2)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试邀请结果
	 */
	public void setResult(java.lang.Integer result){
		this.result = result;
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


	// 简历    注:错误
	/*private ResumeUserEntity resumeEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ResumeUserEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeUserEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}*/
}
