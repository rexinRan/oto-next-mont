<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>dxs_resume_user</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="dxsResumeUserController.do?doUpdate" tiptype="1" >
				<input id="id" name="id" type="hidden" value="${dxsResumeUserPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">简历的id:</label>
		     	 <input id="resumeId" name="resumeId" type="text" style="width: 150px" class="inputxt"  value='${dxsResumeUserPage.resumeId}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">职位id:</label>
		     	 <input id="emoloyedId" name="emoloyedId" type="text" style="width: 150px" class="inputxt"  value='${dxsResumeUserPage.emoloyedId}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">结果:</label>
		     	 <input id="result" name="result" type="text" style="width: 150px" class="inputxt"  value='${dxsResumeUserPage.result}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">创建时间:</label>
					  <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
		      						 value='<fmt:formatDate value='${dxsResumeUserPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>    
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">更新时间:</label>
					  <input id="updateTime" name="updateTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"
		      						 value='<fmt:formatDate value='${dxsResumeUserPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>    
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">删除标志:</label>
		     	 <input id="isDelete" name="isDelete" type="text" style="width: 150px" class="inputxt"  value='${dxsResumeUserPage.isDelete}'>
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/buss/resumeuser/dxsResumeUser.js"></script>		
