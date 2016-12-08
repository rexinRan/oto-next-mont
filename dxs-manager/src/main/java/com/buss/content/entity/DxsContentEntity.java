package com.buss.content.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_content
 * @author onlineGenerator
 * @date 2016-06-02 16:51:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_content", schema = "")
@SuppressWarnings("serial")
public class DxsContentEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**内容类目ID*/
	@Excel(name="内容类目ID")
	private String cid;
	/**内容标题*/
	@Excel(name="内容标题")
	private String title;
	/**子标题*/
	@Excel(name="子标题")
	private String subTitle;
	/**标题描述*/
	@Excel(name="标题描述")
	private String titleDesc;
	/**排序*/
	@Excel(name="排序")
	private Integer sortid;
	/**是否可用（1，可用，0 删除）*/
	@Excel(name="是否可用（1，可用，0 删除）")
	private Integer status;
	/**链接*/
	@Excel(name="链接")
	private String url;
	/**图片绝对路径*/
	@Excel(name="图片绝对路径")
	private String pic;
	/**created*/
	@Excel(name="created",format = "yyyy-MM-dd")
	private Date created;
	/**updated*/
	@Excel(name="updated",format = "yyyy-MM-dd")
	private Date updated;
	/**ext1*/
	@Excel(name="ext1")
	private String ext1;
	/**ext2*/
	@Excel(name="ext2")
	private String ext2;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容类目ID
	 */
	@Column(name ="CID",nullable=false,length=32)
	public String getCid(){
		return this.cid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容类目ID
	 */
	public void setCid(String cid){
		this.cid = cid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容标题
	 */
	@Column(name ="TITLE",nullable=true,length=200)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  子标题
	 */
	@Column(name ="SUB_TITLE",nullable=true,length=100)
	public String getSubTitle(){
		return this.subTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  子标题
	 */
	public void setSubTitle(String subTitle){
		this.subTitle = subTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题描述
	 */
	@Column(name ="TITLE_DESC",nullable=true,length=5000)
	public String getTitleDesc(){
		return this.titleDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题描述
	 */
	public void setTitleDesc(String titleDesc){
		this.titleDesc = titleDesc;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="SORTID",nullable=true,length=10)
	public Integer getSortid(){
		return this.sortid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSortid(Integer sortid){
		this.sortid = sortid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否可用（1，可用，0 删除）
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否可用（1，可用，0 删除）
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  链接
	 */
	@Column(name ="URL",nullable=true,length=500)
	public String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  链接
	 */
	public void setUrl(String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片绝对路径
	 */
	@Column(name ="PIC",nullable=true,length=300)
	public String getPic(){
		return this.pic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片绝对路径
	 */
	public void setPic(String pic){
		this.pic = pic;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  created
	 */
	@Column(name ="CREATED",nullable=true)
	public Date getCreated(){
		return this.created;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  created
	 */
	public void setCreated(Date created){
		this.created = created;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updated
	 */
	@Column(name ="UPDATED",nullable=true)
	public Date getUpdated(){
		return this.updated;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updated
	 */
	public void setUpdated(Date updated){
		this.updated = updated;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ext1
	 */
	@Column(name ="EXT1",nullable=true,length=5000)
	public String getExt1(){
		return this.ext1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ext1
	 */
	public void setExt1(String ext1){
		this.ext1 = ext1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ext2
	 */
	@Column(name ="EXT2",nullable=true,length=255)
	public String getExt2(){
		return this.ext2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ext2
	 */
	public void setExt2(String ext2){
		this.ext2 = ext2;
	}
}
