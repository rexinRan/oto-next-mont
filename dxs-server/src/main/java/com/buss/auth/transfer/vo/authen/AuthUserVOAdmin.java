package com.buss.auth.transfer.vo.authen;

import java.io.Serializable;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

public class AuthUserVOAdmin extends BaseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 275786668344834896L;
	/**id*/
	@Mapping
	private java.lang.String id;
	/** 用户名 */
	@Mapping
	private java.lang.String username;
	/** 密码 */
	@Mapping
	private java.lang.String password;
	/** 性别 */
	@Mapping
	private java.lang.String gender;
	/** 真实姓名 */
	@Mapping
	private java.lang.String realname;
	/** 电子邮件 */
	@Mapping
	private java.lang.String email;
	/** 电话 */
	@Mapping
	private java.lang.String telephone;
	/** 所属公司 */
	@Mapping
	private java.lang.String company;
	/** 所属部门 */
	@Mapping
	private java.lang.String department;
	/** 职位 */
	@Mapping
	private java.lang.String position;
	/** 状态（1有效，0无效） */
	@Mapping
	private java.lang.String status;
	/** 备注 */
	@Mapping
	private java.lang.String remark;
	/** 更新时间 */
	@Mapping
	private java.lang.String updatetime;
	/** 创建时间 */
	@Mapping
	private java.lang.String createtime;
	
	/**用户类型，b表示后台，f表示前台*/
	private String userType;
	
	
	
	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getUsername() {
		return username;
	}
	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	public java.lang.String getPassword() {
		return password;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	public java.lang.String getGender() {
		return gender;
	}
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}
	public java.lang.String getRealname() {
		return realname;
	}
	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getTelephone() {
		return telephone;
	}
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getCompany() {
		return company;
	}
	public void setCompany(java.lang.String company) {
		this.company = company;
	}
	public java.lang.String getDepartment() {
		return department;
	}
	public void setDepartment(java.lang.String department) {
		this.department = department;
	}
	public java.lang.String getPosition() {
		return position;
	}
	public void setPosition(java.lang.String position) {
		this.position = position;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(java.lang.String updatetime) {
		this.updatetime = updatetime;
	}
	public java.lang.String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.lang.String createtime) {
		this.createtime = createtime;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
