package com.buss.voteitem.service.impl;
import com.buss.voteitem.service.DxsVoteItemServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.voteitem.entity.DxsVoteItemEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsVoteItemService")
@Transactional
public class DxsVoteItemServiceImpl extends CommonServiceImpl implements DxsVoteItemServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsVoteItemEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsVoteItemEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsVoteItemEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsVoteItemEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsVoteItemEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsVoteItemEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsVoteItemEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{vote_id}",String.valueOf(t.getVoteId()));
 		sql  = sql.replace("#{vi_title}",String.valueOf(t.getViTitle()));
 		sql  = sql.replace("#{vi_content}",String.valueOf(t.getViContent()));
 		sql  = sql.replace("#{item_image}",String.valueOf(t.getItemImage()));
 		sql  = sql.replace("#{item_num}",String.valueOf(t.getItemNum()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}