package com.buss.activeuser.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.actives.entity.DxsActivesEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
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
public class DxsActiveUserEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动的id*/
	@Excel(name="活动的id")
	private String activeId;
	/**用户的id*/
	@Excel(name="用户的id")
	private String userId;
	/**活动的原价*/
	@Excel(name="活动的原价")
	private java.lang.String origin;
	/**活动实际缴费金额*/
	@Excel(name="活动实际缴费金额")
	private java.lang.String price;
	/**定金*/
	@Excel(name="定金")
	private java.lang.String deposit;
	/**活动步骤*/
	@Excel(name="活动步骤")
	private java.lang.String step;
	/**报名类型*/
	@Excel(name="报名类型")
	private Integer type;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsActivesEntity dxsActivesEntity;

	private DxsUserEntity dxsUserEntity;
	
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
	public java.lang.String getOrigin(){
		return this.origin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动的原价
	 */
	public void setOrigin(java.lang.String origin){
		this.origin = origin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动实际缴费金额
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动实际缴费金额
	 */
	public void setPrice(java.lang.String price){
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动步骤
	 */
	@Column(name ="STEP",nullable=true,length=255)
	public java.lang.String getStep(){
		return this.step;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动步骤
	 */
	public void setStep(java.lang.String step){
		this.step = step;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动步骤
	 */
	@Column(name ="TYPE",nullable=true,length=10)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动步骤
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
	@Column(name ="IS_DELETE",nullable=true,length=2)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "active_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
