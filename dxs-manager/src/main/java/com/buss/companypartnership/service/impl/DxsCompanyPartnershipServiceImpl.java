package com.buss.companypartnership.service.impl;
import com.buss.companypartnership.service.DxsCompanyPartnershipServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.companypartnership.entity.DxsCompanyPartnershipEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsCompanyPartnershipService")
@Transactional
public class DxsCompanyPartnershipServiceImpl extends CommonServiceImpl implements DxsCompanyPartnershipServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsCompanyPartnershipEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsCompanyPartnershipEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsCompanyPartnershipEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsCompanyPartnershipEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsCompanyPartnershipEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsCompanyPartnershipEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsCompanyPartnershipEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{companyname}",String.valueOf(t.getCompanyname()));
 		sql  = sql.replace("#{jointime}",String.valueOf(t.getJointime()));
 		sql  = sql.replace("#{display_img}",String.valueOf(t.getDisplayImg()));
 		sql  = sql.replace("#{display_video}",String.valueOf(t.getDisplayVideo()));
 		sql  = sql.replace("#{introduction}",String.valueOf(t.getIntroduction()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}