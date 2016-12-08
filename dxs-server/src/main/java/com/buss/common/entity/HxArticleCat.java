package com.buss.common.entity;
// Generated 2016-2-24 14:10:58 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HxArticleCat generated by hbm2java
 */
@Entity
@Table(name = "hx_article_cat", catalog = "hxclub")
public class HxArticleCat implements java.io.Serializable {

	private long id;
	private String name;
	private Integer isParent;
	private Long parentId;
	private Integer sortid;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	
//	private List<HxActive> hxActives = new ArrayList<>();

	
	public HxArticleCat() {
	}

	public HxArticleCat(long id) {
		this.id = id;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "is_parent")
	public Integer getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	@Column(name = "parent_id")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "sortid")
	public Integer getSortid() {
		return this.sortid;
	}

	public void setSortid(Integer sortid) {
		this.sortid = sortid;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

//	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy ="articleCat") 
//	public List<HxActive> getHxActives() {
//		return hxActives;
//	}
//
//	public void setHxActives(List<HxActive> hxActives) {
//		this.hxActives = hxActives;
//	}

}
