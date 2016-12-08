<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsContentList" checkbox="true" fitColumns="false" title="" actionUrl="dxsContentController.do?datagrid" idField="id" fit="true" queryMode="group" >
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="内容类目ID"  field="cid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="内容标题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="子标题"  field="subTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="标题描述"  field="titleDesc"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="排序"  field="sortid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否可用"  field="status"    queryMode="group"  width="120" formatterjs="DXS.status" align="center"></t:dgCol>
   <t:dgCol title="链接"  field="url"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="图片绝对路径"  field="pic"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="created"  field="created" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="updated"  field="updated" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="ext1"  field="ext1"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="ext2"  field="ext2"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsContentController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsContentController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsContentController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsContentController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsContentController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/content/dxsContentList.js"></script>		
 <script type="text/javascript">
     var DXS= {
         status : function(value, row,index){
             if (value == "1"){
                 return "<span style='color:#ff3335'>否</span>";
             }else if (value == "0"){
                 return "是";
             }else  {
                 return value;
             }
         }
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsContentListtb").find("input[name='created_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsContentListtb").find("input[name='created_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsContentListtb").find("input[name='updated_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsContentListtb").find("input[name='updated_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsContentController.do?upload', "dxsContentList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsContentController.do?exportXls","dxsContentList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsContentController.do?exportXlsByT","dxsContentList");
}
 </script>