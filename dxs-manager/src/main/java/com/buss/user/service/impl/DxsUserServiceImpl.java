package com.buss.user.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.user.entity.DxsUserEntity;
import com.buss.user.service.DxsUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsUserService")
@Transactional
public class DxsUserServiceImpl extends CommonServiceImpl implements DxsUserServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_HEZUO_COMPANY);
	}
	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsUserEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsUserEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsUserEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsUserEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsUserEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsUserEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsUserEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{realname}",String.valueOf(t.getRealname()));
 		sql  = sql.replace("#{rolecode}",String.valueOf(t.getRolecode()));
 		sql  = sql.replace("#{mphone}",String.valueOf(t.getMphone()));
 		sql  = sql.replace("#{pwd}",String.valueOf(t.getPwd()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{empname}",String.valueOf(t.getEmpname()));
 		sql  = sql.replace("#{empcode}",String.valueOf(t.getEmpcode()));
 		sql  = sql.replace("#{checkstatus}",String.valueOf(t.getCheckstatus()));
 		sql  = sql.replace("#{isdelete}",String.valueOf(t.getIsdelete()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}