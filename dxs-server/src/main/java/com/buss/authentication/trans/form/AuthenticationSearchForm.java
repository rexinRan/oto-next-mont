package com.buss.authentication.trans.form;

import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.entity.HxFile;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;

@Mapping(entityClass=DxsAuthenticationEntity.class)
public class AuthenticationSearchForm extends SearchForm {

	/**主键*/
	@Mapping
	private String id;
	/**用户id*/
	@Mapping
	private String userId;
	/**职称*/
	@Mapping
	private String teacherTitle;
	/**学生证/资格证扫描件*/
	@Mapping
	private String certificateId;
	/**学生证/资格证扫描件*/
	@Mapping
	private String certificateUrl;
	/**身份证正面*/
	@Mapping
	private String identify1Url;
	/**身份证反面*/
	@Mapping
	private String identify2Url;
	/**身份证正面*/
	@Mapping
	private String identify1Id;
	/**身份证反面*/
	@Mapping
	private String identify2Id;
	/**导师类别*/
	@Mapping
	private String toturType;
	/**导师技能*/
	@Mapping
	private String toturSkill;
	/**培训经验*/
	@Mapping
	private String isTrain;
	/**个人简历*/
	@Mapping
	private String resumeId;
	/**个人履历*/
	@Mapping
	private String resumeDisplay;
	/**个人展示视频*/
	@Mapping
	private String displayVideoUrl;
	/**作品或讲义*/
	@Mapping
	private String workId;
	/**认证结果*/
	@Mapping
	private String authenticationResult;
	/**认证次数*/
	@Mapping
	private String authenticationCount;
	/**认证信息反馈*/
	@Mapping
	private String authenticationMessage;
	/**创建时间*/
	@Mapping
	private String createTime;
	/**更新时间*/
	@Mapping
	private String updateTime;
	/**删除标志*/
	@Mapping
	private String isDelete;
	/**外部标记*/
	@Mapping
	private String outSign;
	/**备注*/
	@Mapping
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOutSign() {
		return outSign;
	}

	public void setOutSign(String outSign) {
		this.outSign = outSign;
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

	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getIdentify1Id() {
		return identify1Id;
	}

	public void setIdentify1Id(String identify1Id) {
		this.identify1Id = identify1Id;
	}

	public String getIdentify2Id() {
		return identify2Id;
	}

	public void setIdentify2Id(String identify2Id) {
		this.identify2Id = identify2Id;
	}

	public String getToturType() {
		return toturType;
	}

	public void setToturType(String toturType) {
		this.toturType = toturType;
	}

	public String getToturSkill() {
		return toturSkill;
	}

	public void setToturSkill(String toturSkill) {
		this.toturSkill = toturSkill;
	}

	public String getIsTrain() {
		return isTrain;
	}

	public void setIsTrain(String isTrain) {
		this.isTrain = isTrain;
	}

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getAuthenticationCount() {
		return authenticationCount;
	}

	public void setAuthenticationCount(String authenticationCount) {
		this.authenticationCount = authenticationCount;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getAuthenticationResult() {
		return authenticationResult;
	}

	public void setAuthenticationResult(String authenticationResult) {
		this.authenticationResult = authenticationResult;
	}

	public String getAuthenticationMessage() {
		return authenticationMessage;
	}

	public void setAuthenticationMessage(String authenticationMessage) {
		this.authenticationMessage = authenticationMessage;
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

	public String getResumeDisplay() {
		return resumeDisplay;
	}

	public void setResumeDisplay(String resumeDisplay) {
		this.resumeDisplay = resumeDisplay;
	}

	public String getDisplayVideoUrl() {
		return displayVideoUrl;
	}

	public void setDisplayVideoUrl(String displayVideoUrl) {
		this.displayVideoUrl = displayVideoUrl;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	public String getIdentify1Url() {
		return identify1Url;
	}

	public void setIdentify1Url(String identify1Url) {
		this.identify1Url = identify1Url;
	}

	public String getIdentify2Url() {
		return identify2Url;
	}

	public void setIdentify2Url(String identify2Url) {
		this.identify2Url = identify2Url;
	}
}
