package com.buss.indexarticle.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.indexarticle.entity.DxsIndexArticleEntity;
import com.buss.indexarticle.service.DxsIndexArticleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsIndexArticleService")
@Transactional
public class DxsIndexArticleServiceImpl extends CommonServiceImpl implements DxsIndexArticleServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(DxsIndexArticleEntity t){
		String key = CacheKey.INDEX_ARTICLE_CAT_+t.getIndexCatelogId();
		redisClient.remove(key);
	}

 	public <T> void delete(T entity) {
		this.redisRemove((DxsIndexArticleEntity)entity);
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsIndexArticleEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove((DxsIndexArticleEntity)entity);
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsIndexArticleEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove((DxsIndexArticleEntity)entity);
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsIndexArticleEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsIndexArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsIndexArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsIndexArticleEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsIndexArticleEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{index_catelog_id}",String.valueOf(t.getIndexCatelogId()));
 		sql  = sql.replace("#{article_title}",String.valueOf(t.getArticleTitle()));
 		sql  = sql.replace("#{article_editor}",String.valueOf(t.getArticleEditor()));
 		sql  = sql.replace("#{article_publish_time}",String.valueOf(t.getArticlePublishTime()));
 		sql  = sql.replace("#{article_introduction}",String.valueOf(t.getArticleIntroduction()));
 		sql  = sql.replace("#{article_contents}",String.valueOf(t.getArticleContents()));
 		sql  = sql.replace("#{article_sort}",String.valueOf(t.getArticleSort()));
 		sql  = sql.replace("#{article_img_url}",String.valueOf(t.getArticleImgUrl()));
 		sql  = sql.replace("#{article_video_url}",String.valueOf(t.getArticleVideoUrl()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}