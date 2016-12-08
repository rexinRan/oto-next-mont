<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSchoolPartnershipList" checkbox="true" fitColumns="false" title="dxs_school_partnership" actionUrl="dxsSchoolPartnershipController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  query="true"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id(预留)"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="学校logo"  field="logoImg"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="学院名称"  field="schoolName"    query="true"  width="120"></t:dgCol>
   <%--<t:dgCol title="学校简介"  field="schoolIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="校园风景"  field="schoolScenery"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="特色展示"  field="schoolDisplay"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="校址"  field="schoolRealAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="网址"  field="schoolNetAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="schoolPhone"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSchoolPartnershipController.do?doDel&id={id}" />
      <t:dgDefOpt title="图集详情" url="dxsSchoolPartnershipImgsController.do?list&spId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSchoolPartnershipController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSchoolPartnershipController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSchoolPartnershipController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSchoolPartnershipController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/schoolpartnership/dxsSchoolPartnershipList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSchoolPartnershipListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSchoolPartnershipListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSchoolPartnershipListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSchoolPartnershipListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSchoolPartnershipController.do?upload', "dxsSchoolPartnershipList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSchoolPartnershipController.do?exportXls","dxsSchoolPartnershipList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSchoolPartnershipController.do?exportXlsByT","dxsSchoolPartnershipList");
}
 </script>