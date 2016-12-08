<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<%--<div class="easyui-layout" fit="true">--%>
  <%--<div region="center" style="padding:0px;border:0px">--%>
  <t:datagrid name="dxsOrderItemsList" checkbox="true" fitColumns="false" title="dxs_order_items" actionUrl="dxsOrderItemsController.do?datagrid&orderId=${orderId}" idField="id" >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="userId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="外键"  field="outId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="外部分类"  field="outCatalog"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品单价"  field="price"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="折后价"  field="priceShort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品数量"  field="num"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订货日期"  field="orderTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsOrderItemsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsOrderItemsController.do?goAdd&orderId=${orderId}&userId=${userId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsOrderItemsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsOrderItemsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsOrderItemsController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsOrdersController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  <%--</div>--%>
 <%--</div>--%>
 <script src = "webpage/com/buss/orderitems/dxsOrderItemsList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsOrderItemsListtb").find("input[name='orderTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrderItemsListtb").find("input[name='orderTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrderItemsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrderItemsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrderItemsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrderItemsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsOrderItemsController.do?upload', "dxsOrderItemsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsOrderItemsController.do?exportXls","dxsOrderItemsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsOrderItemsController.do?exportXlsByT","dxsOrderItemsList");
}
 </script>