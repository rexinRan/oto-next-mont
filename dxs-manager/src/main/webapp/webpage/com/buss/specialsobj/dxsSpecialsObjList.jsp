<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialsObjList" checkbox="true" fitColumns="false" title="dxs_specials_obj" actionUrl="dxsSpecialsObjController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="userId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="选聘简章id"  field="shId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请省"  field="objAddressProvince"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请市"  field="objAddressCity"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请项目"  field="objProject"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请类型"  field="type"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请结果"  field="result"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialsObjController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialsObjController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialsObjController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialsObjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialsObjController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialsobj/dxsSpecialsObjList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialsObjListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsObjListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsObjListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsObjListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialsObjController.do?upload', "dxsSpecialsObjList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialsObjController.do?exportXls","dxsSpecialsObjList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialsObjController.do?exportXlsByT","dxsSpecialsObjList");
}
 </script>