/**
 * Copyright  2016
 *
 * 	All right reserved.
 *
 *	Created on  2016年3月9日 上午10:21:40
 * 
 */
package com.buss.footer.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.HxCompany;

/**
 * @author liuh
 *
 */
@Mapping(entityClass=HxCompany.class)
public class CompanyVo extends BaseVO {

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
	 * 集团邮箱
	 */
	@Mapping
	private String ext1;
	@Mapping
	private String ext2;
	@Mapping
	private String ext3;
	@Mapping
	private String ext4;
	@Mapping
	private String ext5;
	@Mapping
	private String ext6;

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

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	public String getExt6() {
		return ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}
	
}
