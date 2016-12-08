package com.buss.trainingarticleuser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_training_article_user
 * @author lu
 * @date 2016-07-01 11:37:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_training_article_user", schema = "")
@SuppressWarnings("serial")
public class TrainingArticleUserEntity implements java.io.Serializable {
	/**主键id*/
	private String id;
	/**用户id*/

	private String userId;
	/**培训文章id*/

	private String trainingArticleId;
	/**申请结果*/

	private Integer result;
	/**申请时间*/

	private Date applyTime;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

	private Integer isDelete;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键id
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
	 *@param: java.lang.String  主键id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训文章id
	 */
	@Column(name ="TRAINING_ARTICLE_ID",nullable=true,length=32)
	public String getTrainingArticleId(){
		return this.trainingArticleId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训文章id
	 */
	public void setTrainingArticleId(String trainingArticleId){
		this.trainingArticleId = trainingArticleId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请结果
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请结果
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_TIME",nullable=true)
	public Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(Date applyTime){
		this.applyTime = applyTime;
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
