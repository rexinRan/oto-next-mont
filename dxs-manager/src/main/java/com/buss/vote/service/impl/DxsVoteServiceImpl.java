package com.buss.vote.service.impl;
import com.buss.vote.service.DxsVoteServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.vote.entity.DxsVoteEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsVoteService")
@Transactional
public class DxsVoteServiceImpl extends CommonServiceImpl implements DxsVoteServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsVoteEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsVoteEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsVoteEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsVoteEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsVoteEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsVoteEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsVoteEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{vote_id}",String.valueOf(t.getVoteId()));
 		sql  = sql.replace("#{vote_title}",String.valueOf(t.getVoteTitle()));
 		sql  = sql.replace("#{vote_image}",String.valueOf(t.getVoteImage()));
 		sql  = sql.replace("#{display_menu}",String.valueOf(t.getDisplayMenu()));
 		sql  = sql.replace("#{vote_address}",String.valueOf(t.getVoteAddress()));
 		sql  = sql.replace("#{host_unit}",String.valueOf(t.getHostUnit()));
 		sql  = sql.replace("#{limited_number}",String.valueOf(t.getLimitedNumber()));
 		sql  = sql.replace("#{histary_date}",String.valueOf(t.getHistaryDate()));
 		sql  = sql.replace("#{deadline_date}",String.valueOf(t.getDeadlineDate()));
 		sql  = sql.replace("#{vote_state_time}",String.valueOf(t.getVoteStateTime()));
 		sql  = sql.replace("#{vote_end_time}",String.valueOf(t.getVoteEndTime()));
 		sql  = sql.replace("#{vote_usertype_id}",String.valueOf(t.getVoteUsertypeId()));
 		sql  = sql.replace("#{vote_introduce}",String.valueOf(t.getVoteIntroduce()));
 		sql  = sql.replace("#{vote_rule}",String.valueOf(t.getVoteRule()));
 		sql  = sql.replace("#{vote_num}",String.valueOf(t.getVoteNum()));
 		sql  = sql.replace("#{is_charge}",String.valueOf(t.getIsCharge()));
 		sql  = sql.replace("#{max_account_count}",String.valueOf(t.getMaxAccountCount()));
 		sql  = sql.replace("#{publish_time}",String.valueOf(t.getPublishTime()));
 		sql  = sql.replace("#{active_editor}",String.valueOf(t.getActiveEditor()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}