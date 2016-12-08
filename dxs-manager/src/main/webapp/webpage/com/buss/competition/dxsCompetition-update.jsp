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
	  window.um = UM.getEditor('container', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//				 imageUrl: "E:/upload/",
		  toolbar:[
			  'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
			  'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
			  '| justifyleft justifycenter justifyright justifyjustify |',
			  'link unlink | emotion image video  | map',
			  '| horizontal print preview fullscreen', 'drafts', 'formula'
		  ]
	  });
  });
  $(function(){
	  window.um = UM.getEditor('_container', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//				 imageUrl: "E:/upload/",
		  toolbar:[
			  'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
			  'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
			  '| justifyleft justifycenter justifyright justifyjustify |',
			  'link unlink | emotion image video  | map',
			  '| horizontal print preview fullscreen', 'drafts', 'formula'
		  ]
	  });
  });
  $(function(){
	  /* 文件提交 */
	  $('#_competitionImgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#competitionImgUrl'))
			  $('#competitionImgUrl').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  </script>
</head>

 <body>

  <form id="formobj" action="dxsCompetitionController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsCompetitionPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);"></a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>用户id：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsCompetitionPage.userId}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">用户id</label>--%>
			          <%--</div>--%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>缩略图id：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="competitionImgId" name="competitionImgId" type="text" class="form-control"  value='${dxsCompetitionPage.competitionImgId}'>--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">缩略图id</label>--%>
						  <%--</div>--%>
							<%--</div>--%>



			          <div class="col-xs-3 text-center">
			          	<b>大赛名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionTitle" name="competitionTitle" type="text" class="form-control"  value='${dxsCompetitionPage.competitionTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">大赛名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>主办方：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionOrganisers" name="competitionOrganisers" type="text" class="form-control"  value='${dxsCompetitionPage.competitionOrganisers}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">主办方</label>
			          </div>
								</div>

			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>大赛开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionStartTime" name="competitionStartTime" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCompetitionPage.competitionStartTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">大赛开始时间</label>
			          </div>
								</div>

								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>大赛结束时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionEndTime" name="competitionEndTime" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCompetitionPage.competitionEndTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">大赛结束时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>赛区范围：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionAreas" name="competitionAreas" type="text" class="form-control"  value='${dxsCompetitionPage.competitionAreas}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">赛区范围</label>
			          </div>
								</div>


			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>参赛对象：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="competitionObject" name="competitionObject" type="text" class="form-control"  value='${dxsCompetitionPage.competitionObject}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">参赛对象</label>
			          </div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>缩略图：</b>
									</div>
									<div class="col-xs-3">
										<div id="_competitionImgUrl"></div>
										<input id="competitionImgUrl" name="competitionImgUrl" type="text" class="form-control" value="${dxsCompetitionPage.competitionImgUrl}" style="display: none">
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">缩略图URL</label>
									</div>
								</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>大赛主旨：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="competitionTopic" class="form-control" rows="6" name="competitionTopic">${dxsCompetitionPage.competitionTopic}</textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">大赛主旨</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>大赛简介：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="competitionIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">
                                 ${dxsCompetitionPage.competitionIntroduce}
							  </script>
						  </div>
					  </div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>大赛规则：</b>
			          </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="_container" name="competitionRule" type="text/plain"  style="width: 800px;min-height:300px;">
                                    ${dxsCompetitionPage.competitionRule}
							  </script>
						  </div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCompetitionPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCompetitionPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          <%----%>
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsCompetitionPage.isDelete}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
			          <%--</div>--%>
							<%--<div class="col-xs-2 text-center"><b></b></div>--%>
			         		<%--<div class="col-xs-4"></div>--%>
							<%--</div>--%>

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
<script src = "webpage/com/buss/competition/dxsCompetition.js"></script>		
</html>