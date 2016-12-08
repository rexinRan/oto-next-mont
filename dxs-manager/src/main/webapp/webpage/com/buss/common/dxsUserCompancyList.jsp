<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsUserCompancyList" checkbox="true" fitColumns="false" title="企业详情列表" actionUrl="dxsUserCompancyController.do?datagrid&userId=${userId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="企业ID"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="公司名称"  field="compancyName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司官网"  field="compancyAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司展示图"  field="displayImg"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司视频展示"  field="displayVideo"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人"  field="contactName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人电话"  field="contactTel"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司规模"  field="compancyNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司地点"  field="compancyPositation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司介绍"  field="compancyIntroduce"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属行业"  field="compancyType"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsUserCompancyController.do?doDel&id={id}" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsUserCompancyController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsUserCompancyController.do?goUpdate" funname="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsUserCompancyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsUserCompancyController.do?goUpdate" funname="detail"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="javascript:history.back(-1)" funname="fanhui"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/usercompancy/dxsUserCompancyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsUserCompancyListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserCompancyListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserCompancyListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserCompancyListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsUserCompancyController.do?upload', "dxsUserCompancyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsUserCompancyController.do?exportXls","dxsUserCompancyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsUserCompancyController.do?exportXlsByT","dxsUserCompancyList");
}
 </script>