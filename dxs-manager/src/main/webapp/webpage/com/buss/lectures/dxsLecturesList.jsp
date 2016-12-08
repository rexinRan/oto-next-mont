<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsLecturesList" checkbox="true" fitColumns="false" title="dxs_lectures" actionUrl="dxsLecturesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="活动名称"  field="dxsActivesEntity.activeTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="名家/企业家的名称"  field="dxsLecturesPersionEntity.prosonName"    queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="主题"  field="lectureTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所在站名"  field="lectureAddressShort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="演讲地址"  field="lectureAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="演讲时间"  field="lectureTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="主题内容简介"  field="lectureContentSummary"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="图片地址"  field="lectureContentImgs"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="主题内容详解"  field="lectureContent"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="所属场次"  field="lgId"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsLecturesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsLecturesController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsLecturesController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsLecturesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsLecturesController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/lectures/dxsLecturesList.js"></script>		
 <script type="text/javascript">
     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsLecturesListtb").find("input[name='lectureTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesListtb").find("input[name='lectureTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsLecturesController.do?upload', "dxsLecturesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsLecturesController.do?exportXls","dxsLecturesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsLecturesController.do?exportXlsByT","dxsLecturesList");
}
 </script>