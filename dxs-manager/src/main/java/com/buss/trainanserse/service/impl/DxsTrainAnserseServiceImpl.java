package com.buss.trainanserse.service.impl;
import com.buss.trainanserse.service.DxsTrainAnserseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.trainanserse.entity.DxsTrainAnserseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainAnserseService")
@Transactional
public class DxsTrainAnserseServiceImpl extends CommonServiceImpl implements DxsTrainAnserseServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainAnserseEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainAnserseEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainAnserseEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainAnserseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainAnserseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainAnserseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainAnserseEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{character_analysis}",String.valueOf(t.getCharacterAnalysis()));
 		sql  = sql.replace("#{character_type}",String.valueOf(t.getCharacterType()));
 		sql  = sql.replace("#{character_trait}",String.valueOf(t.getCharacterTrait()));
 		sql  = sql.replace("#{character_suitible}",String.valueOf(t.getCharacterSuitible()));
 		sql  = sql.replace("#{symbol}",String.valueOf(t.getSymbol()));
 		sql  = sql.replace("#{symbol_say}",String.valueOf(t.getSymbolSay()));
 		sql  = sql.replace("#{base_introduce}",String.valueOf(t.getBaseIntroduce()));
 		sql  = sql.replace("#{suit_field}",String.valueOf(t.getSuitField()));
 		sql  = sql.replace("#{sult_job}",String.valueOf(t.getSultJob()));
 		sql  = sql.replace("#{temperament_type}",String.valueOf(t.getTemperamentType()));
 		sql  = sql.replace("#{general_introdece}",String.valueOf(t.getGeneralIntrodece()));
 		sql  = sql.replace("#{weakness}",String.valueOf(t.getWeakness()));
 		sql  = sql.replace("#{advantage}",String.valueOf(t.getAdvantage()));
 		sql  = sql.replace("#{inferiority}",String.valueOf(t.getInferiority()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}