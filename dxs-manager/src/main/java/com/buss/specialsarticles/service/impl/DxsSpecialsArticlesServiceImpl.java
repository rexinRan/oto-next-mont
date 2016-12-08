package com.buss.specialsarticles.service.impl;
import com.buss.specialsarticles.service.DxsSpecialsArticlesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.specialsarticles.entity.DxsSpecialsArticlesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsSpecialsArticlesService")
@Transactional
public class DxsSpecialsArticlesServiceImpl extends CommonServiceImpl implements DxsSpecialsArticlesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsSpecialsArticlesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsSpecialsArticlesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsSpecialsArticlesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsSpecialsArticlesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsSpecialsArticlesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsSpecialsArticlesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsSpecialsArticlesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{special_id}",String.valueOf(t.getSpecialId()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{autor}",String.valueOf(t.getAutor()));
 		sql  = sql.replace("#{sources}",String.valueOf(t.getSources()));
 		sql  = sql.replace("#{publish_time}",String.valueOf(t.getPublishTime()));
 		sql  = sql.replace("#{address_area}",String.valueOf(t.getAddressArea()));
 		sql  = sql.replace("#{time_year}",String.valueOf(t.getTimeYear()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{video_url}",String.valueOf(t.getVideoUrl()));
 		sql  = sql.replace("#{summary}",String.valueOf(t.getSummary()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{cate_log}",String.valueOf(t.getCateLog()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}