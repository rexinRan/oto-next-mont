package com.buss.activesmathch.service.impl;
import com.buss.activesmathch.service.DxsActivesMathchServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesmathch.entity.DxsActivesMathchEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesMathchService")
@Transactional
public class DxsActivesMathchServiceImpl extends CommonServiceImpl implements DxsActivesMathchServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesMathchEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesMathchEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesMathchEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesMathchEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesMathchEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesMathchEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesMathchEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_id}",String.valueOf(t.getActiveId()));
 		sql  = sql.replace("#{co_organizer}",String.valueOf(t.getCoOrganizer()));
 		sql  = sql.replace("#{undertaking_unit}",String.valueOf(t.getUndertakingUnit()));
 		sql  = sql.replace("#{supporting_unit}",String.valueOf(t.getSupportingUnit()));
 		sql  = sql.replace("#{support_unit}",String.valueOf(t.getSupportUnit()));
 		sql  = sql.replace("#{media_unit}",String.valueOf(t.getMediaUnit()));
 		sql  = sql.replace("#{object_required}",String.valueOf(t.getObjectRequired()));
 		sql  = sql.replace("#{guide}",String.valueOf(t.getGuide()));
 		sql  = sql.replace("#{origanze}",String.valueOf(t.getOriganze()));
 		sql  = sql.replace("#{news}",String.valueOf(t.getNews()));
 		sql  = sql.replace("#{video_url}",String.valueOf(t.getVideoUrl()));
 		sql  = sql.replace("#{imgurls}",String.valueOf(t.getImgurls()));
 		sql  = sql.replace("#{fid}",String.valueOf(t.getFid()));
 		sql  = sql.replace("#{time_flow}",String.valueOf(t.getTimeFlow()));
 		sql  = sql.replace("#{others}",String.valueOf(t.getOthers()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}