<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="entrepreneurshipProjectArticleList" checkbox="true" fitColumns="false" title="创业基地项目" actionUrl="entrepreneurshipProjectArticleController.do?datagrid&isDelete=0&type=4" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名称"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创业基地"  field="entrepreneurshipArticleEntity.entrepreneurshipTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否专利"  field="isPatent"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目介绍"  field="projectIntroduce"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属领域"  field="projectionField"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产品类型"  field="projectionType"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目计划书"  field="projectionPlan"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目进展"  field="projectionProgress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="经营范围"  field="projectionScope"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核码"  field="checkCode" queryMode="group"  width="120" formatterjs="yzg.foundation" align="center"></t:dgCol>
   <t:dgCol title="项目类型"  field="type" queryMode="group"  width="120" formatterjs="type.applicationType" align="center"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>

   <%--杨治国--%>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="entrepreneurshipProjectArticleController.do?doDel&id={id}" />
   <t:dgConfOpt message="确认审核通过?" title="同意" url="entrepreneurshipProjectArticleController.do?empower&id={id}" />
   <t:dgConfOpt message="确认审核拒绝?" title="拒绝" url="entrepreneurshipProjectArticleController.do?reject&id={id}" />
   <t:dgDefOpt url="drownLoad.do?download&outid={id}" title="下载" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="entrepreneurshipProjectArticleController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="entrepreneurshipProjectArticleController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="entrepreneurshipProjectArticleController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="entrepreneurshipProjectArticleController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/entrepreneurshipProjectArticle/entrepreneurshipProjectArticleList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#entrepreneurshipProjectArticleListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#entrepreneurshipProjectArticleListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#entrepreneurshipProjectArticleListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#entrepreneurshipProjectArticleListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'entrepreneurshipProjectArticleController.do?upload', "entrepreneurshipProjectArticleList");
}

//导出
function ExportXls() {
	JeecgExcelExport("entrepreneurshipProjectArticleController.do?exportXls","entrepreneurshipProjectArticleList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("entrepreneurshipProjectArticleController.do?exportXlsByT","entrepreneurshipProjectArticleList");
}
 </script>