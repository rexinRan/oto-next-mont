<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidItemImageList" checkbox="true" fitColumns="false" title="dxs_aid_item_image" actionUrl="dxsAidItemImageController.do?datagrid&aaiId=${aaiId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="扶贫内容项主键"  field="aaiId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="图片地址"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidItemImageController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidItemImageController.do?goAdd&aaiId=${aaiId}" funname="add"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidItemImageController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidItemImageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsAidItemImageController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>--%>
  <t:dgToolBar title="返回内容项页" icon="icon-put" url="dxsAidItemsController.do?list&aaId=${aaId}" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/aiditemimage/dxsAidItemImageList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidItemImageListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemImageListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemImageListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemImageListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidItemImageController.do?upload', "dxsAidItemImageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidItemImageController.do?exportXls","dxsAidItemImageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidItemImageController.do?exportXlsByT","dxsAidItemImageList");
}
 </script>