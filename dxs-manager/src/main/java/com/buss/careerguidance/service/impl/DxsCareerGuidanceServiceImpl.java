package com.buss.careerguidance.service.impl;
import com.buss.careerguidance.service.DxsCareerGuidanceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.careerguidance.entity.DxsCareerGuidanceEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsCareerGuidanceService")
@Transactional
public class DxsCareerGuidanceServiceImpl extends CommonServiceImpl implements DxsCareerGuidanceServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsCareerGuidanceEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsCareerGuidanceEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsCareerGuidanceEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsCareerGuidanceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsCareerGuidanceEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsCareerGuidanceEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsCareerGuidanceEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{cg_catelog_id}",String.valueOf(t.getCgCatelogId()));
 		sql  = sql.replace("#{cg_title}",String.valueOf(t.getCgTitle()));
 		sql  = sql.replace("#{cg_editor}",String.valueOf(t.getCgEditor()));
 		sql  = sql.replace("#{cg_publish_time}",String.valueOf(t.getCgPublishTime()));
 		sql  = sql.replace("#{cg_introduction}",String.valueOf(t.getCgIntroduction()));
 		sql  = sql.replace("#{cg_contents}",String.valueOf(t.getCgContents()));
 		sql  = sql.replace("#{cg_sort}",String.valueOf(t.getCgSort()));
 		sql  = sql.replace("#{cg_video_url}",String.valueOf(t.getCgVideoUrl()));
 		sql  = sql.replace("#{cg_img_url}",String.valueOf(t.getCgImgUrl()));
 		sql  = sql.replace("#{cg_publish_year}",String.valueOf(t.getCgPublishYear()));
 		sql  = sql.replace("#{cg_public_month}",String.valueOf(t.getCgPublicMonth()));
 		sql  = sql.replace("#{is_special}",String.valueOf(t.getIsSpecial()));
 		sql  = sql.replace("#{cg_from}",String.valueOf(t.getCgFrom()));
 		sql  = sql.replace("#{out_sign}",String.valueOf(t.getOutSign()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}