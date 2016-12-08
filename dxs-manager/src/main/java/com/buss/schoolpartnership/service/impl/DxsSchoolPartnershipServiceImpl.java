package com.buss.schoolpartnership.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.schoolpartnership.entity.DxsSchoolPartnershipEntity;
import com.buss.schoolpartnership.service.DxsSchoolPartnershipServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsSchoolPartnershipService")
@Transactional
public class DxsSchoolPartnershipServiceImpl extends CommonServiceImpl implements DxsSchoolPartnershipServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_HEZUO_SCHOOL);
	}
	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSchoolPartnershipEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSchoolPartnershipEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSchoolPartnershipEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSchoolPartnershipEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSchoolPartnershipEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSchoolPartnershipEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSchoolPartnershipEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{logo_img}",String.valueOf(t.getLogoImg()));
 		sql  = sql.replace("#{school_name}",String.valueOf(t.getSchoolName()));
 		sql  = sql.replace("#{school_introduce}",String.valueOf(t.getSchoolIntroduce()));
 		sql  = sql.replace("#{school_scenery}",String.valueOf(t.getSchoolScenery()));
 		sql  = sql.replace("#{school_display}",String.valueOf(t.getSchoolDisplay()));
 		sql  = sql.replace("#{school_real_address}",String.valueOf(t.getSchoolRealAddress()));
 		sql  = sql.replace("#{school_net_address}",String.valueOf(t.getSchoolNetAddress()));
 		sql  = sql.replace("#{school_phone}",String.valueOf(t.getSchoolPhone()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}