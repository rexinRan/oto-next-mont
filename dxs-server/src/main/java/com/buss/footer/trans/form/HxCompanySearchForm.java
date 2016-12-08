/**
 * Copyright  2016
 *
 * 	All right reserved.
 *
 *	Created on  2016年3月9日 上午8:40:27
 * 
 */
package com.buss.footer.trans.form;

import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.HxCompany;

/**
 * @author liuh
 *
 */
@Mapping(entityClass=HxCompany.class)
public class HxCompanySearchForm  extends SearchForm{

	@Mapping
	private String id;
	
	/**
	 * 公司信息
	 */
	@Mapping
	private String name;
	
	/**
	 * 公司简介
	 */
	@Mapping
	private String about;
	
	/**
	 * 电话
	 */
	@Mapping
	private String grouptel;
	
	/**
	 * 集团客服中心电话
	 */
	@Mapping
	private String groupservicetel;
	
	/**
	 * 招聘邮箱
	 */
	@Mapping
	private String advertiseemail;
	
	/**
	 * 集团总部位置
	 */
	@Mapping
	private String groupaddress;
	
	/**
	 * 版权
	 */
	@Mapping
	private String copyright;
	
	/**
	 * 备案信息
	 */
	@Mapping
	private String record;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 * @return the grouptel
	 */
	public String getGrouptel() {
		return grouptel;
	}

	/**
	 * @param grouptel the grouptel to set
	 */
	public void setGrouptel(String grouptel) {
		this.grouptel = grouptel;
	}

	/**
	 * @return the groupservicetel
	 */
	public String getGroupservicetel() {
		return groupservicetel;
	}

	/**
	 * @param groupservicetel the groupservicetel to set
	 */
	public void setGroupservicetel(String groupservicetel) {
		this.groupservicetel = groupservicetel;
	}

	/**
	 * @return the advertiseemail
	 */
	public String getAdvertiseemail() {
		return advertiseemail;
	}

	/**
	 * @param advertiseemail the advertiseemail to set
	 */
	public void setAdvertiseemail(String advertiseemail) {
		this.advertiseemail = advertiseemail;
	}

	/**
	 * @return the groupaddress
	 */
	public String getGroupaddress() {
		return groupaddress;
	}

	/**
	 * @param groupaddress the groupaddress to set
	 */
	public void setGroupaddress(String groupaddress) {
		this.groupaddress = groupaddress;
	}

	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * @return the record
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(String record) {
		this.record = record;
	}
}
