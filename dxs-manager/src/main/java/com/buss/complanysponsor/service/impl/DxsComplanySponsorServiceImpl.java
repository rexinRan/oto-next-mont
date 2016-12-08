package com.buss.complanysponsor.service.impl;
import com.buss.complanysponsor.service.DxsComplanySponsorServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.complanysponsor.entity.DxsComplanySponsorEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("dxsComplanySponsorService")
@Transactional
public class DxsComplanySponsorServiceImpl extends CommonServiceImpl implements DxsComplanySponsorServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((DxsComplanySponsorEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((DxsComplanySponsorEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((DxsComplanySponsorEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(DxsComplanySponsorEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(DxsComplanySponsorEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(DxsComplanySponsorEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,DxsComplanySponsorEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{user_id}",String.valueOf(t.getUserId()));
 		sql  = sql.replace("#{log_address}",String.valueOf(t.getLogAddress()));
 		sql  = sql.replace("#{complany_name}",String.valueOf(t.getComplanyName()));
 		sql  = sql.replace("#{complany_web_address}",String.valueOf(t.getComplanyWebAddress()));
 		sql  = sql.replace("#{complany_field}",String.valueOf(t.getComplanyField()));
 		sql  = sql.replace("#{complany_real_address}",String.valueOf(t.getComplanyRealAddress()));
 		sql  = sql.replace("#{complany_weixin}",String.valueOf(t.getComplanyWeixin()));
 		sql  = sql.replace("#{complany_introduce}",String.valueOf(t.getComplanyIntroduce()));
 		sql  = sql.replace("#{complany_num}",String.valueOf(t.getComplanyNum()));
 		sql  = sql.replace("#{complany_license_img}",String.valueOf(t.getComplanyLicenseImg()));
 		sql  = sql.replace("#{complany_license_num}",String.valueOf(t.getComplanyLicenseNum()));
 		sql  = sql.replace("#{complany_idcard}",String.valueOf(t.getComplanyIdcard()));
 		sql  = sql.replace("#{complany_active}",String.valueOf(t.getComplanyActive()));
 		sql  = sql.replace("#{contacts_name}",String.valueOf(t.getContactsName()));
 		sql  = sql.replace("#{contents_job}",String.valueOf(t.getContentsJob()));
 		sql  = sql.replace("#{contents_letter}",String.valueOf(t.getContentsLetter()));
 		sql  = sql.replace("#{contacts_email}",String.valueOf(t.getContactsEmail()));
 		sql  = sql.replace("#{contents_tel}",String.valueOf(t.getContentsTel()));
 		sql  = sql.replace("#{content_iphone}",String.valueOf(t.getContentIphone()));
 		sql  = sql.replace("#{content_qq}",String.valueOf(t.getContentQq()));
 		sql  = sql.replace("#{create_time}",String.valueOf(t.getCreateTime()));
 		sql  = sql.replace("#{update_time}",String.valueOf(t.getUpdateTime()));
 		sql  = sql.replace("#{is_delete}",String.valueOf(t.getIsDelete()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}