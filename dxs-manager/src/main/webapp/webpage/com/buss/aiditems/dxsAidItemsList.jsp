<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidItemsList" checkbox="true" fitColumns="false" title="dxs_aid_items" actionUrl="dxsAidItemsController.do?datagrid&aaId=${aaId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="关联表id"  field="aaId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="内容"  field="content"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"    queryMode="group"  width="120" formatterjs="DXS.type"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidItemsController.do?doDel&id={id}" />

      <t:dgDefOpt title="内容项图片" url="dxsAidItemImageController.do?list&aaiId={id}&aaId=${aaId}" ></t:dgDefOpt>

   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidItemsController.do?goAdd&aaId=${aaId}" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidItemsController.do?goUpdate" funname="update"  height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidItemsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsAidItemsController.do?goUpdate" funname="detail"  height="720" width="1120"></t:dgToolBar>--%>
      <t:dgToolBar title="返回主题页" icon="icon-put" url="dxsAidThemeController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/aiditems/dxsAidItemsList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         type :function(value,row,index){
              if (value == "1"){
                 return "活动介绍";
             }else if (value == "2"){
                 return "活动实施意义";
             }else if (value == "3"){
                 return "达到目的";
             }else if (value == "4"){
                 return "精彩回顾";
             }else if(value == "5"){
                 return "活动总结";
             }else if(value == "6"){
             return "项目说明";
             }else if(value == "7"){
             return "捐款实施意义";
             }else if(value == "8"){
             return "项目内容";
             }else if(value == "9"){
             return "项目团队";
             }else if(value == "10"){
                  return "项目执行";
              }else if(value == "11"){
                  return "善款使用说明";
              }else if(value == "12"){
                  return "善款发票说明";
              }else if(value == "13"){
                  return "项目进展";
              }else if(value == "14"){
                  return "关于我们";
              }else {
                  return value;
              }
         }
     }

     var quizList = function(title, url, id){
         window.location.href = url;
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidItemsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidItemsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidItemsController.do?upload', "dxsAidItemsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidItemsController.do?exportXls","dxsAidItemsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidItemsController.do?exportXlsByT","dxsAidItemsList");
}
 </script>