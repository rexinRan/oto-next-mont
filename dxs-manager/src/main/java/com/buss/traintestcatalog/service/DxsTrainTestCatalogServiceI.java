package com.buss.traintestcatalog.service;
import com.buss.traintestcatalog.entity.DxsTrainTestCatalogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DxsTrainTestCatalogServiceI extends CommonService{
	
 	public <T> void delete(T entity);
 	
 	public <T> Serializable save(T entity);
 	
 	public <T> void saveOrUpdate(T entity);
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainTestCatalogEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainTestCatalogEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainTestCatalogEntity t);
}
