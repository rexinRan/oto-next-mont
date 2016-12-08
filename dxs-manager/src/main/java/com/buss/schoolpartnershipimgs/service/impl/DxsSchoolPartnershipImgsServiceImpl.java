package com.buss.schoolpartnershipimgs.service.impl;
import com.buss.schoolpartnershipimgs.service.DxsSchoolPartnershipImgsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.schoolpartnershipimgs.entity.DxsSchoolPartnershipImgsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSchoolPartnershipImgsService")
@Transactional
public class DxsSchoolPartnershipImgsServiceImpl extends CommonServiceImpl implements DxsSchoolPartnershipImgsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSchoolPartnershipImgsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSchoolPartnershipImgsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSchoolPartnershipImgsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSchoolPartnershipImgsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSchoolPartnershipImgsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSchoolPartnershipImgsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSchoolPartnershipImgsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{sp_id}",String.valueOf(t.getSpId()));
 		sql  = sql.replace("#{sp_img_fid}",String.valueOf(t.getSpImgFid()));
 		sql  = sql.replace("#{sp_img_url}",String.valueOf(t.getSpImgUrl()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}