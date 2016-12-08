package com.buss.specialshiring.service.impl;
import com.buss.specialshiring.service.DxsSpecialsHiringServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialshiring.entity.DxsSpecialsHiringEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialsHiringService")
@Transactional
public class DxsSpecialsHiringServiceImpl extends CommonServiceImpl implements DxsSpecialsHiringServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialsHiringEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialsHiringEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialsHiringEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialsHiringEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialsHiringEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialsHiringEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialsHiringEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{specials_id}",String.valueOf(t.getSpecialsId()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{introduce}",String.valueOf(t.getIntroduce()));
 		sql  = sql.replace("#{hiring_range}",String.valueOf(t.getHiringRange()));
 		sql  = sql.replace("#{hiring_num}",String.valueOf(t.getHiringNum()));
 		sql  = sql.replace("#{hiring_major}",String.valueOf(t.getHiringMajor()));
 		sql  = sql.replace("#{hiring_condition}",String.valueOf(t.getHiringCondition()));
 		sql  = sql.replace("#{hiring_place}",String.valueOf(t.getHiringPlace()));
 		sql  = sql.replace("#{hiring_job}",String.valueOf(t.getHiringJob()));
 		sql  = sql.replace("#{hiring_net}",String.valueOf(t.getHiringNet()));
 		sql  = sql.replace("#{hiring_exam}",String.valueOf(t.getHiringExam()));
 		sql  = sql.replace("#{hiring_standard}",String.valueOf(t.getHiringStandard()));
 		sql  = sql.replace("#{hiring_interview}",String.valueOf(t.getHiringInterview()));
 		sql  = sql.replace("#{hiring_plan}",String.valueOf(t.getHiringPlan()));
 		sql  = sql.replace("#{hiring_experience}",String.valueOf(t.getHiringExperience()));
 		sql  = sql.replace("#{hiring_retest}",String.valueOf(t.getHiringRetest()));
 		sql  = sql.replace("#{hiring_report}",String.valueOf(t.getHiringReport()));
 		sql  = sql.replace("#{hiring_job_training}",String.valueOf(t.getHiringJobTraining()));
 		sql  = sql.replace("#{hiring_certiticates}",String.valueOf(t.getHiringCertiticates()));
 		sql  = sql.replace("#{hiring_contact}",String.valueOf(t.getHiringContact()));
 		sql  = sql.replace("#{hiring_enclosure_fid}",String.valueOf(t.getHiringEnclosureFid()));
 		sql  = sql.replace("#{hiring_enclosure_url}",String.valueOf(t.getHiringEnclosureUrl()));
 		sql  = sql.replace("#{hiring_project}",String.valueOf(t.getHiringProject()));
 		sql  = sql.replace("#{publish_company}",String.valueOf(t.getPublishCompany()));
 		sql  = sql.replace("#{publish_time}",String.valueOf(t.getPublishTime()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}