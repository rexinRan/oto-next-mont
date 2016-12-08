package com.buss.lecturespersion.entity;

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
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_lectures_persion
 * @author onlineGenerator
 * @date 2016-08-22 09:50:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_lectures_persion", schema = "")
@SuppressWarnings("serial")
public class DxsLecturesPersionEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id(预留)*/
	@Excel(name="用户id(预留)")
	private String userId;
	/**缩略图*/
	@Excel(name="缩略图")
	private java.lang.String imgUrl;
	/**学历*/
	@Excel(name="学历")
	private java.lang.String educational;
	/**姓名*/
	@Excel(name="姓名")
	private String prosonName;
	/**职位*/
	@Excel(name="职位")
	private String prosonJob;
	/**地点*/
	@Excel(name="地点")
	private String prosonAddress;
	/**毕业院校*/
	@Excel(name="毕业院校")
	private String prosonEdu;
	/**社会最高职位*/
	@Excel(name="社会最高职位")
	private String prosonTopJob;
	/**现任职单位*/
	@Excel(name="现任职单位")
	private String prosonNowJob;
	/**企业经营项目*/
	@Excel(name="企业经营项目")
	private String prosonNowProject;
	/**个人履历*/
	@Excel(name="个人履历")
	private String prosonResumeDisplay;
	/**企业家风采视频*/
	@Excel(name="企业家风采视频")
	private String prosonStyleVideo;
	/**企业家风采描述*/
	@Excel(name="企业家风采描述")
	private String prosonStyle;
	/**个人成就展*/
	@Excel(name="个人成就展")
	private String prosonAccomplishment;
	/**类别*/
	@Excel(name="类别")
	private Integer type;
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
	 *@return: java.lang.String  用户id(预留)
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id(预留)
	 */
	public void setUserId(String userId){
		this.userId = userId;
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
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATIONAL",nullable=true,length=50)
	public java.lang.String getEducational(){
		return this.educational;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducational(java.lang.String educational){
		this.educational = educational;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="PROSON_NAME",nullable=true,length=200)
	public String getProsonName(){
		return this.prosonName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setProsonName(String prosonName){
		this.prosonName = prosonName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位
	 */
	@Column(name ="PROSON_JOB",nullable=true,length=100)
	public String getProsonJob(){
		return this.prosonJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位
	 */
	public void setProsonJob(String prosonJob){
		this.prosonJob = prosonJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地点
	 */
	@Column(name ="PROSON_ADDRESS",nullable=true,length=255)
	public String getProsonAddress(){
		return this.prosonAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地点
	 */
	public void setProsonAddress(String prosonAddress){
		this.prosonAddress = prosonAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业院校
	 */
	@Column(name ="PROSON_EDU",nullable=true,length=200)
	public String getProsonEdu(){
		return this.prosonEdu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业院校
	 */
	public void setProsonEdu(String prosonEdu){
		this.prosonEdu = prosonEdu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  社会最高职位
	 */
	@Column(name ="PROSON_TOP_JOB",nullable=true,length=200)
	public String getProsonTopJob(){
		return this.prosonTopJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  社会最高职位
	 */
	public void setProsonTopJob(String prosonTopJob){
		this.prosonTopJob = prosonTopJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现任职单位
	 */
	@Column(name ="PROSON_NOW_JOB",nullable=true,length=200)
	public String getProsonNowJob(){
		return this.prosonNowJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现任职单位
	 */
	public void setProsonNowJob(String prosonNowJob){
		this.prosonNowJob = prosonNowJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业经营项目
	 */
	@Column(name ="PROSON_NOW_PROJECT",nullable=true,length=255)
	public String getProsonNowProject(){
		return this.prosonNowProject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业经营项目
	 */
	public void setProsonNowProject(String prosonNowProject){
		this.prosonNowProject = prosonNowProject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人履历
	 */
	@Column(name ="PROSON_RESUME_DISPLAY",nullable=true,length=16777215)
	public String getProsonResumeDisplay(){
		return this.prosonResumeDisplay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人履历
	 */
	public void setProsonResumeDisplay(String prosonResumeDisplay){
		this.prosonResumeDisplay = prosonResumeDisplay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业家风采视频
	 */
	@Column(name ="PROSON_STYLE_VIDEO",nullable=true,length=255)
	public String getProsonStyleVideo(){
		return this.prosonStyleVideo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业家风采视频
	 */
	public void setProsonStyleVideo(String prosonStyleVideo){
		this.prosonStyleVideo = prosonStyleVideo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业家风采描述
	 */
	@Column(name ="PROSON_STYLE",nullable=true,length=16777215)
	public String getProsonStyle(){
		return this.prosonStyle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业家风采描述
	 */
	public void setProsonStyle(String prosonStyle){
		this.prosonStyle = prosonStyle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人成就展
	 */
	@Column(name ="PROSON_ACCOMPLISHMENT",nullable=true,length=16777215)
	public String getProsonAccomplishment(){
		return this.prosonAccomplishment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人成就展
	 */
	public void setProsonAccomplishment(String prosonAccomplishment){
		this.prosonAccomplishment = prosonAccomplishment;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  类别
	 */
	@Column(name ="TYPE",nullable=true,length=3)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  类别
	 */
	public void setType(Integer type){
		this.type = type;
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
