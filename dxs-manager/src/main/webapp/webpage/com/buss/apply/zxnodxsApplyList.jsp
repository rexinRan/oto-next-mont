<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsApplyList" checkbox="true" fitColumns="false" title="未审助学金" actionUrl="dxsApplyController.do?datagrid&checkcode=${checkcode}&applyType=${applyType}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="奖学金级别"  field="textType"    queryMode="group"  width="120" formatterjs="DXS.TextType" align="center"></t:dgCol>--%>
   <t:dgCol title="审核码"  field="checkcode"    queryMode="group"  width="120" formatterjs="DX.Checkcode" align="center"></t:dgCol>
   <t:dgCol title="申请类型"  field="applyType"    queryMode="group"  width="120" formatterjs="D.ApplyType" align="center"></t:dgCol>
   <t:dgCol title="审请时间"  field="applicationTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="180"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsApplyController.do?doDel&id={id}" />
      <t:dgConfOpt message="确认审核通过?" title="同意" url="dxsApplyController.do?doUpdate&checkcode=3&id={id}" />
      <t:dgConfOpt message="确认审核失败?" title="拒绝" url="dxsApplyController.do?doUpdate&checkcode=4&id={id}" />
      <t:dgDefOpt url="drownLoad.do?download&outid={id}" title="下载凭证" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsApplyController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsApplyController.do?goUpdate" funname="update" height="100"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量审核"  icon="icon-remove" url="dxsApplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsApplyController.do?goUpdate" funname="detail" height="100"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apply/dxsApplyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsApplyListtb").find("input[name='applicationTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsApplyListtb").find("input[name='applicationTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsApplyListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsApplyListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsApplyListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsApplyListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsApplyController.do?upload', "dxsApplyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsApplyController.do?exportXls","dxsApplyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsApplyController.do?exportXlsByT","dxsApplyList");
}
 </script>