package com.buss.trainoutlinecourseclasses.service.impl;
import com.buss.trainoutlinecourseclasses.service.DxsTrainOutlineCourseClassesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.trainoutlinecourseclasses.entity.DxsTrainOutlineCourseClassesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainOutlineCourseClassesService")
@Transactional
public class DxsTrainOutlineCourseClassesServiceImpl extends CommonServiceImpl implements DxsTrainOutlineCourseClassesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainOutlineCourseClassesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainOutlineCourseClassesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainOutlineCourseClassesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainOutlineCourseClassesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainOutlineCourseClassesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainOutlineCourseClassesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainOutlineCourseClassesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{toc_id}",String.valueOf(t.getTocId()));
 		sql  = sql.replace("#{open_time}",String.valueOf(t.getOpenTime()));
 		sql  = sql.replace("#{address_short}",String.valueOf(t.getAddressShort()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{time}",String.valueOf(t.getTime()));
 		sql  = sql.replace("#{start_class}",String.valueOf(t.getStartClass()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}