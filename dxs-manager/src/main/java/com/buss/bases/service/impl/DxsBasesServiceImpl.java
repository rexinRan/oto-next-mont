package com.buss.bases.service.impl;
import com.buss.bases.service.DxsBasesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.bases.entity.DxsBasesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsBasesService")
@Transactional
public class DxsBasesServiceImpl extends CommonServiceImpl implements DxsBasesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsBasesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsBasesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsBasesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsBasesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsBasesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsBasesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsBasesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{base_name}",String.valueOf(t.getBaseName()));
 		sql  = sql.replace("#{base_img_fid}",String.valueOf(t.getBaseImgFid()));
 		sql  = sql.replace("#{base_img_url}",String.valueOf(t.getBaseImgUrl()));
 		sql  = sql.replace("#{base_video_fid}",String.valueOf(t.getBaseVideoFid()));
 		sql  = sql.replace("#{base_video_url}",String.valueOf(t.getBaseVideoUrl()));
 		sql  = sql.replace("#{base_introduce}",String.valueOf(t.getBaseIntroduce()));
 		sql  = sql.replace("#{base_unit_name}",String.valueOf(t.getBaseUnitName()));
 		sql  = sql.replace("#{base_class}",String.valueOf(t.getBaseClass()));
 		sql  = sql.replace("#{base_policy}",String.valueOf(t.getBasePolicy()));
 		sql  = sql.replace("#{base_guide}",String.valueOf(t.getBaseGuide()));
 		sql  = sql.replace("#{base_address}",String.valueOf(t.getBaseAddress()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}