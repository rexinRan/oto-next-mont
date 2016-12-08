package com.buss.entrepreneurshipcatalog.service.impl;
import com.buss.entrepreneurshipcatalog.service.DxsEntrepreneurshipCatalogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entrepreneurshipcatalog.entity.DxsEntrepreneurshipCatalogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEntrepreneurshipCatalogService")
@Transactional
public class DxsEntrepreneurshipCatalogServiceImpl extends CommonServiceImpl implements DxsEntrepreneurshipCatalogServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEntrepreneurshipCatalogEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEntrepreneurshipCatalogEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEntrepreneurshipCatalogEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEntrepreneurshipCatalogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEntrepreneurshipCatalogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEntrepreneurshipCatalogEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEntrepreneurshipCatalogEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{entrepreneurship_catalog_name}",String.valueOf(t.getEntrepreneurshipCatalogName()));
 		sql  = sql.replace("#{entrepreneurship_img}",String.valueOf(t.getEntrepreneurshipImg()));
 		sql  = sql.replace("#{entrepreneurship_introduction}",String.valueOf(t.getEntrepreneurshipIntroduction()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}