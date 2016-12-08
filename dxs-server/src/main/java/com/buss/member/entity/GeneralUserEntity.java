package com.buss.member.entity;

import javax.persistence.*;

import com.buss.usercompancy.entity.UserCompancyEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.jweb.core.bean.annotation.Mapping;

/**   
 * @Title: Entity
 * @Description: 注册用户
 *
 */
@Entity
@Table(name = "dxs_user", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class GeneralUserEntity implements java.io.Serializable {

	/**用户表主键*/
	private java.lang.String id;
	/**真实姓名*/
	private java.lang.String realname;
	/**用户角色*/
	private java.lang.String rolecode;
	/**手机号(老师/学生登录账号)*/
	private java.lang.String mphone;
	/**密码*/
	private java.lang.String pwd;
	/**电子邮箱(企业登录账号)*/
	private java.lang.String email;
	/**企业名称*/
	private java.lang.String empname;
	/**企业组织代码证号*/
	private java.lang.String empcode;

	/**身份证号*/
	private java.lang.String idcardnumber;

	/**核审状态(预留判断企业)*/
	private java.lang.Integer checkstatus;
	/**是否删除(0未删除1删除)*/
	private java.lang.Integer isdelete;
	/**用户加入时间*/
	private java.util.Date createtime;
	/**企业详情*/
	private UserCompancyEntity userCompancyEntity;

	/**报名活动*/
//	Set<ActiveUserEntity> activitySet = new HashSet<ActiveUserEntity>();
//
//	@OneToMany(mappedBy="activeId")
//	@LazyCollection(LazyCollectionOption.EXTRA)
//	public Set<ActiveUserEntity> getActivitySet() {
//		return activitySet;
//	}
//
//	public void setActivitySet(Set<ActiveUserEntity> activitySet) {
//		this.activitySet = activitySet;
//	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户表主键
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
	 *@param: java.lang.String  用户表主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="REALNAME",nullable=true,length=32)
	public java.lang.String getRealname(){
		return this.realname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealname(java.lang.String realname){
		this.realname = realname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户角色
	 */
	@Column(name ="ROLECODE",nullable=false,length=32)
	public java.lang.String getRolecode(){
		return this.rolecode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户角色
	 */
	public void setRolecode(java.lang.String rolecode){
		this.rolecode = rolecode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号(老师/学生登录账号)
	 */
	@Column(name ="MPHONE",nullable=true,length=11)
	public java.lang.String getMphone(){
		return this.mphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号(老师/学生登录账号)
	 */
	public void setMphone(java.lang.String mphone){
		this.mphone = mphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */
	@Column(name ="PWD",nullable=false,length=255)
	public java.lang.String getPwd(){
		return this.pwd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setPwd(java.lang.String pwd){
		this.pwd = pwd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子邮箱(企业登录账号)
	 */
	@Column(name ="EMAIL",nullable=true,length=64)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子邮箱(企业登录账号)
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业名称
	 */
	@Column(name ="EMPNAME",nullable=true,length=255)
	public java.lang.String getEmpname(){
		return this.empname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业名称
	 */
	public void setEmpname(java.lang.String empname){
		this.empname = empname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业组织代码证号
	 */
	@Column(name ="EMPCODE",nullable=true,length=32)
	public java.lang.String getEmpcode(){
		return this.empcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业组织代码证号
	 */
	public void setEmpcode(java.lang.String empcode){
		this.empcode = empcode;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  核审状态(预留判断企业)
	 */
	@Column(name ="CHECKSTATUS",nullable=true,length=10)
	public java.lang.Integer getCheckstatus(){
		return this.checkstatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  核审状态(预留判断企业)
	 */
	public void setCheckstatus(java.lang.Integer checkstatus){
		this.checkstatus = checkstatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否删除(0未删除1删除)
	 */
	@Column(name ="ISDELETE",nullable=true,length=10)
	public java.lang.Integer getIsdelete(){
		return this.isdelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否删除(0未删除1删除)
	 */
	public void setIsdelete(java.lang.Integer isdelete){
		this.isdelete = isdelete;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  用户加入时间
	 */
	@Column(name ="CREATETIME",nullable=true)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  用户加入时间
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="ID_CARD_NUMBER",nullable=true,length=20)
	public java.lang.String getIdcardnumber(){
		return this.idcardnumber;
	}

	public void setIdcardnumber(java.lang.String idcardnumber){
		this.idcardnumber = idcardnumber;
	}
	@OneToOne(mappedBy="userEntity")
	public UserCompancyEntity getUserCompancyEntity() {
		return userCompancyEntity;
	}

	public void setUserCompancyEntity(UserCompancyEntity userCompancyEntity) {
		this.userCompancyEntity = userCompancyEntity;
	}
}
