package com.buss.activesdetails.entity;

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
public class ActivesDetailsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动id*/
	private java.lang.String activesId;
	/**推荐理由*/
	private java.lang.String recommendedReason;
	/**费用包含*/
	private java.lang.String costInclude;
	/**费用不包含*/
	private java.lang.String costUninclude;
	/**签证方式*/
	private java.lang.String visaNote;
	/**行前准备*/
	private java.lang.String preparation;
	/**付款方式*/
	private java.lang.Integer paymentMethod;
	/**常见问题(待定)*/
	private java.lang.String commonProblem;
	/**出发日期和团信息*/
	private java.lang.String activesStart2;
	/**图片1id*/
	private java.lang.String img1Fid;
	/**图片1地址*/
	private java.lang.String img1Url;
	/**图片2id*/
	private java.lang.String img2Fid;
	/**图片2地址*/
	private java.lang.String img2Url;
	/**图片3id*/
	private java.lang.String img3Fid;
	/**图片3地址*/
	private java.lang.String img3Url;
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVES_ID",nullable=true,length=32)
	public java.lang.String getActivesId(){
		return this.activesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActivesId(java.lang.String activesId){
		this.activesId = activesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐理由
	 */
	@Column(name ="RECOMMENDED_REASON",nullable=true,length=255)
	public java.lang.String getRecommendedReason(){
		return this.recommendedReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  推荐理由
	 */
	public void setRecommendedReason(java.lang.String recommendedReason){
		this.recommendedReason = recommendedReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用包含
	 */
	@Column(name ="COST_INCLUDE",nullable=true,length=255)
	public java.lang.String getCostInclude(){
		return this.costInclude;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用包含
	 */
	public void setCostInclude(java.lang.String costInclude){
		this.costInclude = costInclude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  费用不包含
	 */
	@Column(name ="COST_UNINCLUDE",nullable=true,length=255)
	public java.lang.String getCostUninclude(){
		return this.costUninclude;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  费用不包含
	 */
	public void setCostUninclude(java.lang.String costUninclude){
		this.costUninclude = costUninclude;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签证方式
	 */
	@Column(name ="VISA_NOTE",nullable=true,length=255)
	public java.lang.String getVisaNote(){
		return this.visaNote;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签证方式
	 */
	public void setVisaNote(java.lang.String visaNote){
		this.visaNote = visaNote;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行前准备
	 */
	@Column(name ="PREPARATION",nullable=true,length=255)
	public java.lang.String getPreparation(){
		return this.preparation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行前准备
	 */
	public void setPreparation(java.lang.String preparation){
		this.preparation = preparation;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  付款方式
	 */
	@Column(name ="PAYMENT_METHOD",nullable=true,length=10)
	public java.lang.Integer getPaymentMethod(){
		return this.paymentMethod;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  付款方式
	 */
	public void setPaymentMethod(java.lang.Integer paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  常见问题(待定)
	 */
	@Column(name ="COMMON_PROBLEM",nullable=true,length=255)
	public java.lang.String getCommonProblem(){
		return this.commonProblem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  常见问题(待定)
	 */
	public void setCommonProblem(java.lang.String commonProblem){
		this.commonProblem = commonProblem;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发日期和团信息
	 */
	@Column(name ="ACTIVES_START2",nullable=true)
	public String getActivesStart2() {
		return activesStart2;
	}

	public void setActivesStart2(String activesStart2) {
		this.activesStart2 = activesStart2;
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

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片1id
	 */
	@Column(name ="IMG1_FID",nullable=true,length=32)
	public String getImg1Fid() {
		return img1Fid;
	}

	public void setImg1Fid(String img1Fid) {
		this.img1Fid = img1Fid;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片1地址
	 */
	@Column(name ="IMG1_URL",nullable=true,length=255)
	public String getImg1Url() {
		return img1Url;
	}

	public void setImg1Url(String img1Url) {
		this.img1Url = img1Url;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片2id
	 */
	@Column(name ="IMG2_FID",nullable=true,length=32)
	public String getImg2Fid() {
		return img2Fid;
	}

	public void setImg2Fid(String img2Fid) {
		this.img2Fid = img2Fid;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片2地址
	 */
	@Column(name ="IMG2_URL",nullable=true,length=255)
	public String getImg2Url() {
		return img2Url;
	}

	public void setImg2Url(String img2Url) {
		this.img2Url = img2Url;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片3id
	 */
	@Column(name ="IMG3_FID",nullable=true,length=32)
	public String getImg3Fid() {
		return img3Fid;
	}

	public void setImg3Fid(String img3Fid) {
		this.img3Fid = img3Fid;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  图片3地址
	 */
	@Column(name ="IMG3_URL",nullable=true,length=255)
	public String getImg3Url() {
		return img3Url;
	}

	public void setImg3Url(String img3Url) {
		this.img3Url = img3Url;
	}
}
