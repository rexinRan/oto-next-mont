<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainOutlineCourseClassesList" checkbox="true" fitColumns="false" title="dxs_train_outline_course_classes" actionUrl="dxsTrainOutlineCourseClassesController.do?datagrid&tocId=${tocId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="线下培训的名称"  field="tocId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="培训时间"  field="openTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="培训城市"  field="addressShort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="上课地点"  field="address"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="上课时间"  field="time"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开学时间"  field="startClass"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainOutlineCourseClassesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainOutlineCourseClassesController.do?goAdd&tocId=${tocId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainOutlineCourseClassesController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainOutlineCourseClassesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainOutlineCourseClassesController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsTrainOutlineCourseController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainoutlinecourseclasses/dxsTrainOutlineCourseClassesList.js"></script>		
 <script type="text/javascript">

     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='openTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='openTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineCourseClassesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainOutlineCourseClassesController.do?upload', "dxsTrainOutlineCourseClassesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainOutlineCourseClassesController.do?exportXls","dxsTrainOutlineCourseClassesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainOutlineCourseClassesController.do?exportXlsByT","dxsTrainOutlineCourseClassesList");
}
 </script>