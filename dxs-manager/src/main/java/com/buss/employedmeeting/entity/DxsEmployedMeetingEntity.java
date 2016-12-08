package com.buss.employedmeeting.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.employedcatalog.entity.DxsEmployedCatalogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_employed_meeting
 * @author onlineGenerator
 * @date 2016-07-12 12:02:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_meeting", schema = "")
@SuppressWarnings("serial")
public class DxsEmployedMeetingEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**招聘分类主键*/
	@Excel(name="招聘分类主键")
	private String emoloyedCatelogId;
	/**招聘会主题*/
	@Excel(name="招聘会主题")
	private String meetingTitle;
	/**招聘会配图*/
	@Excel(name="招聘会配图")
	private String meetingImgurl;
	/**招聘会描述*/
	@Excel(name="招聘会描述")
	private String meetingContents;
	/**编号*/
	@Excel(name="编号")
	private Integer meetingSort;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsEmployedCatalogEntity dxsEmployedCatalogEntity;
	
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
	 *@return: java.lang.String  招聘分类主键
	 */
	@Column(name ="EMOLOYED_CATELOG_ID",nullable=true,length=32)
	public String getEmoloyedCatelogId(){
		return this.emoloyedCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘分类主键
	 */
	public void setEmoloyedCatelogId(String emoloyedCatelogId){
		this.emoloyedCatelogId = emoloyedCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘会主题
	 */
	@Column(name ="MEETING_TITLE",nullable=true,length=200)
	public String getMeetingTitle(){
		return this.meetingTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘会主题
	 */
	public void setMeetingTitle(String meetingTitle){
		this.meetingTitle = meetingTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘会配图
	 */
	@Column(name ="MEETING_IMGURL",nullable=true,length=200)
	public String getMeetingImgurl(){
		return this.meetingImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘会配图
	 */
	public void setMeetingImgurl(String meetingImgurl){
		this.meetingImgurl = meetingImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘会描述
	 */
	@Column(name ="MEETING_CONTENTS",nullable=true,length=255)
	public String getMeetingContents(){
		return this.meetingContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘会描述
	 */
	public void setMeetingContents(String meetingContents){
		this.meetingContents = meetingContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="MEETING_SORT",nullable=true,length=10)
	public Integer getMeetingSort(){
		return this.meetingSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setMeetingSort(Integer meetingSort){
		this.meetingSort = meetingSort;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emoloyed_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsEmployedCatalogEntity getDxsEmployedCatalogEntity() {
		return dxsEmployedCatalogEntity;
	}

	public void setDxsEmployedCatalogEntity(DxsEmployedCatalogEntity dxsEmployedCatalogEntity) {
		this.dxsEmployedCatalogEntity = dxsEmployedCatalogEntity;
	}
}
