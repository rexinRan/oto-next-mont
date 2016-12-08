package com.buss.founds.service.impl;
import com.buss.founds.service.DxsFoundsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.founds.entity.DxsFoundsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsFoundsService")
@Transactional
public class DxsFoundsServiceImpl extends CommonServiceImpl implements DxsFoundsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsFoundsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsFoundsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsFoundsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsFoundsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsFoundsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsFoundsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsFoundsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{found_title}",String.valueOf(t.getFoundTitle()));
 		sql  = sql.replace("#{found_img_fid}",String.valueOf(t.getFoundImgFid()));
 		sql  = sql.replace("#{found_user_name}",String.valueOf(t.getFoundUserName()));
 		sql  = sql.replace("#{found_industry}",String.valueOf(t.getFoundIndustry()));
 		sql  = sql.replace("#{found_stage}",String.valueOf(t.getFoundStage()));
 		sql  = sql.replace("#{found_num}",String.valueOf(t.getFoundNum()));
 		sql  = sql.replace("#{found_introduce}",String.valueOf(t.getFoundIntroduce()));
 		sql  = sql.replace("#{found_address}",String.valueOf(t.getFoundAddress()));
 		sql  = sql.replace("#{found_exception}",String.valueOf(t.getFoundException()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}