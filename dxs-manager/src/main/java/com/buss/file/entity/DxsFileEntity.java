package com.buss.file.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.entrepreneurshipprojectfund.entity.EntrepreneurshipProjectFundEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_file
 * @author onlineGenerator
 * @date 2016-06-27 19:10:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_file", schema = "")
@SuppressWarnings("serial")
public class DxsFileEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**外键*/
	@Excel(name="外键")
	private String outId;
	/**连接表*/
	@Excel(name="连接表")
	private String tableType;
	/**文件名*/
	@Excel(name="文件名")
	private String name;
	/**title*/
	@Excel(name="title")
	private String title;
	/**文件类型*/
	@Excel(name="文件类型")
	private Integer filetype;
	/**文件审核状态*/
	@Excel(name="文件审核状态")
	private Integer checkstatus;
	/**下载地址*/
	@Excel(name="下载地址")
	private String downloadUrl;
	/**createtime*/
	@Excel(name="createtime",format = "yyyy-MM-dd")
	private Date createtime;
	/**updatetime*/
	@Excel(name="updatetime",format = "yyyy-MM-dd")
	private Date updatetime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDetail;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setOutId(String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  连接表
	 */
	@Column(name ="TABLE_TYPE",nullable=true,length=2)
	public String getTableType(){
		return this.tableType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  连接表
	 */
	public void setTableType(String tableType){
		this.tableType = tableType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件名
	 */
	@Column(name ="NAME",nullable=true,length=255)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  title
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文件类型
	 */
	@Column(name ="FILETYPE",nullable=true,length=10)
	public Integer getFiletype(){
		return this.filetype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文件类型
	 */
	public void setFiletype(Integer filetype){
		this.filetype = filetype;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文件审核状态
	 */
	@Column(name ="CHECKSTATUS",nullable=true,length=10)
	public Integer getCheckstatus(){
		return this.checkstatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文件审核状态
	 */
	public void setCheckstatus(Integer checkstatus){
		this.checkstatus = checkstatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下载地址
	 */
	@Column(name ="DOWNLOAD_URL",nullable=true,length=255)
	public String getDownloadUrl(){
		return this.downloadUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下载地址
	 */
	public void setDownloadUrl(String downloadUrl){
		this.downloadUrl = downloadUrl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createtime
	 */
	@Column(name ="CREATETIME",nullable=true)
	public Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createtime
	 */
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updatetime
	 */
	@Column(name ="UPDATETIME",nullable=true)
	public Date getUpdatetime(){
		return this.updatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updatetime
	 */
	public void setUpdatetime(Date updatetime){
		this.updatetime = updatetime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DETAIL",nullable=true,length=3)
	public Integer getIsDetail(){
		return this.isDetail;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDetail(Integer isDetail){
		this.isDetail = isDetail;
	}

	//=======================关系映射==========================================

	// 创业基金
	private EntrepreneurshipProjectFundEntity entrepreneurshipProjectFundEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "out_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public EntrepreneurshipProjectFundEntity getEntrepreneurshipProjectFundEntity() {
		return entrepreneurshipProjectFundEntity;
	}

	public void setEntrepreneurshipProjectFundEntity(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFundEntity) {
		this.entrepreneurshipProjectFundEntity = entrepreneurshipProjectFundEntity;
	}
}
