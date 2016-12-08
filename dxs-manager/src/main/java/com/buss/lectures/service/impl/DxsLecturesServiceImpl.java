package com.buss.lectures.service.impl;
import com.buss.lectures.service.DxsLecturesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.lectures.entity.DxsLecturesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsLecturesService")
@Transactional
public class DxsLecturesServiceImpl extends CommonServiceImpl implements DxsLecturesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsLecturesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsLecturesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsLecturesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsLecturesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsLecturesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsLecturesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsLecturesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{acitve_id}",String.valueOf(t.getAcitveId()));
 		sql  = sql.replace("#{lp_id}",String.valueOf(t.getLpId()));
 		sql  = sql.replace("#{lecture_title}",String.valueOf(t.getLectureTitle()));
 		sql  = sql.replace("#{lecture_address_short}",String.valueOf(t.getLectureAddressShort()));
 		sql  = sql.replace("#{lecture_address}",String.valueOf(t.getLectureAddress()));
 		sql  = sql.replace("#{lecture_time}",String.valueOf(t.getLectureTime()));
 		sql  = sql.replace("#{lecture_content_summary}",String.valueOf(t.getLectureContentSummary()));
 		sql  = sql.replace("#{lecture_content_imgs}",String.valueOf(t.getLectureContentImgs()));
 		sql  = sql.replace("#{lecture_content}",String.valueOf(t.getLectureContent()));
 		sql  = sql.replace("#{lg_id}",String.valueOf(t.getLgId()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}