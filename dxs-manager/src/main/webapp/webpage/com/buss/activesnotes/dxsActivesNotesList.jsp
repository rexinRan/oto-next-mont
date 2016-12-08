<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesNotesList" checkbox="true" fitColumns="false" title="dxs_actives_notes" actionUrl="dxsActivesNotesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="缩略图URL"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="视频URL"  field="videoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="标题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="作者"  field="editor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发表时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="摘要"  field="summary"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="内容"  field="contents"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="发表年份"  field="publishYear"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="国别"  field="countrys"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesNotesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesNotesController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesNotesController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesNotesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesNotesController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesnotes/dxsActivesNotesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesNotesListtb").find("input[name='publishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesNotesListtb").find("input[name='publishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesNotesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesNotesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesNotesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesNotesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesNotesController.do?upload', "dxsActivesNotesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesNotesController.do?exportXls","dxsActivesNotesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesNotesController.do?exportXlsByT","dxsActivesNotesList");
}
 </script>