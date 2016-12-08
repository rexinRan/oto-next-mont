package com.buss.member.transfer.vo.pwd;

import java.io.Serializable;

/**
 * 短信验证码vo模型，用于缓存服务器缓存数据使用
 * @author Administrator
 *
 */
public class SMSCodeVO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String mphone;
	private String smsCode;
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
}
