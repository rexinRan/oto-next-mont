package com.buss.aidactives.service.impl;
import com.buss.aidactives.service.DxsAidActivesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.aidactives.entity.DxsAidActivesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsAidActivesService")
@Transactional
public class DxsAidActivesServiceImpl extends CommonServiceImpl implements DxsAidActivesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsAidActivesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsAidActivesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsAidActivesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsAidActivesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsAidActivesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsAidActivesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsAidActivesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{catalog}",String.valueOf(t.getCatalog()));
 		sql  = sql.replace("#{sponsor}",String.valueOf(t.getSponsor()));
 		sql  = sql.replace("#{publish_time}",String.valueOf(t.getPublishTime()));
 		sql  = sql.replace("#{deadline_date}",String.valueOf(t.getDeadlineDate()));
 		sql  = sql.replace("#{active_start_time}",String.valueOf(t.getActiveStartTime()));
 		sql  = sql.replace("#{active_end_time}",String.valueOf(t.getActiveEndTime()));
 		sql  = sql.replace("#{active_catelog}",String.valueOf(t.getActiveCatelog()));
 		sql  = sql.replace("#{active_number}",String.valueOf(t.getActiveNumber()));
 		sql  = sql.replace("#{active_address}",String.valueOf(t.getActiveAddress()));
 		sql  = sql.replace("#{active_introduce}",String.valueOf(t.getActiveIntroduce()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}