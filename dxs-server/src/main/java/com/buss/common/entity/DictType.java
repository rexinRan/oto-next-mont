package com.buss.common.entity;
// default package

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 通用类型字典表
 *  @author  张代浩
 */
@Entity
@Table(name = "t_s_type")
public class DictType extends IDEntity implements java.io.Serializable {

	private DictTypegroup dictTypegroup;//类型分组
	private String typename;//类型名称
	private String typecode;//类型编码

	@Column(name = "typename", length = 50)
	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column(name = "typecode", length = 50)
	public String getTypecode() {
		return this.typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typegroupid")
	public DictTypegroup getDictTypegroup() {
		return dictTypegroup;
	}

	public void setDictTypegroup(DictTypegroup dictTypegroup) {
		this.dictTypegroup = dictTypegroup;
	}
	

}