<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialRecruitJobList" checkbox="true" fitColumns="false" title="dxs_special_recruit_job" actionUrl="dxsSpecialRecruitJobController.do?datagrid&srId=${srId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属专场"  field="dxsSpecialRecruitEntity.spSchool"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="岗位名称"  field="srJobName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="srJobNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工资待遇"  field="srJobSalary"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工作地点"  field="srJobAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘单位"  field="dxsUserEntity.empname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘单位"  field="srJobUnit"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialRecruitJobController.do?doDel&id={id}" />
      <t:dgDefOpt title="进入详情" url="dxsSpecialRecruitJobAppointmentController.do?list&srjId={id}&srId=${srId}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialRecruitJobController.do?goAdd&srId=${srId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialRecruitJobController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialRecruitJobController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialRecruitJobController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsSpecialRecruitController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialrecruitjob/dxsSpecialRecruitJobList.js"></script>		
 <script type="text/javascript">

     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialRecruitJobListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialRecruitJobController.do?upload', "dxsSpecialRecruitJobList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialRecruitJobController.do?exportXls","dxsSpecialRecruitJobList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialRecruitJobController.do?exportXlsByT","dxsSpecialRecruitJobList");
}
 </script>