<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsFileList" checkbox="true" fitColumns="false" title="dxs_file" actionUrl="dxsFileController.do?datagrid&outId=${outId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="外键"  field="outId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="连接表"  field="tableType"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="文件名"  field="name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="title"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件类型"  field="filetype"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件审核状态"  field="checkstatus"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="下载地址"  field="downloadUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="createtime"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="updatetime"  field="updatetime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDetail"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="dxsFileController.do?doDel&id={id}" />--%>
   <%--<t:dgDelOpt title="编辑" url="dxsFileController.do?goUpdate" funname="update" />--%>
   <t:dgToolBar title="录入文件" icon="icon-add" url="dxsFileController.do?goAdd&outId=${outId}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="修改文件" icon="icon-edit" url="dxsFileController.do?wenJianUpdate&outId=${outId}" funname="update"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsActivesMathchController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsFileController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsFileController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/file/dxsFileList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }

 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsFileListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFileListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFileListtb").find("input[name='updatetime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsFileListtb").find("input[name='updatetime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsFileController.do?upload', "dxsFileList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsFileController.do?exportXls","dxsFileList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsFileController.do?exportXlsByT","dxsFileList");
}
 </script>