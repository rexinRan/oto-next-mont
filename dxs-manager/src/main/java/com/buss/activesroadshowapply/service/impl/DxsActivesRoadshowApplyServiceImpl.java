package com.buss.activesroadshowapply.service.impl;
import com.buss.activesroadshowapply.service.DxsActivesRoadshowApplyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesroadshowapply.entity.DxsActivesRoadshowApplyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesRoadshowApplyService")
@Transactional
public class DxsActivesRoadshowApplyServiceImpl extends CommonServiceImpl implements DxsActivesRoadshowApplyServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesRoadshowApplyEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesRoadshowApplyEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesRoadshowApplyEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesRoadshowApplyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesRoadshowApplyEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesRoadshowApplyEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesRoadshowApplyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{company_address}",String.valueOf(t.getCompanyAddress()));
 		sql  = sql.replace("#{reg_found}",String.valueOf(t.getRegFound()));
 		sql  = sql.replace("#{company_introduce}",String.valueOf(t.getCompanyIntroduce()));
 		sql  = sql.replace("#{company_team_introduce}",String.valueOf(t.getCompanyTeamIntroduce()));
 		sql  = sql.replace("#{project_introduce}",String.valueOf(t.getProjectIntroduce()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_prospect}",String.valueOf(t.getProjectProspect()));
 		sql  = sql.replace("#{industry_advantage}",String.valueOf(t.getIndustryAdvantage()));
 		sql  = sql.replace("#{file_url}",String.valueOf(t.getFileUrl()));
 		sql  = sql.replace("#{file_id}",String.valueOf(t.getFileId()));
 		sql  = sql.replace("#{roadshow_need}",String.valueOf(t.getRoadshowNeed()));
 		sql  = sql.replace("#{result}",String.valueOf(t.getResult()));
 		sql  = sql.replace("#{message}",String.valueOf(t.getMessage()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}