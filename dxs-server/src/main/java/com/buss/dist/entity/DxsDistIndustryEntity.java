package com.buss.dist.entity;


import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_dist_industry
 * @author onlineGenerator
 * @date 2016-07-23 10:15:27
 * @version V1.0
 */
@Entity
@Table(name = "dxs_dist_industry", schema = "")
@SuppressWarnings("serial")
public class DxsDistIndustryEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.Integer id;
    /**行业编号*/
    private java.lang.Integer industryNo;
    /**行业名称*/
    private java.lang.String industryName;
    /**父级编号*/
    private java.lang.Integer parentNo;

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID",nullable=false,length=5)
    public java.lang.Integer getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  主键
     */
    public void setId(java.lang.Integer id){
        this.id = id;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  行业编号
     */
    @Column(name ="INDUSTRY_NO",nullable=true,length=5)
    public java.lang.Integer getIndustryNo(){
        return this.industryNo;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  行业编号
     */
    public void setIndustryNo(java.lang.Integer industryNo){
        this.industryNo = industryNo;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  行业名称
     */
    @Column(name ="INDUSTRY_NAME",nullable=true,length=30)
    public java.lang.String getIndustryName(){
        return this.industryName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  行业名称
     */
    public void setIndustryName(java.lang.String industryName){
        this.industryName = industryName;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  父级编号
     */
    @Column(name ="PARENT_NO",nullable=true,length=5)
    public java.lang.Integer getParentNo(){
        return this.parentNo;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  父级编号
     */
    public void setParentNo(java.lang.Integer parentNo){
        this.parentNo = parentNo;
    }
}
