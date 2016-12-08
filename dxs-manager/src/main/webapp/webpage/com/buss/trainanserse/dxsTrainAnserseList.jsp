<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainAnserseList" checkbox="true" fitColumns="false" title="dxs_train_anserse" actionUrl="dxsTrainAnserseController.do?datagrid&ttId=${ttId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="性格特征解析"  field="characterAnalysis"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="性格类型"  field="characterType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="性格特质"  field="characterTrait"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="适合从事"  field="characterSuitible"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="代表人物及身份"  field="symbol"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="代表人物语录"  field="symbolSay"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="结果"  field="result"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="基本描述"  field="baseIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="适合领域"  field="suitField"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="适合岗位"  field="sultJob"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="气质类型"  field="temperamentType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="总体描述"  field="generalIntrodece"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="潜在弱点"  field="weakness"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="优势"  field="advantage"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="劣势"  field="inferiority"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainAnserseController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainAnserseController.do?goAdd&ttId=${ttId}" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainAnserseController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainAnserseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainAnserseController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="返回" icon="icon-put" url="dxsTrainTestController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainanserse/dxsTrainAnserseList.js"></script>		
 <script type="text/javascript">
  var quizList = function(title, url, id){
   window.location.href = url;
  }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainAnserseListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainAnserseListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainAnserseListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainAnserseListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainAnserseController.do?upload', "dxsTrainAnserseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainAnserseController.do?exportXls","dxsTrainAnserseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainAnserseController.do?exportXlsByT","dxsTrainAnserseList");
}
 </script>