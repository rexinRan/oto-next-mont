<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsUserDetailList" checkbox="true" fitColumns="false" title="用户详情列表" actionUrl="dxsUserDetailController.do?datagrid&userid=${userId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id"  field="userid"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="真实姓名"  field="name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="头像(预留)"  field="headImg"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身高(预留)"  field="bodyHight"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="体重(预留)"  field="bodyWeight"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="出生日期(预留)"  field="borthday"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户籍所在地(预留)"  field="residence"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="手机号"  field="phone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="email"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="民族(预留)"  field="preNative"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idcard"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="QQ"  field="qq"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="MSN(预留)"  field="msn"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学校名称"  field="schoolName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学校所在地"  field="schoolAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入学时间(预留)"  field="schoolAdmission"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="毕业时间(预留)"  field="schoolGraduation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="年级"  field="schoolGrade"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专业"  field="schoolMajor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="schoolEducation"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证书(预留)"  field="schoolCertificate"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="个人爱好"  field="hobby"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsUserDetailController.do?doDel&id={id}" />

   <%--<t:dgConfOpt exp="opt#eq#111" url="commonToPage.do?pack=user&path=dxsUserStudentList&checkstatus=4&opt=111"--%>
                <%--message="确认完毕,提交申请?" title="办理"></t:dgConfOpt>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsUserDetailController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsUserDetailController.do?goUpdate" funname="update" width="" height=""></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsUserDetailController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看详情" icon="icon-search" url="dxsUserDetailController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="返回" icon="icon-put" url="dxsUserController.do?list" funname="fan" ></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/userdetail/dxsUserDetailList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsUserDetailListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserDetailListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserDetailListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsUserDetailListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsUserDetailController.do?upload', "dxsUserDetailList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsUserDetailController.do?exportXls","dxsUserDetailList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsUserDetailController.do?exportXlsByT","dxsUserDetailList");
}
 </script>