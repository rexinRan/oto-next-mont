<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script src = "webpage/com/buss/accountlog/dxsAccountLogList.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAccountLogList" checkbox="true" fitColumns="false" title="" actionUrl="dxsAccountLogController.do?datagrid&userId=${userId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="账户id"  field="accoutId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="用户ID"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="进账数目"  field="accountIn"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出账数目"  field="accountOut"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="来源"  field="accountFrom"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="流水状态"  field="accountStatus"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="生成时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAccountLogController.do?doDel&id={id}" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsAccountLogController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsAccountLogController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAccountLogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsAccountLogController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="commonToPage.do?pack=account&path=empAccountList&id=1" funname="fanhui"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/accountlog/dxsAccountLogList.js"></script>		
 <script type="text/javascript">
     var fanhui = function(title, url, id){
         window.location.href = url;
     }

     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAccountLogListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountLogListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountLogListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAccountLogListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAccountLogController.do?upload', "dxsAccountLogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAccountLogController.do?exportXls","dxsAccountLogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAccountLogController.do?exportXlsByT","dxsAccountLogList");
}
 </script>