package com.buss.distarea.entity;

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
 * @Description: dxs_dist_area
 * @author onlineGenerator
 * @date 2016-07-20 16:43:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_area", schema = "")
@SuppressWarnings("serial")
public class DxsDistAreaEntity implements java.io.Serializable {
	/**主键*/
	@Excel(name="主键")
	private Integer aid;
	/**市区的id*/
	@Excel(name="市区的id")
	private Integer areaid;
	/**市区名字*/
	@Excel(name="市区名字")
	private String area;
	/**市id*/
	@Excel(name="市id")
	private Integer cityid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue (generator = "generator")
	@Column(name ="AID",nullable=false,length=5)
	public Integer getAid(){
		return this.aid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setAid(Integer aid){
		this.aid = aid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  市区的id
	 */
	@Column(name ="AREAID",nullable=false,length=7)
	public Integer getAreaid(){
		return this.areaid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  市区的id
	 */
	public void setAreaid(Integer areaid){
		this.areaid = areaid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  市区名字
	 */
	@Column(name ="AREA",nullable=false,length=50)
	public String getArea(){
		return this.area;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  市区名字
	 */
	public void setArea(String area){
		this.area = area;
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
}
