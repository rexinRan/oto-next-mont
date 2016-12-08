package com.buss.specials.service.impl;
import com.buss.specials.service.DxsSpecialsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specials.entity.DxsSpecialsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialsService")
@Transactional
public class DxsSpecialsServiceImpl extends CommonServiceImpl implements DxsSpecialsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{introduce}",String.valueOf(t.getIntroduce()));
 		sql  = sql.replace("#{video_url}",String.valueOf(t.getVideoUrl()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{volunteer_obj}",String.valueOf(t.getVolunteerObj()));
 		sql  = sql.replace("#{volunteer_join_type}",String.valueOf(t.getVolunteerJoinType()));
 		sql  = sql.replace("#{volunteer_service}",String.valueOf(t.getVolunteerService()));
 		sql  = sql.replace("#{volunteer_assessment}",String.valueOf(t.getVolunteerAssessment()));
 		sql  = sql.replace("#{volunteer_works}",String.valueOf(t.getVolunteerWorks()));
 		sql  = sql.replace("#{volunteer_active}",String.valueOf(t.getVolunteerActive()));
 		sql  = sql.replace("#{volunteer_teach}",String.valueOf(t.getVolunteerTeach()));
 		sql  = sql.replace("#{volunteer_manager}",String.valueOf(t.getVolunteerManager()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{type}",String.valueOf(t.getType()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}