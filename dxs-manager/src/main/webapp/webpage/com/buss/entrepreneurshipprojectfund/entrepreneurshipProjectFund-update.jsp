<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>entrepreneurship_project_fund</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="online/template/ledefault/css/vendor.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap-theme.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap.css">
  <link rel="stylesheet" href="online/template/ledefault/css/app.css">
  
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css"/>
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css"/>
  
  <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
  <script type="text/javascript" src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
  <script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
  <script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
  <script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css"></link>
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <link rel="stylesheet" href="plug-in/umeditor/themes/default/css/umeditor.css" type="text/css"></link>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.config.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.min.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/lang/zh-cn/zh-cn.js"></script>
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>

 <body>

  <form id="formobj" action="entrepreneurshipProjectFundController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${entrepreneurshipProjectFundPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">创业基金项目审核查看</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>用户ID：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.userId}'>--%>
						  <select name="userId" class="form-control">
							  <c:forEach items="${userEntityList}" var="userEntity">
								  <option value="${userEntity.id}"
								  	<c:if test="${entrepreneurshipProjectFundPage.userId == userEntity.id}">selected="selected"</c:if>
								  >
								  	${userEntity.realname}
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户ID</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>基地外键：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="applytoId" name="applytoId" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.applytoId}'>--%>
								<select name="applytoId" class="form-control">
									<c:forEach items="${employedArticleEntityList}" var="employedArticleEntity">
										<option value="${employedArticleEntity.id}"
												<c:if test="${entrepreneurshipProjectFundPage.applytoId == employedArticleEntity.id}">selected="selected"</c:if>
										>
												${employedArticleEntity.emoloyedTitle}
										</option>
									</c:forEach>
								</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">基地外键</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectName" name="projectName" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>是否专利：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="isPatent" name="isPatent" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.isPatent}'>--%>


						  <input name="isPatent" type="radio" value="是"
								 <c:if test="${entrepreneurshipProjectFundPage.isPatent == '是'}" >checked</c:if>
						  >是&nbsp;
						  <input name="isPatent" type="radio" value="否"
								 <c:if test="${entrepreneurshipProjectFundPage.isPatent == '否'}" >checked</c:if>
						  >否&nbsp;
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">是否专利</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目介绍：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectIntroduce" name="projectIntroduce" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectIntroduce}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目介绍</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属领域：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="projectionField" name="projectionField" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectionField}'>--%>
									<select name="projectionField" class="form-control">
										<c:forEach items="${projectAreaEntityList}" var="projectAreaEntity">
											<option value="${projectAreaEntity.areaName}"
													<c:if test="${projectAreaEntity.areaName eq entrepreneurshipProjectFundPage.projectionField}">selected="selected"</c:if>
											>
													${projectAreaEntity.areaName}
											</option>
										</c:forEach>
									</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属领域</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>产品类型：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="projectionType" name="projectionType" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectionType}'>--%>

								<select name="projectionType" class="form-control">
									<c:forEach items="${projectTypeEntityList}" var="projectTypeEntity">
										<option value="${projectTypeEntity.projectType}"
												<c:if test="${projectTypeEntity.projectType eq entrepreneurshipProjectFundPage.projectionType}">selected="selected"</c:if>
										>
												${projectTypeEntity.projectType}
										</option>
									</c:forEach>
								</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">产品类型</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目计划书：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectionPlan" name="projectionPlan" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectionPlan}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目计划书</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目进展：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectionProgress" name="projectionProgress" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectionProgress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目进展</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>经营范围：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectionScope" name="projectionScope" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.projectionScope}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">经营范围</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>审核码：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="checkCode" name="checkCode" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.checkCode}'>--%>
								<select name="checkCode">
									<option value="0"
											<c:if test="${entrepreneurshipProjectFundPage.checkCode == 0}">selected="selected"</c:if>
									>
										待审核
									</option>
									<option value="5" <c:if test="${entrepreneurshipProjectFundPage.checkCode == 5}">selected="selected"</c:if>>审核中</option>
									<option value="10" <c:if test="${entrepreneurshipProjectFundPage.checkCode == 10}">selected="selected"</c:if>>审核通过</option>
									<option value="15" <c:if test="${entrepreneurshipProjectFundPage.checkCode == 15}">selected="selected"</c:if>>审核失败</option>
								</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">审核码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目类型：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="type" name="type" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.type}'>--%>
								<input name="type" type="radio" value="3"
									   <c:if test="${entrepreneurshipProjectFundPage.type == 3}" >checked</c:if>
								>创业基金&nbsp;
								<input name="type" type="radio" value="4"
									   <c:if test="${entrepreneurshipProjectFundPage.type == 4}" >checked</c:if>
								>创业基地&nbsp;
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目类型</label>
			          </div>
							</div>
			          
			        
						<%--	<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>创建时间：</b>
			          </div>
			          <div class="col-xs-3">
								&lt;%&ndash;<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${entrepreneurshipProjectFundPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>&ndash;%&gt;
						  		<input id="createTime" name="createTime" type="text" style="width: 150px" class="form-control"  value='${entrepreneurshipProjectFundPage.createTime}' onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>更新时间：</b>
			          </div>
			          <div class="col-xs-3">
								&lt;%&ndash;<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${entrepreneurshipProjectFundPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>&ndash;%&gt;
						  		<input id="updateTime" name="updateTime" type="text" style="width: 150px" class="form-control"  value='${entrepreneurshipProjectFundPage.updateTime}' onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新时间</label>
			          </div>
							</div>--%>


							<%--<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>删除标志：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${entrepreneurshipProjectFundPage.isDelete}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">删除标志</label>
			          </div>
							<div class="col-xs-2 text-center"><b></b></div>
			         		<div class="col-xs-4"></div>
							</div>--%>
			          
			        

			       
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				          <div class="col-xs-6"></div>
				          <div class="col-xs-6"><button type="button" onclick="neibuClick();" class="btn btn-default">提交</button></div>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
			 </div>
	</form>
<script type="text/javascript">
$(function() {
    $("#formobj").Validform({
        tiptype: 1,
        btnSubmit: "#btn_sub",
        btnReset: "#btn_reset",
        ajaxPost: true,
		beforeSubmit: function(curform) {
            var tag = true;
			//提交前处理
            return tag;
        },
        usePlugin: {
            passwordstrength: {
                minLen: 6,
                maxLen: 18,
                trigger: function(obj, error) {
                    if (error) {
                        obj.parent().next().find(".Validform_checktip").show();
                        obj.find(".passwordStrength").hide();
                    } else {
                        $(".passwordStrength").show();
                        obj.parent().next().find(".Validform_checktip").hide();
                    }
                }
            }
        },
        callback: function(data) {
            if (data.success == true) {
			     var win = frameElement.api.opener;
                 win.reloadTable();
 				 win.tip(data.msg);
 				 frameElement.api.close();
            } else {
                if (data.responseText == '' || data.responseText == undefined) {
                    $.messager.alert('错误', data.msg);
                    $.Hidemsg();
                } else {
                    try {
                        var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
                        $.messager.alert('错误', emsg);
                        $.Hidemsg();
                    } catch(ex) {
                        $.messager.alert('错误', data.responseText + '');
                    }
                }
                return false;
            }
        }
    });
});
</script>

<script type="text/javascript">
   $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
	
	if(location.href.indexOf("mode=read")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
	}
	if(location.href.indexOf("mode=onbutton")!=-1){
		//其他模式显示提交按钮
		$("#sub_tr").show();
	}
   });

  var neibuClickFlag = false;
  function neibuClick() {
	  neibuClickFlag = true; 
	  $('#btn_sub').trigger('click');
  }

</script>
 </body>
<script src = "webpage/com/buss/entrepreneurshipprojectfund/entrepreneurshipProjectFund.js"></script>		
</html>