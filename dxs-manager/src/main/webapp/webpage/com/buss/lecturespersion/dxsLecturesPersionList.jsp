<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsLecturesPersionList" checkbox="true" fitColumns="false" title="dxs_lectures_persion" actionUrl="dxsLecturesPersionController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id(预留)"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="姓名"  field="prosonName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职位"  field="prosonJob"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="地点"  field="prosonAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="毕业院校"  field="prosonEdu"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="社会最高职位"  field="prosonTopJob"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="现任职单位"  field="prosonNowJob"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="企业经营项目"  field="prosonNowProject"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="个人履历"  field="prosonResumeDisplay"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="企业家风采视频"  field="prosonStyleVideo"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="企业家风采描述"  field="prosonStyle"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="个人成就展"  field="prosonAccomplishment"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="类别"  field="type"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsLecturesPersionController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsLecturesPersionController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsLecturesPersionController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsLecturesPersionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsLecturesPersionController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/lecturespersion/dxsLecturesPersionList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsLecturesPersionListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesPersionListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesPersionListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsLecturesPersionListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsLecturesPersionController.do?upload', "dxsLecturesPersionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsLecturesPersionController.do?exportXls","dxsLecturesPersionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsLecturesPersionController.do?exportXlsByT","dxsLecturesPersionList");
}
 </script>