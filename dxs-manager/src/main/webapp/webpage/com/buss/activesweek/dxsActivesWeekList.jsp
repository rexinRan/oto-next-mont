<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesWeekList" checkbox="true" fitColumns="false" title="dxs_actives_week" actionUrl="dxsActivesWeekController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="活动id"  field="activeId"    hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动名称"  field="dxsActivesEntity.activeTitle"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="协办单位"  field="coOrganizer"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="承办单位"  field="undertakingUnit"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="赞助单位"  field="supportingUnit"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="支持单位"  field="supportUnit"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="媒体单位"  field="mediaUnit"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="学校"  field="schoolName"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="宣传片"  field="videoUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="子分类(预留)"  field="catalogChildren"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="活动日程"  field="activeSchedule"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="参加对象及要求"  field="objectRequired"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="精彩回放"  field="imgUrls"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="其他"  field="others"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesWeekController.do?doDel&id={id}" />
      <t:dgDefOpt title="单位管理" url="awdxsActivesMatchComController.do?list&amId={id}&activesId={activeId}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesWeekController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesWeekController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesWeekController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesWeekController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesweek/dxsActivesWeekList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesWeekListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWeekListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWeekListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesWeekListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesWeekController.do?upload', "dxsActivesWeekList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesWeekController.do?exportXls","dxsActivesWeekList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesWeekController.do?exportXlsByT","dxsActivesWeekList");
}
 </script>