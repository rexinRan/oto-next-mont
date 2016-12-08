<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainTestSubjectItemList" checkbox="true" fitColumns="false" title="dxs_train_test_subject_item" actionUrl="dxsTrainTestSubjectItemController.do?datagrid&ttsId=${ttsId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="试题ID"  field="ttsId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="试题项内容"  field="itemName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="测试偏向"  field="itemObject"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgColl title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgColl>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainTestSubjectItemController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainTestSubjectItemController.do?goAdd&ttsId=${ttsId}" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainTestSubjectItemController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainTestSubjectItemController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainTestSubjectItemController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>

      <t:dgToolBar title="返回试题管理" icon="icon-search" url="dxsTrainTestSubjectController.do?list&ttId=${ttId}" funname="quizList"></t:dgToolBar>

   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBaroolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBaroolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/traintestsubjectitem/dxsTrainTestSubjectItemList.js"></script>		
 <script type="text/javascript">

     var quizList = function(title, url, id){
         window.location.href = url;
     }


     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainTestSubjectItemListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectItemListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectItemListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainTestSubjectItemListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainTestSubjectItemController.do?upload', "dxsTrainTestSubjectItemList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainTestSubjectItemController.do?exportXls","dxsTrainTestSubjectItemList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainTestSubjectItemController.do?exportXlsByT","dxsTrainTestSubjectItemList");
}
 </script>