package com.buss.employed.service.impl;
import com.buss.employed.service.DxsEmployedServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.employed.entity.DxsEmployedEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEmployedService")
@Transactional
public class DxsEmployedServiceImpl extends CommonServiceImpl implements DxsEmployedServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEmployedEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEmployedEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEmployedEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEmployedEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEmployedEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEmployedEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEmployedEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{employed_catalog_id}",String.valueOf(t.getEmployedCatalogId()));
 		sql  = sql.replace("#{employed_name}",String.valueOf(t.getEmployedName()));
 		sql  = sql.replace("#{employed_position}",String.valueOf(t.getEmployedPosition()));
 		sql  = sql.replace("#{employed_salary}",String.valueOf(t.getEmployedSalary()));
 		sql  = sql.replace("#{employed_num}",String.valueOf(t.getEmployedNum()));
 		sql  = sql.replace("#{employed_responsibilities}",String.valueOf(t.getEmployedResponsibilities()));
 		sql  = sql.replace("#{employed_requirements}",String.valueOf(t.getEmployedRequirements()));
 		sql  = sql.replace("#{compancy_address}",String.valueOf(t.getCompancyAddress()));
 		sql  = sql.replace("#{contact_name}",String.valueOf(t.getContactName()));
 		sql  = sql.replace("#{contact_tel}",String.valueOf(t.getContactTel()));
 		sql  = sql.replace("#{contact_phone}",String.valueOf(t.getContactPhone()));
 		sql  = sql.replace("#{contact_mail}",String.valueOf(t.getContactMail()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}