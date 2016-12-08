<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsFoundsList" checkbox="true" fitColumns="false" title="dxs_founds" actionUrl="dxsFoundsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="基金名称"  field="foundTitle"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="log文件"  field="foundImgFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="创始人"  field="foundUserName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="关注领域"  field="foundIndustry"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="投资阶段"  field="foundStage"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基金金额"  field="foundNum"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基金介绍"  field="foundIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="办公地点"  field="foundAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="成功案例"  field="foundException"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="修改时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsFoundsController.do?doDel&id={id}" />
      <t:dgDefOpt title="成功案例" url="dxsFoundCasesController.do?list&dfId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsFoundsController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsFoundsController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsFoundsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsFoundsController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/founds/dxsFoundsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsFoundsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFoundsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsFoundsController.do?upload', "dxsFoundsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsFoundsController.do?exportXls","dxsFoundsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsFoundsController.do?exportXlsByT","dxsFoundsList");
}
 </script>