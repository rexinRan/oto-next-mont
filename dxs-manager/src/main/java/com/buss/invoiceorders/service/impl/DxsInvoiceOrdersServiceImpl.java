package com.buss.invoiceorders.service.impl;
import com.buss.invoiceorders.service.DxsInvoiceOrdersServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.invoiceorders.entity.DxsInvoiceOrdersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsInvoiceOrdersService")
@Transactional
public class DxsInvoiceOrdersServiceImpl extends CommonServiceImpl implements DxsInvoiceOrdersServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsInvoiceOrdersEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsInvoiceOrdersEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsInvoiceOrdersEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsInvoiceOrdersEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsInvoiceOrdersEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsInvoiceOrdersEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsInvoiceOrdersEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{invoice_id}",String.valueOf(t.getInvoiceId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{order_id}",String.valueOf(t.getOrderId()));
 		sql  = sql.replace("#{invoice_value}",String.valueOf(t.getInvoiceValue()));
 		sql  = sql.replace("#{invoice_labels}",String.valueOf(t.getInvoiceLabels()));
 		sql  = sql.replace("#{apply_time}",String.valueOf(t.getApplyTime()));
 		sql  = sql.replace("#{invoice_status}",String.valueOf(t.getInvoiceStatus()));
 		sql  = sql.replace("#{recipient}",String.valueOf(t.getRecipient()));
 		sql  = sql.replace("#{recipient_address}",String.valueOf(t.getRecipientAddress()));
 		sql  = sql.replace("#{post_num}",String.valueOf(t.getPostNum()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{logistics_company}",String.valueOf(t.getLogisticsCompany()));
 		sql  = sql.replace("#{express_number}",String.valueOf(t.getExpressNumber()));
 		sql  = sql.replace("#{invoice_order_num}",String.valueOf(t.getInvoiceOrderNum()));
 		sql  = sql.replace("#{product_name}",String.valueOf(t.getProductName()));
 		sql  = sql.replace("#{collection_type}",String.valueOf(t.getCollectionType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}