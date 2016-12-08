<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
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
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css"></link>
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <link rel="stylesheet" href="plug-in/umeditor/themes/default/css/umeditor.css" type="text/css"></link>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.config.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/umeditor.min.js"></script>
  <script type="text/javascript" src="plug-in/umeditor/lang/zh-cn/zh-cn.js"></script>
   <script type="text/javascript">
  //编写自定义JS代码
  $(function(){
	  /* 文件提交 */
	  $('#_projectImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传项目配图',
		  'width' : 100,
		  'height' : 50,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#projectImgurl' +
					  ''))
			  $('#projectImgurl').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
/*富文本编辑器*/
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

  <form id="formobj" action="dxsEntrepreneurshipProjectCompetitionController.do?doAdd" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">添加创业项目</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目所属领域：</b>
			          </div>
			          <%--<div class="col-xs-3">
								<input id="projectAreaId" name="projectAreaId" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目所属领域id</label>
			          </div>--%>
						<div class="col-xs-3" >
							<select name="projectAreaId" class="form-control">
								<c:forEach items="${projectAreaEntityList}" var="projectAreaEntity">
									<option value="${projectAreaEntity.id}">${projectAreaEntity.areaName}
									<%--<c:if test="${dxsnewscatelog.id==dxsNewsPage.newCatelogId}">selected="selected"</c:if>--%>

									<%--<t:mutiLang langKey="${projectAreaEntity.areaName}"/>--%>
									</option>
								</c:forEach>
							</select>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
						</div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目所属类型：</b>
			          </div>
			          <%--<div class="col-xs-3">
								<input id="projectTypeId" name="projectTypeId" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目所属类型id</label>
			          </div>
							</div>--%>
						<div class="col-xs-3" >
							<select name="projectTypeId" class="form-control">
								<c:forEach items="${projectTypeEntityList}" var="projectTypeEntity">
									<option value="${projectTypeEntity.id}">${projectTypeEntity.projectType}
											<%--<c:if test="${dxsnewscatelog.id==dxsNewsPage.newCatelogId}">selected="selected"</c:if>--%>

											<%--<t:mutiLang langKey="${projectAreaEntity.areaName}"/>--%>
									</option>
								</c:forEach>
							</select>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
						</div>
			        </div>
					   <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectName" name="projectName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目分类：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectCatalog" name="projectCatalog" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目分类</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectStartTime" name="projectStartTime" type="text"  class="form-control"   onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目开始时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目结束时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectEndTime" name="projectEndTime" type="text"  class="form-control"  onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目结束时间</label>
			          </div>
							</div>
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目状态：</b>
			          </div>
			          <div class="col-xs-3">
								<%--<input id="projectStatus" name="projectStatus" type="text" class="form-control"  >--%>
									<input type="radio" name="projectStatus" value="1">已获投资&nbsp;
									<input type="radio" name="projectStatus" value="0">未获投资&nbsp;
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目状态</label>
			          </div>
			          
			        
			          <%--<div class="col-xs-3 text-center">
			          	<b>项目简介：</b>
			          </div>
			          <div class="col-xs-9">
								<input id="projectProfile" name="projectProfile" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目简介</label>
			          </div>--%>

								<div class="col-xs-3 text-center">
									<b>审核码：</b>
								</div>
								<div class="col-xs-3">
									<%--<input id="checkCode" name="checkCode" type="text" class="form-control"  >--%>
									<select name="checkCode"  class="form-control">
										<option value="0">未审核</option>
										<option value="5">待审核</option>
										<option value="10">审核通过</option>
										<option value="15">审核失败</option>
									</select>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">审核码</label>
								</div>

							</div>
			          
			        
							<%--<div class="row show-grid">--%>
								<%--<div class="col-xs-3 text-center">--%>
									<%--<b>删除标志：</b>--%>
								<%--</div>--%>
								<%--<div class="col-xs-3">--%>
									<%--<input type="radio" name="isDelete" value="0">显示&nbsp;--%>
									<%--<input type="radio" name="isDelete" value="1">不显示&nbsp;--%>
									<%--&lt;%&ndash;<input id="isDelete" name="isDelete" type="text" class="form-control"  >&ndash;%&gt;--%>
									<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
									<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
								<%--</div>--%>


						<div class="row show-grid">
							<div class="col-xs-3 text-center">
								<b>项目等级：</b>
							</div>
							<div class="col-xs-3">
								<%--<input id="projectGrade" name="projectGrade" type="text" class="form-control"  >--%>
									<select name="projectGrade"  class="form-control">
										<option value="0">校级</option>
										<option value="1">市级</option>
										<option value="2">省级</option>
										<option value="3">全国总决赛</option>
										<option value="4">大区级</option>
									</select>
								<span class="Validform_checktip" style="float:left;height:0px;"></span>
								<label class="Validform_label" style="display: none">项目等级</label>
							</div>
						</div>
			         <%-- <div class="col-xs-3 text-center">
			          	<b>创建时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createTime" name="createTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建时间</label>
			          </div>--%>
							<%--</div>--%>

			        

			         <%-- <div class="col-xs-3 text-center">
			          	<b>更新时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新时间</label>
			          </div>--%>

			        

						<%--杨治国--%>
						<%--<div class="col-xs-3 text-center">
							<b>活动种类配图：</b>
						</div>
						<div class="col-xs-3">
							<div id="_activeCatelogImg"></div>
							<input id="activeCatelogImg" name="activeCatelogImg" type="text" class="form-control" value="" style="display: none">
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">活动种类配图</label>
						</div>
							</div>--%>


						<div class="row show-grid">
						<%--<div class="col-xs-3 text-center">--%>
							<%--<b>项目展示图片路径：</b>--%>
						<%--</div>--%>
						<%--<div class="col-xs-3">--%>
							<%--<input id="projectImgurl" name="projectImgurl" type="text" class="form-control" value="" content="">--%>
							<%--&lt;%&ndash;<div id="_projectImg"></div>--%>
							<%--<input id="projectImgurl" name="projectImgurl" type="text" class="form-control" value="" style="display: none">&ndash;%&gt;--%>
							<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							<%--<label class="Validform_label" style="display: none">项目展示图片</label>--%>
						<%--</div>--%>

						<div class="col-xs-3 text-center">
							<b>项目图片上传：</b>
						</div>
						<div class="col-xs-3">
							<%--<input id="projectImgurl" name="projectImgurl" type="text" class="form-control"  >--%>
							<div id="_projectImg"></div>
							<input id="projectImgurl" name="projectImgurl" type="text" class="form-control" value="" style="display: none" align="center">
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">项目展示图片</label>
						</div>
                        </div>
					  <div class="row show-grid">
						 <div class="col-xs-3 text-center" style="border: 0px solid red;">
							 <b>项目简介：</b>
						 </div>
						 <div class="col-xs-9">
							 <!-- 加载编辑器的容器 -->
							 <script id="container" name="projectProfile" type="text/plain" style="width: 800px;min-height:300px;"></script>
						 </div>
                      </div>
			       
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				          <div class="col-xs-6"></div>
				          <div class="col-xs-6"><button type="button" onclick="neibuClick();" class="btn btn-default">提交</button></div>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <%--<div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>--%>
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