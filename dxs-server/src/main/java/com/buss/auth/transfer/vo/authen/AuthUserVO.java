package com.buss.auth.transfer.vo.authen;

import java.io.Serializable;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

public class AuthUserVO extends BaseVO implements Serializable{

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
	/**邮箱*/
	@Mapping
	private java.lang.String email;
	/**手机号*/
	@Mapping
	private String mphone;
	/**核审状态*/
	@Mapping
	private java.lang.String checkstatus;
	/**用户级别*/
	@Mapping
	private java.lang.String rolecode;
	/**是否删除*/
	@Mapping
	private java.lang.String isdelete;
	
	/**入会形式（1个人，2公司）*/
	@Mapping
	private java.lang.String empname;
	/**身份证号*/
	@Mapping
	private java.lang.String idcardnumber;
	/**公司名称*/
	@Mapping
	private java.lang.String empcode;

	/**创建时间*/
	private java.lang.String createtime;
	
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

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getIdcardnumber() {
		return idcardnumber;
	}

	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
}
