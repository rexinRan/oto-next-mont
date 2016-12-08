<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<script src = "webpage/com/buss/user/dxsUserList.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsUserList" checkbox="true" fitColumns="false" title="用户列表" actionUrl="dxsUserController.do?datagrid&checkstatus=${checkstatus}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="用户表主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="真实姓名"  field="realname"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="用户角色"  field="dxsRoleEntity.name"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="手机号"  field="mphone"    queryMode="group"  width="120"></t:dgCol>--%>
  <%-- <t:dgCol title="密码"  field="pwd"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="电子邮箱"  field="email"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业名称"  field="empname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业组织代码证号"  field="empcode"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="核审状态"  field="checkstatus"    queryMode="group"  width="120" formatterjs="DXSuser.userCheck" align="center"></t:dgCol>
  <%-- <t:dgCol title="是否删除"  field="isdelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="加入时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="180"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsUserController.do?doDel&id={id}" />
   <%--<t:dgDefOpt title="查看详情" url="dxsUserCompancyController.do?list&userId={id}" />--%>
   <t:dgConfOpt message="确认审核通过？" title="同意" url="dxsUserController.do?dostatus&id={id}&tongyi=1" />
   <t:dgConfOpt   message="确认审核失败？" title="拒绝" url="dxsUserController.do?dostatus&id={id}&tongyi=2" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsUserController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsUserCompancyController.do?goUpdate" funname="update" height="400" width="800"></t:dgToolBar>
   <t:dgToolBar title="查看详情" icon="icon-search" url="dxsUserCompancyController.do?goUpdate" funname="detail" height="400" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="批量审核"  icon="icon-remove" url="dxsUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsUserController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   --%>
  </t:datagrid>
  </div>
 </div>

 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsUserListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsUserController.do?upload', "dxsUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsUserController.do?exportXls","dxsUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsUserController.do?exportXlsByT","dxsUserList");
}
 </script>