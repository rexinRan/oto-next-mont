package com.buss.specialrecruitjobappointment.service.impl;
import com.buss.specialrecruitjobappointment.service.DxsSpecialRecruitJobAppointmentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialrecruitjobappointment.entity.DxsSpecialRecruitJobAppointmentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialRecruitJobAppointmentService")
@Transactional
public class DxsSpecialRecruitJobAppointmentServiceImpl extends CommonServiceImpl implements DxsSpecialRecruitJobAppointmentServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialRecruitJobAppointmentEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialRecruitJobAppointmentEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialRecruitJobAppointmentEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialRecruitJobAppointmentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialRecruitJobAppointmentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialRecruitJobAppointmentEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialRecruitJobAppointmentEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{srj_id}",String.valueOf(t.getSrjId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{appointment_type}",String.valueOf(t.getAppointmentType()));
 		sql  = sql.replace("#{appointment_time}",String.valueOf(t.getAppointmentTime()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}