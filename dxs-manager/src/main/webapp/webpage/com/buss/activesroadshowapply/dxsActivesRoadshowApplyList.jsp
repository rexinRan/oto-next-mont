<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActivesRoadshowApplyList" checkbox="true" fitColumns="false" title="dxs_actives_roadshow_apply" actionUrl="dxsActivesRoadshowApplyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请人姓名"  field="dxsUserEntity.empname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业所在地"  field="companyAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="注册资金"  field="regFound"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="企业简介"  field="companyIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="团队介绍"  field="companyTeamIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="项目介绍"  field="projectIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="项目名称"  field="projectName"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="项目前景"  field="projectProspect"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="行业优势"  field="industryAdvantage"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="文件地址"  field="fileUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="文件id"  field="fileId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="路演需求"  field="roadshowNeed"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="处理结果"  field="result"    queryMode="group"  width="120" formatterjs="DXS.result"></t:dgCol>
   <%--<t:dgCol title="处理结果说明"  field="message"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsActivesRoadshowApplyController.do?doDel&id={id}" />
      <t:dgDefOpt url="drownLoad.do?download&outid={id}" title="下载" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsActivesRoadshowApplyController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActivesRoadshowApplyController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActivesRoadshowApplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActivesRoadshowApplyController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activesroadshowapply/dxsActivesRoadshowApplyList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         result : function(value, row, index){
             if (value == "0") {
                 return "<span style='color:#ff3335'>审核中</span>";
             } else if(value == "1"){
                 return "已同意";
             } else if(value=="2"){
                 return "已拒绝";
             } else {
                 return value;
             }
         }
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActivesRoadshowApplyListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesRoadshowApplyListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesRoadshowApplyListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActivesRoadshowApplyListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActivesRoadshowApplyController.do?upload', "dxsActivesRoadshowApplyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActivesRoadshowApplyController.do?exportXls","dxsActivesRoadshowApplyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActivesRoadshowApplyController.do?exportXlsByT","dxsActivesRoadshowApplyList");
}
 </script>