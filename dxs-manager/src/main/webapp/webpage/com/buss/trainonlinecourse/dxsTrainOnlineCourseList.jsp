<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainOnlineCourseList" checkbox="true" fitColumns="false" title="dxs_train_online_course" actionUrl="dxsTrainOnlineCourseController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分类"  field="dxsTrainCourseCatalogEntity.catalogName"    queryMode="group"  width="120"></t:dgCol>
      <t:dgCol title="培训课题"  field="title"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="显示分类"  field="catalogDisplayNum"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="导师"  field="dxsUserEntity.realname"    query="true"  width="120"></t:dgCol>
   <t:dgCol title="总课时数"  field="courseNumAll"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="总学习数"  field="courseMinutesAll"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="课程价格"  field="coursePrices"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缩略图"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="外部标记"  field="outSign"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="班号"  field="classNum"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="授课方式"  field="courseType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="培训方式"  field="trainType"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="学费"  field="price"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="课程介绍"  field="courseIntroduce"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="适用学员"  field="courseObj"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="教学目标"  field="trainObj"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="授课内容"  field="trainContent"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="课程体系"  field="courseDir"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="课程特色"  field="courseSpecial"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="开班规律"  field="startClassRule"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="其他"  field="others"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainOnlineCourseController.do?doDel&id={id}" />

   <t:dgDefOpt  title="视频管理"  url="dxsTrainCourseVideoController.do?list&tocId={id}&userId={userId}" > </t:dgDefOpt>

   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainOnlineCourseController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainOnlineCourseController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainOnlineCourseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="dxsTrainOnlineCourseController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/trainonlinecourse/dxsTrainOnlineCourseList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainOnlineCourseListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOnlineCourseListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOnlineCourseListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainOnlineCourseListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainOnlineCourseController.do?upload', "dxsTrainOnlineCourseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainOnlineCourseController.do?exportXls","dxsTrainOnlineCourseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainOnlineCourseController.do?exportXlsByT","dxsTrainOnlineCourseList");
}
 </script>