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
 * 用户角色关系实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "dxs_user_role", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class UserAndRoleEntity  implements Serializable{

	private String id;
	private GeneralUserEntity user;
	private RoleEntity role;
	
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
    @JoinColumn(name="USER_ID")
	public GeneralUserEntity getUser() {
		return user;
	}
	public void setUser(GeneralUserEntity user) {
		this.user = user;
	}
	@ManyToOne(fetch = FetchType.LAZY) //　　ManyToOne关联到GoodsEntity
    @JoinColumn(name="ROLE_ID")
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
}
