package com.buss.employedmeeting.service.impl;
import com.buss.employedmeeting.service.DxsEmployedMeetingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.employedmeeting.entity.DxsEmployedMeetingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsEmployedMeetingService")
@Transactional
public class DxsEmployedMeetingServiceImpl extends CommonServiceImpl implements DxsEmployedMeetingServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsEmployedMeetingEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsEmployedMeetingEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsEmployedMeetingEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsEmployedMeetingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsEmployedMeetingEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsEmployedMeetingEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsEmployedMeetingEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{emoloyed_catelog_id}",String.valueOf(t.getEmoloyedCatelogId()));
 		sql  = sql.replace("#{meeting_title}",String.valueOf(t.getMeetingTitle()));
 		sql  = sql.replace("#{meeting_imgurl}",String.valueOf(t.getMeetingImgurl()));
 		sql  = sql.replace("#{meeting_contents}",String.valueOf(t.getMeetingContents()));
 		sql  = sql.replace("#{meeting_sort}",String.valueOf(t.getMeetingSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}