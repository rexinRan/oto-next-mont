package com.buss.common.entity;
// Generated 2016-3-29 10:56:41 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.buss.member.entity.GeneralUserEntity;

/**
 * HxUserArticle generated by hbm2java
 */
@Entity
@Table(name = "hx_user_active", catalog = "hxclub")
public class HxUserActive implements java.io.Serializable {

	private String id;
	private HxActive hxActive;
	private GeneralUserEntity hxUser;
	private Integer checkstatus;
	private Integer isDelete;

	public HxUserActive() {
	}

	public HxUserActive(String id) {
		this.id = id;
	}

	public HxUserActive(String id, HxActive hxActive, GeneralUserEntity hxUser, Integer checkstatus, Integer isDelete) {
		this.id = id;
		this.hxActive = hxActive;
		this.hxUser = hxUser;
		this.checkstatus = checkstatus;
		this.isDelete = isDelete;
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activeid")
	public HxActive getHxActive() {
		return this.hxActive;
	}

	public void setHxActive(HxActive hxActive) {
		this.hxActive = hxActive;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public GeneralUserEntity getHxUser() {
		return this.hxUser;
	}

	public void setHxUser(GeneralUserEntity hxUser) {
		this.hxUser = hxUser;
	}

	@Column(name = "checkstatus")
	public Integer getCheckstatus() {
		return this.checkstatus;
	}

	public void setCheckstatus(Integer checkstatus) {
		this.checkstatus = checkstatus;
	}

	@Column(name = "is_delete")
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}
