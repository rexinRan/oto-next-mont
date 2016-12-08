package com.buss.authentication.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_authentication
 * @author onlineGenerator
 * @date 2016-07-19 13:24:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_authentication", schema = "")
@SuppressWarnings("serial")
public class DxsAuthenticationEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**职称*/
	@Excel(name="职称")
	private String teacherTitle;
	/**学生证/资格证扫描件URL*/
	@Excel(name="学生证/资格证扫描件URL")
	private java.lang.String certificateUrl;
	/**学生证/资格证扫描件*/
	@Excel(name="学生证/资格证扫描件")
	private String certificateId;
	/**身份证正面URL*/
	@Excel(name="身份证正面URL")
	private java.lang.String identify1Url;
	/**身份证正面*/
	@Excel(name="身份证正面")
	private String identify1Id;
	/**身份证反面*/
	@Excel(name="身份证反面")
	private java.lang.String identify2Url;
	/**身份证反面*/
	@Excel(name="身份证反面")
	private String identify2Id;
	/**导师类别*/
	@Excel(name="导师类别")
	private String toturType;
	/**导师技能*/
	@Excel(name="导师技能")
	private String toturSkill;
	/**培训经验*/
	@Excel(name="培训经验")
	private String isTrain;
	/**个人简历*/
	@Excel(name="个人简历")
	private String resumeId;
	/**个人履历*/
	@Excel(name="个人履历")
	private java.lang.String resumeDisplay;
	/**个人展示视频*/
	@Excel(name="个人展示视频")
	private java.lang.String displayVideoUrl;
	/**作品或讲义*/
	@Excel(name="作品或讲义")
	private String workId;
	/**认证结果*/
	@Excel(name="认证结果")
	private String authenticationResult;
	/**认证信息反馈*/
	@Excel(name="认证信息反馈")
	private String authenticationMessage;
	/**认证次数*/
	@Excel(name="认证次数")
	private java.lang.Integer authenticationCount;
	/**外部标记*/
	@Excel(name="外部标记")
	private java.lang.Integer outSign;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remarks;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsUserEntity  dxsUserEntity;
	
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职称
	 */
	@Column(name ="TEACHER_TITLE",nullable=true,length=200)
	public String getTeacherTitle(){
		return this.teacherTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称
	 */
	public void setTeacherTitle(String teacherTitle){
		this.teacherTitle = teacherTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生证/资格证扫描件URL
	 */
	@Column(name ="CERTIFICATE_URL",nullable=true,length=100)
	public java.lang.String getCertificateUrl(){
		return this.certificateUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生证/资格证扫描件URL
	 */
	public void setCertificateUrl(java.lang.String certificateUrl){
		this.certificateUrl = certificateUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生证/资格证扫描件
	 */
	@Column(name ="CERTIFICATE_ID",nullable=true,length=32)
	public String getCertificateId(){
		return this.certificateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生证/资格证扫描件
	 */
	public void setCertificateId(String certificateId){
		this.certificateId = certificateId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证正面URL
	 */
	@Column(name ="IDENTIFY1_URL",nullable=true,length=100)
	public java.lang.String getIdentify1Url(){
		return this.identify1Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证正面URL
	 */
	public void setIdentify1Url(java.lang.String identify1Url){
		this.identify1Url = identify1Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证正面
	 */
	@Column(name ="IDENTIFY1_ID",nullable=true,length=32)
	public String getIdentify1Id(){
		return this.identify1Id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证正面
	 */
	public void setIdentify1Id(String identify1Id){
		this.identify1Id = identify1Id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证反面
	 */
	@Column(name ="IDENTIFY2_URL",nullable=true,length=100)
	public java.lang.String getIdentify2Url(){
		return this.identify2Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证反面
	 */
	public void setIdentify2Url(java.lang.String identify2Url){
		this.identify2Url = identify2Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证反面
	 */
	@Column(name ="IDENTIFY2_ID",nullable=true,length=32)
	public String getIdentify2Id(){
		return this.identify2Id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证反面
	 */
	public void setIdentify2Id(String identify2Id){
		this.identify2Id = identify2Id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师类别
	 */
	@Column(name ="TOTUR_TYPE",nullable=true,length=50)
	public String getToturType(){
		return this.toturType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师类别
	 */
	public void setToturType(String toturType){
		this.toturType = toturType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师技能
	 */
	@Column(name ="TOTUR_SKILL",nullable=true,length=255)
	public String getToturSkill(){
		return this.toturSkill;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师技能
	 */
	public void setToturSkill(String toturSkill){
		this.toturSkill = toturSkill;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训经验
	 */
	@Column(name ="IS_TRAIN",nullable=true,length=10)
	public String getIsTrain(){
		return this.isTrain;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训经验
	 */
	public void setIsTrain(String isTrain){
		this.isTrain = isTrain;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人简历
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人简历
	 */
	public void setResumeId(String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人履历
	 */
	@Column(name ="RESUME_DISPLAY",nullable=true,length=16777215)
	public java.lang.String getResumeDisplay(){
		return this.resumeDisplay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人履历
	 */
	public void setResumeDisplay(java.lang.String resumeDisplay){
		this.resumeDisplay = resumeDisplay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人展示视频
	 */
	@Column(name ="DISPLAY_VIDEO_URL",nullable=true,length=255)
	public java.lang.String getDisplayVideoUrl(){
		return this.displayVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人展示视频
	 */
	public void setDisplayVideoUrl(java.lang.String displayVideoUrl){
		this.displayVideoUrl = displayVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作品或讲义
	 */
	@Column(name ="WORK_ID",nullable=true,length=32)
	public String getWorkId(){
		return this.workId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作品或讲义
	 */
	public void setWorkId(String workId){
		this.workId = workId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  认证结果
	 */
	@Column(name ="AUTHENTICATION_RESULT",nullable=true,length=5)
	public String getAuthenticationResult(){
		return this.authenticationResult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  认证结果
	 */
	public void setAuthenticationResult(String authenticationResult){
		this.authenticationResult = authenticationResult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  认证信息反馈
	 */
	@Column(name ="AUTHENTICATION_MESSAGE",nullable=true,length=255)
	public String getAuthenticationMessage(){
		return this.authenticationMessage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  认证信息反馈
	 */
	public void setAuthenticationMessage(String authenticationMessage){
		this.authenticationMessage = authenticationMessage;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  认证次数
	 */
	@Column(name ="AUTHENTICATION_COUNT",nullable=true,length=3)
	public java.lang.Integer getAuthenticationCount(){
		return this.authenticationCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  认证次数
	 */
	public void setAuthenticationCount(java.lang.Integer authenticationCount){
		this.authenticationCount = authenticationCount;
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
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
