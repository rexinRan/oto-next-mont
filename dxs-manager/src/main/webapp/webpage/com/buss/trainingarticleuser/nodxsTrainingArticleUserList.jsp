<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/trainingarticleuser/dxsTrainingArticleUserList.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainingArticleUserList" checkbox="true" fitColumns="false" title="" actionUrl="dxsTrainingArticleUserController.do?datagrid&result=${result}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="培训文章"  field="dxsTrainingArticleEntity.trainingTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请结果"  field="result"    queryMode="group"  width="120"  formatterjs="Train.result" align="center"></t:dgCol>
   <t:dgCol title="申请时间"  field="applyTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="130"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainingArticleUserController.do?doDel&id={id}" />
      <t:dgConfOpt message="确认审核通过?" title="同意" url="dxsTrainingArticleUserController.do?doUpdate&result=3&id={id}" />
      <t:dgConfOpt message="确认审核失败?" title="拒绝" url="dxsTrainingArticleUserController.do?doUpdate&result=4&id={id}" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsTrainingArticleUserController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainingArticleUserController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainingArticleUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsTrainingArticleUserController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainingarticleuser/dxsTrainingArticleUserList.js"></script>		
 <script type="text/javascript">
     //实习实训
     var Train = {
         result: function (value, row, index) {
             if (value == "0") {
                 return "<span style='color:#ff3335'>未审核</span>";
             } else if (value == "3") {
                 return "已通过";
             }  else if(value == "4"){
                 return "已拒绝" ;
             }else {
                 return value;
             }
         }
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainingArticleUserListtb").find("input[name='applyTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingArticleUserListtb").find("input[name='applyTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingArticleUserListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingArticleUserListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingArticleUserListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainingArticleUserListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainingArticleUserController.do?upload', "dxsTrainingArticleUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainingArticleUserController.do?exportXls","dxsTrainingArticleUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainingArticleUserController.do?exportXlsByT","dxsTrainingArticleUserList");
}
 </script>