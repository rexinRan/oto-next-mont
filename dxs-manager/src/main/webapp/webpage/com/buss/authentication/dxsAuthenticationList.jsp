<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">

  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="dxsAuthenticationList" checkbox="true" fitColumns="false" title="dxs_authentication" actionUrl="dxsAuthenticationController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="dxsUserEntity.realname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="teacherTitle"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="学生证/资格证扫描件"  field="certificateId"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="身份证正面"  field="identify1Id"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="身份证反面"  field="identify2Id"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="导师类别"  field="toturType"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="导师技能"  field="toturSkill"    queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="培训经验"  field="isTrain"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="个人简历"  field="resumeId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="作品或讲义"  field="workId"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="认证结果"  field="authenticationResult"    query="true"  width="120" formatterjs="DXS.authenticationResult"></t:dgCol>
   <t:dgCol title="认证信息反馈"  field="authenticationMessage"    queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="创建时间"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="更新时间"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
   <t:dgDelOpt title="删除" url="dxsAuthenticationController.do?doDel&id={id}" />
      <t:dgConfOpt message="确认审核通过？" title="同意" url="dxsAuthenticationController.do?doType&id={id}&tongyi=1" />
      <t:dgConfOpt   message="确认审核失败？" title="拒绝" url="dxsAuthenticationController.do?doType&id={id}&tongyi=2" />
      <t:dgDefOpt url="drownLoad.do?downloadfid&fid={workId +','+ rec.resumeId}" title="下载" />
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsAuthenticationController.do?goAdd" funname="add" height="720" width="1120"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsAuthenticationController.do?goUpdate" funname="update" height="720" width="1120"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsAuthenticationController.do?doBatchDel" funname="deleteALLSelect" ></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsAuthenticationController.do?goUpdate" funname="detail" height="720" width="1120"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/authentication/dxsAuthenticationList.js"></script>		
 <script type="text/javascript">
     var DXS = {
         authenticationResult : function(value, row, index){
             if (value == "8"){
                 return "创业导师认证通过";
             }else if(value == "11"){
                 return "就业导师认证通过";
             } else if(value == "14"){
                 return "创客导师认证通过";
             } else if(value == "17"){
                 return "学习导师认证通过";
             } else if(value == "20"){
                 return "技能培训导师认证通过";
             } else if(value == "7"){
                 return "申请创业导师";
             } else if(value == "10"){
                 return "申请就业导师";
             } else if(value == "13"){
                 return "申请创客导师";
             } else if(value == "16"){
                 return "申请学习导师";
             } else if(value == "19"){
                 return "申请技能培训导师";
             } else if(value == "9"){
                 return "创业导师认证失败";
             } else if(value == "12"){
                 return "就业导师认证失败";
             } else if(value == "15"){
                 return "创客导师认证失败";
             } else if(value == "18"){
                 return "学习导师认证失败";
             }else if(value == "21"){
                 return "技能培训导师认证失败";
             }else {
                 return value;
             }
         }
     }
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#dxsAuthenticationListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAuthenticationListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAuthenticationListtb").find("input[name='updateTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#dxsAuthenticationListtb").find("input[name='updateTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'dxsAuthenticationController.do?upload', "dxsAuthenticationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("dxsAuthenticationController.do?exportXls","dxsAuthenticationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("dxsAuthenticationController.do?exportXlsByT","dxsAuthenticationList");
}
 </script>