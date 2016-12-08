package com.buss.recommend.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_recommend
 * @author lu
 * @date 2016-06-27 17:00:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_recommend", schema = "")
@SuppressWarnings("serial")
public class RecommendEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**招聘岗位的ID*/

	private String outId;
	/**推荐人id*/

	private String recommendedUserId;
	/**被推荐人id*/

	private String berecommendedUserId;
	/**简历投递id*/

	private String resumeUserId;
	/**推荐评语*/

	private String recommendedReviews;
	/**简历附件*/

	private String accessories;
	/**鸿鑫币*/
	private Integer hxCurrency;

	/**推荐时间*/
	private String recommendTime;
	/**结果*/

	private String result;

	/**推荐类型*/
	private String type;

	/**推荐理由*/
	private java.lang.String recommendAccount;
	/**备注*/
	private java.lang.String remarks;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

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
	 *@return: java.lang.String  招聘岗位的ID
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘岗位的ID
	 */
	public void setOutId(String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐人id
	 */
	@Column(name ="RECOMMENDED_USER_ID",nullable=true,length=32)
	public String getRecommendedUserId(){
		return this.recommendedUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  推荐人id
	 */
	public void setRecommendedUserId(String recommendedUserId){
		this.recommendedUserId = recommendedUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被推荐人id
	 */
	@Column(name ="BERECOMMENDED_USER_ID",nullable=true,length=32)
	public String getBerecommendedUserId(){
		return this.berecommendedUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被推荐人id
	 */
	public void setBerecommendedUserId(String berecommendedUserId){
		this.berecommendedUserId = berecommendedUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历投递id
	 */
	@Column(name ="RESUME_USER_ID",nullable=true,length=32)
	public String getResumeUserId(){
		return this.resumeUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历投递id
	 */
	public void setResumeUserId(String resumeUserId){
		this.resumeUserId = resumeUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐评语
	 */
	@Column(name ="RECOMMENDED_REVIEWS",nullable=true,length=255)
	public String getRecommendedReviews(){
		return this.recommendedReviews;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  推荐评语
	 */
	public void setRecommendedReviews(String recommendedReviews){
		this.recommendedReviews = recommendedReviews;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历附件
	 */
	@Column(name ="ACCESSORIES",nullable=true,length=255)
	public String getAccessories(){
		return this.accessories;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历附件
	 */
	public void setAccessories(String accessories){
		this.accessories = accessories;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULT",nullable=true,length=2)
	public String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResult(String result){
		this.result = result;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐类型
	 */
	@Column(name ="TYPE",nullable=true,length=50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  推荐理由
	 */
	@Column(name ="RECOMMEND_ACCOUNT",nullable=true,length=255)
	public String getRecommendAccount() {
		return recommendAccount;
	}

	public void setRecommendAccount(String recommendAccount) {
		this.recommendAccount = recommendAccount;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  鸿鑫币
	 */
	@Column(name ="HX_CURRENCY",nullable=true,length=50)
	public Integer getHxCurrency() {
		return hxCurrency;
	}

	public void setHxCurrency(Integer hxCurrency) {
		this.hxCurrency = hxCurrency;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  推荐时间
	 */
	@Column(name ="RECOMMEND_TIME",nullable=true,length=50)
	public String getRecommendTime() {
		return recommendTime;
	}

	public void setRecommendTime(String recommendTime) {
		this.recommendTime = recommendTime;
	}
}
