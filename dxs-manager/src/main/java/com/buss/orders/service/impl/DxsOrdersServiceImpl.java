package com.buss.orders.service.impl;
import com.buss.orders.service.DxsOrdersServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.orders.entity.DxsOrdersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsOrdersService")
@Transactional
public class DxsOrdersServiceImpl extends CommonServiceImpl implements DxsOrdersServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsOrdersEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsOrdersEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsOrdersEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsOrdersEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsOrdersEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsOrdersEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsOrdersEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{order_num}",String.valueOf(t.getOrderNum()));
 		sql  = sql.replace("#{reg_num}",String.valueOf(t.getRegNum()));
 		sql  = sql.replace("#{order_all}",String.valueOf(t.getOrderAll()));
 		sql  = sql.replace("#{order_time}",String.valueOf(t.getOrderTime()));
 		sql  = sql.replace("#{invoice_num}",String.valueOf(t.getInvoiceNum()));
 		sql  = sql.replace("#{hongxin_num}",String.valueOf(t.getHongxinNum()));
 		sql  = sql.replace("#{order_status}",String.valueOf(t.getOrderStatus()));
 		sql  = sql.replace("#{send_time}",String.valueOf(t.getSendTime()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}