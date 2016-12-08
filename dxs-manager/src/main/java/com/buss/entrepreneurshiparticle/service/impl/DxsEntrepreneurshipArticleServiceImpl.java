package com.buss.entrepreneurshiparticle.service.impl;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.entrepreneurshiparticle.service.DxsEntrepreneurshipArticleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entrepreneurshiparticle.entity.DxsEntrepreneurshipArticleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEntrepreneurshipArticleService")
@Transactional
public class DxsEntrepreneurshipArticleServiceImpl extends CommonServiceImpl implements DxsEntrepreneurshipArticleServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_JIDI);
	}
	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEntrepreneurshipArticleEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEntrepreneurshipArticleEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEntrepreneurshipArticleEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEntrepreneurshipArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEntrepreneurshipArticleEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEntrepreneurshipArticleEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEntrepreneurshipArticleEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{entrepreneurship_catelog_id}",String.valueOf(t.getEntrepreneurshipCatelogId()));
 		sql  = sql.replace("#{entrepreneurship_imgurl}",String.valueOf(t.getEntrepreneurshipImgurl()));
 		sql  = sql.replace("#{entrepreneurship_title}",String.valueOf(t.getEntrepreneurshipTitle()));
 		sql  = sql.replace("#{entrepreneurship_editor}",String.valueOf(t.getEntrepreneurshipEditor()));
 		sql  = sql.replace("#{entrepreneurship_publish_time}",String.valueOf(t.getEntrepreneurshipPublishTime()));
 		sql  = sql.replace("#{entrepreneurship_contents}",String.valueOf(t.getEntrepreneurshipContents()));
 		sql  = sql.replace("#{entrepreneurship_sort}",String.valueOf(t.getEntrepreneurshipSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}