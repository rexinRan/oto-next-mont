<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>编辑</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="dxsSiteController.do?doUpdate" tiptype="1" >
				<input id="id" name="id" type="hidden" value="${dxsSitePage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">公司名称:</label>
		     	 <input id="companyName" name="companyName" type="text" style="width: 150px" class="inputxt"  value='${dxsSitePage.companyName}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">公司网站:</label>
		     	 <input id="companySite" name="companySite" type="text" style="width: 150px" class="inputxt"  value='${dxsSitePage.companySite}'>
		      <span class="Validform_checktip"></span>
		    </div>
			<%--<div class="form">--%>
		      <%--<label class="Validform_label">扩展字段1:</label>--%>
		     	 <%--<input id="ext1" name="ext1" type="text" style="width: 150px" class="inputxt"  value='${dxsSitePage.ext1}'>--%>
		      <%--<span class="Validform_checktip"></span>--%>
		    <%--</div>--%>
			<%--<div class="form">--%>
		      <%--<label class="Validform_label">扩展字段2:</label>--%>
		     	 <%--<input id="ext2" name="ext2" type="text" style="width: 150px" class="inputxt"  value='${dxsSitePage.ext2}'>--%>
		      <%--<span class="Validform_checktip"></span>--%>
		    <%--</div>--%>
			<%--<div class="form">--%>
		      <%--<label class="Validform_label">扩展字段3:</label>--%>
		     	 <%--<input id="ext3" name="ext3" type="text" style="width: 150px" class="inputxt"  value='${dxsSitePage.ext3}'>--%>
		      <%--<span class="Validform_checktip"></span>--%>
		    <%--</div>--%>
	    </fieldset>
  </t:formvalid>
 </body>
  <script src = "webpage/com/buss/site/dxsSite.js"></script>		
