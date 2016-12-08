package com.buss.activescompanies.entity;

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
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_actives_companies
 * @author onlineGenerator
 * @date 2016-08-18 13:35:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_companies", schema = "")
@SuppressWarnings("serial")
public class DxsActivesCompaniesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**企业id(预留)*/
	@Excel(name="企业id(预留)")
	private String companyUserId;
	/**三张图片*/
	@Excel(name="三张图片")
	private java.lang.String images;
	/**活动id*/
	@Excel(name="活动id")
	private String activeId;
	/**名企所属地*/
	@Excel(name="名企所属地")
	private String companyAddress;
	/**大巴车牌号*/
	@Excel(name="大巴车牌号")
	private String busNum;
	/**参观企业*/
	@Excel(name="参观企业")
	private String companyName;
	/**参观流程*/
	@Excel(name="参观流程")
	private String companyPropress;
	/**注意事项*/
	@Excel(name="注意事项")
	private String companyNotes;
	/**参观费用*/
	@Excel(name="参观费用")
	private String seeFree;
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
	 *@return: java.lang.String  企业id(预留)
	 */
	@Column(name ="COMPANY_USER_ID",nullable=true,length=32)
	public String getCompanyUserId(){
		return this.companyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业id(预留)
	 */
	public void setCompanyUserId(String companyUserId){
		this.companyUserId = companyUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  三张图片
	 */
	@Column(name ="IMAGES",nullable=true,length=255)
	public java.lang.String getImages(){
		return this.images;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  三张图片
	 */
	public void setImages(java.lang.String images){
		this.images = images;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名企所属地
	 */
	@Column(name ="COMPANY_ADDRESS",nullable=true,length=255)
	public String getCompanyAddress(){
		return this.companyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名企所属地
	 */
	public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大巴车牌号
	 */
	@Column(name ="BUS_NUM",nullable=true,length=100)
	public String getBusNum(){
		return this.busNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大巴车牌号
	 */
	public void setBusNum(String busNum){
		this.busNum = busNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观企业
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=255)
	public String getCompanyName(){
		return this.companyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观企业
	 */
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观流程
	 */
	@Column(name ="COMPANY_PROPRESS",nullable=true,length=255)
	public String getCompanyPropress(){
		return this.companyPropress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观流程
	 */
	public void setCompanyPropress(String companyPropress){
		this.companyPropress = companyPropress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注意事项
	 */
	@Column(name ="COMPANY_NOTES",nullable=true,length=255)
	public String getCompanyNotes(){
		return this.companyNotes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注意事项
	 */
	public void setCompanyNotes(String companyNotes){
		this.companyNotes = companyNotes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观费用
	 */
	@Column(name ="SEE_FREE",nullable=true,length=10)
	public String getSeeFree(){
		return this.seeFree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观费用
	 */
	public void setSeeFree(String seeFree){
		this.seeFree = seeFree;
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

	//大权添加与dxs_actives表和dxs_users表的多对一关联
	private DxsActivesEntity dxsActivesEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "active_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}

	private DxsUserEntity dxsUserEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
