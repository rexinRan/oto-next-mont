<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesDetailsDaysList" checkbox="true" fitColumns="false" title="dxs_actives_details_days" actionUrl="dxsActivesDetailsDaysController.do?datagrid&activeId=${activeId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="活动id"  field="activeId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="天数"  field="daysName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="地名"  field="addressName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="图片1主键"  field="fid1"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="图片1地址"  field="fid1ImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="图片2主键"  field="fid2"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="图片2地址"  field="fid2ImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="图片3主键"  field="fid3"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="图片3地址"  field="fidImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="内容"  field="content"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="住宿地"  field="boarders"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesDetailsDaysController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesDetailsDaysController.do?goAdd&activeId=${activeId}" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesDetailsDaysController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesDetailsDaysController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesDetailsDaysController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="返回" icon="icon-put" url="dxsActivesDetailsController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesdetailsdays/dxsActivesDetailsDaysList.js"></script>		
 <script type="text/javascript">
  var quizList = function(title, url, id){
   window.location.href = url;
  }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesDetailsDaysListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsDaysListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsDaysListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesDetailsDaysListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesDetailsDaysController.do?upload', "dxsActivesDetailsDaysList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesDetailsDaysController.do?exportXls","dxsActivesDetailsDaysList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesDetailsDaysController.do?exportXlsByT","dxsActivesDetailsDaysList");
}
 </script>