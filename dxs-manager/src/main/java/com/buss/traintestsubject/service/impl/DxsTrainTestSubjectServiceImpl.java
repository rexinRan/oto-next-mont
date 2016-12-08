package com.buss.traintestsubject.service.impl;
import com.buss.traintestsubject.service.DxsTrainTestSubjectServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.traintestsubject.entity.DxsTrainTestSubjectEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainTestSubjectService")
@Transactional
public class DxsTrainTestSubjectServiceImpl extends CommonServiceImpl implements DxsTrainTestSubjectServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainTestSubjectEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainTestSubjectEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainTestSubjectEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainTestSubjectEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainTestSubjectEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainTestSubjectEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainTestSubjectEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{tt_id}",String.valueOf(t.getTtId()));
 		sql  = sql.replace("#{subject_num}",String.valueOf(t.getSubjectNum()));
 		sql  = sql.replace("#{subject_content}",String.valueOf(t.getSubjectContent()));
 		sql  = sql.replace("#{test_content}",String.valueOf(t.getTestContent()));
 		sql  = sql.replace("#{subject_group}",String.valueOf(t.getSubjectGroup()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}