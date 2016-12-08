package com.buss.member.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色权限关系实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "dxs_role_function", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class RoleAndFunctionEntity  implements Serializable{

	private String id;
	private RoleEntity role;
	private FunctionEntity function;
	
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
	@ManyToOne(fetch = FetchType.LAZY) //　　ManyToOne关联到GoodsEntity
    @JoinColumn(name="ROLE_ID")
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	@ManyToOne(fetch = FetchType.LAZY) //　　ManyToOne关联到GoodsEntity
    @JoinColumn(name="FUNCTION_ID")
	public FunctionEntity getFunction() {
		return function;
	}
	public void setFunction(FunctionEntity function) {
		this.function = function;
	}
}
