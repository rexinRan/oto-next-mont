<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidCatelogList" checkbox="true" fitColumns="false" title="dxs_aid_catelog" actionUrl="dxsAidCatelogController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫分类的名称"  field="aidCatelogName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫分类的描述"  field="aidCatelogDescribe"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫分类的配图"  field="aidCatelogImg"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫分类显示位置"  field="aidCatelogPosition"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="父id"  field="pid"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="扶贫分类的创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="扶贫分类的修改时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="排序"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidCatelogController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidCatelogController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidCatelogController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidCatelogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsAidCatelogController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/aidcatelog/dxsAidCatelogList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidCatelogListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidCatelogListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidCatelogListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidCatelogListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidCatelogController.do?upload', "dxsAidCatelogList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidCatelogController.do?exportXls","dxsAidCatelogList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidCatelogController.do?exportXlsByT","dxsAidCatelogList");
}
 </script>