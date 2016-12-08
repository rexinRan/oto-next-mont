package com.buss.specialrecruitapply.entity;

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
 * @Description: dxs_special_recruit_apply
 * @author onlineGenerator
 * @date 2016-08-05 14:34:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit_apply", schema = "")
@SuppressWarnings("serial")
public class SpecialRecruitApplyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**申请企业id*/
	private java.lang.String userId;
	/**专场id*/
	private java.lang.String srId;
	/**招聘省份*/
	private java.lang.String privince;
	/**招聘方向*/
	private java.lang.String employDirection;
	/**招聘院校*/
	private java.lang.String employSchool;
	/**岗位文件id*/
	private java.lang.String fileId;
	/**是否处理*/
	private java.lang.Integer isHandle;
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
	 *@return: java.lang.String  申请企业id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请企业id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专场id
	 */
	@Column(name ="SR_ID",nullable=true,length=32)
	public java.lang.String getSrId(){
		return this.srId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场id
	 */
	public void setSrId(java.lang.String srId){
		this.srId = srId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘省份
	 */
	@Column(name ="PRIVINCE",nullable=true,length=50)
	public java.lang.String getPrivince(){
		return this.privince;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘省份
	 */
	public void setPrivince(java.lang.String privince){
		this.privince = privince;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘方向
	 */
	@Column(name ="EMPLOY_DIRECTION",nullable=true,length=255)
	public java.lang.String getEmployDirection(){
		return this.employDirection;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘方向
	 */
	public void setEmployDirection(java.lang.String employDirection){
		this.employDirection = employDirection;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘院校
	 */
	@Column(name ="EMPLOY_SCHOOL",nullable=true,length=255)
	public java.lang.String getEmploySchool(){
		return this.employSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘院校
	 */
	public void setEmploySchool(java.lang.String employSchool){
		this.employSchool = employSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位文件id
	 */
	@Column(name ="FILE_ID",nullable=true,length=32)
	public java.lang.String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位文件id
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否处理
	 */
	@Column(name ="IS_HANDLE",nullable=true,length=3)
	public java.lang.Integer getIsHandle(){
		return this.isHandle;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否处理
	 */
	public void setIsHandle(java.lang.Integer isHandle){
		this.isHandle = isHandle;
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
