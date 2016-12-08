package com.buss.specialrecruit.service.impl;
import com.buss.specialrecruit.service.DxsSpecialRecruitServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialrecruit.entity.DxsSpecialRecruitEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialRecruitService")
@Transactional
public class DxsSpecialRecruitServiceImpl extends CommonServiceImpl implements DxsSpecialRecruitServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialRecruitEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialRecruitEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialRecruitEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialRecruitEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialRecruitEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialRecruitEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialRecruitEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{sp_school}",String.valueOf(t.getSpSchool()));
 		sql  = sql.replace("#{sp_imgurl_fid}",String.valueOf(t.getSpImgurlFid()));
 		sql  = sql.replace("#{sp_imgurl}",String.valueOf(t.getSpImgurl()));
 		sql  = sql.replace("#{sp_direction}",String.valueOf(t.getSpDirection()));
 		sql  = sql.replace("#{sp_job_num}",String.valueOf(t.getSpJobNum()));
 		sql  = sql.replace("#{sp_education}",String.valueOf(t.getSpEducation()));
 		sql  = sql.replace("#{hold_datatime}",String.valueOf(t.getHoldDatatime()));
 		sql  = sql.replace("#{hold_date}",String.valueOf(t.getHoldDate()));
 		sql  = sql.replace("#{hold_num}",String.valueOf(t.getHoldNum()));
 		sql  = sql.replace("#{sp_address}",String.valueOf(t.getSpAddress()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}