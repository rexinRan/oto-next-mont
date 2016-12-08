/**
 * Copyright  2016
 *
 * 	All right reserved.
 *
 *	Created on  2016年3月8日 上午10:24:37
 * 
 */
package com.buss.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liuh
 *
 */
@Entity
@Table(name = "dxs_company", catalog = "dxsdb")
public class HxCompany implements java.io.Serializable{

	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 公司信息
	 */
	private String name;
	
	/**
	 * 公司简介
	 */
	private String about;
	
	/**
	 * 电话
	 */
	private String grouptel;
	
	/**
	 * 集团客服中心电话
	 */
	private String groupservicetel;
	
	/**
	 * 招聘邮箱
	 */
	private String advertiseemail;
	
	/**
	 * 集团总部位置
	 */
	private String groupaddress;
	
	/**
	 * 版权
	 */
	private String copyright;
	
	/**
	 * 备案信息
	 */
	private String record;
	
	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;
	private String ext6;
	
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "name", length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "about", length = 5000)
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Column(name = "group_tel", length = 255)
	public String getGrouptel() {
		return grouptel;
	}

	public void setGrouptel(String grouptel) {
		this.grouptel = grouptel;
	}
	
	@Column(name = "group_service_tel", length = 255)
	public String getGroupservicetel() {
		return groupservicetel;
	}

	public void setGroupservicetel(String groupservicetel) {
		this.groupservicetel = groupservicetel;
	}
	
	@Column(name = "advertise_email", length = 255)
	public String getAdvertiseemail() {
		return advertiseemail;
	}

	public void setAdvertiseemail(String advertiseemail) {
		this.advertiseemail = advertiseemail;
	}

	@Column(name = "group_address", length = 255)
	public String getGroupaddress() {
		return groupaddress;
	}

	public void setGroupaddress(String groupaddress) {
		this.groupaddress = groupaddress;
	}

	@Column(name = "copyright", length = 255)
	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@Column(name = "record", length = 255)
	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Column(name = "EXT1", length = 255)
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "EXT2", length = 255)
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "EXT3", length = 255)
	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "EXT4", length = 255)
	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	@Column(name = "EXT5", length = 255)
	public String getExt5() {
		return ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	@Column(name = "EXT6", length = 255)
	public String getExt6() {
		return ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}
	
}
