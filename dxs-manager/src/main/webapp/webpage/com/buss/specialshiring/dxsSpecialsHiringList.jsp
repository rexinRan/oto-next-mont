<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialsHiringList" checkbox="true" fitColumns="false" title="dxs_specials_hiring" actionUrl="dxsSpecialsHiringController.do?datagrid&specialsId=${specialsId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="专项就业id"  field="specialsId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="标题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="简介"  field="introduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="选聘范围"  field="hiringRange"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="选聘数量"  field="hiringNum"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="选聘专业"  field="hiringMajor"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="选聘条件"  field="hiringCondition"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="选聘地点"  field="hiringPlace"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="志愿项目"  field="hiringJob"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="网上报名时间及要求"  field="hiringNet"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="笔试时间及要求"  field="hiringExam"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="资格初审内容及标准"  field="hiringStandard"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="面试时间及相关事宜"  field="hiringInterview"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="确定拟聘用人员时间及标准"  field="hiringPlan"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="体验和心理测试"  field="hiringExperience"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="资格复审"  field="hiringRetest"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="办理报到手续及签订劳动合同"  field="hiringReport"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="岗前培训"  field="hiringJobTraining"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="持证上岗"  field="hiringCertiticates"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="联系人及联系电话"  field="hiringContact"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="附件"  field="hiringEnclosureFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="附件地址"  field="hiringEnclosureUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="选聘项目(预留)"  field="hiringProject"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="发布单位"  field="publishCompany"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialsHiringController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialsHiringController.do?goAdd&specialsId=${specialsId}&type=${type}" funname="add" height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialsHiringController.do?goUpdate&type=${type}" funname="update"  height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialsHiringController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialsHiringController.do?goUpdate" funname="detail"  height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="返回" icon="icon-put" url="dxsSpecialsController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialshiring/dxsSpecialsHiringList.js"></script>		
 <script type="text/javascript">
  var quizList = function(title, url, id){
   window.location.href = url;
  }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialsHiringListtb").find("input[name='publishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsHiringListtb").find("input[name='publishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsHiringListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsHiringListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsHiringListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsHiringListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialsHiringController.do?upload', "dxsSpecialsHiringList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialsHiringController.do?exportXls","dxsSpecialsHiringList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialsHiringController.do?exportXlsByT","dxsSpecialsHiringList");
}
 </script>