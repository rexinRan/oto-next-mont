package com.buss.distschool.entity;

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
 * @Description: dxs_dist_school
 * @author onlineGenerator
 * @date 2016-07-20 17:16:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_school", schema = "")
@SuppressWarnings("serial")
public class DxsDistSchoolEntity implements java.io.Serializable {
	/**主键*/
	@Excel(name="主键")
	private Integer scid;
	/**院系名称*/
	@Excel(name="院系名称")
	private String name;
	/**大学id*/
	@Excel(name="大学id")
	private Integer collegeid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue (generator = "generator")
	@Column(name ="SCID",nullable=false,length=10)
	public Integer getScid(){
		return this.scid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setScid(Integer scid){
		this.scid = scid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  院系名称
	 */
	@Column(name ="NAME",nullable=false,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  院系名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  大学id
	 */
	@Column(name ="COLLEGEID",nullable=false,length=5)
	public Integer getCollegeid(){
		return this.collegeid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  大学id
	 */
	public void setCollegeid(Integer collegeid){
		this.collegeid = collegeid;
	}
}
