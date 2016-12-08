<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEntrepreneurshipCatalogList" checkbox="true" fitColumns="false" title="分类管理" actionUrl="dxsEntrepreneurshipCatalogController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="父节点"  field="pid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="创业中心分类"  field="entrepreneurshipCatalogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分类配图"  field="entrepreneurshipImg"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="分类的简介"  field="entrepreneurshipIntroduction"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编码"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEntrepreneurshipCatalogController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsEntrepreneurshipCatalogController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsEntrepreneurshipCatalogController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsEntrepreneurshipCatalogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsEntrepreneurshipCatalogController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/entrepreneurshipcatalog/dxsEntrepreneurshipCatalogList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEntrepreneurshipCatalogListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipCatalogListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipCatalogListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipCatalogListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEntrepreneurshipCatalogController.do?upload', "dxsEntrepreneurshipCatalogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEntrepreneurshipCatalogController.do?exportXls","dxsEntrepreneurshipCatalogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEntrepreneurshipCatalogController.do?exportXlsByT","dxsEntrepreneurshipCatalogList");
}
 </script>