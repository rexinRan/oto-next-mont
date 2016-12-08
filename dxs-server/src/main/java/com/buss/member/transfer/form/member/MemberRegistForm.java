package com.buss.member.transfer.form.member;

import org.jweb.core.bean.BaseForm;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.member.entity.GeneralUserEntity;

@Mapping(entityClass=GeneralUserEntity.class)
public class MemberRegistForm extends BaseForm{

	/**用户角色*/
	@Mapping
	private java.lang.String rolecode;
	@Mapping
	private java.lang.String realname;
	/**邮箱*/
	@Mapping
	private java.lang.String email;
	/**手机号*/
	@Mapping
	private String mphone;
	/**登陆密码*/
	@Mapping
	private String pwd;


	/**身份证号*/
	@Mapping
	private java.lang.String idcardnumber;

	/**企业名称*/
	@Mapping
	private java.lang.String empname;
	/**企业组织代码证号*/
	@Mapping
	private java.lang.String empcode;
	/**核审状态(预留判断企业)*/
	@Mapping
	private java.lang.String checkstatus;
	/**是否删除(0未删除1删除)*/
	@Mapping
	private java.lang.String isdelete;
	/**用户加入时间*/
	@Mapping
	private java.lang.String createtime;

	/**短信验证码*/
	private String validCode;


	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getCheckstatus() {
		return checkstatus;
	}

	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}

	public String getIdcardnumber() {
		return idcardnumber;
	}

	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}
}
