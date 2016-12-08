package com.buss.company.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.company.entity.DxsCompanyEntity;
import com.buss.company.service.DxsCompanyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsCompanyService")
@Transactional
public class DxsCompanyServiceImpl extends CommonServiceImpl implements DxsCompanyServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_FOOTER_COMP);
	}
 	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsCompanyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsCompanyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsCompanyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsCompanyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsCompanyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsCompanyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsCompanyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{about}",String.valueOf(t.getAbout()));
 		sql  = sql.replace("#{group_tel}",String.valueOf(t.getGroupTel()));
 		sql  = sql.replace("#{group_service_tel}",String.valueOf(t.getGroupServiceTel()));
 		sql  = sql.replace("#{advertise_email}",String.valueOf(t.getAdvertiseEmail()));
 		sql  = sql.replace("#{group_address}",String.valueOf(t.getGroupAddress()));
 		sql  = sql.replace("#{copyright}",String.valueOf(t.getCopyright()));
 		sql  = sql.replace("#{record}",String.valueOf(t.getRecord()));
 		sql  = sql.replace("#{ext1}",String.valueOf(t.getExt1()));
 		sql  = sql.replace("#{ext2}",String.valueOf(t.getExt2()));
 		sql  = sql.replace("#{ext3}",String.valueOf(t.getExt3()));
 		sql  = sql.replace("#{ext4}",String.valueOf(t.getExt4()));
 		sql  = sql.replace("#{ext5}",String.valueOf(t.getExt5()));
 		sql  = sql.replace("#{ext6}",String.valueOf(t.getExt6()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}