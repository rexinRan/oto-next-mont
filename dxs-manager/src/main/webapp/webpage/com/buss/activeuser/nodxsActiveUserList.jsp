<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsActiveUserList" checkbox="true" fitColumns="false" title="报名活动列表" actionUrl="dxsActiveUserController.do?datagrid&type=${type}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动标题"  field="dxsActivesEntity.activeTitle"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名称"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="活动步骤"  field="type"    queryMode="group"  width="120" formatterjs="DXSActive.Active" align="center"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol> dxsActiveUserController.do?seePic&outId={id} --%>
   <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
   <%--<t:dgOpenOpt url="dxsActiveUserController.do?goAdd" title="弹出窗" openModel="OpenWin" height="500px" width="500px"/>--%>
   <t:dgDelOpt title="删除" url="dxsActiveUserController.do?doDel&id={id}" />
      <t:dgConfOpt message="确认审核通过?" title="同意" url="dxsActiveUserController.do?doUpdate&type=3&id={id}" />
      <t:dgConfOpt message="确认审核失败?" title="拒绝" url="dxsActiveUserController.do?doUpdate&type=4&id={id}" />
   <t:dgFunOpt funname="seePic(id)" title="查看上传凭证"/>
   <%--<t:dgOpenOpt url="dxsActiveUserController.do?doUpdate&type=3&id={id}" title="同意二"></t:dgOpenOpt>--%>
      <%--<t:dgFunOpt funname="argree(3, {id})" title="同意三"/>--%>

   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsActiveUserController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsActiveUserController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsActiveUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsActiveUserController.do?goUpdate" funname="detail"></t:dgToolBar>

   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/activeuser/dxsActiveUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsActiveUserListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveUserListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveUserListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsActiveUserListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsActiveUserController.do?upload', "dxsActiveUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsActiveUserController.do?exportXls","dxsActiveUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsActiveUserController.do?exportXlsByT","dxsActiveUserList");
}

     function seePic(id) {
         createwindow('查看凭证', 'dxsActiveUserController.do?seePic&outId=' + id);
     }

 </script>