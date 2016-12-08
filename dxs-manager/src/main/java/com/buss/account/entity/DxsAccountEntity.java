package com.buss.account.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_account
 * @author onlineGenerator
 * @date 2016-07-04 14:18:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_account", schema = "")
@SuppressWarnings("serial")
public class DxsAccountEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户ID*/
	@Excel(name="用户ID")
	private String userId;
	/**账户(鸿鑫币)*/
	@Excel(name="账户(鸿鑫币)")
	private String account;
	/**用户类型*/
	@Excel(name="用户类型")
	private Integer userType;
	/**账户状态*/
	@Excel(name="账户状态")
	private Integer accountStatus;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

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
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户(鸿鑫币)
	 */
	@Column(name ="ACCOUNT",nullable=true,length=255)
	public String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户(鸿鑫币)
	 */
	public void setAccount(String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户类型
	 */
	@Column(name ="USER_TYPE",nullable=true,length=10)
	public Integer getUserType(){
		return this.userType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户类型
	 */
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  账户状态
	 */
	@Column(name ="ACCOUNT_STATUS",nullable=true,length=10)
	public Integer getAccountStatus(){
		return this.accountStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  账户状态
	 */
	public void setAccountStatus(Integer accountStatus){
		this.accountStatus = accountStatus;
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


	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
