package com.buss.auth.transfer.form.authen;

import org.jweb.core.bean.BaseForm;

public class LoginForm extends BaseForm{
	/**任何能够说明用户身份的信息，如用户名，用户手机号，用户邮箱等，当然，如果多身份信息登陆，需要编写多个realm，并且配置*/
	private String code;
	/**登陆密码*/
	private String pwd;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
