package com.buss.projects.service.impl;
import com.buss.projects.service.DxsProjectsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.projects.entity.DxsProjectsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsProjectsService")
@Transactional
public class DxsProjectsServiceImpl extends CommonServiceImpl implements DxsProjectsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsProjectsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsProjectsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsProjectsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsProjectsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsProjectsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsProjectsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsProjectsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{bc_id}",String.valueOf(t.getBcId()));
 		sql  = sql.replace("#{project_img}",String.valueOf(t.getProjectImg()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_industry}",String.valueOf(t.getProjectIndustry()));
 		sql  = sql.replace("#{project_type}",String.valueOf(t.getProjectType()));
 		sql  = sql.replace("#{is_school_technology}",String.valueOf(t.getIsSchoolTechnology()));
 		sql  = sql.replace("#{is_stock}",String.valueOf(t.getIsStock()));
 		sql  = sql.replace("#{team_name}",String.valueOf(t.getTeamName()));
 		sql  = sql.replace("#{project_introduce}",String.valueOf(t.getProjectIntroduce()));
 		sql  = sql.replace("#{project_progress}",String.valueOf(t.getProjectProgress()));
 		sql  = sql.replace("#{project_plan_fileurl}",String.valueOf(t.getProjectPlanFileurl()));
 		sql  = sql.replace("#{user_num}",String.valueOf(t.getUserNum()));
 		sql  = sql.replace("#{is_privacy}",String.valueOf(t.getIsPrivacy()));
 		sql  = sql.replace("#{is_end}",String.valueOf(t.getIsEnd()));
 		sql  = sql.replace("#{found_need}",String.valueOf(t.getFoundNeed()));
 		sql  = sql.replace("#{address_need}",String.valueOf(t.getAddressNeed()));
 		sql  = sql.replace("#{recruit_need}",String.valueOf(t.getRecruitNeed()));
 		sql  = sql.replace("#{join_type}",String.valueOf(t.getJoinType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_count}",String.valueOf(t.getUpdateCount()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}