package com.buss.specialrecruitapply.service.impl;
import com.buss.specialrecruitapply.service.DxsSpecialRecruitApplyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialrecruitapply.entity.DxsSpecialRecruitApplyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialRecruitApplyService")
@Transactional
public class DxsSpecialRecruitApplyServiceImpl extends CommonServiceImpl implements DxsSpecialRecruitApplyServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialRecruitApplyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialRecruitApplyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialRecruitApplyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialRecruitApplyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialRecruitApplyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialRecruitApplyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialRecruitApplyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{sr_id}",String.valueOf(t.getSrId()));
 		sql  = sql.replace("#{privince}",String.valueOf(t.getPrivince()));
 		sql  = sql.replace("#{employ_direction}",String.valueOf(t.getEmployDirection()));
 		sql  = sql.replace("#{employ_school}",String.valueOf(t.getEmploySchool()));
 		sql  = sql.replace("#{file_id}",String.valueOf(t.getFileId()));
 		sql  = sql.replace("#{is_handle}",String.valueOf(t.getIsHandle()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}