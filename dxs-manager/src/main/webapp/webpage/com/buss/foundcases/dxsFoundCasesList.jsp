<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsFoundCasesList" checkbox="true" fitColumns="false" title="dxs_found_cases" actionUrl="dxsFoundCasesController.do?datagrid&dfId=${dfId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基金的id"  field="dfId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="成功案例的名称"  field="dfName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="案例缩图id"  field="dfImgFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="案例缩图URL"  field="dfImgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsFoundCasesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsFoundCasesController.do?goAdd&dfId=${dfId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsFoundCasesController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsFoundCasesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsFoundCasesController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回上一页" icon="icon-put" url="dxsFoundsController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/foundcases/dxsFoundCasesList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsFoundCasesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundCasesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundCasesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundCasesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsFoundCasesController.do?upload', "dxsFoundCasesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsFoundCasesController.do?exportXls","dxsFoundCasesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsFoundCasesController.do?exportXlsByT","dxsFoundCasesList");
}
 </script>