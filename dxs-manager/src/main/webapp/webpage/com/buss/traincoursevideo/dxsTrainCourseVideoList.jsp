<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsTrainCourseVideoList" checkbox="true" fitColumns="false" title="dxs_train_course_video" actionUrl="dxsTrainCourseVideoController.do?datagrid&tocId=${tocId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="课程id"  field="tocId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="导师id"  field="userId"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="视频名称"  field="videoName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="缩略图"  field="imgUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="视频地址"  field="videoUrl"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="sort"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="视频时长"  field="videoHourses"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否免费"  field="isFree"    queryMode="group"  width="120" formatterjs="DXS.isFree"></t:dgCol>
   <t:dgCol title="内部标记"  field="inSign"    queryMode="group"  width="120" formatterjs="DXS.inSign"></t:dgCol>
   <%--<t:dgCol title="外部标记"  field="outSign"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="价格"  field="price"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsTrainCourseVideoController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="dxsTrainCourseVideoController.do?goAdd&tocId=${tocId}&userId=${userId}" funname="add" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="dxsTrainCourseVideoController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsTrainCourseVideoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsTrainCourseVideoController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>--%>
   <t:dgToolBar title="返回线上培训页" icon="icon-put" url="dxsTrainOnlineCourseController.do?list" funname="quizList"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/traincoursevideo/dxsTrainCourseVideoList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         isFree : function(value, row,index){
             if (value == "0"){
                 return "收费";
             }else if (value == "1"){
                 return "免费";
             }else{
                 return value;
             }
         },
         inSign: function(value, row,index){
             if (value == "0"){
                 return "试看";
             }else if (value == "1"){
                 return "正常";
             }else{
                 return value;
             }
         }
     }


     var quizList = function(title, url, id){
         window.location.href = url;
     }

     $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsTrainCourseVideoListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainCourseVideoListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainCourseVideoListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsTrainCourseVideoListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsTrainCourseVideoController.do?upload', "dxsTrainCourseVideoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsTrainCourseVideoController.do?exportXls","dxsTrainCourseVideoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsTrainCourseVideoController.do?exportXlsByT","dxsTrainCourseVideoList");
}
 </script>