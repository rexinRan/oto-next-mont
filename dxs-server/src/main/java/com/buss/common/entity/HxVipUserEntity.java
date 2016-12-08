package com.buss.common.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 会员成员展
 * @author zhangdaihao
 * @date 2016-05-04 17:07:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "hx_VipUser", catalog = "hxclub")
@SuppressWarnings("serial")
public class HxVipUserEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**姓名*/
	private String name;
	/**头像*/
	private String headImg;
	/**公司职务*/
	private String job;
	/**会员水平 预留*/
	private Integer levelclass;
	/**会员职称*/
	private String levelname;
	/**个人简介*/
	private String persionsummary;
	/**公司简介*/
	private String companysummary;
	/**创建时间*/
	private Date createtime;
	/**更新时间*/
	private Date updatetime;
	/**排序 预留*/
	private Integer sort;
	/**有效位*/
	private Integer isDelete;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=40)
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=50)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEAD_IMG",nullable=true,length=200)
	public String getHeadImg(){
		return this.headImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadImg(String headImg){
		this.headImg = headImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司职务
	 */
	@Column(name ="JOB",nullable=true,length=200)
	public String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司职务
	 */
	public void setJob(String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  会员水平 预留
	 */
	@Column(name ="LEVELCLASS",nullable=true,precision=10,scale=0)
	public Integer getLevelclass(){
		return this.levelclass;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  会员水平 预留
	 */
	public void setLevelclass(Integer levelclass){
		this.levelclass = levelclass;
	}

	@Column(name ="LEVELNAME",nullable=true,length=200)
	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  个人简介
	 */
	@Column(name ="PERSIONSUMMARY",nullable=true,length=65535)
	public String getPersionsummary(){
		return this.persionsummary;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  个人简介
	 */
	public void setPersionsummary(String persionsummary){
		this.persionsummary = persionsummary;
	}
	/**
	 *方法: 取得java.lang.Object
	 *@return: java.lang.Object  公司简介
	 */
	@Column(name ="COMPANYSUMMARY",nullable=true,length=65535)
	public String getCompanysummary(){
		return this.companysummary;
	}

	/**
	 *方法: 设置java.lang.Object
	 *@param: java.lang.Object  公司简介
	 */
	public void setCompanysummary(String companysummary){
		this.companysummary = companysummary;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATETIME",nullable=true)
	public Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATETIME",nullable=true)
	public Date getUpdatetime(){
		return this.updatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdatetime(Date updatetime){
		this.updatetime = updatetime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序 预留
	 */
	@Column(name ="SORT",nullable=true,precision=10,scale=0)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序 预留
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  有效位
	 */
	@Column(name ="IS_DELETE",nullable=true,precision=3,scale=0)
	public Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  有效位
	 */
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}
}
