package com.buss.common.service.impl;
import com.buss.common.service.DxsUserDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.common.entity.DxsUserDetailEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsUserDetailService")
@Transactional
public class DxsUserDetailServiceImpl extends CommonServiceImpl implements DxsUserDetailServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsUserDetailEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsUserDetailEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsUserDetailEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsUserDetailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsUserDetailEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsUserDetailEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsUserDetailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{head_img}",String.valueOf(t.getHeadImg()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{body_hight}",String.valueOf(t.getBodyHight()));
 		sql  = sql.replace("#{body_weight}",String.valueOf(t.getBodyWeight()));
 		sql  = sql.replace("#{borthday}",String.valueOf(t.getBorthday()));
 		sql  = sql.replace("#{residence}",String.valueOf(t.getResidence()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{pre_native}",String.valueOf(t.getPreNative()));
 		sql  = sql.replace("#{idcard}",String.valueOf(t.getIdcard()));
 		sql  = sql.replace("#{qq}",String.valueOf(t.getQq()));
 		sql  = sql.replace("#{msn}",String.valueOf(t.getMsn()));
 		sql  = sql.replace("#{school_name}",String.valueOf(t.getSchoolName()));
 		sql  = sql.replace("#{school_address}",String.valueOf(t.getSchoolAddress()));
 		sql  = sql.replace("#{school_admission}",String.valueOf(t.getSchoolAdmission()));
 		sql  = sql.replace("#{school_graduation}",String.valueOf(t.getSchoolGraduation()));
 		sql  = sql.replace("#{school_major}",String.valueOf(t.getSchoolMajor()));
 		sql  = sql.replace("#{school_education}",String.valueOf(t.getSchoolEducation()));
 		sql  = sql.replace("#{school_certificate}",String.valueOf(t.getSchoolCertificate()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}