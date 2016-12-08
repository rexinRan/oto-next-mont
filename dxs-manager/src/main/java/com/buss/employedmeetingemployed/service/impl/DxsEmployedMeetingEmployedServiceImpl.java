package com.buss.employedmeetingemployed.service.impl;
import com.buss.employedmeetingemployed.service.DxsEmployedMeetingEmployedServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.employedmeetingemployed.entity.DxsEmployedMeetingEmployedEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEmployedMeetingEmployedService")
@Transactional
public class DxsEmployedMeetingEmployedServiceImpl extends CommonServiceImpl implements DxsEmployedMeetingEmployedServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEmployedMeetingEmployedEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEmployedMeetingEmployedEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEmployedMeetingEmployedEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEmployedMeetingEmployedEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEmployedMeetingEmployedEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEmployedMeetingEmployedEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEmployedMeetingEmployedEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{employed_meeting_id}",String.valueOf(t.getEmployedMeetingId()));
 		sql  = sql.replace("#{employed_name}",String.valueOf(t.getEmployedName()));
 		sql  = sql.replace("#{employed_number}",String.valueOf(t.getEmployedNumber()));
 		sql  = sql.replace("#{employed_company}",String.valueOf(t.getEmployedCompany()));
 		sql  = sql.replace("#{employed_position}",String.valueOf(t.getEmployedPosition()));
 		sql  = sql.replace("#{employed_sort}",String.valueOf(t.getEmployedSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}