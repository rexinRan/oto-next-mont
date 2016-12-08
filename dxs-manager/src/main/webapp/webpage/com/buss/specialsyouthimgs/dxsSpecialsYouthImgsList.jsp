<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialsYouthImgsList" checkbox="true" fitColumns="false" title="dxs_specials_youth_imgs" actionUrl="dxsSpecialsYouthImgsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="用户id(预留)"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="类型,菜单"  field="type"    queryMode="group"  width="120" formatterjs="DXS.type"></t:dgCol>
   <t:dgCol title="标题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缩略图地址"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="简介"  field="introduce"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialsYouthImgsController.do?doDel&id={id}" />

   <t:dgDefOpt title="专项就业图片详情" url="dxsSpecialsYouthImgController.do?list&dsyiId={id}"/>

   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialsYouthImgsController.do?goAdd" funname="add" height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialsYouthImgsController.do?goUpdate" funname="update" height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialsYouthImgsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialsYouthImgsController.do?goUpdate" funname="detail" height="720" width="1200"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialsyouthimgs/dxsSpecialsYouthImgsList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         type: function(value, row, index){
             if (value == "1") {
                 return "三支一扶";
             } else if(value=="2"){
                 return "边区支教";
             } else if(value=="3"){
                 return "志愿西部";
             } else if(value=="4"){
                 return "大学生村官";
             }else{
                 return value;
             }
         }
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsSpecialsYouthImgsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsYouthImgsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsYouthImgsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsYouthImgsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialsYouthImgsController.do?upload', "dxsSpecialsYouthImgsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialsYouthImgsController.do?exportXls","dxsSpecialsYouthImgsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialsYouthImgsController.do?exportXlsByT","dxsSpecialsYouthImgsList");
}
 </script>