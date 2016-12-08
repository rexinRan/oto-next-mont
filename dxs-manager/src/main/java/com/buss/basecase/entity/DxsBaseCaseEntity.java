package com.buss.basecase.entity;

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
 * @Description: dxs_base_case
 * @author onlineGenerator
 * @date 2016-07-25 14:00:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_base_case", schema = "")
@SuppressWarnings("serial")
public class DxsBaseCaseEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**基地主键*/
	@Excel(name="基地主键")
	private String dbId;
	/**基地图片文件*/
	@Excel(name="基地图片文件")
	private String dbImgFid;
	/**图片地址*/
	@Excel(name="图片地址")
	private String dbImgUrl;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;
	
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
	 *@return: java.lang.String  基地主键
	 */
	@Column(name ="DB_ID",nullable=true,length=32)
	public String getDbId(){
		return this.dbId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地主键
	 */
	public void setDbId(String dbId){
		this.dbId = dbId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地图片文件
	 */
	@Column(name ="DB_IMG_FID",nullable=true,length=32)
	public String getDbImgFid(){
		return this.dbImgFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地图片文件
	 */
	public void setDbImgFid(String dbImgFid){
		this.dbImgFid = dbImgFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片地址
	 */
	@Column(name ="DB_IMG_URL",nullable=true,length=255)
	public String getDbImgUrl(){
		return this.dbImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片地址
	 */
	public void setDbImgUrl(String dbImgUrl){
		this.dbImgUrl = dbImgUrl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}
}
