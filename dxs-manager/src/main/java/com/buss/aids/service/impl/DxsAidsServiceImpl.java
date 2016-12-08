package com.buss.aids.service.impl;
import com.buss.aids.service.DxsAidsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.aids.entity.DxsAidsEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsAidsService")
@Transactional
public class DxsAidsServiceImpl extends CommonServiceImpl implements DxsAidsServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsAidsEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsAidsEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsAidsEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsAidsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsAidsEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsAidsEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsAidsEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{aid_catelog_id}",String.valueOf(t.getAidCatelogId()));
 		sql  = sql.replace("#{aid_title}",String.valueOf(t.getAidTitle()));
 		sql  = sql.replace("#{aid_editor}",String.valueOf(t.getAidEditor()));
 		sql  = sql.replace("#{aid_publish_time}",String.valueOf(t.getAidPublishTime()));
 		sql  = sql.replace("#{aid_introduction}",String.valueOf(t.getAidIntroduction()));
 		sql  = sql.replace("#{aid_contents}",String.valueOf(t.getAidContents()));
 		sql  = sql.replace("#{aid_sort}",String.valueOf(t.getAidSort()));
 		sql  = sql.replace("#{aid_video_url}",String.valueOf(t.getAidVideoUrl()));
 		sql  = sql.replace("#{aid_img_url}",String.valueOf(t.getAidImgUrl()));
 		sql  = sql.replace("#{aid_publish_year}",String.valueOf(t.getAidPublishYear()));
 		sql  = sql.replace("#{aid_public_month}",String.valueOf(t.getAidPublicMonth()));
 		sql  = sql.replace("#{aid_region}",String.valueOf(t.getAidRegion()));
 		sql  = sql.replace("#{is_special}",String.valueOf(t.getIsSpecial()));
 		sql  = sql.replace("#{aid_from}",String.valueOf(t.getAidFrom()));
 		sql  = sql.replace("#{out_sign}",String.valueOf(t.getOutSign()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}