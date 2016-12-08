<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsVoteList" checkbox="true" fitColumns="false" title="在线投票" actionUrl="dxsVoteController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  query="true"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="投票分类的id"  field="voteId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="投票标题"  field="voteTitle"    query="true"  width="120"></t:dgCol>
   <%--<t:dgCol title="投票活动缩略图"  field="voteImage"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="展示菜单"  field="displayMenu"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="投票地点"  field="voteAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主办单位"  field="hostUnit"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="限报人数"  field="limitedNumber"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="精彩回顾"  field="histaryDate"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="截止投票时间"  field="deadlineDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动开始时间"  field="voteStateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动结束时间"  field="voteEndTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="活动对象"  field="voteUsertypeId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="活动内容"  field="voteIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="投票规则"  field="voteRule"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="投票总人数"  field="voteNum"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="投票总票数"  field="voteCount"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="是否收费"  field="isCharge"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="可得到鸿鑫币数量"  field="maxAccountCount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编辑人"  field="activeEditor"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsVoteController.do?doDel&id={id}" />
      <t:dgDefOpt title="查看详情" url="dxsVoteItemController.do?list&voteId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsVoteController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsVoteController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsVoteController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsVoteController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/vote/dxsVoteList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsVoteListtb").find("input[name='deadlineDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='deadlineDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='voteStateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='voteStateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='voteEndTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='voteEndTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='publishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='publishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsVoteController.do?upload', "dxsVoteList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsVoteController.do?exportXls","dxsVoteList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsVoteController.do?exportXlsByT","dxsVoteList");
}
 </script>