<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainingCourseList" checkbox="true" fitColumns="false" title="dxs_training_course" actionUrl="dxsTrainingCourseController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="培训中心分类"  field="dxsTrainingCatalogEntity.trainingCatalogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="课程名称"  field="courseName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任课老师"  field="courseTeacher"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="课程发布者"  field="courseEditor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="coursePublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="课程视频"  field="courseVideourl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="课程介绍"  field="courseIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编号"  field="courseSort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainingCourseController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainingCourseController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainingCourseController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainingCourseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainingCourseController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainingcourse/dxsTrainingCourseList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainingCourseListtb").find("input[name='coursePublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCourseListtb").find("input[name='coursePublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCourseListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCourseListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCourseListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingCourseListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainingCourseController.do?upload', "dxsTrainingCourseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainingCourseController.do?exportXls","dxsTrainingCourseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainingCourseController.do?exportXlsByT","dxsTrainingCourseList");
}
 </script>