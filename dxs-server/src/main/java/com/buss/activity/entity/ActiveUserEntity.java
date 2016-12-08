package com.buss.activity.entity;

import com.buss.actives.entity.ActivesEntity;
import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.*;
import java.util.Date;

/**
 * 报名活动表
 * @Title: Entity
 * @Description: dxs_active_user
 * @author onlineGenerator
 * @date 2016-06-15 17:48:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_active_user", schema = "")
@SuppressWarnings("serial")
public class ActiveUserEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动的id*/
	private java.lang.String activeId;
	/**用户的id*/
	private java.lang.String userId;
	/**活动的原价*/
	private java.lang.String origin;
	/**活动实际缴费金额*/
	private java.lang.String price;
	/**定金*/
	private java.lang.String deposit;
	/**活动步骤*/
	private java.lang.String step;
	/**报名类型*/
	private java.lang.Integer type;
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
	 *@return: java.lang.String  活动的id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动的id
	 */
	public void setActiveId(String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户的id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户的id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动的原价
	 */
	@Column(name ="ORIGIN",nullable=true,length=10)
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动实际缴费金额
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  定金
	 */
	@Column(name ="DEPOSIT",nullable=true,length=10)
	public java.lang.String getDeposit(){
		return this.deposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  定金
	 */
	public void setDeposit(java.lang.String deposit){
		this.deposit = deposit;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动步骤
	 */
	@Column(name ="STEP",nullable=true,length=255)
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  报名类型
	 */
	@Column(name ="TYPE",nullable=true,length=10)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  报名类型
	 */
	public void setType(Integer type){
		this.type = type;
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

	// 杨治国
	// 活动
	private ActivesEntity activesEntity;
	// 用户
	private GeneralUserEntity generalUserEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "active_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ActivesEntity getActivesEntity() {
		return activesEntity;
	}

	public void setActivesEntity(ActivesEntity activesEntity) {
		this.activesEntity = activesEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public GeneralUserEntity getGeneralUserEntity() {
		return generalUserEntity;
	}

	public void setGeneralUserEntity(GeneralUserEntity generalUserEntity) {
		this.generalUserEntity = generalUserEntity;
	}


}
