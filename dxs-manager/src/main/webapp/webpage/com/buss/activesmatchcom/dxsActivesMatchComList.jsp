<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesMatchComList" checkbox="true" fitColumns="false" title="dxs_actives_match_com" actionUrl="dxsActivesMatchComController.do?datagrid&amId=${amId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动名称"  field="dxsActivesEntity.activeTitle"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="校园赛事id"  field="amId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="缩略图id"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="companyName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司展示分类"  field="dataType"    queryMode="group"  width="120" formatterjs="DXS.dataType"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesMatchComController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesMatchComController.do?goAdd&amId=${amId}&activesId=${activesId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesMatchComController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesMatchComController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesMatchComController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsActivesFriendshipController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesmatchcom/dxsActivesMatchComList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         dataType: function (value, row, index) {
             if (value == "1") {
                 return "主办单位";
             } else if (value == "2") {
                 return "协办单位";
             }else if (value == "3") {
                 return "承办单位";
             }else if (value == "4") {
                 return "赞助单位";
             }else if (value == "5") {
                 return "支持单位";
             }else if (value == "6") {
                 return "媒体单位";
             } else {
                 return value;
             }
         }
     }
     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesMatchComListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesMatchComListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesMatchComListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesMatchComListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesMatchComController.do?upload', "dxsActivesMatchComList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesMatchComController.do?exportXls","dxsActivesMatchComList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesMatchComController.do?exportXlsByT","dxsActivesMatchComList");
}
 </script>