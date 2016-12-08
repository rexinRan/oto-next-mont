package com.buss.member.transfer.vo.pwd;

import java.io.Serializable;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

public class PwdUserVO extends BaseVO implements Serializable{

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
	
	public java.lang.String getRealname() {
		return realname;
	}
	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}
	
}
