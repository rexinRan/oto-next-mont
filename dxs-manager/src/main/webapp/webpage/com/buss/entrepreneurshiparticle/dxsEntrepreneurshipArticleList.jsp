<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEntrepreneurshipArticleList" checkbox="true" fitColumns="false" title="文章列表" actionUrl="dxsEntrepreneurshipArticleController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创业中心分类"  field="dxsEntrepreneurshipCatalogEntity.entrepreneurshipCatalogName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="缩略图"  field="entrepreneurshipImgurl"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="创业中心文章标题"  field="entrepreneurshipTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编辑人"  field="entrepreneurshipEditor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="entrepreneurshipPublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创业中心文章内容"  field="entrepreneurshipContents"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编号"  field="entrepreneurshipSort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="修改时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEntrepreneurshipArticleController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsEntrepreneurshipArticleController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsEntrepreneurshipArticleController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsEntrepreneurshipArticleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsEntrepreneurshipArticleController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/entrepreneurshiparticle/dxsEntrepreneurshipArticleList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='entrepreneurshipPublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='entrepreneurshipPublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipArticleListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEntrepreneurshipArticleController.do?upload', "dxsEntrepreneurshipArticleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEntrepreneurshipArticleController.do?exportXls","dxsEntrepreneurshipArticleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEntrepreneurshipArticleController.do?exportXlsByT","dxsEntrepreneurshipArticleList");
}
 </script>