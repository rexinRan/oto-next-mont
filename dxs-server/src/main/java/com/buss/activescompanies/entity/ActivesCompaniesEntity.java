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

import com.buss.actives.entity.ActivessEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
public class ActivesCompaniesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**企业id(预留)*/
	private java.lang.String companyUserId;
	/**活动id*/
	private java.lang.String activeId;
	/**图片*/
	private java.lang.String images;
	/**名企所属地*/
	private java.lang.String companyAddress;
	/**大巴车牌号*/
	private java.lang.String busNum;
	/**参观企业*/
	private java.lang.String companyName;
	/**参观流程*/
	private java.lang.String companyPropress;
	/**注意事项*/
	private java.lang.String companyNotes;
	/**参观费用*/
	private java.lang.String seeFree;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;
	
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
	 *@return: java.lang.String  企业id(预留)
	 */
	@Column(name ="COMPANY_USER_ID",nullable=true,length=32)
	public java.lang.String getCompanyUserId(){
		return this.companyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业id(预留)
	 */
	public void setCompanyUserId(java.lang.String companyUserId){
		this.companyUserId = companyUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public java.lang.String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(java.lang.String activeId){
		this.activeId = activeId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="IMAGES",nullable=true,length=255)
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名企所属地
	 */
	@Column(name ="COMPANY_ADDRESS",nullable=true,length=255)
	public java.lang.String getCompanyAddress(){
		return this.companyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名企所属地
	 */
	public void setCompanyAddress(java.lang.String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大巴车牌号
	 */
	@Column(name ="BUS_NUM",nullable=true,length=100)
	public java.lang.String getBusNum(){
		return this.busNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大巴车牌号
	 */
	public void setBusNum(java.lang.String busNum){
		this.busNum = busNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观企业
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=255)
	public java.lang.String getCompanyName(){
		return this.companyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观企业
	 */
	public void setCompanyName(java.lang.String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观流程
	 */
	@Column(name ="COMPANY_PROPRESS",nullable=true,length=255)
	public java.lang.String getCompanyPropress(){
		return this.companyPropress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观流程
	 */
	public void setCompanyPropress(java.lang.String companyPropress){
		this.companyPropress = companyPropress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注意事项
	 */
	@Column(name ="COMPANY_NOTES",nullable=true,length=255)
	public java.lang.String getCompanyNotes(){
		return this.companyNotes;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注意事项
	 */
	public void setCompanyNotes(java.lang.String companyNotes){
		this.companyNotes = companyNotes;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参观费用
	 */
	@Column(name ="SEE_FREE",nullable=true,length=10)
	public java.lang.String getSeeFree(){
		return this.seeFree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参观费用
	 */
	public void setSeeFree(java.lang.String seeFree){
		this.seeFree = seeFree;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public java.lang.Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDelete(java.lang.Integer isDelete){
		this.isDelete = isDelete;
	}



	// ==============================================关联映射============================================


	/**
	 * 活动
	 */
	/*private ActivessEntity activessEntity;

	@OneToOne
	@JoinColumn(name = "active_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ActivessEntity getActivessEntity() {
		return activessEntity;
	}

	public void setActivessEntity(ActivessEntity activessEntity) {
		this.activessEntity = activessEntity;
	}*/
}
