<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsDistCityList" checkbox="true" fitColumns="false" title="dxs_dist_city" actionUrl="dxsDistCityController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="cid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="市id"  field="cityid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="市区名称"  field="city"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省份id"  field="provinceid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsDistCityController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsDistCityController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsDistCityController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsDistCityController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsDistCityController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/distcity/dxsDistCityList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsDistCityController.do?upload', "dxsDistCityList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsDistCityController.do?exportXls","dxsDistCityList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsDistCityController.do?exportXlsByT","dxsDistCityList");
}
 </script>