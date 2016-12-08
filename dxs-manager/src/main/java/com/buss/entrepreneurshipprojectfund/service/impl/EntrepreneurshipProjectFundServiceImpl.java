package com.buss.entrepreneurshipprojectfund.service.impl;
import com.buss.entrepreneurshipprojectfund.service.EntrepreneurshipProjectFundServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entrepreneurshipprojectfund.entity.EntrepreneurshipProjectFundEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("entrepreneurshipProjectFundService")
@Transactional
public class EntrepreneurshipProjectFundServiceImpl extends CommonServiceImpl implements EntrepreneurshipProjectFundServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((EntrepreneurshipProjectFundEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((EntrepreneurshipProjectFundEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((EntrepreneurshipProjectFundEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(EntrepreneurshipProjectFundEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(EntrepreneurshipProjectFundEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(EntrepreneurshipProjectFundEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,EntrepreneurshipProjectFundEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{applyto_id}",String.valueOf(t.getApplytoId()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{is_patent}",String.valueOf(t.getIsPatent()));
 		sql  = sql.replace("#{project_introduce}",String.valueOf(t.getProjectIntroduce()));
 		sql  = sql.replace("#{projection_field}",String.valueOf(t.getProjectionField()));
 		sql  = sql.replace("#{projection_type}",String.valueOf(t.getProjectionType()));
 		sql  = sql.replace("#{projection_plan}",String.valueOf(t.getProjectionPlan()));
 		sql  = sql.replace("#{projection_progress}",String.valueOf(t.getProjectionProgress()));
 		sql  = sql.replace("#{projection_scope}",String.valueOf(t.getProjectionScope()));
 		sql  = sql.replace("#{check_code}",String.valueOf(t.getCheckCode()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}