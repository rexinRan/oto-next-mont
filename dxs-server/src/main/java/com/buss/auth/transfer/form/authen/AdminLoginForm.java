package com.buss.auth.transfer.form.authen;

import org.jweb.core.bean.BaseForm;

public class AdminLoginForm extends BaseForm {
	/**
	 * 管理员用户名
	 */
	private String userName;
	/**
	 * 管理员密码
	 */
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
