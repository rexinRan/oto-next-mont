<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEmployedMeetingEmployedList" checkbox="true" fitColumns="false" title="dxs_employed_meeting_employed" actionUrl="dxsEmployedMeetingEmployedController.do?datagrid&employedMeetingId=${employedMeetingId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="招聘会主键"  field="employedMeetingId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="职位名称"  field="employedName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘人数"  field="employedNumber"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘公司"  field="employedCompany"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="地点"  field="employedPosition"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="employedSort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEmployedMeetingEmployedController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsEmployedMeetingEmployedController.do?goAdd&employedMeetingId=${employedMeetingId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsEmployedMeetingEmployedController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsEmployedMeetingEmployedController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsEmployedMeetingEmployedController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <t:dgToolBar title="返回" icon="icon-put" url="dxsEmployedMeetingController.do?list" funname="fanhui"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/employedmeetingemployed/dxsEmployedMeetingEmployedList.js"></script>		
 <script type="text/javascript">
  var fanhui = function(title, url, id){
   window.location.href = url;
  }

 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEmployedMeetingEmployedListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedMeetingEmployedListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedMeetingEmployedListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedMeetingEmployedListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEmployedMeetingEmployedController.do?upload', "dxsEmployedMeetingEmployedList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEmployedMeetingEmployedController.do?exportXls","dxsEmployedMeetingEmployedList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEmployedMeetingEmployedController.do?exportXlsByT","dxsEmployedMeetingEmployedList");
}
 </script>