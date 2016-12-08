package com.buss.activesdetailsdays.service.impl;
import com.buss.activesdetailsdays.service.DxsActivesDetailsDaysServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.activesdetailsdays.entity.DxsActivesDetailsDaysEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsActivesDetailsDaysService")
@Transactional
public class DxsActivesDetailsDaysServiceImpl extends CommonServiceImpl implements DxsActivesDetailsDaysServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsActivesDetailsDaysEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsActivesDetailsDaysEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsActivesDetailsDaysEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsActivesDetailsDaysEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsActivesDetailsDaysEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsActivesDetailsDaysEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsActivesDetailsDaysEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{active_id}",String.valueOf(t.getActiveId()));
 		sql  = sql.replace("#{days_name}",String.valueOf(t.getDaysName()));
 		sql  = sql.replace("#{address_name}",String.valueOf(t.getAddressName()));
 		sql  = sql.replace("#{fid1}",String.valueOf(t.getFid1()));
 		sql  = sql.replace("#{fid1_img_url}",String.valueOf(t.getFid1ImgUrl()));
 		sql  = sql.replace("#{fid2}",String.valueOf(t.getFid2()));
 		sql  = sql.replace("#{fid2_img_url}",String.valueOf(t.getFid2ImgUrl()));
 		sql  = sql.replace("#{fid3}",String.valueOf(t.getFid3()));
 		sql  = sql.replace("#{fid_img_url}",String.valueOf(t.getFidImgUrl()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{boarders}",String.valueOf(t.getBoarders()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}