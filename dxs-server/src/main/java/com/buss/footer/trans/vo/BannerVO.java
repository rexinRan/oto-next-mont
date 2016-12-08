package com.buss.footer.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.BannerEntity;

@Mapping(entityClass=BannerEntity.class)
public class BannerVO extends BaseVO{
	
	@Mapping
	private java.lang.String id;
	@Mapping
	private java.lang.String cid;
	@Mapping
	private java.lang.String title;
	@Mapping
	private java.lang.String subTitle;
	@Mapping
	private java.lang.String titleDesc;
	@Mapping
	private java.lang.String sortid;
	@Mapping
	private java.lang.String status;
	@Mapping
	private java.lang.String url;
	@Mapping
	private java.lang.String pic;
	@Mapping
	private java.lang.String created;
	@Mapping
	private java.lang.String updated;
	@Mapping
	private java.lang.String ext1;
	@Mapping
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
	public java.lang.String getTitle() {
		return title;
	}
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(java.lang.String subTitle) {
		this.subTitle = subTitle;
	}
	public java.lang.String getTitleDesc() {
		return titleDesc;
	}
	public void setTitleDesc(java.lang.String titleDesc) {
		this.titleDesc = titleDesc;
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
	public java.lang.String getUrl() {
		return url;
	}
	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	public java.lang.String getPic() {
		return pic;
	}
	public void setPic(java.lang.String pic) {
		this.pic = pic;
	}
	public java.lang.String getCreated() {
		return created;
	}
	public void setCreated(java.lang.String created) {
		this.created = created;
	}
	public java.lang.String getUpdated() {
		return updated;
	}
	public void setUpdated(java.lang.String updated) {
		this.updated = updated;
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
