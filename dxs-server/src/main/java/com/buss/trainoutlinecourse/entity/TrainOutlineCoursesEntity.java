package com.buss.trainoutlinecourse.entity;

import java.util.Date;
import java.lang.String;
import java.lang.Integer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: dxs_train_outline_course
 * @author onlineGenerator
 * @date 2016-12-13 13:32:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_outline_course", schema = "")
@SuppressWarnings("serial")
public class TrainOutlineCoursesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**分类id*/
	private String tccId;
	/**显示分类*/
	private String catalogDisplayNum;
	/**导师id*/
	private String userId;
	/**总课时数*/
	private Integer courseNumAll;
	/**总学习数*/
	private Integer courseMinutesAll;
	/**招生人数*/
	private Integer number;
	/**课程价格*/
	private String coursePrices;
	/**缩略图*/
	private String imgUrl;
	/**培训课题*/
	private String title;
	/**外部标记*/
	private Integer outSign;
	/**开班时间*/
	private String openingTime;
	/**班号*/
	private String classNum;
	/**授课方式*/
	private Integer courseType;
	/**报名人数*/
	private Integer regNumbers;
	/**培训方式*/
	private Integer trainType;
	/**限报人数*/
	private Integer limitedNumber;
	/**是否是支付的定金*/
	private Integer isFrontMoney;
	/**学费*/
	private String price;
	/**课程介绍*/
	private String courseIntroduce;
	/**适用学员*/
	private String courseObj;
	/**教学目标*/
	private String trainObj;
	/**授课内容*/
	private String trainContent;
	/**课程体系*/
	private String courseDir;
	/**课程特色*/
	private String courseSpecial;
	/**开班规律*/
	private String startClassRule;
	/**地点简称*/
	private String addressShort;
	/**具体地点*/
	private String address;
	/**其他*/
	private String others;
	/**编号*/
	private Integer sort;
	/**赠送鸿鑫币数量*/
	private String account;
	/**备注*/
	private String remarks;
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
	 *@return: java.lang.String  分类id
	 */
	@Column(name ="TCC_ID",nullable=true,length=32)
	public String getTccId(){
		return this.tccId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类id
	 */
	public void setTccId(String tccId){
		this.tccId = tccId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  显示分类
	 */
	@Column(name ="CATALOG_DISPLAY_NUM",nullable=true,length=50)
	public String getCatalogDisplayNum(){
		return this.catalogDisplayNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  显示分类
	 */
	public void setCatalogDisplayNum(String catalogDisplayNum){
		this.catalogDisplayNum = catalogDisplayNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总课时数
	 */
	@Column(name ="COURSE_NUM_ALL",nullable=true,length=3)
	public Integer getCourseNumAll(){
		return this.courseNumAll;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总课时数
	 */
	public void setCourseNumAll(Integer courseNumAll){
		this.courseNumAll = courseNumAll;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  总学习数
	 */
	@Column(name ="COURSE_MINUTES_ALL",nullable=true,length=10)
	public Integer getCourseMinutesAll(){
		return this.courseMinutesAll;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  总学习数
	 */
	public void setCourseMinutesAll(Integer courseMinutesAll){
		this.courseMinutesAll = courseMinutesAll;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  招生人数
	 */
	@Column(name ="NUMBER",nullable=true,length=10)
	public Integer getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  招生人数
	 */
	public void setNumber(Integer number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程价格
	 */
	@Column(name ="COURSE_PRICES",nullable=true,length=10)
	public String getCoursePrices(){
		return this.coursePrices;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程价格
	 */
	public void setCoursePrices(String coursePrices){
		this.coursePrices = coursePrices;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训课题
	 */
	@Column(name ="TITLE",nullable=true,length=200)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训课题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=10)
	public Integer getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  外部标记
	 */
	public void setOutSign(Integer outSign){
		this.outSign = outSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开班时间
	 */
	@Column(name ="OPENING_TIME",nullable=true,length=11)
	public String getOpeningTime(){
		return this.openingTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开班时间
	 */
	public void setOpeningTime(String openingTime){
		this.openingTime = openingTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班号
	 */
	@Column(name ="CLASS_NUM",nullable=true,length=20)
	public String getClassNum(){
		return this.classNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班号
	 */
	public void setClassNum(String classNum){
		this.classNum = classNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  授课方式
	 */
	@Column(name ="COURSE_TYPE",nullable=true,length=3)
	public Integer getCourseType(){
		return this.courseType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  授课方式
	 */
	public void setCourseType(Integer courseType){
		this.courseType = courseType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  报名人数
	 */
	@Column(name ="REG_NUMBERS",nullable=true,length=10)
	public Integer getRegNumbers(){
		return this.regNumbers;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  报名人数
	 */
	public void setRegNumbers(Integer regNumbers){
		this.regNumbers = regNumbers;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  培训方式
	 */
	@Column(name ="TRAIN_TYPE",nullable=true,length=3)
	public Integer getTrainType(){
		return this.trainType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  培训方式
	 */
	public void setTrainType(Integer trainType){
		this.trainType = trainType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  限报人数
	 */
	@Column(name ="LIMITED_NUMBER",nullable=true,length=10)
	public Integer getLimitedNumber(){
		return this.limitedNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  限报人数
	 */
	public void setLimitedNumber(Integer limitedNumber){
		this.limitedNumber = limitedNumber;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否是支付的定金
	 */
	@Column(name ="IS_FRONT_MONEY",nullable=true,length=10)
	public Integer getIsFrontMoney(){
		return this.isFrontMoney;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否是支付的定金
	 */
	public void setIsFrontMoney(Integer isFrontMoney){
		this.isFrontMoney = isFrontMoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学费
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学费
	 */
	public void setPrice(String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程介绍
	 */
	@Column(name ="COURSE_INTRODUCE",nullable=true,length=16777215)
	public String getCourseIntroduce(){
		return this.courseIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程介绍
	 */
	public void setCourseIntroduce(String courseIntroduce){
		this.courseIntroduce = courseIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适用学员
	 */
	@Column(name ="COURSE_OBJ",nullable=true,length=1000)
	public String getCourseObj(){
		return this.courseObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适用学员
	 */
	public void setCourseObj(String courseObj){
		this.courseObj = courseObj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教学目标
	 */
	@Column(name ="TRAIN_OBJ",nullable=true,length=16777215)
	public String getTrainObj(){
		return this.trainObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教学目标
	 */
	public void setTrainObj(String trainObj){
		this.trainObj = trainObj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  授课内容
	 */
	@Column(name ="TRAIN_CONTENT",nullable=true,length=16777215)
	public String getTrainContent(){
		return this.trainContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  授课内容
	 */
	public void setTrainContent(String trainContent){
		this.trainContent = trainContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程体系
	 */
	@Column(name ="COURSE_DIR",nullable=true,length=16777215)
	public String getCourseDir(){
		return this.courseDir;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程体系
	 */
	public void setCourseDir(String courseDir){
		this.courseDir = courseDir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程特色
	 */
	@Column(name ="COURSE_SPECIAL",nullable=true,length=16777215)
	public String getCourseSpecial(){
		return this.courseSpecial;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程特色
	 */
	public void setCourseSpecial(String courseSpecial){
		this.courseSpecial = courseSpecial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开班规律
	 */
	@Column(name ="START_CLASS_RULE",nullable=true,length=16777215)
	public String getStartClassRule(){
		return this.startClassRule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开班规律
	 */
	public void setStartClassRule(String startClassRule){
		this.startClassRule = startClassRule;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地点简称
	 */
	@Column(name ="ADDRESS_SHORT",nullable=true,length=200)
	public String getAddressShort(){
		return this.addressShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地点简称
	 */
	public void setAddressShort(String addressShort){
		this.addressShort = addressShort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体地点
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体地点
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="OTHERS",nullable=true,length=16777215)
	public String getOthers(){
		return this.others;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOthers(String others){
		this.others = others;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赠送鸿鑫币数量
	 */
	@Column(name ="ACCOUNT",nullable=true,length=255)
	public String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赠送鸿鑫币数量
	 */
	public void setAccount(String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(String remarks){
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
}
