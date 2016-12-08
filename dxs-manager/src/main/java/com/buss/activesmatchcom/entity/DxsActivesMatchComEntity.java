package com.buss.activesmatchcom.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.actives.entity.DxsActivesEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_actives_match_com
 * @author onlineGenerator
 * @date 2016-08-30 15:48:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_match_com", schema = "")
@SuppressWarnings("serial")
public class DxsActivesMatchComEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动id*/
	@Excel(name="活动id")
	private String activesId;
	/**校园赛事id*/
	@Excel(name="校园赛事id")
	private String amId;
	/**缩略图id*/
	@Excel(name="缩略图id")
	private String imgUrl;
	/**公司名称*/
	@Excel(name="公司名称")
	private String companyName;
	/**公司展示分类*/
	@Excel(name="公司展示分类")
	private Integer dataType;
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVES_ID",nullable=false,length=32)
	public String getActivesId(){
		return this.activesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActivesId(String activesId){
		this.activesId = activesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校园赛事id
	 */
	@Column(name ="AM_ID",nullable=true,length=32)
	public String getAmId(){
		return this.amId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校园赛事id
	 */
	public void setAmId(String amId){
		this.amId = amId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图id
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图id
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=255)
	public String getCompanyName(){
		return this.companyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公司展示分类
	 */
	@Column(name ="DATA_TYPE",nullable=true,length=3)
	public Integer getDataType(){
		return this.dataType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公司展示分类
	 */
	public void setDataType(Integer dataType){
		this.dataType = dataType;
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

	//卢跃跃
	// 添加与dxs_actives表的多对一关联
	private DxsActivesEntity dxsActivesEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actives_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}
}
