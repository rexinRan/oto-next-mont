package com.buss.common.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import com.buss.common.entity.HxFile;

@Mapping(entityClass=HxFile.class)
public class FileVo extends BaseVO implements java.io.Serializable{

	@Mapping
	private String id;
	@Mapping
	private String name;
	@Mapping
	private String title;
	/** 文件类型（1入会申请资料2入会协议3缴费回执单。。） */
	@Mapping
	private String filetype;
	/** 核审状态 */
	@Mapping
	private String checkstatus;
	@Mapping
	private String downloadUrl;
	@Mapping
	private String createtime;
	@Mapping
	private String updatetime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getCheckstatus() {
		return checkstatus;
	}
	public void setCheckstatus(String checkstatus) {
		this.checkstatus = checkstatus;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	
}
