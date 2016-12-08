<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsQuizUserList" checkbox="true" fitColumns="false" title="用户测试表" actionUrl="dxsQuizUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试卷"  field="dxsQuizEntity.quizName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="结果处理类型"  field="resulttype"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="结果"  field="result"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="结果报告地址"  field="resultUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsQuizUserController.do?doDel&id={id}" />
      <%--<t:dgDefOpt title="查看详情" url="dxsQuizUserItemController.do?list&quizUserId={id}" />--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsQuizUserController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsQuizUserController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsQuizUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsQuizUserController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/quizuser/dxsQuizUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsQuizUserListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsQuizUserListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsQuizUserController.do?upload', "dxsQuizUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsQuizUserController.do?exportXls","dxsQuizUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsQuizUserController.do?exportXlsByT","dxsQuizUserList");
}
 </script>