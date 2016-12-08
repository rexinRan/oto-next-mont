<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script src = "webpage/com/buss/common/common.js"></script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
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
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css">
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <link rel="stylesheet" href="plug-in/umeditor/themes/default/css/umeditor.css" type="text/css">
  <script type="text/javascript" src="plug-in/umeditor/umeditor.config.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.min.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/lang/zh-cn/zh-cn.js"></script>
   <script type="text/javascript">
  //编写自定义JS代码
  $(function(){
	  /* 文件提交 */
	  $('#_projectImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do;jsessionid=${pageContext.session.id}',		/*后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 50,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#projectImgurl'))
			  $('#projectImgurl').val(data);
			  $('#Imgurl').attr("src",data);
		  }
	  });
  })

/*项目简介*/
  $(function(){
	  window.um = UM.getEditor('container', {
		  toolbar:[
			  'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
			  'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
			  '| justifyleft justifycenter justifyright justifyjustify |',
			  'link unlink | emotion image video  | map',
			  '| horizontal print preview fullscreen', 'drafts', 'formula'
		  ]
	  });
  });
  </script>
</head>

 <body>

  <form id="formobj" action="dxsEntrepreneurshipProjectCompetitionController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsEntrepreneurshipProjectCompetitionPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">编辑创业项目</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目所属领域：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="projectAreaId" name="projectAreaId" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectAreaEntity.areaName}'readonly>--%>

						<select name="projectAreaId" class="form-control" >
							<c:forEach items="${projectAreaEntityList}" var="projectAreaEntity">
								<option value="${projectAreaEntity.id}"
										<c:if test="${projectAreaEntity.id == dxsEntrepreneurshipProjectCompetitionPage.projectAreaId }">selected="selected"</c:if>
								>
									${projectAreaEntity.areaName}
									<%--<t:mutiLang langKey="${dxsactivescatelog.activeCatelogName}"/>--%>
								</option>
							</c:forEach>
						</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目所属领域id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目所属类型：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="projectTypeId" name="projectTypeId" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectTypeEntity.projectType}'readonly>--%>

						<select name="projectTypeId" class="form-control" >
							<c:forEach items="${projectTypeEntityList}" var="projectTypeEntity">
								<option value="${projectTypeEntity.id}"
										<c:if test="${projectTypeEntity.id == dxsEntrepreneurshipProjectCompetitionPage.projectTypeId }">selected="selected"</c:if>
								>
										${projectTypeEntity.projectType}
									<%--<t:mutiLang langKey="${dxsactivescatelog.activeCatelogName}"/>--%>
								</option>
							</c:forEach>
						</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目所属类型id</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectName" name="projectName" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目名称</label>
			          </div>
			          
			        
			         <%-- <div class="col-xs-3 text-center">
			          	<b>项目分类：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectCatalog" name="projectCatalog" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectCatalog}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目分类</label>
			          </div>--%>
								<div class="col-xs-3 text-center">
									<b>项目等级：</b>
								</div>
								<div class="col-xs-3">

									<select name="projectGrade"  class="form-control">
										<option value="0" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectGrade == 0}">selected="selected"</c:if>>校级</option>
										<option value="1" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectGrade == 1}">selected="selected"</c:if>>市级</option>
										<option value="2" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectGrade == 2}">selected="selected"</c:if>>省级</option>
										<option value="3" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectGrade == 3}">selected="selected"</c:if>>全国总决赛</option>
										<option value="4" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectGrade == 4}">selected="selected"</c:if>>大区级</option>
									</select>
									<%--<input id="projectGrade" name="projectGrade" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectGrade}'>--%>
									<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">项目等级</label>--%>
								</div>

							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectStartTime" name="projectStartTime" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectStartTime}' onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目开始时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目结束时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectEndTime" name="projectEndTime" type="text"  class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectEndTime}' onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目结束时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目状态：</b>
			          </div>
			          <div class="col-xs-3">
						 <select name="projectStatus"  class="form-control">
							 <option value="0" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectStatus == 0}">selected="selected"</c:if>>未获取投资</option>
							 <option value="1" <c:if test="${dxsEntrepreneurshipProjectCompetitionPage.projectStatus == 1}">selected="selected"</c:if>>已获取投资</option>
						 </select>

						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目状态</label>
			          </div>


							</div>


						<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>项目图片上传：</b>
					</div>
					<div class="col-xs-3">
						<%--<input id="projectImgurl" name="projectImgurl" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectImgurl}'>--%>
							<div id="_projectImg"></div>
							<input id="projectImgurl" name="projectImgurl" type="text" class="form-control" value="${dxsEntrepreneurshipProjectCompetitionPage.projectImgurl}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目图片上传</label>
					</div>

					<div class="col-xs-3">
						<%--<input id="projectImgurl" name="projectImgurl" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectImgurl}'>--%>
						<img id="Imgurl" src='${dxsEntrepreneurshipProjectCompetitionPage.projectImgurl}'width="70%" height="30%"/>
					</div>

						</div>

					  	<div class="row show-grid">

							<%--<div class="col-xs-3 text-center">
			          	<b>项目简介：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectProfile" name="projectProfile" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.projectProfile}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目简介</label>
			          </div>--%>
					  <div class="col-xs-3 text-center" style="border: 0px solid red;">
						  <b>项目简介</b>
					  </div>
					  <div class="col-xs-9">
						  <!-- 加载编辑器的容器 -->
						  <script id="container" name="projectProfile" type="text/plain" style="width: 800px;min-height:300px;">
								${dxsEntrepreneurshipProjectCompetitionPage.projectProfile}
							</script>
					  </div>

						</div>
			         <%-- <div class="col-xs-3 text-center">
			          	<b>审核码：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="checkCode" name="checkCode" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.checkCode}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">审核码</label>
			          </div>--%>






							<%--<div class="row show-grid">



			          <div class="col-xs-3 text-center">
			          	<b>创建时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEntrepreneurshipProjectCompetitionPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建时间</label>
			          </div>
							</div>--%>
			          
			        
							<%--<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>更新时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEntrepreneurshipProjectCompetitionPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>删除标志：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsEntrepreneurshipProjectCompetitionPage.isDelete}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">删除标志</label>
			          </div>
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
<script src = "webpage/com/buss/entrepreneurshipprojectcompetition/dxsEntrepreneurshipProjectCompetition.js"></script>		
</html>