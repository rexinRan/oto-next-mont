<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsIndexArticleList" checkbox="true" fitColumns="false" title="文章管理" actionUrl="dxsIndexArticleController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="首页分类"  field="dxsIndexCatelogEntity.indexCatelogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文章标题"  field="articleTitle"    query="true"  width="120"></t:dgCol>
   <t:dgCol title="文章编辑人"  field="articleEditor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文章发布时间"  field="articlePublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文章简介"  field="articleIntroduction"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="文章内容"  field="articleContents"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="文章排序"  field="articleSort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="文章缩略图"  field="articleImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="文章视频"  field="articleVideoUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsIndexArticleController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsIndexArticleController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsIndexArticleController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsIndexArticleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsIndexArticleController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/indexarticle/dxsIndexArticleList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsIndexArticleListtb").find("input[name='articlePublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsIndexArticleListtb").find("input[name='articlePublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsIndexArticleListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsIndexArticleListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsIndexArticleListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsIndexArticleListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsIndexArticleController.do?upload', "dxsIndexArticleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsIndexArticleController.do?exportXls","dxsIndexArticleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsIndexArticleController.do?exportXlsByT","dxsIndexArticleList");
}
 </script>