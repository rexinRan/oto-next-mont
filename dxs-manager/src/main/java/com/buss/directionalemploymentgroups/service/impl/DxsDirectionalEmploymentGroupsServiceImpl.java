package com.buss.directionalemploymentgroups.service.impl;
import com.buss.directionalemploymentgroups.service.DxsDirectionalEmploymentGroupsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.directionalemploymentgroups.entity.DxsDirectionalEmploymentGroupsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsDirectionalEmploymentGroupsService")
@Transactional
public class DxsDirectionalEmploymentGroupsServiceImpl extends CommonServiceImpl implements DxsDirectionalEmploymentGroupsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsDirectionalEmploymentGroupsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsDirectionalEmploymentGroupsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsDirectionalEmploymentGroupsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsDirectionalEmploymentGroupsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsDirectionalEmploymentGroupsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsDirectionalEmploymentGroupsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsDirectionalEmploymentGroupsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{directional_employment_name}",String.valueOf(t.getDirectionalEmploymentName()));
 		sql  = sql.replace("#{direction_display_menu}",String.valueOf(t.getDirectionDisplayMenu()));
 		sql  = sql.replace("#{direction_publish_time}",String.valueOf(t.getDirectionPublishTime()));
 		sql  = sql.replace("#{cretate_time}",String.valueOf(t.getCretateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}