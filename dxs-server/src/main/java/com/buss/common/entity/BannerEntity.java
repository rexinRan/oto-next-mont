package com.buss.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @Title: Entity
 * @Description: banner管理
 * @author zhangdaihao
 * @date 2016-03-08 14:47:56
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_content", catalog = "dxsdb")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class BannerEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	/** 内容类目ID */
	private java.lang.Long cid;
	/** 内容标题 */
	private java.lang.String title;
	/** 子标题 */
	private java.lang.String subTitle;
	/** 标题描述 */
	private java.lang.String titleDesc;
	/** 排序 */
	private java.lang.Integer sortid;
	/** 是否可用（1，可用，0 删除） */
	private java.lang.Integer status;
	/** 链接 */
	private java.lang.String url;
	/** 图片绝对路径 */
	private java.lang.String pic;
	/** created */
	private java.util.Date created;
	/** updated */
	private java.util.Date updated;
	/** ext1 */
	private java.lang.String ext1;
	/** ext2 */
	private java.lang.String ext2;

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer id
	 */

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 内容类目ID
	 */
	@Column(name = "CID", nullable = false, precision = 19, scale = 0)
	public java.lang.Long getCid() {
		return this.cid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer
	 *             内容类目ID
	 */
	public void setCid(java.lang.Long cid) {
		this.cid = cid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 内容标题
	 */
	@Column(name = "TITLE", nullable = true, length = 200)
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             内容标题
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 子标题
	 */
	@Column(name = "SUB_TITLE", nullable = true, length = 100)
	public java.lang.String getSubTitle() {
		return this.subTitle;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             子标题
	 */
	public void setSubTitle(java.lang.String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 标题描述
	 */
	@Column(name = "TITLE_DESC", nullable = true, length = 500)
	public java.lang.String getTitleDesc() {
		return this.titleDesc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             标题描述
	 */
	public void setTitleDesc(java.lang.String titleDesc) {
		this.titleDesc = titleDesc;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 排序
	 */
	@Column(name = "SORTID", nullable = true, precision = 10, scale = 0)
	public java.lang.Integer getSortid() {
		return this.sortid;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer
	 *             排序
	 */
	public void setSortid(java.lang.Integer sortid) {
		this.sortid = sortid;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 是否可用（1，可用，0 删除）
	 */
	@Column(name = "STATUS", nullable = true, precision = 10, scale = 0)
	public java.lang.Integer getStatus() {
		return this.status;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer
	 *             是否可用（1，可用，0 删除）
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 链接
	 */
	@Column(name = "URL", nullable = true, length = 500)
	public java.lang.String getUrl() {
		return this.url;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             链接
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 图片绝对路径
	 */
	@Column(name = "PIC", nullable = true, length = 300)
	public java.lang.String getPic() {
		return this.pic;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             图片绝对路径
	 */
	public void setPic(java.lang.String pic) {
		this.pic = pic;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date created
	 */
	@Column(name = "CREATED", nullable = true)
	public java.util.Date getCreated() {
		return this.created;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date
	 *             created
	 */
	public void setCreated(java.util.Date created) {
		this.created = created;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date updated
	 */
	@Column(name = "UPDATED", nullable = true)
	public java.util.Date getUpdated() {
		return this.updated;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date
	 *             updated
	 */
	public void setUpdated(java.util.Date updated) {
		this.updated = updated;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String ext1
	 */
	@Column(name = "EXT1", nullable = true, length = 255)
	public java.lang.String getExt1() {
		return this.ext1;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             ext1
	 */
	public void setExt1(java.lang.String ext1) {
		this.ext1 = ext1;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String ext2
	 */
	@Column(name = "EXT2", nullable = true, length = 255)
	public java.lang.String getExt2() {
		return this.ext2;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String
	 *             ext2
	 */
	public void setExt2(java.lang.String ext2) {
		this.ext2 = ext2;
	}
}
