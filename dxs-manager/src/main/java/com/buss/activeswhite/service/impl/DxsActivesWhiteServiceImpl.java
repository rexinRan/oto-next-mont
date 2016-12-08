package com.buss.activeswhite.service.impl;
import com.buss.activeswhite.service.DxsActivesWhiteServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activeswhite.entity.DxsActivesWhiteEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesWhiteService")
@Transactional
public class DxsActivesWhiteServiceImpl extends CommonServiceImpl implements DxsActivesWhiteServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesWhiteEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesWhiteEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesWhiteEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesWhiteEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesWhiteEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesWhiteEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesWhiteEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{destination}",String.valueOf(t.getDestination()));
 		sql  = sql.replace("#{destination_remarks}",String.valueOf(t.getDestinationRemarks()));
 		sql  = sql.replace("#{set_out_time}",String.valueOf(t.getSetOutTime()));
 		sql  = sql.replace("#{set_out_time_remarks_time}",String.valueOf(t.getSetOutTimeRemarksTime()));
 		sql  = sql.replace("#{days}",String.valueOf(t.getDays()));
 		sql  = sql.replace("#{trip_prices}",String.valueOf(t.getTripPrices()));
 		sql  = sql.replace("#{trip_big_num}",String.valueOf(t.getTripBigNum()));
 		sql  = sql.replace("#{trip_smail_num}",String.valueOf(t.getTripSmailNum()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
 		sql  = sql.replace("#{result}",String.valueOf(t.getResult()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}