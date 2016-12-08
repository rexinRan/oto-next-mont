<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainTestList" checkbox="true" fitColumns="false" title="dxs_train_test" actionUrl="dxsTrainTestController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="试题名称"  field="tiName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="题目总数"  field="tiNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试题分类"  field="ttcId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缩略图"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="摘要(预留)"  field="tSummary"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="介绍"  field="tiIntroduce"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="答题须知"  field="requested"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="计分类型"  field="scoreType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainTestController.do?doDel&id={id}" />

      <t:dgDefOpt  title="试题管理"  url="dxsTrainTestSubjectController.do?list&ttId={id}" > </t:dgDefOpt>
      <t:dgDefOpt  title="解析管理"  url="dxsTrainAnserseController.do?list&ttId={id}" > </t:dgDefOpt>
      <t:dgDefOpt  title="试题对立项管理"  url="dxsTrainTestItemOppositeController.do?list&ttId={id}" > </t:dgDefOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainTestController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainTestController.do?goUpdate" funname="update"   height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainTestController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainTestController.do?goUpdate" funname="detail"   height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/traintest/dxsTrainTestList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainTestListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainTestController.do?upload', "dxsTrainTestList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainTestController.do?exportXls","dxsTrainTestList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainTestController.do?exportXlsByT","dxsTrainTestList");
}
 </script>