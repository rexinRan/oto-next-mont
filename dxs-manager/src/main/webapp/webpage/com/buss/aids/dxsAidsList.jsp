<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script>

</script>
<%--<t:comboBox url="dxsAidsController.do?datagrid" name="aidCatelogEntity.aidCatelogName" text="aidCatelogEntity.aidCatelogName" id="id"></t:comboBox>--%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAidsList" checkbox="true" fitColumns="false" title="dxs_aids" actionUrl="dxsAidsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="扶贫分类" field="aidCatelogEntity.aidCatelogName" query="true" width="60"></t:dgCol>
   <%--<t:dgCol title="扶贫分类id"  field="aidCatelogId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="扶贫标题"  field="aidTitle"    queryMode="group"  width="120" ></t:dgCol>
   <t:dgCol title="编辑人"  field="aidEditor"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发布时间"  field="aidPublishTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="扶贫简介"  field="aidIntroduction"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="扶贫内容"  field="aidContents"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编号"  field="aidSort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫视频"  field="aidVideoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫缩略图"  field="aidImgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫发布年份"  field="aidPublishYear"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="扶贫发布月份"  field="aidPublicMonth"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属地区"  field="aidRegion"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="是否特别关注"  field="isSpecial"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="新闻来源"  field="aidFrom"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="外部标记"  field="outSign"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="createTime"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="updateTime"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAidsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsAidsController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsAidsController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAidsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsAidsController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/aids/dxsAidsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAidsListtb").find("input[name='aidPublishTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidsListtb").find("input[name='aidPublishTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidsListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidsListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidsListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAidsListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAidsController.do?upload', "dxsAidsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAidsController.do?exportXls","dxsAidsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAidsController.do?exportXlsByT","dxsAidsList");
}
 </script>