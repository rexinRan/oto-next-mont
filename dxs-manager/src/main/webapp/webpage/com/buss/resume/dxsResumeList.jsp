<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsResumeList" checkbox="true" fitColumns="false" title="" actionUrl="dxsResumeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id"  field="userid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="姓名"  field="name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"    queryMode="group"  width="120"></t:dgCol>
  <%-- <t:dgCol title="出生日期"  field="borthday"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户籍所在地"  field="residence"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="手机号"  field="phone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="email"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idcard"    queryMode="group"  width="120"></t:dgCol>
  <%-- <t:dgCol title="学校名称"  field="schoolName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学校地址"  field="schoolAddress"    queryMode="group"  width="120"></t:dgCol>--%>
   <%-- <t:dgCol title="入学时间"  field="schoolAdmission"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="毕业时间"  field="schoolGraduation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专业"  field="schoolMajor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="schoolEducation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证书"  field="schoolCertificate"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专业技能"  field="professional"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="自我评价"  field="selfAssessment"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="简历附件"  field="accessories"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol> --%>
  <%-- <t:dgFunOpt title="" funname=""--%>
   <t:dgCol title="简历详情"  field="accessories"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsResumeController.do?doDel&id={id}" />
      <t:dgDefOpt url="drownLoad.do?download&outid={id}" title="下载简历" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsResumeController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsResumeController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsResumeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsResumeController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/resume/dxsResumeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsResumeListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsResumeListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsResumeController.do?upload', "dxsResumeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsResumeController.do?exportXls","dxsResumeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsResumeController.do?exportXlsByT","dxsResumeList");
}
 </script>