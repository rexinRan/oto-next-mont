package com.buss.activesdetails.service.impl;
import com.buss.activesdetails.service.DxsActivesDetailsServiceI;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesdetails.entity.DxsActivesDetailsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesDetailsService")
@Transactional
public class DxsActivesDetailsServiceImpl extends CommonServiceImpl implements DxsActivesDetailsServiceI {

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
		this.doDelSql((DxsActivesDetailsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesDetailsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesDetailsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesDetailsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesDetailsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesDetailsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesDetailsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{actives_id}",String.valueOf(t.getActivesId()));
 		sql  = sql.replace("#{recommended_reason}",String.valueOf(t.getRecommendedReason()));
 		sql  = sql.replace("#{cost_include}",String.valueOf(t.getCostInclude()));
 		sql  = sql.replace("#{cost_uninclude}",String.valueOf(t.getCostUninclude()));
 		sql  = sql.replace("#{visa_note}",String.valueOf(t.getVisaNote()));
 		sql  = sql.replace("#{preparation}",String.valueOf(t.getPreparation()));
 		sql  = sql.replace("#{payment_method}",String.valueOf(t.getPaymentMethod()));
 		sql  = sql.replace("#{common_problem}",String.valueOf(t.getCommonProblem()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}