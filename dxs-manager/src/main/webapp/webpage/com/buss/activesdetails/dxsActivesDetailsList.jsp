<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesDetailsList" checkbox="true" fitColumns="false" title="dxs_actives_details" actionUrl="dxsActivesDetailsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="活动id"  field="activesId"    queryMode="group"  width="120"></t:dgCol>--%>
      <t:dgCol title="活动主键"  field="dxsActivesEntity.id"    queryMode="group"   width="120"></t:dgCol>
      <t:dgCol title="活动标题"  field="dxsActivesEntity.activeTitle"    query="true"  width="120"></t:dgCol>
   <t:dgCol title="推荐理由"  field="recommendedReason"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="费用包含"  field="costInclude"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="费用不包含"  field="costUninclude"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签证方式"  field="visaNote"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行前准备"  field="preparation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款方式"  field="paymentMethod"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="常见问题(待定)"  field="commonProblem"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesDetailsController.do?doDel&id={id}" />
      <t:dgDefOpt title="活动详情" url="dxsActivesDetailsDaysController.do?list&activeId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesDetailsController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesDetailsController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesDetailsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesDetailsController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesdetails/dxsActivesDetailsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesDetailsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesDetailsController.do?upload', "dxsActivesDetailsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesDetailsController.do?exportXls","dxsActivesDetailsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesDetailsController.do?exportXlsByT","dxsActivesDetailsList");
}
 </script>