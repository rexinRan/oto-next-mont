<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainingCatalogList" checkbox="true" fitColumns="false" title="分类管理" actionUrl="dxsTrainingCatalogController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="父级主键"  field="pid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="培训中心分类名称"  field="trainingCatalogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分类配图"  field="trainingCatalogImg"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="分类简介"  field="trainingCatalogIntroduction"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainingCatalogController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainingCatalogController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainingCatalogController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainingCatalogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainingCatalogController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainingcatalog/dxsTrainingCatalogList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainingCatalogListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCatalogListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCatalogListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCatalogListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainingCatalogController.do?upload', "dxsTrainingCatalogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainingCatalogController.do?exportXls","dxsTrainingCatalogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainingCatalogController.do?exportXlsByT","dxsTrainingCatalogList");
}
 </script>