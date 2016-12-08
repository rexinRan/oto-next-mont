<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAccountList" checkbox="true" fitColumns="false" title="账户管理" actionUrl="dxsAccountController.do?datagrid&id=${id}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="用户id"  field="userId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业名"  field="dxsUserEntity.empname"    queryMode="group"  width="120" ></t:dgCol>
   <t:dgCol title="账户(鸿鑫币)"  field="account"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户类型"  field="userType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="账户状态"  field="accountStatus"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAccountController.do?doDel&id={id}" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsAccountController.do?goAdd" funname="add"></t:dgToolBar>--%>
      <t:dgDefOpt title="查看明细" url="commonToPage.do?pack=accountlog&path=empAccountLogList&userId={userId}" />
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsAccountController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAccountController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看详情" icon="icon-search" url="dxsAccountController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/account/dxsAccountList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAccountListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAccountController.do?upload', "dxsAccountList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAccountController.do?exportXls","dxsAccountList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAccountController.do?exportXlsByT","dxsAccountList");
}
 </script>