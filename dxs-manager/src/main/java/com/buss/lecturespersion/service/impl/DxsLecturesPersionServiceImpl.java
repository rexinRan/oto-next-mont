package com.buss.lecturespersion.service.impl;
import com.buss.lecturespersion.service.DxsLecturesPersionServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.lecturespersion.entity.DxsLecturesPersionEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsLecturesPersionService")
@Transactional
public class DxsLecturesPersionServiceImpl extends CommonServiceImpl implements DxsLecturesPersionServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsLecturesPersionEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsLecturesPersionEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsLecturesPersionEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsLecturesPersionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsLecturesPersionEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsLecturesPersionEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsLecturesPersionEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{proson_name}",String.valueOf(t.getProsonName()));
 		sql  = sql.replace("#{proson_job}",String.valueOf(t.getProsonJob()));
 		sql  = sql.replace("#{proson_address}",String.valueOf(t.getProsonAddress()));
 		sql  = sql.replace("#{proson_edu}",String.valueOf(t.getProsonEdu()));
 		sql  = sql.replace("#{proson_top_job}",String.valueOf(t.getProsonTopJob()));
 		sql  = sql.replace("#{proson_now_job}",String.valueOf(t.getProsonNowJob()));
 		sql  = sql.replace("#{proson_now_project}",String.valueOf(t.getProsonNowProject()));
 		sql  = sql.replace("#{proson_resume_display}",String.valueOf(t.getProsonResumeDisplay()));
 		sql  = sql.replace("#{proson_style_video}",String.valueOf(t.getProsonStyleVideo()));
 		sql  = sql.replace("#{proson_style}",String.valueOf(t.getProsonStyle()));
 		sql  = sql.replace("#{proson_accomplishment}",String.valueOf(t.getProsonAccomplishment()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}