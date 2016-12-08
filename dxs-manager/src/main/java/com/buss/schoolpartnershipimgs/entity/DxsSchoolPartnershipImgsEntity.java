package com.buss.schoolpartnershipimgs.entity;

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
 * @Description: dxs_school_partnership_imgs
 * @author onlineGenerator
 * @date 2016-07-27 16:05:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_school_partnership_imgs", schema = "")
@SuppressWarnings("serial")
public class DxsSchoolPartnershipImgsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**合作院校id*/
	@Excel(name="合作院校id")
	private String spId;
	/**图片文件id*/
	@Excel(name="图片文件id")
	private String spImgFid;
	/**图片访问地址*/
	@Excel(name="图片访问地址")
	private String spImgUrl;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private String isDelete;
	
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
	 *@return: java.lang.String  合作院校id
	 */
	@Column(name ="SP_ID",nullable=true,length=32)
	public String getSpId(){
		return this.spId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合作院校id
	 */
	public void setSpId(String spId){
		this.spId = spId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片文件id
	 */
	@Column(name ="SP_IMG_FID",nullable=true,length=32)
	public String getSpImgFid(){
		return this.spImgFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片文件id
	 */
	public void setSpImgFid(String spImgFid){
		this.spImgFid = spImgFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片访问地址
	 */
	@Column(name ="SP_IMG_URL",nullable=true,length=255)
	public String getSpImgUrl(){
		return this.spImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片访问地址
	 */
	public void setSpImgUrl(String spImgUrl){
		this.spImgUrl = spImgUrl;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=2)
	public String getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  删除标志
	 */
	public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
}
