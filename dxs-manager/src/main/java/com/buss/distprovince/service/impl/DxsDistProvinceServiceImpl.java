package com.buss.distprovince.service.impl;
import com.buss.distprovince.service.DxsDistProvinceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.distprovince.entity.DxsDistProvinceEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsDistProvinceService")
@Transactional
public class DxsDistProvinceServiceImpl extends CommonServiceImpl implements DxsDistProvinceServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsDistProvinceEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsDistProvinceEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsDistProvinceEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsDistProvinceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsDistProvinceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsDistProvinceEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsDistProvinceEntity t){
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{provinceid}",String.valueOf(t.getProvinceid()));
 		sql  = sql.replace("#{pname}",String.valueOf(t.getPname()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}