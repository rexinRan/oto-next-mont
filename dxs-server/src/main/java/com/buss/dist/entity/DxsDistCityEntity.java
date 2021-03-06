package com.buss.dist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Title: Entity
 * @Description: dxs_dist_city
 * @author onlineGenerator
 * @date 2016-07-19 15:44:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_city", schema = "")
@SuppressWarnings("serial")
public class DxsDistCityEntity implements java.io.Serializable {
	/**主键*/
	private Integer cid;
	/**市id*/
	private Integer cityid;
	/**市区名称*/
	private String city;
	/**省份id*/
	private Integer provinceid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@Column(name ="CID",nullable=false,length=5)
	public Integer getCid(){
		return this.cid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setCid(Integer cid){
		this.cid = cid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  市id
	 */
	@Column(name ="CITYID",nullable=false,length=7)
	public Integer getCityid(){
		return this.cityid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  市id
	 */
	public void setCityid(Integer cityid){
		this.cityid = cityid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  市区名称
	 */
	@Column(name ="CITY",nullable=false,length=50)
	public String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  市区名称
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  省份id
	 */
	@Column(name ="PROVINCEID",nullable=false,length=7)
	public Integer getProvinceid(){
		return this.provinceid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  省份id
	 */
	public void setProvinceid(Integer provinceid){
		this.provinceid = provinceid;
	}
}
