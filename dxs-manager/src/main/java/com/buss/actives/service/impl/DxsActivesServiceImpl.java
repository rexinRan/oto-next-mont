package com.buss.actives.service.impl;
import com.buss.actives.service.DxsActivesServiceI;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.actives.entity.DxsActivesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesService")
@Transactional
public class DxsActivesServiceImpl extends CommonServiceImpl implements DxsActivesServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_ACTIVES);
		redisClient.remove(CacheKey.INDEX_ACTIVES_PID);
		redisClient.remove(CacheKey.INDEX_ACTIVES_6);
	}
 	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_catelog_id}",String.valueOf(t.getActiveCatelogId()));
 		sql  = sql.replace("#{active_title}",String.valueOf(t.getActiveTitle()));
 		sql  = sql.replace("#{active_state_time}",String.valueOf(t.getActiveStateTime()));
 		sql  = sql.replace("#{active_end_time}",String.valueOf(t.getActiveEndTime()));
 		sql  = sql.replace("#{active_usertype_id}",String.valueOf(t.getActiveUsertypeId()));
 		sql  = sql.replace("#{active_content}",String.valueOf(t.getActiveContent()));
 		sql  = sql.replace("#{active_price}",String.valueOf(t.getActivePrice()));
 		sql  = sql.replace("#{is_charge}",String.valueOf(t.getIsCharge()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}