package com.buss.activecatelog.service.impl;
import com.buss.activecatelog.service.DxsActiveCatelogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activecatelog.entity.DxsActiveCatelogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActiveCatelogService")
@Transactional
public class DxsActiveCatelogServiceImpl extends CommonServiceImpl implements DxsActiveCatelogServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActiveCatelogEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActiveCatelogEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActiveCatelogEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActiveCatelogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActiveCatelogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActiveCatelogEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActiveCatelogEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_catelog_name}",String.valueOf(t.getActiveCatelogName()));
 		sql  = sql.replace("#{active_catelog_img}",String.valueOf(t.getActiveCatelogImg()));
 		sql  = sql.replace("#{active_catelog_describe}",String.valueOf(t.getActiveCatelogDescribe()));
 		sql  = sql.replace("#{active_catelog_sort}",String.valueOf(t.getActiveCatelogSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}