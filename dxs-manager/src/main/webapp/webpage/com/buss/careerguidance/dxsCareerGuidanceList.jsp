<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsCareerGuidanceList" checkbox="true" fitColumns="false" title="dxs_career_guidance" actionUrl="dxsCareerGuidanceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导分类"  field="dxsCareerGuidanceCatalogEntity.cgCatelogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导标题"  field="cgTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编辑人"  field="cgEditor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="cgPublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="职场引导简介"  field="cgIntroduction"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="职场引导内容"  field="cgContents"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编号"  field="cgSort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导视频"  field="cgVideoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导缩略图"  field="cgImgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导发布年份"  field="cgPublishYear"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导发布月份"  field="cgPublicMonth"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否特别关注"  field="isSpecial"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职场引导来源"  field="cgFrom"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="外部标记"  field="outSign"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="createTime"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="updateTime"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsCareerGuidanceController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsCareerGuidanceController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsCareerGuidanceController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsCareerGuidanceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsCareerGuidanceController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/careerguidance/dxsCareerGuidanceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsCareerGuidanceListtb").find("input[name='cgPublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsCareerGuidanceListtb").find("input[name='cgPublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsCareerGuidanceListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsCareerGuidanceListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsCareerGuidanceListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsCareerGuidanceListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsCareerGuidanceController.do?upload', "dxsCareerGuidanceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsCareerGuidanceController.do?exportXls","dxsCareerGuidanceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsCareerGuidanceController.do?exportXlsByT","dxsCareerGuidanceList");
}
 </script>