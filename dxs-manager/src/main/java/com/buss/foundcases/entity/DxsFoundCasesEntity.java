package com.buss.foundcases.entity;

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
 * @Description: dxs_found_cases
 * @author onlineGenerator
 * @date 2016-08-01 09:27:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_found_cases", schema = "")
@SuppressWarnings("serial")
public class DxsFoundCasesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**基金的id*/
	@Excel(name="基金的id")
	private String dfId;
	/**成功案例的名称*/
	@Excel(name="成功案例的名称")
	private String dfName;
	/**案例缩图id*/
	@Excel(name="案例缩图id")
	private String dfImgFid;
	/**案例缩图URL*/
	@Excel(name="案例缩图URL")
	private String dfImgUrl;
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
	 *@return: java.lang.String  基金的id
	 */
	@Column(name ="DF_ID",nullable=true,length=32)
	public String getDfId(){
		return this.dfId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基金的id
	 */
	public void setDfId(String dfId){
		this.dfId = dfId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  成功案例的名称
	 */
	@Column(name ="DF_NAME",nullable=true,length=255)
	public String getDfName(){
		return this.dfName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  成功案例的名称
	 */
	public void setDfName(String dfName){
		this.dfName = dfName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  案例缩图id
	 */
	@Column(name ="DF_IMG_FID",nullable=true,length=32)
	public String getDfImgFid(){
		return this.dfImgFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  案例缩图id
	 */
	public void setDfImgFid(String dfImgFid){
		this.dfImgFid = dfImgFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  案例缩图URL
	 */
	@Column(name ="DF_IMG_URL",nullable=true,length=255)
	public String getDfImgUrl(){
		return this.dfImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  案例缩图URL
	 */
	public void setDfImgUrl(String dfImgUrl){
		this.dfImgUrl = dfImgUrl;
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
