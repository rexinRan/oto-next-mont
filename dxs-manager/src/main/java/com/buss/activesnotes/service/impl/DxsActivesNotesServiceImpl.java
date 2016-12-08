package com.buss.activesnotes.service.impl;
import com.buss.activesnotes.service.DxsActivesNotesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesnotes.entity.DxsActivesNotesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesNotesService")
@Transactional
public class DxsActivesNotesServiceImpl extends CommonServiceImpl implements DxsActivesNotesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesNotesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesNotesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesNotesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesNotesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesNotesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesNotesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesNotesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{video_url}",String.valueOf(t.getVideoUrl()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{editor}",String.valueOf(t.getEditor()));
 		sql  = sql.replace("#{publish_time}",String.valueOf(t.getPublishTime()));
 		sql  = sql.replace("#{summary}",String.valueOf(t.getSummary()));
 		sql  = sql.replace("#{contents}",String.valueOf(t.getContents()));
 		sql  = sql.replace("#{publish_year}",String.valueOf(t.getPublishYear()));
 		sql  = sql.replace("#{countrys}",String.valueOf(t.getCountrys()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}