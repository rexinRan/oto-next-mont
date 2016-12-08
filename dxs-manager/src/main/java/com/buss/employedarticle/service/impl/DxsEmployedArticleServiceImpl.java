package com.buss.employedarticle.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.employedarticle.entity.DxsEmployedArticleEntity;
import com.buss.employedarticle.service.DxsEmployedArticleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsEmployedArticleService")
@Transactional
public class DxsEmployedArticleServiceImpl extends CommonServiceImpl implements DxsEmployedArticleServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_ARTICLE_EMP);
	}
	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEmployedArticleEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEmployedArticleEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEmployedArticleEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEmployedArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEmployedArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEmployedArticleEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEmployedArticleEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{emoloyed_catelog_id}",String.valueOf(t.getEmoloyedCatelogId()));
 		sql  = sql.replace("#{emoloyed_title}",String.valueOf(t.getEmoloyedTitle()));
 		sql  = sql.replace("#{emoloyed_editor}",String.valueOf(t.getEmoloyedEditor()));
 		sql  = sql.replace("#{emoloyed_publish_time}",String.valueOf(t.getEmoloyedPublishTime()));
 		sql  = sql.replace("#{emoloyed_imgurl}",String.valueOf(t.getEmoloyedImgurl()));
 		sql  = sql.replace("#{emoloyed_contents}",String.valueOf(t.getEmoloyedContents()));
 		sql  = sql.replace("#{emoloyed_sort}",String.valueOf(t.getEmoloyedSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}