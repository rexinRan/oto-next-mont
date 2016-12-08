<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsInvoiceOrdersList" checkbox="true" fitColumns="false" title="dxs_invoice_orders" actionUrl="dxsInvoiceOrdersController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票信息"  field="DxsInvoicesEntity.invoiceHeader"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名称"  field="DxsUserDetailEntity.name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="DxsOrdersEntity.orderNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票金额"  field="invoiceValue"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票标号"  field="invoiceLabels"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="applyTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票状态"  field="invoiceStatus"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收件人"  field="recipient"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收取地址"  field="recipientAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮编"  field="postNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="phone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="物流公司"  field="logisticsCompany"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="快递编号"  field="expressNumber"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开票订单号"  field="invoiceOrderNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产品名称"  field="productName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="收取方式"  field="collectionType"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsInvoiceOrdersController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsInvoiceOrdersController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsInvoiceOrdersController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsInvoiceOrdersController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsInvoiceOrdersController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/invoiceorders/dxsInvoiceOrdersList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsInvoiceOrdersListtb").find("input[name='applyTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoiceOrdersListtb").find("input[name='applyTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoiceOrdersListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoiceOrdersListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoiceOrdersListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsInvoiceOrdersListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsInvoiceOrdersController.do?upload', "dxsInvoiceOrdersList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsInvoiceOrdersController.do?exportXls","dxsInvoiceOrdersList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsInvoiceOrdersController.do?exportXlsByT","dxsInvoiceOrdersList");
}
 </script>