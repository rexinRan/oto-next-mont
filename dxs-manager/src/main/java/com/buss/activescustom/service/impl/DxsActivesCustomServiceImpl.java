package com.buss.activescustom.service.impl;
import com.buss.activescustom.service.DxsActivesCustomServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activescustom.entity.DxsActivesCustomEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesCustomService")
@Transactional
public class DxsActivesCustomServiceImpl extends CommonServiceImpl implements DxsActivesCustomServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesCustomEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesCustomEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesCustomEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesCustomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesCustomEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesCustomEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesCustomEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{customized_id}",String.valueOf(t.getCustomizedId()));
 		sql  = sql.replace("#{custom_country_id}",String.valueOf(t.getCustomCountryId()));
 		sql  = sql.replace("#{custom_courses_id}",String.valueOf(t.getCustomCoursesId()));
 		sql  = sql.replace("#{custom_mode_id}",String.valueOf(t.getCustomModeId()));
 		sql  = sql.replace("#{custom_duration_id}",String.valueOf(t.getCustomDurationId()));
 		sql  = sql.replace("#{custom_visa_id}",String.valueOf(t.getCustomVisaId()));
 		sql  = sql.replace("#{setouttime}",String.valueOf(t.getSetouttime()));
 		sql  = sql.replace("#{contacts1}",String.valueOf(t.getContacts1()));
 		sql  = sql.replace("#{phone1}",String.valueOf(t.getPhone1()));
 		sql  = sql.replace("#{contacts2}",String.valueOf(t.getContacts2()));
 		sql  = sql.replace("#{phone2}",String.valueOf(t.getPhone2()));
 		sql  = sql.replace("#{result}",String.valueOf(t.getResult()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}