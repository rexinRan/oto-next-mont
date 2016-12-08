<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsBasesList" checkbox="true" fitColumns="false" title="dxs_bases" actionUrl="dxsBasesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基地名称"  field="baseName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基地缩图文件"  field="baseImgFid"    queryMode="group"  width="120"></t:dgCol>--%>

   <%--<t:dgCol title="基地缩图地址"  field="baseImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="视频文件id"  field="baseVideoFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="视频播放地址"  field="baseVideoUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="基地简介"  field="baseIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>

   <%--<t:dgCol title="基地缩图地址"  field="baseImgUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="视频文件id"  field="baseVideoFid"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="视频播放地址"  field="baseVideoUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="基地简介"  field="baseIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>


   <t:dgCol title="主管单位"  field="baseUnitName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基地级别"  field="baseClass"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="优惠政策"  field="basePolicy"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="入驻指南"  field="baseGuide"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="详细地址"  field="baseAddress"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsBasesController.do?doDel&id={id}" />
      <t:dgDefOpt title="基地图片集" url="dxsBaseCaseController.do?list&dbId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsBasesController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsBasesController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsBasesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsBasesController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/bases/dxsBasesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsBasesListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBasesListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBasesListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsBasesListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsBasesController.do?upload', "dxsBasesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsBasesController.do?exportXls","dxsBasesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsBasesController.do?exportXlsByT","dxsBasesList");
}
 </script>