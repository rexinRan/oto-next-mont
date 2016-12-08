package com.buss.common.service.impl;
import com.buss.common.service.DxsUserCompancyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.common.entity.DxsUserCompancyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsUserCompancyService")
@Transactional
public class DxsUserCompancyServiceImpl extends CommonServiceImpl implements DxsUserCompancyServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsUserCompancyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsUserCompancyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsUserCompancyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsUserCompancyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsUserCompancyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsUserCompancyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsUserCompancyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{compancy_name}",String.valueOf(t.getCompancyName()));
 		sql  = sql.replace("#{compancy_address}",String.valueOf(t.getCompancyAddress()));
 		sql  = sql.replace("#{display_img}",String.valueOf(t.getDisplayImg()));
 		sql  = sql.replace("#{display_video}",String.valueOf(t.getDisplayVideo()));
 		sql  = sql.replace("#{contact_name}",String.valueOf(t.getContactName()));
 		sql  = sql.replace("#{contact_tel}",String.valueOf(t.getContactTel()));
 		sql  = sql.replace("#{compancy_num}",String.valueOf(t.getCompancyNum()));
 		sql  = sql.replace("#{compancy_positation}",String.valueOf(t.getCompancyPositation()));
 		sql  = sql.replace("#{compancy_introduce}",String.valueOf(t.getCompancyIntroduce()));
 		sql  = sql.replace("#{compancy_type}",String.valueOf(t.getCompancyType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}