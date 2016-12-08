package com.buss.vote.entity;

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
 * @Description: dxs_vote
 * @author onlineGenerator
 * @date 2016-07-16 13:06:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_vote", schema = "")
@SuppressWarnings("serial")
public class DxsVoteEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id(admin)*/
	@Excel(name="用户id(admin)")
	private String userId;
	/**投票分类的id*/
	@Excel(name="投票分类的id")
	private String voteId;
	/**投票标题*/
	@Excel(name="投票标题")
	private String voteTitle;
	/**投票活动缩略图*/
	@Excel(name="投票活动缩略图")
	private String voteImage;
	/**展示菜单*/
	@Excel(name="展示菜单")
	private String displayMenu;
	/**投票地点*/
	@Excel(name="投票地点")
	private String voteAddress;
	/**主办单位*/
	@Excel(name="主办单位")
	private String hostUnit;
	/**限报人数*/
	@Excel(name="限报人数")
	private String limitedNumber;
	/**精彩回顾*/
	@Excel(name="精彩回顾")
	private String histaryDate;
	/**截止投票时间*/
	@Excel(name="截止投票时间",format = "yyyy-MM-dd")
	private Date deadlineDate;
	/**活动开始时间*/
	@Excel(name="活动开始时间",format = "yyyy-MM-dd")
	private Date voteStateTime;
	/**活动结束时间*/
	@Excel(name="活动结束时间",format = "yyyy-MM-dd")
	private Date voteEndTime;
	/**活动对象*/
	@Excel(name="活动对象")
	private String voteUsertypeId;
	/**活动内容*/
	@Excel(name="活动内容")
	private String voteIntroduce;
	/**投票规则*/
	@Excel(name="投票规则")
	private String voteRule;
	/**投票总人数*/
	@Excel(name="投票总人数")
	private Integer voteNum;
	/**投票总票数*/
	@Excel(name="投票总票数")
	private java.lang.Integer voteCount;
	/**是否收费 0收费 1不收费*/
	@Excel(name="是否收费 0收费 1不收费")
	private Integer isCharge;
	/**可得到鸿鑫币数量*/
	@Excel(name="可得到鸿鑫币数量")
	private String maxAccountCount;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date publishTime;
	/**编辑人*/
	@Excel(name="编辑人")
	private String activeEditor;
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
	 *@return: java.lang.String  用户id(admin)
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id(admin)
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票分类的id
	 */
	@Column(name ="VOTE_ID",nullable=true,length=32)
	public String getVoteId(){
		return this.voteId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票分类的id
	 */
	public void setVoteId(String voteId){
		this.voteId = voteId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票标题
	 */
	@Column(name ="VOTE_TITLE",nullable=true,length=100)
	public String getVoteTitle(){
		return this.voteTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票标题
	 */
	public void setVoteTitle(String voteTitle){
		this.voteTitle = voteTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票活动缩略图
	 */
	@Column(name ="VOTE_IMAGE",nullable=true,length=255)
	public String getVoteImage(){
		return this.voteImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票活动缩略图
	 */
	public void setVoteImage(String voteImage){
		this.voteImage = voteImage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  展示菜单
	 */
	@Column(name ="DISPLAY_MENU",nullable=true,length=100)
	public String getDisplayMenu(){
		return this.displayMenu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  展示菜单
	 */
	public void setDisplayMenu(String displayMenu){
		this.displayMenu = displayMenu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票地点
	 */
	@Column(name ="VOTE_ADDRESS",nullable=true,length=255)
	public String getVoteAddress(){
		return this.voteAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票地点
	 */
	public void setVoteAddress(String voteAddress){
		this.voteAddress = voteAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主办单位
	 */
	@Column(name ="HOST_UNIT",nullable=true,length=100)
	public String getHostUnit(){
		return this.hostUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主办单位
	 */
	public void setHostUnit(String hostUnit){
		this.hostUnit = hostUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  限报人数
	 */
	@Column(name ="LIMITED_NUMBER",nullable=true,length=255)
	public String getLimitedNumber(){
		return this.limitedNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  限报人数
	 */
	public void setLimitedNumber(String limitedNumber){
		this.limitedNumber = limitedNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  精彩回顾
	 */
	@Column(name ="HISTARY_DATE",nullable=true,length=255)
	public String getHistaryDate(){
		return this.histaryDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  精彩回顾
	 */
	public void setHistaryDate(String histaryDate){
		this.histaryDate = histaryDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  截止投票时间
	 */
	@Column(name ="DEADLINE_DATE",nullable=true)
	public Date getDeadlineDate(){
		return this.deadlineDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  截止投票时间
	 */
	public void setDeadlineDate(Date deadlineDate){
		this.deadlineDate = deadlineDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动开始时间
	 */
	@Column(name ="VOTE_STATE_TIME",nullable=true)
	public Date getVoteStateTime(){
		return this.voteStateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动开始时间
	 */
	public void setVoteStateTime(Date voteStateTime){
		this.voteStateTime = voteStateTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动结束时间
	 */
	@Column(name ="VOTE_END_TIME",nullable=true)
	public Date getVoteEndTime(){
		return this.voteEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动结束时间
	 */
	public void setVoteEndTime(Date voteEndTime){
		this.voteEndTime = voteEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动对象
	 */
	@Column(name ="VOTE_USERTYPE_ID",nullable=true,length=32)
	public String getVoteUsertypeId(){
		return this.voteUsertypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动对象
	 */
	public void setVoteUsertypeId(String voteUsertypeId){
		this.voteUsertypeId = voteUsertypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动内容
	 */
	@Column(name ="VOTE_INTRODUCE",nullable=true,length=16777215)
	public String getVoteIntroduce(){
		return this.voteIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动内容
	 */
	public void setVoteIntroduce(String voteIntroduce){
		this.voteIntroduce = voteIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票规则
	 */
	@Column(name ="VOTE_RULE",nullable=true,length=16777215)
	public String getVoteRule(){
		return this.voteRule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票规则
	 */
	public void setVoteRule(String voteRule){
		this.voteRule = voteRule;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票总人数
	 */
	@Column(name ="VOTE_NUM",nullable=true,length=11)
	public Integer getVoteNum(){
		return this.voteNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票总人数
	 */
	public void setVoteNum(Integer voteNum){
		this.voteNum = voteNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  投票总票数
	 */
	@Column(name ="VOTE_COUNT",nullable=true,length=10)
	public java.lang.Integer getVoteCount(){
		return this.voteCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  投票总票数
	 */
	public void setVoteCount(java.lang.Integer voteCount){
		this.voteCount = voteCount;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否收费 0收费 1不收费
	 */
	@Column(name ="IS_CHARGE",nullable=true,length=10)
	public Integer getIsCharge(){
		return this.isCharge;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否收费 0收费 1不收费
	 */
	public void setIsCharge(Integer isCharge){
		this.isCharge = isCharge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可得到鸿鑫币数量
	 */
	@Column(name ="MAX_ACCOUNT_COUNT",nullable=true,length=255)
	public String getMaxAccountCount(){
		return this.maxAccountCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可得到鸿鑫币数量
	 */
	public void setMaxAccountCount(String maxAccountCount){
		this.maxAccountCount = maxAccountCount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="ACTIVE_EDITOR",nullable=true,length=100)
	public String getActiveEditor(){
		return this.activeEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setActiveEditor(String activeEditor){
		this.activeEditor = activeEditor;
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
}
