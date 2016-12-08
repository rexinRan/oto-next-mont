<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/quizitems/dxsQuizItemsList.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsQuizItemsList" checkbox="true" fitColumns="false" title="试卷内容" actionUrl="dxsQuizItemsController.do?datagrid&quizId=${quizId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="试卷主键"  field="quizId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="本题内容"  field="quizItemContent"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本题答案"  field="quizItemAnswer"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本题解析"  field="quizItemAnswerIntroduce"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsQuizItemsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsQuizItemsController.do?goAdd&quizId=${quizId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsQuizItemsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsQuizItemsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsQuizItemsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="返回试卷页" icon="icon-put" url="dxsQuizController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <%--<script src = "webpage/com/buss/quizitems/dxsQuizItemsList.js"></script>		--%>
 <script type="text/javascript">

 $(document).ready(function(){

 		//给时间控件加上样式
 			$("#dxsQuizItemsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizItemsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizItemsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizItemsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsQuizItemsController.do?upload', "dxsQuizItemsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsQuizItemsController.do?exportXls","dxsQuizItemsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsQuizItemsController.do?exportXlsByT","dxsQuizItemsList");
}
 </script>