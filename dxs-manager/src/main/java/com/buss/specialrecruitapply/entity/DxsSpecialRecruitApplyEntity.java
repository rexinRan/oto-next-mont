package com.buss.specialrecruitapply.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.specialrecruit.entity.DxsSpecialRecruitEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_special_recruit_apply
 * @author dq
 * @date 2016-08-05 10:46:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit_apply", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialRecruitApplyEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**申请企业id*/
	@Excel(name="申请企业id")
	private String userId;
	/**专场id*/
	@Excel(name="专场id")
	private String srId;
	/**招聘省份*/
	@Excel(name="招聘省份")
	private String privince;
	/**招聘方向*/
	@Excel(name="招聘方向")
	private String employDirection;
	/**招聘院校*/
	@Excel(name="招聘院校")
	private String employSchool;
	/**岗位文件id*/
	@Excel(name="岗位文件id")
	private String fileId;
	/**是否处理*/
	@Excel(name="是否处理")
	private Integer isHandle;
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
	 * @author dq
	 * 与表dxs_user的多对一关联
	 * */
	private DxsUserEntity dxsUserEntity;
	/**
	 * @author dq
	 * 与表dxs_special_recruit的多对一关联
	 * */
	private DxsSpecialRecruitEntity dxsSpecialRecruitEntity;


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
	 *@return: java.lang.String  申请企业id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请企业id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专场id
	 */
	@Column(name ="SR_ID",nullable=true,length=32)
	public String getSrId(){
		return this.srId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场id
	 */
	public void setSrId(String srId){
		this.srId = srId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘省份
	 */
	@Column(name ="PRIVINCE",nullable=true,length=50)
	public String getPrivince(){
		return this.privince;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘省份
	 */
	public void setPrivince(String privince){
		this.privince = privince;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘方向
	 */
	@Column(name ="EMPLOY_DIRECTION",nullable=true,length=255)
	public String getEmployDirection(){
		return this.employDirection;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘方向
	 */
	public void setEmployDirection(String employDirection){
		this.employDirection = employDirection;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘院校
	 */
	@Column(name ="EMPLOY_SCHOOL",nullable=true,length=255)
	public String getEmploySchool(){
		return this.employSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘院校
	 */
	public void setEmploySchool(String employSchool){
		this.employSchool = employSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位文件id
	 */
	@Column(name ="FILE_ID",nullable=true,length=32)
	public String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位文件id
	 */
	public void setFileId(String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否处理
	 */
	@Column(name ="IS_HANDLE",nullable=true,length=3)
	public Integer getIsHandle(){
		return this.isHandle;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否处理
	 */
	public void setIsHandle(Integer isHandle){
		this.isHandle = isHandle;
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

	/**
	 *@author dq
	 *添加表dxs_user多对一bean
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}

	/**
	 *@author dq
	 *添加表dxs_special_recruit多对一bean
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sr_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsSpecialRecruitEntity getDxsSpecialRecruitEntity() {
		return dxsSpecialRecruitEntity;
	}

	public void setDxsSpecialRecruitEntity(DxsSpecialRecruitEntity dxsSpecialRecruitEntity) {
		this.dxsSpecialRecruitEntity = dxsSpecialRecruitEntity;
	}
}
