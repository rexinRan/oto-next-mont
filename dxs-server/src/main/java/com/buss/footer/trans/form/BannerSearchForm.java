package com.buss.footer.trans.form;

import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.BannerEntity;

@Mapping(entityClass=BannerEntity.class)
public class BannerSearchForm extends SearchForm{

	@Mapping("id")
	private java.lang.String id;
	@Mapping("cid")
	private java.lang.String cid;
	@Mapping("sortid")
	private java.lang.String sortid;
	@Mapping("status")
	private java.lang.String status;
	@Mapping("title")
	private java.lang.String title;
	@Mapping("ext1")
	private java.lang.String ext1;
	@Mapping("ext2")
	private java.lang.String ext2;

	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getCid() {
		return cid;
	}
	public void setCid(java.lang.String cid) {
		this.cid = cid;
	}
	public java.lang.String getSortid() {
		return sortid;
	}
	public void setSortid(java.lang.String sortid) {
		this.sortid = sortid;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
