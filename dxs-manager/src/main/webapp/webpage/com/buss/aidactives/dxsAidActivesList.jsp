<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidActivesList" checkbox="true" fitColumns="false" title="dxs_aid_actives" actionUrl="dxsAidActivesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公益主题"  field="catalog"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主办方"  field="sponsor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="报名截止时间"  field="deadlineDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动开始时间"  field="activeStartTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动结束时间"  field="activeEndTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动分类"  field="activeCatelog"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="已报名人数"  field="activeNumber"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动地点"  field="activeAddress"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="活动简介"  field="activeIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="图片地址"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidActivesController.do?doDel&id={id}" />
      <t:dgDefOpt title="内容项管理" url="activedxsAidItemsController.do?list&aaId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidActivesController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidActivesController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidActivesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsAidActivesController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/aidactives/dxsAidActivesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidActivesListtb").find("input[name='publishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='publishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='deadlineDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='deadlineDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='activeStartTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='activeStartTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='activeEndTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='activeEndTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidActivesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidActivesController.do?upload', "dxsAidActivesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidActivesController.do?exportXls","dxsAidActivesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidActivesController.do?exportXlsByT","dxsAidActivesList");
}
 </script>