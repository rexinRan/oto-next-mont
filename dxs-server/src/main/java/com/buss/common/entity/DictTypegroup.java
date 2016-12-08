package com.buss.common.entity;
// default package

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * TTypegroup entity.
 */
@Entity
@Table(name = "t_s_typegroup")
public class DictTypegroup extends IDEntity implements java.io.Serializable {

	private String typegroupname;
	private String typegroupcode;
	private List<DictType> dictTypes = new ArrayList<DictType>();
	
	@Column(name = "typegroupname", length = 50)
	public String getTypegroupname() {
		return this.typegroupname;
	}

	public void setTypegroupname(String typegroupname) {
		this.typegroupname = typegroupname;
	}

	@Column(name = "typegroupcode", length = 50)
	public String getTypegroupcode() {
		return this.typegroupcode;
	}

	public void setTypegroupcode(String typegroupcode) {
		this.typegroupcode = typegroupcode;
	}

	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "dictTypegroup")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public List<DictType> getDictTypes() {
		return this.dictTypes;
	}

	public void setDictTypes(List<DictType> dictTypes) {
		this.dictTypes = dictTypes;
	}

}