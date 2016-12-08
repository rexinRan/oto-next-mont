<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsCompanyList" checkbox="true" fitColumns="false" title="公司网站群列表" actionUrl="dxsCompanyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司信息"  field="name"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公司简介"  field="about"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="电话"  field="groupTel"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="集团客服中心电话"  field="groupServiceTel"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="中心邮箱"  field="advertiseEmail"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="集团总部位置"  field="groupAddress"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="版权信息"  field="copyright"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备案信息"  field="record"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="微信公众号"  field="ext1"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="俱乐部网站"  field="ext2"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="传媒网址"  field="ext3"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="集团网站"  field="ext4"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="集团总部"  field="ext5"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="公司简介详情"  field="ext6"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsCompanyController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsCompanyController.do?goAdd" funname="add" height="600" width="800"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsCompanyController.do?goUpdate" funname="update" height="600" width="800"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsCompanyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsCompanyController.do?goUpdate" funname="detail" height="600" width="800"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/company/dxsCompanyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsCompanyController.do?upload', "dxsCompanyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsCompanyController.do?exportXls","dxsCompanyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsCompanyController.do?exportXlsByT","dxsCompanyList");
}
 </script>