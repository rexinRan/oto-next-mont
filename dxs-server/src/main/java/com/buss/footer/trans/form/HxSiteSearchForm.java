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

import com.buss.common.entity.HxSite;

/**
 * @author liuh
 *
 */
@Mapping(entityClass=HxSite.class)
public class HxSiteSearchForm  extends SearchForm{

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
