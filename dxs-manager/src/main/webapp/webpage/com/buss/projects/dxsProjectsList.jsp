<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsProjectsList" checkbox="true" fitColumns="false" title="dxs_projects" actionUrl="dxsProjectsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名称"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="大赛名称"  field="dxsCompetitionEntity.competitionTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目标识"  field="projectImg"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属行业"  field="projectIndustry"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="所属类别"  field="projectType"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="是否与高校科技结合"  field="isSchoolTechnology"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="股权结构"  field="isStock"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="团队名称"  field="teamName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="项目介绍"  field="projectIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="项目进展"  field="projectProgress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目计划书"  field="projectPlanFileurl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="成员人数"  field="userNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="隐私设置"  field="isPrivacy"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否结束"  field="isEnd"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基金需求"  field="foundNeed"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="基地需求"  field="addressNeed"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="招聘需求"  field="recruitNeed"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="参赛类型(给推荐预留)"  field="joinType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="修改次数"  field="updateCount"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsProjectsController.do?doDel&id={id}" />
   <t:dgDefOpt url="drownLoad.do?downloadfid&fid={projectPlanFileurl}" title="下载" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsProjectsController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsProjectsController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsProjectsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsProjectsController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/projects/dxsProjectsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsProjectsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsProjectsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsProjectsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsProjectsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsProjectsController.do?upload', "dxsProjectsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsProjectsController.do?exportXls","dxsProjectsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsProjectsController.do?exportXlsByT","dxsProjectsList");
}
 </script>