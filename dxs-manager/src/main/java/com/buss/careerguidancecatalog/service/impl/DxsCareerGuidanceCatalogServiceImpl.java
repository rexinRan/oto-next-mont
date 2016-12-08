package com.buss.careerguidancecatalog.service.impl;
import com.buss.careerguidancecatalog.service.DxsCareerGuidanceCatalogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.careerguidancecatalog.entity.DxsCareerGuidanceCatalogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsCareerGuidanceCatalogService")
@Transactional
public class DxsCareerGuidanceCatalogServiceImpl extends CommonServiceImpl implements DxsCareerGuidanceCatalogServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsCareerGuidanceCatalogEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsCareerGuidanceCatalogEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsCareerGuidanceCatalogEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsCareerGuidanceCatalogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsCareerGuidanceCatalogEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsCareerGuidanceCatalogEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsCareerGuidanceCatalogEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{cg_catelog_name}",String.valueOf(t.getCgCatelogName()));
 		sql  = sql.replace("#{cg_catelog_describe}",String.valueOf(t.getCgCatelogDescribe()));
 		sql  = sql.replace("#{cg_catelog_img}",String.valueOf(t.getCgCatelogImg()));
 		sql  = sql.replace("#{cg_catelog_position}",String.valueOf(t.getCgCatelogPosition()));
 		sql  = sql.replace("#{pid}",String.valueOf(t.getPid()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}