package com.buss.messageuser.trans.form;

import com.buss.messageuser.entity.DxsMessagesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**   
 * @Title: Entity
 * @Description: dxs_messages
 * @author onlineGenerator
 * @date 2016-09-20 10:18:25
 * @version V1.0   
 *
 */
@Mapping(entityClass=DxsMessagesEntity.class)
public class DxsMessagesSearchForm extends SearchForm {
	/**主键*/
	@Mapping
	private String id;
	/**发信id(预留)*/
	@Mapping
	private String userId;
	/**标题内容*/
	@Mapping
	private String title;
	/**提交时间*/
	@Mapping
	private String commitTime;
	/**类型(预留)*/
	@Mapping
	private String catalog;
	/**内容*/
	@Mapping
	private String content;
	/**是否已读(预留)*/
	@Mapping
	private String isRead;
	/**是否放到回收站*/
	@Mapping
	private String isRubbish;
	/**创建时间*/
	@Mapping
	private String createTime;
	/**更新时间*/
	@Mapping
	private String updateTime;
	/**删除标志*/
	@Mapping
	private String isDelete;

	public DxsMessagesSearchForm() {
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getIsRubbish() {
		return isRubbish;
	}

	public void setIsRubbish(String isRubbish) {
		this.isRubbish = isRubbish;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
