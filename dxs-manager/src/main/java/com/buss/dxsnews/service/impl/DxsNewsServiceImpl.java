package com.buss.dxsnews.service.impl;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.dxsnews.entity.DxsNewsEntity;
import com.buss.dxsnews.service.DxsNewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

@Service("dxsNewsService")
@Transactional
public class DxsNewsServiceImpl extends CommonServiceImpl implements DxsNewsServiceI {

	@Resource
	private RedisClient redisClient;

	/**
	 * 清理redis缓存
	 * @param t
     */
	public void redisRemove(DxsNewsEntity t){
//		String key = CacheKey.INDEX_NEWS_CAT_+t.getNewCatelogId();
		for (int n=1;n<10;n++){
			redisClient.remove(CacheKey.INDEX_NEWS_CAT_+n);
		}

		if(t.getIsSpecial()==1){
			redisClient.remove(CacheKey.INDEX_NEWS_SPECIAL);
		}
//		System.out.println("#### redis remove key:"+key+" sussess! ####");
	}

 	public <T> void delete(T entity) {
		this.redisRemove((DxsNewsEntity)entity);
		super.delete(entity);
		//执行删除操作配置的sql增强
		this.doDelSql((DxsNewsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove((DxsNewsEntity)entity);
		Serializable t = super.save(entity);
		//执行新增操作配置的sql增强
		this.doAddSql((DxsNewsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove((DxsNewsEntity)entity);
		super.saveOrUpdate(entity);
		//执行更新操作配置的sql增强
		this.doUpdateSql((DxsNewsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @return
	 */
 	public boolean doAddSql(DxsNewsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @return
	 */
 	public boolean doUpdateSql(DxsNewsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @return
	 */
 	public boolean doDelSql(DxsNewsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsNewsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{new_catelog_id}",String.valueOf(t.getNewCatelogId()));
 		sql  = sql.replace("#{new_title}",String.valueOf(t.getNewTitle()));
 		sql  = sql.replace("#{new_editor}",String.valueOf(t.getNewEditor()));
 		sql  = sql.replace("#{new_publish_time}",String.valueOf(t.getNewPublishTime()));
 		sql  = sql.replace("#{new_contents}",String.valueOf(t.getNewContents()));
 		sql  = sql.replace("#{new_sort}",String.valueOf(t.getNewSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}