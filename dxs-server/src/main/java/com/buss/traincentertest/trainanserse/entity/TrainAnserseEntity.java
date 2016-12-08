package com.buss.traincentertest.trainanserse.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_train_anserse
 * @author onlineGenerator
 * @date 2016-09-08 11:58:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_anserse", schema = "")
@SuppressWarnings("serial")
public class TrainAnserseEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**结果*/

	private String result;

	/**试卷id*/

	private String ttId;
	/**性格特征解析*/

	private String characterAnalysis;
	/**性格类型*/

	private String characterType;
	/**性格特质*/

	private String characterTrait;
	/**适合从事*/

	private String characterSuitible;
	/**代表人物及身份*/

	private String symbol;
	/**代表人物头像*/

	private String symbolImg;
	/**代表人物语录*/

	private String symbolSay;
	/**基本描述*/

	private String baseIntroduce;
	/**适合领域*/

	private String suitField;
	/**适合岗位*/

	private String sultJob;
	/**气质类型*/

	private String temperamentType;
	/**总体描述*/

	private String generalIntrodece;
	/**潜在弱点*/

	private String weakness;
	/**优势*/

	private String advantage;
	/**劣势*/

	private String inferiority;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

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
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULT",nullable=true,length=20)
	public String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResult(String result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试卷id
	 */
	@Column(name ="TT_ID",nullable=true,length=32)
	public String getTtId(){
		return this.ttId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试卷id
	 */
	public void setTtId(String ttId){
		this.ttId = ttId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性格特征解析
	 */
	@Column(name ="CHARACTER_ANALYSIS",nullable=true,length=255)
	public String getCharacterAnalysis(){
		return this.characterAnalysis;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性格特征解析
	 */
	public void setCharacterAnalysis(String characterAnalysis){
		this.characterAnalysis = characterAnalysis;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性格类型
	 */
	@Column(name ="CHARACTER_TYPE",nullable=true,length=20)
	public String getCharacterType(){
		return this.characterType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性格类型
	 */
	public void setCharacterType(String characterType){
		this.characterType = characterType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性格特质
	 */
	@Column(name ="CHARACTER_TRAIT",nullable=true,length=100)
	public String getCharacterTrait(){
		return this.characterTrait;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性格特质
	 */
	public void setCharacterTrait(String characterTrait){
		this.characterTrait = characterTrait;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适合从事
	 */
	@Column(name ="CHARACTER_SUITIBLE",nullable=true,length=255)
	public String getCharacterSuitible(){
		return this.characterSuitible;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适合从事
	 */
	public void setCharacterSuitible(String characterSuitible){
		this.characterSuitible = characterSuitible;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代表人物及身份
	 */
	@Column(name ="SYMBOL",nullable=true,length=255)
	public String getSymbol(){
		return this.symbol;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代表人物及身份
	 */
	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代表人物头像
	 */
	@Column(name ="SYMBOL_IMG",nullable=true,length=255)
	public String getSymbolImg(){
		return this.symbolImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代表人物头像
	 */
	public void setSymbolImg(String symbolImg){
		this.symbolImg = symbolImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代表人物语录
	 */
	@Column(name ="SYMBOL_SAY",nullable=true,length=255)
	public String getSymbolSay(){
		return this.symbolSay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代表人物语录
	 */
	public void setSymbolSay(String symbolSay){
		this.symbolSay = symbolSay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本描述
	 */
	@Column(name ="BASE_INTRODUCE",nullable=true,length=16777215)
	public String getBaseIntroduce(){
		return this.baseIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本描述
	 */
	public void setBaseIntroduce(String baseIntroduce){
		this.baseIntroduce = baseIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适合领域
	 */
	@Column(name ="SUIT_FIELD",nullable=true,length=255)
	public String getSuitField(){
		return this.suitField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适合领域
	 */
	public void setSuitField(String suitField){
		this.suitField = suitField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  适合岗位
	 */
	@Column(name ="SULT_JOB",nullable=true,length=255)
	public String getSultJob(){
		return this.sultJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  适合岗位
	 */
	public void setSultJob(String sultJob){
		this.sultJob = sultJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  气质类型
	 */
	@Column(name ="TEMPERAMENT_TYPE",nullable=true,length=16777215)
	public String getTemperamentType(){
		return this.temperamentType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  气质类型
	 */
	public void setTemperamentType(String temperamentType){
		this.temperamentType = temperamentType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  总体描述
	 */
	@Column(name ="GENERAL_INTRODECE",nullable=true,length=16777215)
	public String getGeneralIntrodece(){
		return this.generalIntrodece;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  总体描述
	 */
	public void setGeneralIntrodece(String generalIntrodece){
		this.generalIntrodece = generalIntrodece;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  潜在弱点
	 */
	@Column(name ="WEAKNESS",nullable=true,length=16777215)
	public String getWeakness(){
		return this.weakness;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  潜在弱点
	 */
	public void setWeakness(String weakness){
		this.weakness = weakness;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优势
	 */
	@Column(name ="ADVANTAGE",nullable=true,length=16777215)
	public String getAdvantage(){
		return this.advantage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优势
	 */
	public void setAdvantage(String advantage){
		this.advantage = advantage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  劣势
	 */
	@Column(name ="INFERIORITY",nullable=true,length=16777215)
	public String getInferiority(){
		return this.inferiority;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  劣势
	 */
	public void setInferiority(String inferiority){
		this.inferiority = inferiority;
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
