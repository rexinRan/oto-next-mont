<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEmployedList" checkbox="true" fitColumns="false" title="招聘管理" actionUrl="Employed.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="就业分类"  field="dxsEmployedCatalogEntity.employedCatalogName"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="企业用户名称"  field="dxsUserEntity.empname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职业名称"  field="employedName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工作地点"  field="employedPosition"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="月薪"  field="employedSalary"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘岗位数目"  field="employedNum"    queryMode="group"  width="120"></t:dgCol>
  <%-- <t:dgCol title="岗位职责"  field="employedResponsibilities"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任职要求"  field="employedRequirements"    queryMode="group"  width="120"></t:dgCol>--%>
      <%--<t:dgCol title="岗位类型"  field="employedType"    queryMode="group"  width="120"></t:dgCol>--%>
      <%--<t:dgCol title="工作经验"  field="experience"    queryMode="group"  width="120"></t:dgCol>--%>
      <%--<t:dgCol title="学历"  field="education"    queryMode="group"  width="120"></t:dgCol>--%>
      <%--<t:dgCol title="公司名称"  field="compancyName"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="公司网址"  field="compancyAddress"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="联系人"  field="contactName"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="电话"  field="contactTel"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="手机"  field="contactPhone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="contactMail"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="线上招聘针对大学"  field="university"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="招聘信息发布时间"  field="publishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEmployedController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="Employed.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="Employed.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="Employed.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="Employed.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>

   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/employed/dxsEmployedList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }

     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEmployedListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEmployedController.do?upload', "dxsEmployedList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEmployedController.do?exportXls","dxsEmployedList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEmployedController.do?exportXlsByT","dxsEmployedList");
}
 </script>