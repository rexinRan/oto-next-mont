package com.buss.auth.transfer.vo.authen;

import java.io.Serializable;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

public class AuthUserVOAll extends BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 275786668344834896L;
	/**id*/
	@Mapping
	private java.lang.String id;
	/**用户姓名*/
	@Mapping
	private java.lang.String realname;
	/**入会形式（1个人，2公司）*/
	@Mapping
	private java.lang.String jointype;
	/**密码*/
	@Mapping
	private java.lang.String pwd;
	/**手机号*/
	@Mapping
	private String mphone;
	/**邮箱*/
	@Mapping
	private java.lang.String email;
	/**身份证号*/
	@Mapping
	private java.lang.String idcord;
	/**公司名称*/
	@Mapping
	private java.lang.String companyname;
	/**目前职务*/
	@Mapping
	private java.lang.String job;
	/**核审状态*/
	@Mapping
	private java.lang.String checkstatus;
	/**用户级别*/
	@Mapping
	private java.lang.String levelclass;
	/**是否删除*/
	@Mapping
	private java.lang.String isDelete;
	/**创建时间*/
	@Mapping
	private java.lang.String joinDate;
	/**更新时间*/
	@Mapping
	private java.lang.String updateInfoDate;
	/**出于安全避免别人随意更改用户密码*/
	@Mapping
	private java.lang.String isupdatepwd;
	
	/**用户类型，b表示后台，f表示前台*/
	private String userType;
	
	
	
	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public java.lang.String getRealname() {
		return realname;
	}
	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}
	public java.lang.String getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(java.lang.String checkstatus) {
		this.checkstatus = checkstatus;
	}
	public java.lang.String getLevelclass() {
		return levelclass;
	}
	public void setLevelclass(java.lang.String levelclass) {
		this.levelclass = levelclass;
	}
	public java.lang.String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(java.lang.String isDelete) {
		this.isDelete = isDelete;
	}
	public java.lang.String getJointype() {
		return jointype;
	}
	public void setJointype(java.lang.String jointype) {
		this.jointype = jointype;
	}
	public java.lang.String getIdcord() {
		return idcord;
	}
	public void setIdcord(java.lang.String idcord) {
		this.idcord = idcord;
	}
	public java.lang.String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(java.lang.String companyname) {
		this.companyname = companyname;
	}
	public java.lang.String getJob() {
		return job;
	}
	public void setJob(java.lang.String job) {
		this.job = job;
	}
	public java.lang.String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(java.lang.String joinDate) {
		this.joinDate = joinDate;
	}
	public java.lang.String getPwd() {
		return pwd;
	}
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}
	public java.lang.String getUpdateInfoDate() {
		return updateInfoDate;
	}
	public void setUpdateInfoDate(java.lang.String updateInfoDate) {
		this.updateInfoDate = updateInfoDate;
	}
	public java.lang.String getIsupdatepwd() {
		return isupdatepwd;
	}
	public void setIsupdatepwd(java.lang.String isupdatepwd) {
		this.isupdatepwd = isupdatepwd;
	}
	
	
}
