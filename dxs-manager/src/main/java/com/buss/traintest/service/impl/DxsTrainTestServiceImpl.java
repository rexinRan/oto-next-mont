package com.buss.traintest.service.impl;
import com.buss.traintest.service.DxsTrainTestServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.traintest.entity.DxsTrainTestEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsTrainTestService")
@Transactional
public class DxsTrainTestServiceImpl extends CommonServiceImpl implements DxsTrainTestServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsTrainTestEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsTrainTestEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsTrainTestEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsTrainTestEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsTrainTestEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsTrainTestEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsTrainTestEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{ti_num}",String.valueOf(t.getTiNum()));
 		sql  = sql.replace("#{ttc_id}",String.valueOf(t.getTtcId()));
 		sql  = sql.replace("#{t_name}",String.valueOf(t.getTiName()));
 		sql  = sql.replace("#{img_url}",String.valueOf(t.getImgUrl()));
 		sql  = sql.replace("#{t_summary}",String.valueOf(t.getTSummary()));
 		sql  = sql.replace("#{t_introduce}",String.valueOf(t.getTiIntroduce()));
 		sql  = sql.replace("#{requested}",String.valueOf(t.getRequested()));
 		sql  = sql.replace("#{score_type}",String.valueOf(t.getScoreType()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}