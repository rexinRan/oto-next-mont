package com.buss.invoices.service.impl;
import com.buss.invoices.service.DxsInvoicesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.invoices.entity.DxsInvoicesEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsInvoicesService")
@Transactional
public class DxsInvoicesServiceImpl extends CommonServiceImpl implements DxsInvoicesServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsInvoicesEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsInvoicesEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsInvoicesEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsInvoicesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsInvoicesEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsInvoicesEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsInvoicesEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{issue_type}",String.valueOf(t.getIssueType()));
 		sql  = sql.replace("#{invoice_header}",String.valueOf(t.getInvoiceHeader()));
 		sql  = sql.replace("#{invoice_type}",String.valueOf(t.getInvoiceType()));
 		sql  = sql.replace("#{tax_account}",String.valueOf(t.getTaxAccount()));
 		sql  = sql.replace("#{bank_name}",String.valueOf(t.getBankName()));
 		sql  = sql.replace("#{bank_account}",String.valueOf(t.getBankAccount()));
 		sql  = sql.replace("#{register_palce}",String.valueOf(t.getRegisterPalce()));
 		sql  = sql.replace("#{register_phone}",String.valueOf(t.getRegisterPhone()));
 		sql  = sql.replace("#{business_lincense}",String.valueOf(t.getBusinessLincense()));
 		sql  = sql.replace("#{tax_person}",String.valueOf(t.getTaxPerson()));
 		sql  = sql.replace("#{general_taxpayer}",String.valueOf(t.getGeneralTaxpayer()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}