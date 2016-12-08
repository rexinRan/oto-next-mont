<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsVoteItemList" checkbox="true" fitColumns="false" title="投票项" actionUrl="dxsVoteItemController.do?datagrid&voteId=${voteId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="投票id"  field="voteId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="投票项标题"  field="viTitle"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="投票内容"  field="viContent"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="投票项图片"  field="itemImage"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="所得投票数"  field="itemNum"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsVoteItemController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsVoteItemController.do?goAdd&voteId=${voteId}" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsVoteItemController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsVoteItemController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsVoteItemController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsVoteController.do?list" funname="fanhui"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/voteitem/dxsVoteItemList.js"></script>		
 <script type="text/javascript">
     var fanhui = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsVoteItemListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteItemListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteItemListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsVoteItemListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsVoteItemController.do?upload', "dxsVoteItemList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsVoteItemController.do?exportXls","dxsVoteItemList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsVoteItemController.do?exportXlsByT","dxsVoteItemList");
}
 </script>