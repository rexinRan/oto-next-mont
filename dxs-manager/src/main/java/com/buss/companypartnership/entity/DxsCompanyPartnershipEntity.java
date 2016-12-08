package com.buss.companypartnership.entity;

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
 * @Description: dxs_company_partnership
 * @author onlineGenerator
 * @date 2016-06-03 10:42:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_company_partnership", schema = "")
@SuppressWarnings("serial")
public class DxsCompanyPartnershipEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**公司名称*/
	@Excel(name="公司名称")
	private String companyname;
	/**加入时间*/
	@Excel(name="加入时间",format = "yyyy-MM-dd")
	private Date jointime;
	/**公司展示图*/
	@Excel(name="公司展示图")
	private String displayImg;
	/**公司宣传视频*/
	@Excel(name="公司宣传视频")
	private String displayVideo;
	/**公司简介*/
	@Excel(name="公司简介")
	private String introduction;
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
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANYNAME",nullable=true,length=100)
	public String getCompanyname(){
		return this.companyname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompanyname(String companyname){
		this.companyname = companyname;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  加入时间
	 */
	@Column(name ="JOINTIME",nullable=true)
	public Date getJointime(){
		return this.jointime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  加入时间
	 */
	public void setJointime(Date jointime){
		this.jointime = jointime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司展示图
	 */
	@Column(name ="DISPLAY_IMG",nullable=true,length=200)
	public String getDisplayImg(){
		return this.displayImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司展示图
	 */
	public void setDisplayImg(String displayImg){
		this.displayImg = displayImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司宣传视频
	 */
	@Column(name ="DISPLAY_VIDEO",nullable=true,length=255)
	public String getDisplayVideo(){
		return this.displayVideo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司宣传视频
	 */
	public void setDisplayVideo(String displayVideo){
		this.displayVideo = displayVideo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司简介
	 */
	@Column(name ="INTRODUCTION",nullable=true)
	public String getIntroduction(){
		return this.introduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司简介
	 */
	public void setIntroduction(String introduction){
		this.introduction = introduction;
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
