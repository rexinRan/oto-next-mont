package com.buss.competition.service.impl;
import com.buss.competition.service.DxsCompetitionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.competition.entity.DxsCompetitionEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsCompetitionService")
@Transactional
public class DxsCompetitionServiceImpl extends CommonServiceImpl implements DxsCompetitionServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsCompetitionEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsCompetitionEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsCompetitionEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsCompetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsCompetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsCompetitionEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsCompetitionEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{competition_title}",String.valueOf(t.getCompetitionTitle()));
 		sql  = sql.replace("#{competition_organisers}",String.valueOf(t.getCompetitionOrganisers()));
 		sql  = sql.replace("#{competition_introduce}",String.valueOf(t.getCompetitionIntroduce()));
 		sql  = sql.replace("#{competition_start_time}",String.valueOf(t.getCompetitionStartTime()));
 		sql  = sql.replace("#{competition_end_time}",String.valueOf(t.getCompetitionEndTime()));
 		sql  = sql.replace("#{competition_areas}",String.valueOf(t.getCompetitionAreas()));
 		sql  = sql.replace("#{competition_topic}",String.valueOf(t.getCompetitionTopic()));
 		sql  = sql.replace("#{competition_object}",String.valueOf(t.getCompetitionObject()));
 		sql  = sql.replace("#{competition_rule}",String.valueOf(t.getCompetitionRule()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}