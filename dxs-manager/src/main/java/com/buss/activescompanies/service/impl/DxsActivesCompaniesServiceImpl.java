package com.buss.activescompanies.service.impl;
import com.buss.activescompanies.service.DxsActivesCompaniesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activescompanies.entity.DxsActivesCompaniesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesCompaniesService")
@Transactional
public class DxsActivesCompaniesServiceImpl extends CommonServiceImpl implements DxsActivesCompaniesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesCompaniesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesCompaniesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesCompaniesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesCompaniesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesCompaniesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesCompaniesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesCompaniesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{company_user_id}",String.valueOf(t.getCompanyUserId()));
 		sql  = sql.replace("#{active_id}",String.valueOf(t.getActiveId()));
 		sql  = sql.replace("#{company_address}",String.valueOf(t.getCompanyAddress()));
 		sql  = sql.replace("#{bus_num}",String.valueOf(t.getBusNum()));
 		sql  = sql.replace("#{company_name}",String.valueOf(t.getCompanyName()));
 		sql  = sql.replace("#{company_propress}",String.valueOf(t.getCompanyPropress()));
 		sql  = sql.replace("#{company_notes}",String.valueOf(t.getCompanyNotes()));
 		sql  = sql.replace("#{see_free}",String.valueOf(t.getSeeFree()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}