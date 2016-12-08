package com.buss.entrepreneurshipprojectarticle.service;
import com.buss.entrepreneurshipprojectarticle.entity.EntrepreneurshipProjectArticleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EntrepreneurshipProjectArticleServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(EntrepreneurshipProjectArticleEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(EntrepreneurshipProjectArticleEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(EntrepreneurshipProjectArticleEntity t);
}
