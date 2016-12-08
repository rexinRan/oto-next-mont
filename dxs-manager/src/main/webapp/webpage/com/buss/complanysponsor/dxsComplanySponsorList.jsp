<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsComplanySponsorList" checkbox="true" fitColumns="true" title="dxs_complany_sponsor" actionUrl="dxsComplanySponsorController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请公司"  field="dxsUserEntity.empname"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="企业log"  field="logAddress"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="公司名称"  field="complanyName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司网址"  field="complanyWebAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属行业"  field="complanyField"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="办公地点"  field="complanyRealAddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信公众号"  field="complanyWeixin"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="公司简介"  field="complanyIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="公司规模"  field="complanyNum"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="营业执照图"  field="complanyLicenseImg"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="营业执照编号"  field="complanyLicenseNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="complanyIdcard"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="赞助活动"  field="complanyActive"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人姓名"  field="contactsName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人职位"  field="contentsJob"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="单位介绍函"  field="contentsLetter"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="联系人邮箱"  field="contactsEmail"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人单位座机"  field="contentsTel"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人手机号"  field="contentIphone"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系人QQ"  field="contentQq"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsComplanySponsorController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsComplanySponsorController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsComplanySponsorController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsComplanySponsorController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsComplanySponsorController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/complanysponsor/dxsComplanySponsorList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsComplanySponsorListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsComplanySponsorListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsComplanySponsorListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsComplanySponsorListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsComplanySponsorController.do?upload', "dxsComplanySponsorList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsComplanySponsorController.do?exportXls","dxsComplanySponsorList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsComplanySponsorController.do?exportXlsByT","dxsComplanySponsorList");
}
 </script>