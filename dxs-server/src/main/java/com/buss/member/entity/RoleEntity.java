package com.buss.member.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "dxs_role", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class RoleEntity  implements Serializable{

	private String id;
	private String name;
	private String code;
	private String description;
	private List<RoleAndFunctionEntity> functions;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name ="NAME",nullable=true,length=32)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name ="CODE",nullable=true,length=32)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name ="DESCRIPTION",nullable=true,length=32)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="role")//　OneToMany关联到了AdminRole这个类，由AdminRole这个类来维护多对一的关系，mappedBy="admin"
	@LazyCollection(LazyCollectionOption.EXTRA)//
	public List<RoleAndFunctionEntity> getFunctions() {
		return functions;
	}
	public void setFunctions(List<RoleAndFunctionEntity> functions) {
		this.functions = functions;
	}
}
