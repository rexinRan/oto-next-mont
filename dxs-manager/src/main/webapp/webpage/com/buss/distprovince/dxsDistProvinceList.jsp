<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsDistProvinceList" checkbox="true" fitColumns="false" title="dxs_dist_province" actionUrl="dxsDistProvinceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="pid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省份ID"  field="provinceid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省份名称"  field="pname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsDistProvinceController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsDistProvinceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsDistProvinceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsDistProvinceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsDistProvinceController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/distprovince/dxsDistProvinceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsDistProvinceController.do?upload', "dxsDistProvinceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsDistProvinceController.do?exportXls","dxsDistProvinceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsDistProvinceController.do?exportXlsByT","dxsDistProvinceList");
}
 </script>