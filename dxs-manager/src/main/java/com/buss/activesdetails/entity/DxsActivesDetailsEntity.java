package com.buss.activesdetails.entity;

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
 * @Description: dxs_actives_details
 * @author onlineGenerator
 * @date 2016-08-02 17:35:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_details", schema = "")
@SuppressWarnings("serial")
public class DxsActivesDetailsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**图片1id*/
	@Excel(name="图片1id")
	private java.lang.String img1Fid;
	/**图片1地址*/
	@Excel(name="图片1地址")
	private java.lang.String img1Url;
	/**图片2id*/
	@Excel(name="图片2id")
	private java.lang.String img2Fid;
	/**图片2地址*/
	@Excel(name="图片2地址")
	private java.lang.String img2Url;
	/**图片3id*/
	@Excel(name="图片3id")
	private java.lang.String img3Fid;
	/**图片3地址*/
	@Excel(name="图片3地址")
	private java.lang.String img3Url;
	/**活动id*/
	@Excel(name="活动id")
	private String activesId;
	/**推荐理由*/
	@Excel(name="推荐理由")
	private String recommendedReason;
	/**费用包含*/
	@Excel(name="费用包含")
	private String costInclude;
	/**费用不包含*/
	@Excel(name="费用不包含")
	private String costUninclude;
	/**签证方式*/
	@Excel(name="签证方式")
	private String visaNote;
	/**行前准备*/
	@Excel(name="行前准备")
	private String preparation;
	/**付款方式*/
	@Excel(name="付款方式")
	private Integer paymentMethod;
	/**常见问题(待定)*/
	@Excel(name="常见问题(待定)")
	private String commonProblem;
	/**出发日期和团信息*/
	@Excel(name="出发日期和团信息")
	private java.lang.String activesStart2;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsActivesEntity dxsActivesEntity;
	
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
	 *@return: java.lang.String  图片1id
	 */
	@Column(name ="IMG1_FID",nullable=true,length=32)
	public java.lang.String getImg1Fid(){
		return this.img1Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1id
	 */
	public void setImg1Fid(java.lang.String img1Fid){
		this.img1Fid = img1Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片1地址
	 */
	@Column(name ="IMG1_URL",nullable=true,length=255)
	public java.lang.String getImg1Url(){
		return this.img1Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1地址
	 */
	public void setImg1Url(java.lang.String img1Url){
		this.img1Url = img1Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2id
	 */
	@Column(name ="IMG2_FID",nullable=true,length=32)
	public java.lang.String getImg2Fid(){
		return this.img2Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2id
	 */
	public void setImg2Fid(java.lang.String img2Fid){
		this.img2Fid = img2Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2地址
	 */
	@Column(name ="IMG2_URL",nullable=true,length=255)
	public java.lang.String getImg2Url(){
		return this.img2Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2地址
	 */
	public void setImg2Url(java.lang.String img2Url){
		this.img2Url = img2Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3id
	 */
	@Column(name ="IMG3_FID",nullable=true,length=32)
	public java.lang.String getImg3Fid(){
		return this.img3Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3id
	 */
	public void setImg3Fid(java.lang.String img3Fid){
		this.img3Fid = img3Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3地址
	 */
	@Column(name ="IMG3_URL",nullable=true,length=255)
	public java.lang.String getImg3Url(){
		return this.img3Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3地址
	 */
	public void setImg3Url(java.lang.String img3Url){
		this.img3Url = img3Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVES_ID",nullable=true,length=32)
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
	 *@return: java.lang.String  推荐理由
	 */
	@Column(name ="RECOMMENDED_REASON",nullable=true,length=255)
	public String getRecommendedReason(){
		return this.recommendedReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  推荐理由
	 */
	public void setRecommendedReason(String recommendedReason){
		this.recommendedReason = recommendedReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用包含
	 */
	@Column(name ="COST_INCLUDE",nullable=true,length=255)
	public String getCostInclude(){
		return this.costInclude;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用包含
	 */
	public void setCostInclude(String costInclude){
		this.costInclude = costInclude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用不包含
	 */
	@Column(name ="COST_UNINCLUDE",nullable=true,length=255)
	public String getCostUninclude(){
		return this.costUninclude;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用不包含
	 */
	public void setCostUninclude(String costUninclude){
		this.costUninclude = costUninclude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签证方式
	 */
	@Column(name ="VISA_NOTE",nullable=true,length=255)
	public String getVisaNote(){
		return this.visaNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签证方式
	 */
	public void setVisaNote(String visaNote){
		this.visaNote = visaNote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行前准备
	 */
	@Column(name ="PREPARATION",nullable=true,length=255)
	public String getPreparation(){
		return this.preparation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行前准备
	 */
	public void setPreparation(String preparation){
		this.preparation = preparation;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  付款方式
	 */
	@Column(name ="PAYMENT_METHOD",nullable=true,length=10)
	public Integer getPaymentMethod(){
		return this.paymentMethod;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  付款方式
	 */
	public void setPaymentMethod(Integer paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  常见问题(待定)
	 */
	@Column(name ="COMMON_PROBLEM",nullable=true,length=255)
	public String getCommonProblem(){
		return this.commonProblem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  常见问题(待定)
	 */
	public void setCommonProblem(String commonProblem){
		this.commonProblem = commonProblem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发日期和团信息
	 */
	@Column(name ="ACTIVES_START2",nullable=true,length=65535)
	public java.lang.String getActivesStart2(){
		return this.activesStart2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出发日期和团信息
	 */
	public void setActivesStart2(java.lang.String activesStart2){
		this.activesStart2 = activesStart2;
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

	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "actives_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}


}
