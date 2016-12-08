<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/quizuseritems/dxsQuizUserItemsList.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsQuizUserItemList" checkbox="true" fitColumns="false" title="dxs_quiz_user_item" actionUrl="dxsQuizUserItemController.do?datagrid&quizUserId=${quizUserId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试卷id"  field="quizUserId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试卷项id"  field="quizItemId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试卷项的回答"  field="quizItemReplay"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试卷项的得分"  field="quizItemGoal"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsQuizUserItemController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsQuizUserItemController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsQuizUserItemController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsQuizUserItemController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsQuizUserItemController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回试卷页" icon="icon-put" url="dxsQuizUserController.do?list" funname="quizUserList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/quizuseritem/dxsQuizUserItemList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsQuizUserItemListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserItemListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserItemListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserItemListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsQuizUserItemController.do?upload', "dxsQuizUserItemList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsQuizUserItemController.do?exportXls","dxsQuizUserItemList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsQuizUserItemController.do?exportXlsByT","dxsQuizUserItemList");
}
 </script>