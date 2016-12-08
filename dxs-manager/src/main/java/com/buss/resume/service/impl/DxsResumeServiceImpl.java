package com.buss.resume.service.impl;
import com.buss.resume.service.DxsResumeServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.resume.entity.DxsResumeEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsResumeService")
@Transactional
public class DxsResumeServiceImpl extends CommonServiceImpl implements DxsResumeServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsResumeEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsResumeEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsResumeEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsResumeEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsResumeEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsResumeEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsResumeEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{borthday}",String.valueOf(t.getBorthday()));
 		sql  = sql.replace("#{residence}",String.valueOf(t.getResidence()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{idcard}",String.valueOf(t.getIdcard()));
 		sql  = sql.replace("#{school_name}",String.valueOf(t.getSchoolName()));
 		sql  = sql.replace("#{school_address}",String.valueOf(t.getSchoolAddress()));
 		sql  = sql.replace("#{school_admission}",String.valueOf(t.getSchoolAdmission()));
 		sql  = sql.replace("#{school_graduation}",String.valueOf(t.getSchoolGraduation()));
 		sql  = sql.replace("#{school_major}",String.valueOf(t.getSchoolMajor()));
 		sql  = sql.replace("#{school_education}",String.valueOf(t.getSchoolEducation()));
 		sql  = sql.replace("#{school_certificate}",String.valueOf(t.getSchoolCertificate()));
 		sql  = sql.replace("#{professional}",String.valueOf(t.getProfessional()));
 		sql  = sql.replace("#{self_assessment}",String.valueOf(t.getSelfAssessment()));
 		sql  = sql.replace("#{accessories}",String.valueOf(t.getAccessories()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}