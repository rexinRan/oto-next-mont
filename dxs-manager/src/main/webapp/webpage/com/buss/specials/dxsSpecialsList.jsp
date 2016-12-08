<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialsList" checkbox="true" fitColumns="false" title="dxs_specials" actionUrl="dxsSpecialsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="介绍"  field="introduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="视频地址"  field="videoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缩略图"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="志愿者招募对象和条件"  field="volunteerObj"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="招募方式"  field="volunteerJoinType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="服务期限"  field="volunteerService"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="业务指导与监测评估"  field="volunteerAssessment"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="工作时间及工作量"  field="volunteerWorks"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="文化活动安排"  field="volunteerActive"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="志愿者培训"  field="volunteerTeach"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="工作点的设置与管理"  field="volunteerManager"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="所属分类"  field="type"    queryMode="group"  width="120" formatterjs="DXS.type"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialsController.do?doDel&id={id}" />
   <t:dgDefOpt title="选聘简章" url="dxsSpecialsHiringController.do?list&specialsId={id}&type={type}" />
      <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialsController.do?goAdd" funname="add" height="720" width="1200"></t:dgToolBar>
      <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialsController.do?goUpdate" funname="update" height="720" width="1200"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialsController.do?goUpdate" funname="detail" height="720" width="1200"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specials/dxsSpecialsList.js"></script>		
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
 			$("#dxsSpecialsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialsController.do?upload', "dxsSpecialsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialsController.do?exportXls","dxsSpecialsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialsController.do?exportXlsByT","dxsSpecialsList");
}
 </script>