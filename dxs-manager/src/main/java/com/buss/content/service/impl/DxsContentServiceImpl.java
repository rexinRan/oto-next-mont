package com.buss.content.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.content.entity.DxsContentEntity;
import com.buss.content.service.DxsContentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsContentService")
@Transactional
public class DxsContentServiceImpl extends CommonServiceImpl implements DxsContentServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(DxsContentEntity t){
		String key = "INDEX_BANNER_"+t.getCid();
		redisClient.remove(key);
	}

 	public <T> void delete(T entity) {
		this.redisRemove((DxsContentEntity)entity);
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsContentEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove((DxsContentEntity)entity);
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsContentEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove((DxsContentEntity)entity);
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsContentEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsContentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsContentEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsContentEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsContentEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{cid}",String.valueOf(t.getCid()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{sub_title}",String.valueOf(t.getSubTitle()));
 		sql  = sql.replace("#{title_desc}",String.valueOf(t.getTitleDesc()));
 		sql  = sql.replace("#{sortid}",String.valueOf(t.getSortid()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{url}",String.valueOf(t.getUrl()));
 		sql  = sql.replace("#{pic}",String.valueOf(t.getPic()));
 		sql  = sql.replace("#{created}",String.valueOf(t.getCreated()));
 		sql  = sql.replace("#{updated}",String.valueOf(t.getUpdated()));
 		sql  = sql.replace("#{ext1}",String.valueOf(t.getExt1()));
 		sql  = sql.replace("#{ext2}",String.valueOf(t.getExt2()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}