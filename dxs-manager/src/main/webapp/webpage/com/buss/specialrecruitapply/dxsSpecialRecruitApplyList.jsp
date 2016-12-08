<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsSpecialRecruitApplyList" checkbox="true" fitColumns="false" title="dxs_special_recruit_apply" actionUrl="dxsSpecialRecruitApplyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="申请企业名称"  field="dxsUserEntity.empname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="专场"  field="dxsSpecialRecruitEntity.spSchool"    queryMode="group"  width="120"></t:dgCol>

   <t:dgCol title="招聘省份"  field="privince"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘方向"  field="employDirection"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="招聘院校"  field="employSchool"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="岗位文件id"  field="fileId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="是否处理"  field="isHandle"    query="true"  width="120" formatterjs="DXS.isHandle" align="center"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsSpecialRecruitApplyController.do?doDel&id={id}" />
      <t:dgDefOpt url="drownLoad.do?download&outid={id}" title="下载文件" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsSpecialRecruitApplyController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsSpecialRecruitApplyController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsSpecialRecruitApplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsSpecialRecruitApplyController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/specialrecruitapply/dxsSpecialRecruitApplyList.js"></script>		
 <script type="text/javascript">
     var DXS= {
         isHandle : function(value, row,index){
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
 			$("#dxsSpecialRecruitApplyListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitApplyListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitApplyListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsSpecialRecruitApplyListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsSpecialRecruitApplyController.do?upload', "dxsSpecialRecruitApplyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsSpecialRecruitApplyController.do?exportXls","dxsSpecialRecruitApplyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsSpecialRecruitApplyController.do?exportXlsByT","dxsSpecialRecruitApplyList");
}
 </script>