package com.buss.activespainting.service.impl;
import com.buss.activespainting.service.DxsActivesPaintingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activespainting.entity.DxsActivesPaintingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesPaintingService")
@Transactional
public class DxsActivesPaintingServiceImpl extends CommonServiceImpl implements DxsActivesPaintingServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesPaintingEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesPaintingEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesPaintingEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesPaintingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesPaintingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesPaintingEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesPaintingEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_id}",String.valueOf(t.getActiveId()));
 		sql  = sql.replace("#{co_organizer}",String.valueOf(t.getCoOrganizer()));
 		sql  = sql.replace("#{undertaking_unit}",String.valueOf(t.getUndertakingUnit()));
 		sql  = sql.replace("#{supporting_unit}",String.valueOf(t.getSupportingUnit()));
 		sql  = sql.replace("#{support_unit}",String.valueOf(t.getSupportUnit()));
 		sql  = sql.replace("#{media_unit}",String.valueOf(t.getMediaUnit()));
 		sql  = sql.replace("#{host_provinces}",String.valueOf(t.getHostProvinces()));
 		sql  = sql.replace("#{activity_flow}",String.valueOf(t.getActivityFlow()));
 		sql  = sql.replace("#{object_required}",String.valueOf(t.getObjectRequired()));
 		sql  = sql.replace("#{img_urls}",String.valueOf(t.getImgUrls()));
 		sql  = sql.replace("#{time_flows}",String.valueOf(t.getTimeFlows()));
 		sql  = sql.replace("#{others}",String.valueOf(t.getOthers()));
 		sql  = sql.replace("#{catalog_childs}",String.valueOf(t.getCatalogChilds()));
 		sql  = sql.replace("#{send_email}",String.valueOf(t.getSendEmail()));
 		sql  = sql.replace("#{email_style}",String.valueOf(t.getEmailStyle()));
 		sql  = sql.replace("#{send_address}",String.valueOf(t.getSendAddress()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}