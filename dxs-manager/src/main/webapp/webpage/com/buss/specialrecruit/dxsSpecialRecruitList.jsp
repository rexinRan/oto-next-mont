<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialRecruitList" checkbox="true" fitColumns="false" title="dxs_special_recruit" actionUrl="dxsSpecialRecruitController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专场大学"  field="spSchool"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专场缩略图"  field="spImgurlFid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专场图片地址"  field="spImgurl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘专业方向"  field="spDirection"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘岗位数"  field="spJobNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学历层次"  field="spEducation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="日期"  field="holdDatatime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="举办年份"  field="holdDate"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="举办场次"  field="holdNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="详细地址"  field="spAddress"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialRecruitController.do?doDel&id={id}" />
      <t:dgDefOpt title="进入详情" url="dxsSpecialRecruitJobController.do?list&srId={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialRecruitController.do?goAdd" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialRecruitController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialRecruitController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialRecruitController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialrecruit/dxsSpecialRecruitList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialRecruitListtb").find("input[name='holdDatatime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitListtb").find("input[name='holdDatatime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialRecruitController.do?upload', "dxsSpecialRecruitList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialRecruitController.do?exportXls","dxsSpecialRecruitList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialRecruitController.do?exportXlsByT","dxsSpecialRecruitList");
}
 </script>