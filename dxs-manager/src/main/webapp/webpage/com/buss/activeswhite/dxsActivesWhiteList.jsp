<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesWhiteList" checkbox="true" fitColumns="false" title="dxs_actives_white" actionUrl="dxsActivesWhiteController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="userId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="目的地"  field="destination"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备选目的地"  field="destinationRemarks"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出发时间"  field="setOutTime"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备选时间"  field="setOutTimeRemarksTime"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出行天数"  field="days"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行程预算"  field="tripPrices"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="成人人数"  field="tripBigNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="儿童人数"  field="tripSmailNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="详细地址"  field="address"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请状态"  field="result"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesWhiteController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesWhiteController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesWhiteController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesWhiteController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesWhiteController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activeswhite/dxsActivesWhiteList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesWhiteListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWhiteListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWhiteListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWhiteListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesWhiteController.do?upload', "dxsActivesWhiteList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesWhiteController.do?exportXls","dxsActivesWhiteList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesWhiteController.do?exportXlsByT","dxsActivesWhiteList");
}
 </script>