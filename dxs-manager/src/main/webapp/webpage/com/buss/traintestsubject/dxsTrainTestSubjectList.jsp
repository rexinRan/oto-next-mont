<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainTestSubjectList" checkbox="true" fitColumns="false" title="dxs_train_test_subject" actionUrl="dxsTrainTestSubjectController.do?datagrid&ttId=${ttId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="试卷id"  field="ttId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="题号"  field="subjectNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="试题内容"  field="subjectContent"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="测试项(预留)"  field="testContent"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="试题组"  field="subjectGroup"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainTestSubjectController.do?doDel&id={id}" />

      <t:dgDefOpt url="dxsTrainTestSubjectItemController.do?list&ttsId={id}&ttId=${ttId}" title="试题项管理"></t:dgDefOpt>

   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainTestSubjectController.do?goAdd&ttId=${ttId}" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainTestSubjectController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainTestSubjectController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainTestSubjectController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>

      <t:dgToolBar title="返回试卷管理" icon="icon-put" url="dxsTrainTestController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/traintestsubject/dxsTrainTestSubjectList.js"></script>		
 <script type="text/javascript">

     var quizList = function(title, url, id){
         window.location.href = url;
     }


     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainTestSubjectListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainTestSubjectController.do?upload', "dxsTrainTestSubjectList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainTestSubjectController.do?exportXls","dxsTrainTestSubjectList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainTestSubjectController.do?exportXlsByT","dxsTrainTestSubjectList");
}
 </script>