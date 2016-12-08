<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsResumeTemplateList" checkbox="true" fitColumns="false" title="dxs_resume_template" actionUrl="dxsResumeTemplateController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板名称"  field="templateName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="求职意向"  field="jobIntention"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板风格"  field="templateStyle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板语言"  field="templateLanguage"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板图片"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板分类"  field="templateCatelog"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="模板访问地址"  field="templateUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="模板特点"  field="templateFeature"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="价格"  field="price"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsResumeTemplateController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsResumeTemplateController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsResumeTemplateController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsResumeTemplateController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsResumeTemplateController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/resumetemplate/dxsResumeTemplateList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsResumeTemplateListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeTemplateListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeTemplateListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeTemplateListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsResumeTemplateController.do?upload', "dxsResumeTemplateList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsResumeTemplateController.do?exportXls","dxsResumeTemplateList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsResumeTemplateController.do?exportXlsByT","dxsResumeTemplateList");
}
 </script>