package com.buss.trainonlinecourse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: dxs_train_online_course
 * @author onlineGenerator
 * @date 2016-12-13 14:00:11
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_train_online_course", schema = "")
@SuppressWarnings("serial")
public class TrainOnlineCoursesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**分类id*/
	private java.lang.String tccId;
	/**显示分类*/
	private java.lang.String catalogDisplayNum;
	/**导师id*/
	private java.lang.String userId;
	/**总课时数*/
	private java.lang.Integer courseNumAll;
	/**总学习数*/
	private java.lang.Integer courseMinutesAll;
	/**课程价格*/
	private java.lang.String coursePrices;
	/**缩略图*/
	private java.lang.String imgUrl;
	/**培训课题*/
	private java.lang.String title;
	/**外部标记*/
	private java.lang.Integer outSign;
	/**班号*/
	private java.lang.String classNum;
	/**授课方式*/
	private java.lang.Integer courseType;
	/**培训方式*/
	private java.lang.Integer trainType;
	/**学费*/
	private java.lang.String price;
	/**课程介绍*/
	private java.lang.String courseIntroduce;
	/**报名人数*/
	private java.lang.Integer regNumbers;
	/**招生人数*/
	private java.lang.Integer number;
	/**适用学员*/
	private java.lang.String courseObj;
	/**是否支付的是定金*/
	private java.lang.Integer isFrontMoney;
	/**教学目标*/
	private java.lang.String trainObj;
	/**授课内容*/
	private java.lang.String trainContent;
	/**课程体系*/
	private java.lang.String courseDir;
	/**课程特色*/
	private java.lang.String courseSpecial;
	/**开班规律*/
	private java.lang.String startClassRule;
	/**其他*/
	private java.lang.String others;
	/**编号*/
	private java.lang.Integer sort;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;
	/**赠送鸿鑫币数量*/
	private java.lang.String account;
	/**备注*/
	private java.lang.String remarks;

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
	 *@return: java.lang.String  分类id
	 */
	@Column(name ="TCC_ID",nullable=true,length=32)
	public java.lang.String getTccId(){
		return this.tccId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类id
	 */
	public void setTccId(java.lang.String tccId){
		this.tccId = tccId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  显示分类
	 */
	@Column(name ="CATALOG_DISPLAY_NUM",nullable=true,length=50)
	public java.lang.String getCatalogDisplayNum(){
		return this.catalogDisplayNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  显示分类
	 */
	public void setCatalogDisplayNum(java.lang.String catalogDisplayNum){
		this.catalogDisplayNum = catalogDisplayNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总课时数
	 */
	@Column(name ="COURSE_NUM_ALL",nullable=true,length=3)
	public java.lang.Integer getCourseNumAll(){
		return this.courseNumAll;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总课时数
	 */
	public void setCourseNumAll(java.lang.Integer courseNumAll){
		this.courseNumAll = courseNumAll;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总学习数
	 */
	@Column(name ="COURSE_MINUTES_ALL",nullable=true,length=10)
	public java.lang.Integer getCourseMinutesAll(){
		return this.courseMinutesAll;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总学习数
	 */
	public void setCourseMinutesAll(java.lang.Integer courseMinutesAll){
		this.courseMinutesAll = courseMinutesAll;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程价格
	 */
	@Column(name ="COURSE_PRICES",nullable=true,length=10)
	public java.lang.String getCoursePrices(){
		return this.coursePrices;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程价格
	 */
	public void setCoursePrices(java.lang.String coursePrices){
		this.coursePrices = coursePrices;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训课题
	 */
	@Column(name ="TITLE",nullable=true,length=200)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训课题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=10)
	public java.lang.Integer getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  外部标记
	 */
	public void setOutSign(java.lang.Integer outSign){
		this.outSign = outSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班号
	 */
	@Column(name ="CLASS_NUM",nullable=true,length=20)
	public java.lang.String getClassNum(){
		return this.classNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班号
	 */
	public void setClassNum(java.lang.String classNum){
		this.classNum = classNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  授课方式
	 */
	@Column(name ="COURSE_TYPE",nullable=true,length=3)
	public java.lang.Integer getCourseType(){
		return this.courseType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  授课方式
	 */
	public void setCourseType(java.lang.Integer courseType){
		this.courseType = courseType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  培训方式
	 */
	@Column(name ="TRAIN_TYPE",nullable=true,length=3)
	public java.lang.Integer getTrainType(){
		return this.trainType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  培训方式
	 */
	public void setTrainType(java.lang.Integer trainType){
		this.trainType = trainType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学费
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学费
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程介绍
	 */
	@Column(name ="COURSE_INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getCourseIntroduce(){
		return this.courseIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程介绍
	 */
	public void setCourseIntroduce(java.lang.String courseIntroduce){
		this.courseIntroduce = courseIntroduce;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  报名人数
	 */
	@Column(name ="REG_NUMBERS",nullable=true,length=10)
	public java.lang.Integer getRegNumbers(){
		return this.regNumbers;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  报名人数
	 */
	public void setRegNumbers(java.lang.Integer regNumbers){
		this.regNumbers = regNumbers;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  招生人数
	 */
	@Column(name ="NUMBER",nullable=true,length=10)
	public java.lang.Integer getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  招生人数
	 */
	public void setNumber(java.lang.Integer number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适用学员
	 */
	@Column(name ="COURSE_OBJ",nullable=true,length=255)
	public java.lang.String getCourseObj(){
		return this.courseObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适用学员
	 */
	public void setCourseObj(java.lang.String courseObj){
		this.courseObj = courseObj;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否支付的是定金
	 */
	@Column(name ="IS_FRONT_MONEY",nullable=true,length=10)
	public java.lang.Integer getIsFrontMoney(){
		return this.isFrontMoney;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否支付的是定金
	 */
	public void setIsFrontMoney(java.lang.Integer isFrontMoney){
		this.isFrontMoney = isFrontMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教学目标
	 */
	@Column(name ="TRAIN_OBJ",nullable=true,length=16777215)
	public java.lang.String getTrainObj(){
		return this.trainObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教学目标
	 */
	public void setTrainObj(java.lang.String trainObj){
		this.trainObj = trainObj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  授课内容
	 */
	@Column(name ="TRAIN_CONTENT",nullable=true,length=255)
	public java.lang.String getTrainContent(){
		return this.trainContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  授课内容
	 */
	public void setTrainContent(java.lang.String trainContent){
		this.trainContent = trainContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程体系
	 */
	@Column(name ="COURSE_DIR",nullable=true,length=16777215)
	public java.lang.String getCourseDir(){
		return this.courseDir;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程体系
	 */
	public void setCourseDir(java.lang.String courseDir){
		this.courseDir = courseDir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程特色
	 */
	@Column(name ="COURSE_SPECIAL",nullable=true,length=255)
	public java.lang.String getCourseSpecial(){
		return this.courseSpecial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程特色
	 */
	public void setCourseSpecial(java.lang.String courseSpecial){
		this.courseSpecial = courseSpecial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开班规律
	 */
	@Column(name ="START_CLASS_RULE",nullable=true,length=255)
	public java.lang.String getStartClassRule(){
		return this.startClassRule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开班规律
	 */
	public void setStartClassRule(java.lang.String startClassRule){
		this.startClassRule = startClassRule;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="OTHERS",nullable=true,length=255)
	public java.lang.String getOthers(){
		return this.others;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOthers(java.lang.String others){
		this.others = others;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public java.lang.Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赠送鸿鑫币数量
	 */
	@Column(name ="ACCOUNT",nullable=true,length=255)
	public java.lang.String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赠送鸿鑫币数量
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
}
