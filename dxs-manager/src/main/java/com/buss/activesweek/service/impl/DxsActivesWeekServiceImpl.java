package com.buss.activesweek.service.impl;
import com.buss.activesweek.service.DxsActivesWeekServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesweek.entity.DxsActivesWeekEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesWeekService")
@Transactional
public class DxsActivesWeekServiceImpl extends CommonServiceImpl implements DxsActivesWeekServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesWeekEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesWeekEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesWeekEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesWeekEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesWeekEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesWeekEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesWeekEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_id}",String.valueOf(t.getActiveId()));
 		sql  = sql.replace("#{co_organizer}",String.valueOf(t.getCoOrganizer()));
 		sql  = sql.replace("#{undertaking_unit}",String.valueOf(t.getUndertakingUnit()));
 		sql  = sql.replace("#{supporting_unit}",String.valueOf(t.getSupportingUnit()));
 		sql  = sql.replace("#{support_unit}",String.valueOf(t.getSupportUnit()));
 		sql  = sql.replace("#{media_unit}",String.valueOf(t.getMediaUnit()));
 		sql  = sql.replace("#{school_name}",String.valueOf(t.getSchoolName()));
 		sql  = sql.replace("#{catalog_children}",String.valueOf(t.getCatalogChildren()));
 		sql  = sql.replace("#{active_schedule}",String.valueOf(t.getActiveSchedule()));
 		sql  = sql.replace("#{object_required}",String.valueOf(t.getObjectRequired()));
 		sql  = sql.replace("#{img_urls}",String.valueOf(t.getImgUrls()));
 		sql  = sql.replace("#{others}",String.valueOf(t.getOthers()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}