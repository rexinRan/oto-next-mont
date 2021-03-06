package com.buss.file.entity;

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

/**   
 * @Title: Entity
 * @Description: dxs_file
 * @author onlineGenerator
 * @date 2016-06-20 16:11:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_file", schema = "")
@SuppressWarnings("serial")
public class FileEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**外键*/
	private java.lang.String outId;
	/**连接表*/
	private java.lang.String tableType;
	/**文件名*/
	private java.lang.String name;
	/**title*/
	private java.lang.String title;
	/**文件类型*/
	private java.lang.Integer filetype;
	/**文件审核状态*/
	private java.lang.Integer checkstatus;
	/**下载地址*/
	private java.lang.String downloadUrl;
	/**createtime*/
	private java.util.Date createtime;
	/**updatetime*/
	private java.util.Date updatetime;
	/**删除标志*/
	private java.lang.Integer isDetail;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public java.lang.String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setOutId(java.lang.String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  连接表
	 */
	@Column(name ="TABLE_TYPE",nullable=true,length=2)
	public java.lang.String getTableType(){
		return this.tableType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  连接表
	 */
	public void setTableType(java.lang.String tableType){
		this.tableType = tableType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件名
	 */
	@Column(name ="NAME",nullable=true,length=255)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  title
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  title
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文件类型
	 */
	@Column(name ="FILETYPE",nullable=true,length=10)
	public java.lang.Integer getFiletype(){
		return this.filetype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文件类型
	 */
	public void setFiletype(java.lang.Integer filetype){
		this.filetype = filetype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文件审核状态
	 */
	@Column(name ="CHECKSTATUS",nullable=true,length=10)
	public java.lang.Integer getCheckstatus(){
		return this.checkstatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文件审核状态
	 */
	public void setCheckstatus(java.lang.Integer checkstatus){
		this.checkstatus = checkstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下载地址
	 */
	@Column(name ="DOWNLOAD_URL",nullable=true,length=255)
	public java.lang.String getDownloadUrl(){
		return this.downloadUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下载地址
	 */
	public void setDownloadUrl(java.lang.String downloadUrl){
		this.downloadUrl = downloadUrl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createtime
	 */
	@Column(name ="CREATETIME",nullable=true)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createtime
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updatetime
	 */
	@Column(name ="UPDATETIME",nullable=true)
	public java.util.Date getUpdatetime(){
		return this.updatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updatetime
	 */
	public void setUpdatetime(java.util.Date updatetime){
		this.updatetime = updatetime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DETAIL",nullable=true,length=3)
	public java.lang.Integer getIsDetail(){
		return this.isDetail;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDetail(java.lang.Integer isDetail){
		this.isDetail = isDetail;
	}
}
