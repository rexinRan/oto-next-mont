<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div  class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsOrdersList" checkbox="true" fitColumns="false" title="dxs_orders" actionUrl="dxsOrdersController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="用户"  field="userId"    hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="dxsUserDetailEntity.name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册号"  field="regNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单金额"  field="orderAll"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订货日期"  field="orderTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发票号码"  field="invoiceNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="鸿鑫豆数量"  field="hongxinNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单状态"  field="orderStatus"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="配送日期"  field="sendTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>

   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsOrdersController.do?doDel&id={id}" />
      <%--<t:dgFunOpt funname="outId(id)" title="详情管理"></t:dgFunOpt>--%>

      <t:dgDefOpt  title="详情管理"  url="dxsOrderItemsController.do?list&orderId={id}&userId={userId}" > </t:dgDefOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="dxsOrdersController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsOrdersController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsOrdersController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsOrdersController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
<%--<div data-options="region:'east',--%>
	<%--title:'<t:mutiLang langKey="haah"/>',--%>
	<%--collapsed:true,--%>
	<%--split:true,--%>
	<%--border:false,--%>
	<%--onExpand : function(){--%>
		<%--li_east = 1;--%>
	<%--},--%>
	<%--onCollapse : function() {--%>
	    <%--li_east = 0;--%>
	<%--}"--%>
     <%--style="width: 400px; overflow: hidden;">--%>
    <%--<div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="operationDetailpanel"></div>--%>
<%--</div>--%>
 <script src = "webpage/com/buss/orders/dxsOrdersList.js"></script>		
 <script type="text/javascript">
//     $(function() {
//         var li_east = 0;
//     });
//     function outId(outId)
//     {
//         if(li_east == 0){
//             $('#system_function_functionList').layout('expand','east');
//         }
//         $('#operationDetailpanel').panel("refresh", "dxsOrderItemsController.do?list&outId=" +outId);
//     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsOrdersListtb").find("input[name='orderTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='orderTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='sendTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='sendTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsOrdersListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
////导入
//function ImportXls() {
//	openuploadwin('Excel导入', 'dxsOrdersController.do?upload', "dxsOrdersList");
//}
//
////导出
//function ExportXls() {
//	JeecgExcelExport("dxsOrdersController.do?exportXls","dxsOrdersList");
//}
//
////模板下载
//function ExportXlsByT() {
//	JeecgExcelExport("dxsOrdersController.do?exportXlsByT","dxsOrdersList");
//}
 </script>