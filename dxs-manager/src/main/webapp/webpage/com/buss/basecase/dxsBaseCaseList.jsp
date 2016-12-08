<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsBaseCaseList" checkbox="true" fitColumns="false" title="基地图集" actionUrl="dxsBaseCaseController.do?datagrid&dbId=${dbId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基地主键"  field="dbId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="基地图片文件"  field="dbImgFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="图片地址"  field="dbImgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsBaseCaseController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsBaseCaseController.do?goAdd&dbId=${dbId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsBaseCaseController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsBaseCaseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsBaseCaseController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
      <t:dgToolBar title="返回创业基地" icon="icon-put" url="dxsBasesController.do?list" funname="baseList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/basecase/dxsBaseCaseList.js"></script>		
 <script type="text/javascript">
     var baseList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsBaseCaseListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBaseCaseListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBaseCaseListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBaseCaseListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsBaseCaseController.do?upload', "dxsBaseCaseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsBaseCaseController.do?exportXls","dxsBaseCaseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsBaseCaseController.do?exportXlsByT","dxsBaseCaseList");
}
 </script>