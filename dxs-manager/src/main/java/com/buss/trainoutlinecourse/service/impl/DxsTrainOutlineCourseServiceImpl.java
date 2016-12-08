package com.buss.trainoutlinecourse.service.impl;
import com.buss.trainoutlinecourse.service.DxsTrainOutlineCourseServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.trainoutlinecourse.entity.DxsTrainOutlineCourseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainOutlineCourseService")
@Transactional
public class DxsTrainOutlineCourseServiceImpl extends CommonServiceImpl implements DxsTrainOutlineCourseServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainOutlineCourseEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainOutlineCourseEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainOutlineCourseEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainOutlineCourseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainOutlineCourseEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainOutlineCourseEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainOutlineCourseEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{tcc_id}",String.valueOf(t.getTccId()));
 		sql  = sql.replace("#{catalog_display_num}",String.valueOf(t.getCatalogDisplayNum()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{course_num_all}",String.valueOf(t.getCourseNumAll()));
 		sql  = sql.replace("#{course_minutes_all}",String.valueOf(t.getCourseMinutesAll()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
 		sql  = sql.replace("#{course_prices}",String.valueOf(t.getCoursePrices()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{out_sign}",String.valueOf(t.getOutSign()));
 		sql  = sql.replace("#{class_num}",String.valueOf(t.getClassNum()));
 		sql  = sql.replace("#{course_type}",String.valueOf(t.getCourseType()));
 		sql  = sql.replace("#{train_type}",String.valueOf(t.getTrainType()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{course_introduce}",String.valueOf(t.getCourseIntroduce()));
 		sql  = sql.replace("#{course_obj}",String.valueOf(t.getCourseObj()));
 		sql  = sql.replace("#{train_obj}",String.valueOf(t.getTrainObj()));
 		sql  = sql.replace("#{train_content}",String.valueOf(t.getTrainContent()));
 		sql  = sql.replace("#{course_dir}",String.valueOf(t.getCourseDir()));
 		sql  = sql.replace("#{course_special}",String.valueOf(t.getCourseSpecial()));
 		sql  = sql.replace("#{start_class_rule}",String.valueOf(t.getStartClassRule()));
 		sql  = sql.replace("#{address_short}",String.valueOf(t.getAddressShort()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{others}",String.valueOf(t.getOthers()));
 		sql  = sql.replace("#{sort}",String.valueOf(t.getSort()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}