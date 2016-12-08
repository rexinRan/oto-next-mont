package com.buss.site.entity;

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
 * @Description: dxs_site
 * @author onlineGenerator
 * @date 2016-06-02 16:51:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_site", schema = "")
@SuppressWarnings("serial")
public class DxsSiteEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**公司名称*/
	@Excel(name="公司名称")
	private String companyName;
	/**公司网站*/
	@Excel(name="公司网站")
	private String companySite;
	/**扩展字段1*/
	@Excel(name="扩展字段1")
	private String ext1;
	/**扩展字段2*/
	@Excel(name="扩展字段2")
	private String ext2;
	/**扩展字段3*/
	@Excel(name="扩展字段3")
	private String ext3;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=255)
	public String getCompanyName(){
		return this.companyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司网站
	 */
	@Column(name ="COMPANY_SITE",nullable=true,length=255)
	public String getCompanySite(){
		return this.companySite;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司网站
	 */
	public void setCompanySite(String companySite){
		this.companySite = companySite;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扩展字段1
	 */
	@Column(name ="EXT1",nullable=true,length=255)
	public String getExt1(){
		return this.ext1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扩展字段1
	 */
	public void setExt1(String ext1){
		this.ext1 = ext1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扩展字段2
	 */
	@Column(name ="EXT2",nullable=true,length=255)
	public String getExt2(){
		return this.ext2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扩展字段2
	 */
	public void setExt2(String ext2){
		this.ext2 = ext2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扩展字段3
	 */
	@Column(name ="EXT3",nullable=true,length=255)
	public String getExt3(){
		return this.ext3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扩展字段3
	 */
	public void setExt3(String ext3){
		this.ext3 = ext3;
	}
}
