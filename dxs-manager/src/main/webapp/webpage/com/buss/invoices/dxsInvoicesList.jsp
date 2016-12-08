<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsInvoicesList" checkbox="true" fitColumns="false" title="dxs_invoices" actionUrl="dxsInvoicesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名称"  field="DxsUserDetailEntity.name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开具类型"  field="issueType"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票抬头"  field="invoiceHeader"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票类型"  field="invoiceType"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="税务登记账号"  field="taxAccount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基本开户银行名称"  field="bankName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基本开户账号"  field="bankAccount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册场所地址"  field="registerPalce"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册固定电话"  field="registerPhone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="营业执照复印件"  field="businessLincense"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="税务登记复印件"  field="taxPerson"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="一般纳税人资格复印件"  field="generalTaxpayer"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsInvoicesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsInvoicesController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsInvoicesController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsInvoicesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsInvoicesController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/invoices/dxsInvoicesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsInvoicesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoicesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoicesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoicesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsInvoicesController.do?upload', "dxsInvoicesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsInvoicesController.do?exportXls","dxsInvoicesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsInvoicesController.do?exportXlsByT","dxsInvoicesList");
}
 </script>