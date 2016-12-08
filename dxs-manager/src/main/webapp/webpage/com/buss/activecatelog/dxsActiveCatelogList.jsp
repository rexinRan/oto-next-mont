<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActiveCatelogList" checkbox="true" fitColumns="false" title="分类管理" actionUrl="dxsActiveCatelogController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动种类名称"  field="activeCatelogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动种类配图"  field="activeCatelogImg"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动种类的描述"  field="activeCatelogDescribe"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动种类的排序"  field="activeCatelogSort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActiveCatelogController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActiveCatelogController.do?goAdd" funname="add" height="600" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActiveCatelogController.do?goUpdate" funname="update"  height="600" width="800"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActiveCatelogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActiveCatelogController.do?goUpdate" funname="detail"  height="600" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activecatelog/dxsActiveCatelogList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActiveCatelogListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveCatelogListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveCatelogListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveCatelogListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActiveCatelogController.do?upload', "dxsActiveCatelogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActiveCatelogController.do?exportXls","dxsActiveCatelogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActiveCatelogController.do?exportXlsByT","dxsActiveCatelogList");
}
 </script>