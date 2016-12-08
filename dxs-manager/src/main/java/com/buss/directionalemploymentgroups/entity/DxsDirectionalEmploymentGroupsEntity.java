package com.buss.directionalemploymentgroups.entity;

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
 * @Description: dxs_directional_employment_groups
 * @author onlineGenerator
 * @date 2016-08-05 15:43:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_directional_employment_groups", schema = "")
@SuppressWarnings("serial")
public class DxsDirectionalEmploymentGroupsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**企业id*/
	@Excel(name="企业id")
	private String userId;
	/**定项就业名称*/
	@Excel(name="定项就业名称")
	private String directionalEmploymentName;
	/**显示菜单*/
	@Excel(name="显示菜单")
	private String directionDisplayMenu;
	/**定项就业发布时间*/
	@Excel(name="定项就业发布时间",format = "yyyy-MM-dd")
	private Date directionPublishTime;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date cretateTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsUserEntity dxsUserEntity;
	
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
	 *@return: java.lang.String  企业id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  定项就业名称
	 */
	@Column(name ="DIRECTIONAL_EMPLOYMENT_NAME",nullable=true,length=200)
	public String getDirectionalEmploymentName(){
		return this.directionalEmploymentName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  定项就业名称
	 */
	public void setDirectionalEmploymentName(String directionalEmploymentName){
		this.directionalEmploymentName = directionalEmploymentName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  显示菜单
	 */
	@Column(name ="DIRECTION_DISPLAY_MENU",nullable=true,length=200)
	public String getDirectionDisplayMenu(){
		return this.directionDisplayMenu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  显示菜单
	 */
	public void setDirectionDisplayMenu(String directionDisplayMenu){
		this.directionDisplayMenu = directionDisplayMenu;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  定项就业发布时间
	 */
	@Column(name ="DIRECTION_PUBLISH_TIME",nullable=true)
	public Date getDirectionPublishTime(){
		return this.directionPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  定项就业发布时间
	 */
	public void setDirectionPublishTime(Date directionPublishTime){
		this.directionPublishTime = directionPublishTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CRETATE_TIME",nullable=true)
	public Date getCretateTime(){
		return this.cretateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCretateTime(Date cretateTime){
		this.cretateTime = cretateTime;
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
