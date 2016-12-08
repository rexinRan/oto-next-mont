package com.buss.accountlog.entity;

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
 * @Description: dxs_account_log
 * @author onlineGenerator
 * @date 2016-07-04 14:20:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_account_log", schema = "")
@SuppressWarnings("serial")
public class DxsAccountLogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**账户id*/
	@Excel(name="账户id")
	private String accoutId;
	/**用户ID*/
	@Excel(name="用户ID")
	private String userId;
	/**进账数目*/
	@Excel(name="进账数目")
	private String accountIn;
	/**出账数目*/
	@Excel(name="出账数目")
	private String accountOut;
	/**来源*/
	@Excel(name="来源")
	private Integer accountFrom;
	/**流水状态*/
	@Excel(name="流水状态")
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
	 *@return: java.lang.String  账户id
	 */
	@Column(name ="ACCOUT_ID",nullable=true,length=32)
	public String getAccoutId(){
		return this.accoutId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户id
	 */
	public void setAccoutId(String accoutId){
		this.accoutId = accoutId;
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
	 *@return: java.lang.String  进账数目
	 */
	@Column(name ="ACCOUNT_IN",nullable=true,length=255)
	public String getAccountIn(){
		return this.accountIn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进账数目
	 */
	public void setAccountIn(String accountIn){
		this.accountIn = accountIn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出账数目
	 */
	@Column(name ="ACCOUNT_OUT",nullable=true,length=255)
	public String getAccountOut(){
		return this.accountOut;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出账数目
	 */
	public void setAccountOut(String accountOut){
		this.accountOut = accountOut;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  来源
	 */
	@Column(name ="ACCOUNT_FROM",nullable=true,length=10)
	public Integer getAccountFrom(){
		return this.accountFrom;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  来源
	 */
	public void setAccountFrom(Integer accountFrom){
		this.accountFrom = accountFrom;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  流水状态
	 */
	@Column(name ="ACCOUNT_STATUS",nullable=true,length=10)
	public Integer getAccountStatus(){
		return this.accountStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  流水状态
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
}
