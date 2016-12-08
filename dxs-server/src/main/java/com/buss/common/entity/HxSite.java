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
@Table(name = "dxs_site", catalog = "dxsdb")
public class HxSite implements java.io.Serializable{

	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 公司名称
	 */
	private String companyname;
	
	/**
	 * 公司网站
	 */
	private String companysite;
	
	public HxSite(){
		
	}

	public HxSite(Long id, String companyname, String companysite) {
		this.id = id;
		this.companyname = companyname;
		this.companysite = companysite;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "company_name", length = 255)
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Column(name = "company_site", length = 255)
	public String getCompanysite() {
		return companysite;
	}

	public void setCompanysite(String companysite) {
		this.companysite = companysite;
	}
}
