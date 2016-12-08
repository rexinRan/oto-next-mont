<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialRecruitJobAppointmentList" checkbox="true" fitColumns="false" title="dxs_special_recruit_job_appointment" actionUrl="dxsSpecialRecruitJobAppointmentController.do?datagrid&srjId=${srjId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="所属专场"  field="dxsSpecialRecruitEntity.spSchool"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专岗"  field="dxsSpecialRecruitJobEntity.srJobName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预约类型"  field="appointmentType"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预约时间"  field="appointmentTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请类型"  field="type"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialRecruitJobAppointmentController.do?doDel&id={id}" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialRecruitJobAppointmentController.do?goAdd&srjId=${srjId}" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialRecruitJobAppointmentController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialRecruitJobAppointmentController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
      <t:dgToolBar title="返回"  icon="icon-put" url="dxsSpecialRecruitJobController.do?list&srId=${srId}" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialRecruitJobAppointmentController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialrecruitjobappointment/dxsSpecialRecruitJobAppointmentList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, srId){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='appointmentTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='appointmentTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitJobAppointmentListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialRecruitJobAppointmentController.do?upload', "dxsSpecialRecruitJobAppointmentList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialRecruitJobAppointmentController.do?exportXls","dxsSpecialRecruitJobAppointmentList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialRecruitJobAppointmentController.do?exportXlsByT","dxsSpecialRecruitJobAppointmentList");
}
 </script>