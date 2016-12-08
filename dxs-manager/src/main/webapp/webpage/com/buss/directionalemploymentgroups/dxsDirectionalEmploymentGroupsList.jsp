<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsDirectionalEmploymentGroupsList" checkbox="true" fitColumns="false" title="dxs_directional_employment_groups" actionUrl="dxsDirectionalEmploymentGroupsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业"  field="userId"   queryMode="group"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="企业"  field="dxsUserEntity.empname"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="定项就业名称"  field="directionalEmploymentName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="显示菜单"  field="directionDisplayMenu"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="定项就业发布时间"  field="directionPublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="cretateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsDirectionalEmploymentGroupsController.do?doDel&id={id}" />
      <t:dgDefOpt title="进入详情" url="dxsEmployedController.do?list&degId={id}&userId={userId}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsDirectionalEmploymentGroupsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsDirectionalEmploymentGroupsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsDirectionalEmploymentGroupsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsDirectionalEmploymentGroupsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/directionalemploymentgroups/dxsDirectionalEmploymentGroupsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='directionPublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='directionPublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='cretateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='cretateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsDirectionalEmploymentGroupsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsDirectionalEmploymentGroupsController.do?upload', "dxsDirectionalEmploymentGroupsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsDirectionalEmploymentGroupsController.do?exportXls","dxsDirectionalEmploymentGroupsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsDirectionalEmploymentGroupsController.do?exportXlsByT","dxsDirectionalEmploymentGroupsList");
}
 </script>