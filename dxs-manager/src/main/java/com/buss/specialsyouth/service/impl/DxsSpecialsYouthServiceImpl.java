package com.buss.specialsyouth.service.impl;
import com.buss.specialsyouth.service.DxsSpecialsYouthServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialsyouth.entity.DxsSpecialsYouthEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialsYouthService")
@Transactional
public class DxsSpecialsYouthServiceImpl extends CommonServiceImpl implements DxsSpecialsYouthServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialsYouthEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialsYouthEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialsYouthEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialsYouthEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialsYouthEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialsYouthEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialsYouthEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{head_img_url}",String.valueOf(t.getHeadImgUrl()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{age}",String.valueOf(t.getAge()));
 		sql  = sql.replace("#{political}",String.valueOf(t.getPolitical()));
 		sql  = sql.replace("#{education}",String.valueOf(t.getEducation()));
 		sql  = sql.replace("#{persent_post}",String.valueOf(t.getPersentPost()));
 		sql  = sql.replace("#{work_place}",String.valueOf(t.getWorkPlace()));
 		sql  = sql.replace("#{major}",String.valueOf(t.getMajor()));
 		sql  = sql.replace("#{university}",String.valueOf(t.getUniversity()));
 		sql  = sql.replace("#{motto}",String.valueOf(t.getMotto()));
 		sql  = sql.replace("#{profile}",String.valueOf(t.getProfile()));
 		sql  = sql.replace("#{deeds}",String.valueOf(t.getDeeds()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{display_img01_fid}",String.valueOf(t.getDisplayImg01Fid()));
 		sql  = sql.replace("#{display_img01_url}",String.valueOf(t.getDisplayImg01Url()));
 		sql  = sql.replace("#{display_img02_fid}",String.valueOf(t.getDisplayImg02Fid()));
 		sql  = sql.replace("#{display_img02_url}",String.valueOf(t.getDisplayImg02Url()));
 		sql  = sql.replace("#{display_img03_fid}",String.valueOf(t.getDisplayImg03Fid()));
 		sql  = sql.replace("#{display_img03_url}",String.valueOf(t.getDisplayImg03Url()));
 		sql  = sql.replace("#{display_img04_fid}",String.valueOf(t.getDisplayImg04Fid()));
 		sql  = sql.replace("#{display_img04_url}",String.valueOf(t.getDisplayImg04Url()));
 		sql  = sql.replace("#{display_img05_fid}",String.valueOf(t.getDisplayImg05Fid()));
 		sql  = sql.replace("#{display_img05_url}",String.valueOf(t.getDisplayImg05Url()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}