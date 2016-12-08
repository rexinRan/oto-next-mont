package com.buss.resume.resumecertificate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**   
 * @Title: Entity
 * @Description: dxs_resume_certificate
 * @author lu
 * @date 2016-06-24 11:14:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_certificate", schema = "")
@SuppressWarnings("serial")
public class ResumeCertificateEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/

	private java.lang.String resumeId;
	/**证书种类(预留)*/

	private java.lang.String certificateKey;
	/**证书名称*/

	private java.lang.String certificateName;
	/**补充*/

	private java.lang.String certificateName2;
	/**分数*/

	private java.lang.String score;
	/**图片*/

	private java.lang.String imgUrl;
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
	 *@return: java.lang.String  简历ID
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public java.lang.String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(java.lang.String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书种类(预留)
	 */
	@Column(name ="CERTIFICATE_KEY",nullable=true,length=50)
	public java.lang.String getCertificateKey(){
		return this.certificateKey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书种类(预留)
	 */
	public void setCertificateKey(java.lang.String certificateKey){
		this.certificateKey = certificateKey;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书名称
	 */
	@Column(name ="CERTIFICATE_NAME",nullable=true,length=50)
	public java.lang.String getCertificateName(){
		return this.certificateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书名称
	 */
	public void setCertificateName(java.lang.String certificateName){
		this.certificateName = certificateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  补充
	 */
	@Column(name ="CERTIFICATE_NAME2",nullable=true,length=50)
	public java.lang.String getCertificateName2(){
		return this.certificateName2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  补充
	 */
	public void setCertificateName2(java.lang.String certificateName2){
		this.certificateName2 = certificateName2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分数
	 */
	@Column(name ="SCORE",nullable=true,length=10)
	public java.lang.String getScore(){
		return this.score;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分数
	 */
	public void setScore(java.lang.String score){
		this.score = score;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
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
}
