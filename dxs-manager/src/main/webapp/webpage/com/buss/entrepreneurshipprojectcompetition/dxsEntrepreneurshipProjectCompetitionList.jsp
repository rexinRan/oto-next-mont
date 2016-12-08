<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEntrepreneurshipProjectCompetitionList" checkbox="true" fitColumns="false" title="添加创业项目" actionUrl="dxsEntrepreneurshipProjectCompetitionController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目所属领域"  field="projectAreaEntity.areaName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目所属类型"  field="projectTypeEntity.projectType"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="项目分类"  field="projectCatalog"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="项目开始时间"  field="projectStartTime"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目结束时间"  field="projectEndTime"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目状态"  field="projectStatus"    queryMode="group"  width="120" formatterjs="project1.status" align="center"></t:dgCol>
   <%--<t:dgCol title="项目简介"  field="projectProfile"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="审核码"  field="checkCode"    queryMode="group"  width="120"></t:dgCol>--%>
  <%-- <t:dgCol title="项目展示图片"  field="projectImgurl"    queryMode="group"  width="120"></t:dgCol>--%>
      <%--<t:dgCol title="审核码"  field="checkCode" queryMode="group"  width="120" formatterjs="yzg.foundation" align="center"></t:dgCol>--%>
   <t:dgCol title="项目等级"  field="projectGrade"    queryMode="group"  width="120" formatterjs="project.grade" align="center"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="45"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEntrepreneurshipProjectCompetitionController.do?doDel&id={id}" />
   <%--<t:dgDefOpt url="drownLoad.do?download&outid={id}" title="上传" />--%>
   <t:dgToolBar title="录入" icon="icon-add" url="dxsEntrepreneurshipProjectCompetitionController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsEntrepreneurshipProjectCompetitionController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsEntrepreneurshipProjectCompetitionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsEntrepreneurshipProjectCompetitionController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/entrepreneurshipprojectcompetition/dxsEntrepreneurshipProjectCompetitionList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEntrepreneurshipProjectCompetitionListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipProjectCompetitionListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipProjectCompetitionListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEntrepreneurshipProjectCompetitionListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEntrepreneurshipProjectCompetitionController.do?upload', "dxsEntrepreneurshipProjectCompetitionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEntrepreneurshipProjectCompetitionController.do?exportXls","dxsEntrepreneurshipProjectCompetitionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEntrepreneurshipProjectCompetitionController.do?exportXlsByT","dxsEntrepreneurshipProjectCompetitionList");
}
 </script>