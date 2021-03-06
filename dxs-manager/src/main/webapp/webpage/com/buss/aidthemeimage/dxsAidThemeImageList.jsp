<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidThemeImageList" checkbox="true" fitColumns="false" title="dxs_aid_theme_image" actionUrl="dxsAidThemeImageController.do?datagrid&atId=${atId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="主题主键"  field="atId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="图片地址"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="图片介绍"  field="content"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="图片标题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidThemeImageController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidThemeImageController.do?goAdd&atId=${atId}" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidThemeImageController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidThemeImageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsAidThemeImageController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>
      <t:dgToolBar title="返回" icon="icon-put" url="dxsAidThemeController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>

 </div>
 <script src = "webpage/com/buss/aidthemeimage/dxsAidThemeImageList.js"></script>		
 <script type="text/javascript">
     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidThemeImageListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidThemeImageListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidThemeImageListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidThemeImageListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidThemeImageController.do?upload', "dxsAidThemeImageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidThemeImageController.do?exportXls","dxsAidThemeImageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidThemeImageController.do?exportXlsByT","dxsAidThemeImageList");
}
 </script>