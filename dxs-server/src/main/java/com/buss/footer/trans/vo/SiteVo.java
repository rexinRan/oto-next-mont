package com.buss.footer.trans.vo;

import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.HxSite;

@Mapping(entityClass=HxSite.class)
public class SiteVo {

	@Mapping
	private String id;
	
	@Mapping
	private String companyname;
	
	@Mapping
	private String companysite;

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
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the companysite
	 */
	public String getCompanysite() {
		return companysite;
	}

	/**
	 * @param companysite the companysite to set
	 */
	public void setCompanysite(String companysite) {
		this.companysite = companysite;
	}
}
