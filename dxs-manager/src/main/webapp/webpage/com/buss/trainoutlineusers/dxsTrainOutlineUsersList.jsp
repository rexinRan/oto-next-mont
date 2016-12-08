<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainOutlineUsersList" checkbox="true" fitColumns="false" title="dxs_train_outline_users" actionUrl="dxsTrainOutlineUsersController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="头像"  field="headImgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="就职公司"  field="company"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工作"  field="job"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="薪资"  field="salary"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="备注(预留)"  field="resume"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="createTime"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="updateTime"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainOutlineUsersController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainOutlineUsersController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainOutlineUsersController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainOutlineUsersController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainOutlineUsersController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainoutlineusers/dxsTrainOutlineUsersList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainOutlineUsersListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineUsersListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineUsersListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOutlineUsersListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainOutlineUsersController.do?upload', "dxsTrainOutlineUsersList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainOutlineUsersController.do?exportXls","dxsTrainOutlineUsersList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainOutlineUsersController.do?exportXlsByT","dxsTrainOutlineUsersList");
}
 </script>