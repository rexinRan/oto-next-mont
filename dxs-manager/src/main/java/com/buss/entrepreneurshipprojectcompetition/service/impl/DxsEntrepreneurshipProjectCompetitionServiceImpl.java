package com.buss.entrepreneurshipprojectcompetition.service.impl;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.entrepreneurshipprojectcompetition.service.DxsEntrepreneurshipProjectCompetitionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.entrepreneurshipprojectcompetition.entity.DxsEntrepreneurshipProjectCompetitionEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEntrepreneurshipProjectCompetitionService")
@Transactional
public class DxsEntrepreneurshipProjectCompetitionServiceImpl extends CommonServiceImpl implements DxsEntrepreneurshipProjectCompetitionServiceI {

	@Resource
	private RedisClient redisClient;
	/**
	 * 清理redis缓存
	 * @param t
	 */
	public void redisRemove(){
		redisClient.remove(CacheKey.INDEX_PROJECT);
	}
	public <T> void delete(T entity) {
		this.redisRemove();
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEntrepreneurshipProjectCompetitionEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
		this.redisRemove();
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEntrepreneurshipProjectCompetitionEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
		this.redisRemove();
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEntrepreneurshipProjectCompetitionEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEntrepreneurshipProjectCompetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEntrepreneurshipProjectCompetitionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEntrepreneurshipProjectCompetitionEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEntrepreneurshipProjectCompetitionEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{project_area_id}",String.valueOf(t.getProjectAreaId()));
 		sql  = sql.replace("#{project_type_id}",String.valueOf(t.getProjectTypeId()));
 		sql  = sql.replace("#{project_name}",String.valueOf(t.getProjectName()));
 		sql  = sql.replace("#{project_catalog}",String.valueOf(t.getProjectCatalog()));
 		sql  = sql.replace("#{project_start_time}",String.valueOf(t.getProjectStartTime()));
 		sql  = sql.replace("#{project_end_time}",String.valueOf(t.getProjectEndTime()));
 		sql  = sql.replace("#{project_status}",String.valueOf(t.getProjectStatus()));
 		sql  = sql.replace("#{project_profile}",String.valueOf(t.getProjectProfile()));
 		sql  = sql.replace("#{check_code}",String.valueOf(t.getCheckCode()));
 		sql  = sql.replace("#{project_imgurl}",String.valueOf(t.getProjectImgurl()));
 		sql  = sql.replace("#{project_grade}",String.valueOf(t.getProjectGrade()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}