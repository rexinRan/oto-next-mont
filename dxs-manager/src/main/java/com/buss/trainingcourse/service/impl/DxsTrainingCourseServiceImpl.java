package com.buss.trainingcourse.service.impl;
import com.buss.trainingcourse.service.DxsTrainingCourseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.trainingcourse.entity.DxsTrainingCourseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainingCourseService")
@Transactional
public class DxsTrainingCourseServiceImpl extends CommonServiceImpl implements DxsTrainingCourseServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainingCourseEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainingCourseEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainingCourseEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainingCourseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainingCourseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainingCourseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainingCourseEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{training_catelog_id}",String.valueOf(t.getTrainingCatelogId()));
 		sql  = sql.replace("#{course_name}",String.valueOf(t.getCourseName()));
 		sql  = sql.replace("#{course_teacher}",String.valueOf(t.getCourseTeacher()));
 		sql  = sql.replace("#{course_editor}",String.valueOf(t.getCourseEditor()));
 		sql  = sql.replace("#{course_publish_time}",String.valueOf(t.getCoursePublishTime()));
 		sql  = sql.replace("#{course_videourl}",String.valueOf(t.getCourseVideourl()));
 		sql  = sql.replace("#{course_introduce}",String.valueOf(t.getCourseIntroduce()));
 		sql  = sql.replace("#{course_sort}",String.valueOf(t.getCourseSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}