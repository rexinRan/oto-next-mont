
/*
package com.buss.file.ggh.impl;
import com.buss.file.ggh.DxsFileServiceI;
import org.jeecgframework.core.common.ggh.impl.CommonServiceImpl;
import com.buss.file.entity.FileEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsFileService")
@Transactional
public class DxsFileServiceImpl extends CommonServiceImpl implements DxsFileServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((FileEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((FileEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((FileEntity)entity);
 	}
 	
 	*//*

*/
/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 *//*
*/
/*

 	public boolean doAddSql(FileEntity t){
	 	return true;
 	}
 	*//*

*/
/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 *//*
*/
/*

 	public boolean doUpdateSql(FileEntity t){
	 	return true;
 	}
 	*//*

*/
/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 *//*
*/
/*

 	public boolean doDelSql(FileEntity t){
	 	return true;
 	}
 	
 	*//*

*/
/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 *//*
*/
/*

 	public String replaceVal(String sql,FileEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{out_id}",String.valueOf(t.getOutId()));
 		sql  = sql.replace("#{table_type}",String.valueOf(t.getTableType()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
 		sql  = sql.replace("#{filetype}",String.valueOf(t.getFiletype()));
 		sql  = sql.replace("#{checkstatus}",String.valueOf(t.getCheckstatus()));
 		sql  = sql.replace("#{download_url}",String.valueOf(t.getDownloadUrl()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{updatetime}",String.valueOf(t.getUpdatetime()));
 		sql  = sql.replace("#{is_detail}",String.valueOf(t.getIsDetail()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}


//package com.buss.file.ggh.impl;
//import com.buss.file.ggh.DxsFileServiceI;
//import org.jeecgframework.core.common.ggh.impl.CommonServiceImpl;
//import com.buss.file.entity.FileEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.UUID;
//import java.io.Serializable;
//
//@Service("dxsFileService")
//@Transactional
//public class DxsFileServiceImpl extends CommonServiceImpl implements DxsFileServiceI {
//
//
// 	public <T> void delete(T entity) {
// 		super.delete(entity);
// 		//执行删除操作配置的sql增强
//		this.doDelSql((FileEntity)entity);
// 	}
//
// 	public <T> Serializable save(T entity) {
// 		Serializable t = super.save(entity);
// 		//执行新增操作配置的sql增强
// 		this.doAddSql((FileEntity)entity);
// 		return t;
// 	}
//
// 	public <T> void saveOrUpdate(T entity) {
// 		super.saveOrUpdate(entity);
// 		//执行更新操作配置的sql增强
// 		this.doUpdateSql((FileEntity)entity);
// 	}
//
// 	*/
/**
//	 * 默认按钮-sql增强-新增操作
//	 * @param id
//	 * @return
//	 *//*

// 	public boolean doAddSql(FileEntity t){
//	 	return true;
// 	}
// 	*/
/**
//	 * 默认按钮-sql增强-更新操作
//	 * @param id
//	 * @return
//	 *//*

// 	public boolean doUpdateSql(FileEntity t){
//	 	return true;
// 	}
// 	*/
/**
//	 * 默认按钮-sql增强-删除操作
//	 * @param id
//	 * @return
//	 *//*

// 	public boolean doDelSql(FileEntity t){
//	 	return true;
// 	}
//
// 	*/
/**
//	 * 替换sql中的变量
//	 * @param sql
//	 * @return
//	 *//*

// 	public String replaceVal(String sql,FileEntity t){
// 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
// 		sql  = sql.replace("#{out_id}",String.valueOf(t.getOutId()));
// 		sql  = sql.replace("#{table_type}",String.valueOf(t.getTableType()));
// 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
// 		sql  = sql.replace("#{title}",String.valueOf(t.getTitle()));
// 		sql  = sql.replace("#{filetype}",String.valueOf(t.getFiletype()));
// 		sql  = sql.replace("#{checkstatus}",String.valueOf(t.getCheckstatus()));
// 		sql  = sql.replace("#{download_url}",String.valueOf(t.getDownloadUrl()));
// 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
// 		sql  = sql.replace("#{updatetime}",String.valueOf(t.getUpdatetime()));
// 		sql  = sql.replace("#{is_detail}",String.valueOf(t.getIsDetail()));
// 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
// 		return sql;
// 	}
//}

*/
