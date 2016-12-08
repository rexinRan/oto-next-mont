<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsMessagesList" checkbox="true" fitColumns="false" title="dxs_messages" actionUrl="dxsMessagesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="发信id(预留)"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="标题内容"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="提交时间"  field="commitTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="类型(预留)"  field="catalog"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="内容"  field="content"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="是否已读(预留)"  field="isRead"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="是否放到回收站"  field="isRubbish"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="380"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsMessagesController.do?doDel&id={id}" />
      <t:dgConfOpt message="确认发送？" title="发送给学生用户" url="dxsMessagesController.do?send&type=1&id={id}" />
      <t:dgConfOpt message="确认发送？" title="发送给教师用户" url="dxsMessagesController.do?send&type=2&id={id}" />
      <t:dgConfOpt message="确认发送？" title="发送给企业用户" url="dxsMessagesController.do?send&type=3&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsMessagesController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsMessagesController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsMessagesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsMessagesController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/messages/dxsMessagesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsMessagesListtb").find("input[name='commitTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsMessagesListtb").find("input[name='commitTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsMessagesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsMessagesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsMessagesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsMessagesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsMessagesController.do?upload', "dxsMessagesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsMessagesController.do?exportXls","dxsMessagesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsMessagesController.do?exportXlsByT","dxsMessagesList");
}
 </script>