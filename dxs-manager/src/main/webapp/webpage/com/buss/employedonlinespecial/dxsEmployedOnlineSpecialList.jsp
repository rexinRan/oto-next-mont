<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsEmployedOnlineSpecialList" checkbox="true" fitColumns="false" title="dxs_employed_online_special" actionUrl="dxsEmployedOnlineSpecialController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="视频播放地址"  field="videoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="小缩略图"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="banner图"  field="imgBannerUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="通告地址(预留)"  field="noteUrl"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="开始时间"  field="startTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="结束时间"  field="endTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否开放"  field="isPublic"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新日期"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsEmployedOnlineSpecialController.do?doDel&id={id}" />
      <t:dgDefOpt title="进入详情" url="EmployedController.do?list&osId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsEmployedOnlineSpecialController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsEmployedOnlineSpecialController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsEmployedOnlineSpecialController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsEmployedOnlineSpecialController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/employedonlinespecial/dxsEmployedOnlineSpecialList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='startTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='startTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='endTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='endTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsEmployedOnlineSpecialListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsEmployedOnlineSpecialController.do?upload', "dxsEmployedOnlineSpecialList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsEmployedOnlineSpecialController.do?exportXls","dxsEmployedOnlineSpecialList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsEmployedOnlineSpecialController.do?exportXlsByT","dxsEmployedOnlineSpecialList");
}
 </script>