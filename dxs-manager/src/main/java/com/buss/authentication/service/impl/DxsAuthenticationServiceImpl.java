package com.buss.authentication.service.impl;
import com.buss.authentication.service.DxsAuthenticationServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsAuthenticationService")
@Transactional
public class DxsAuthenticationServiceImpl extends CommonServiceImpl implements DxsAuthenticationServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsAuthenticationEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsAuthenticationEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsAuthenticationEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsAuthenticationEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsAuthenticationEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsAuthenticationEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsAuthenticationEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{teacher_title}",String.valueOf(t.getTeacherTitle()));
 		sql  = sql.replace("#{certificate_id}",String.valueOf(t.getCertificateId()));
 		sql  = sql.replace("#{identify1_id}",String.valueOf(t.getIdentify1Id()));
 		sql  = sql.replace("#{identify2_id}",String.valueOf(t.getIdentify2Id()));
 		sql  = sql.replace("#{totur_type}",String.valueOf(t.getToturType()));
 		sql  = sql.replace("#{totur_skill}",String.valueOf(t.getToturSkill()));
 		sql  = sql.replace("#{is_train}",String.valueOf(t.getIsTrain()));
 		sql  = sql.replace("#{resume_id}",String.valueOf(t.getResumeId()));
 		sql  = sql.replace("#{work_id}",String.valueOf(t.getWorkId()));
 		sql  = sql.replace("#{authentication_result}",String.valueOf(t.getAuthenticationResult()));
 		sql  = sql.replace("#{authentication_message}",String.valueOf(t.getAuthenticationMessage()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}