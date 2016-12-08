package com.buss.specialrecruitjob.service.impl;
import com.buss.specialrecruitjob.service.DxsSpecialRecruitJobServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialrecruitjob.entity.DxsSpecialRecruitJobEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialRecruitJobService")
@Transactional
public class DxsSpecialRecruitJobServiceImpl extends CommonServiceImpl implements DxsSpecialRecruitJobServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialRecruitJobEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialRecruitJobEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialRecruitJobEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialRecruitJobEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialRecruitJobEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialRecruitJobEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialRecruitJobEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{sr_id}",String.valueOf(t.getSrId()));
 		sql  = sql.replace("#{sr_job_name}",String.valueOf(t.getSrJobName()));
 		sql  = sql.replace("#{sr_job_num}",String.valueOf(t.getSrJobNum()));
 		sql  = sql.replace("#{sr_job_salary}",String.valueOf(t.getSrJobSalary()));
 		sql  = sql.replace("#{sr_job_address}",String.valueOf(t.getSrJobAddress()));
 		sql  = sql.replace("#{sr_job_unit_id}",String.valueOf(t.getSrJobUnitId()));
 		sql  = sql.replace("#{sr_job_unit}",String.valueOf(t.getSrJobUnit()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}