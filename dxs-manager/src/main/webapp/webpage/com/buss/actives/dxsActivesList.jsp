<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src="webpage/com/buss/common/common.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesList" checkbox="true" fitColumns="false" title="活动列表" actionUrl="dxsActivesController.do?datagrid&checkstatus=${checkstatus}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="活动分类"  field="DxsActiveCatelogEntity.activeCatelogName"    query="true"  width="120"></t:dgCol>
   <t:dgCol title="活动标题"  field="activeTitle"    query="true"  width="120"></t:dgCol>
      <t:dgCol title="展示菜单"  field="displayMenu"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="活动地点"  field="activeAddress"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="主办单位"  field="hostUnit"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="限报人数"  field="limitedNumber"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="精彩回顾"  field="histaryDate"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="报名截止时间"  field="deadlineDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动开始时间"  field="activeStateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动结束时间"  field="activeEndTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动对象"  field="activeUsertypeId"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="具体活动内容"  field="activeContent"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="价钱"  field="activePrice"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否收费"  field="isCharge"    queryMode="group"  width="120" formatterjs="DXActives.Actives" align="center"></t:dgCol>
      <t:dgCol title="发布时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="可使用鸿鑫币数量"  field="maxAccountCount"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="编辑人"  field="activeEditor"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="活动分类2"  field="sctiveType2"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="活动分类3"  field="sctiveType3"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="出发时间"  field="setOutTime"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="出发地"  field="setOutAddress"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="活动国家"  field="activeCountry"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="行程天数"  field="activesNum"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
     <%--<t:dgToolBar title="已结束"  icon="icon-search" funname="end"  url="dxsActivesController.do?datagrid&checkstatus=1" ></t:dgToolBar>--%>
      <%--<t:dgToolBar title="进行中" url="commonToPage.do?pack=actives&path=dxsActivesList&checkstatus=2" funname="start"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/actives/dxsActivesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
     $("#dxsActivesListtb").find("input[name='activeStateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='activeStateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='activeEndTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='activeEndTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='publishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='publishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
     $("#dxsActivesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });

 function end(name, url) {
     alert(url);
     $("#dxsActivesListtb").attr("actionUrl",url);
     alert(url);
     reloadTable();
 }

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesController.do?upload', "dxsActivesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesController.do?exportXls","dxsActivesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesController.do?exportXlsByT","dxsActivesList");
}
 </script>