<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSiteList" checkbox="true" fitColumns="false" title="网站群管理" actionUrl="dxsSiteController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="companyName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司网站"  field="companySite"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="扩展字段1"  field="ext1"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="扩展字段2"  field="ext2"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="扩展字段3"  field="ext3"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSiteController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSiteController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSiteController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSiteController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSiteController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/site/dxsSiteList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSiteController.do?upload', "dxsSiteList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSiteController.do?exportXls","dxsSiteList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSiteController.do?exportXlsByT","dxsSiteList");
}
 </script>