package com.buss.specialsobj.entity;

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

/**   
 * @Title: Entity
 * @Description: dxs_specials_obj
 * @author onlineGenerator
 * @date 2016-08-05 14:54:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials_obj", schema = "")
@SuppressWarnings("serial")
public class SpecialsObjEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**选聘简章id*/
	private java.lang.String shId;
	/**申请省*/
	private java.lang.String objAddressProvince;
	/**申请市*/
	private java.lang.String objAddressCity;
	/**申请项目*/
	private java.lang.String objProject;
	/**申请类型*/
	private java.lang.Integer type;
	/**申请结果*/
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘简章id
	 */
	@Column(name ="SH_ID",nullable=true,length=32)
	public java.lang.String getShId(){
		return this.shId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘简章id
	 */
	public void setShId(java.lang.String shId){
		this.shId = shId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请省
	 */
	@Column(name ="OBJ_ADDRESS_PROVINCE",nullable=true,length=50)
	public java.lang.String getObjAddressProvince(){
		return this.objAddressProvince;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请省
	 */
	public void setObjAddressProvince(java.lang.String objAddressProvince){
		this.objAddressProvince = objAddressProvince;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请市
	 */
	@Column(name ="OBJ_ADDRESS_CITY",nullable=true,length=50)
	public java.lang.String getObjAddressCity(){
		return this.objAddressCity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请市
	 */
	public void setObjAddressCity(java.lang.String objAddressCity){
		this.objAddressCity = objAddressCity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请项目
	 */
	@Column(name ="OBJ_PROJECT",nullable=true,length=255)
	public java.lang.String getObjProject(){
		return this.objProject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请项目
	 */
	public void setObjProject(java.lang.String objProject){
		this.objProject = objProject;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请类型
	 */
	@Column(name ="TYPE",nullable=true,length=3)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请结果
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请结果
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
}
