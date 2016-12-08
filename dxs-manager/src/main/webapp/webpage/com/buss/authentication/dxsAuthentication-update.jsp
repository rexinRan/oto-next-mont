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
	  $('#_certificateId').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '文件图片',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#certificateId'))
			  $('#certificateId').val(data);
			  $('#Image').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_resumeId').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '文件上传',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#resumeId'))
			  $('#resumeId').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_workId').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '文件上传',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#workId'))
			  $('#workId').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_identify1Id').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#identify1Id'))
			  $('#identify1Id').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_identify2Id').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
//			  console.info($('#complanyLicenseImg'))
			  $('#identify2Id').val(data);
			  alert($('#identify2Id').val());
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
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
	  window.um = UM.getEditor('container2', {
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
	  window.um = UM.getEditor('container3', {
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
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $('#authenticationResult').val($('#_authenticationResult').val())
	  var html="";
		  if ($("#authenticationResult").val() == "11") {
			  html += ("<option value='0'>-请选择-</option>");
			  html += ("<option value='1'>金牌就业导师</option>");
			  $("#outSign").empty().append(html)
			  $('#outSign').val($('#_outSign').val())
		  } else {
			  html += ("<option value='0'>无</option>");
			  $("#outSign").empty().append(html)
			  $('#outSign').val($('#_outSign').val())
		  }

	  $("#authenticationResult").change(function(){
		  var html="";
		  if($("#authenticationResult").val()=="11"){
			  html+=("<option value='0'>-请选择-</option>");
			  html+=("<option value='1'>金牌就业导师</option>");
			  $("#outSign").empty().append(html)
		  }else {
			  html+=("<option value='0'>无</option>");
			  $("#outSign").empty().append(html)
		  }
	  });
  }

  </script>
</head>

 <body>

  <form id="formobj" action="dxsAuthenticationController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsAuthenticationPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);"></a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>用户名：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control" >
							  <c:forEach items="${teacherList}" var="user">
								  <option value="${user.id}"
										  <c:if test="${user.id==dxsAuthenticationPage.userId}">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${user.realname}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户名</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>职称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="teacherTitle" name="teacherTitle" type="text" class="form-control"  value='${dxsAuthenticationPage.teacherTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职称</label>
			          </div>
							</div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>导师类别：</b>
					  </div>
					  <div class="col-xs-3">
						  <input id="toturType" name="toturType" type="text" class="form-control"  value='${dxsAuthenticationPage.toturType}'>
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">导师类别</label>
					  </div>

						<div class="col-xs-3 text-center">
							<b>专长：</b>
						</div>
						<div class="col-xs-3">
							<input id="toturSkill" name="toturSkill" type="text" class="form-control"  value='${dxsAuthenticationPage.toturSkill}'>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">导师技能</label>
						</div>
					</div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>个人展示视频：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="displayVideoUrl" name="displayVideoUrl" type="text" class="form-control"  value='${dxsAuthenticationPage.displayVideoUrl}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">个人展示视频</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>认证次数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="authenticationCount" name="authenticationCount" type="text" class="form-control"  value='${dxsAuthenticationPage.authenticationCount}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">认证次数</label>
						  </div>
					  </div>
					<%--<div class="row show-grid">--%>
						<%--<div class="col-xs-3 text-center">--%>
							<%--<b>个人简历：</b>--%>
						<%--</div>--%>
						<%--<div class="col-xs-3">--%>
							<%--<div id="_resumeId"></div>--%>
							<%--<input id="resumeId" name="resumeId" type="text" class="form-control"  value="${dxsAuthenticationPage.resumeId}" style="display: none">--%>
							<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							<%--<label class="Validform_label" style="display: none">个人简历</label>--%>
						<%--</div>--%>
					<%--</div>--%>

						<%--<div class="row show-grid">--%>
						<%--<div class="col-xs-3 text-center">--%>
							<%--<b>作品或讲义：</b>--%>
						<%--</div>--%>
						<%--<div class="col-xs-3">--%>
							<%--<div id="_workId"></div>--%>
							<%--<input id="workId" name="workId" type="text" class="form-control"  value="${dxsAuthenticationPage.workId}" style="display: none">--%>
							<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							<%--<label class="Validform_label" style="display: none">作品或讲义</label>--%>
						<%--</div>--%>
					<%--</div>--%>



					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>认证结果：</b>
						</div>
						<div class="col-xs-3">
							<select id="authenticationResult" name="authenticationResult" class="form-control">
								<option value="8">创业导师认证通过</option>
								<option value="11">就业导师认证通过</option>
								<option value="14">创客导师认证通过</option>
								<option value="17">学习导师认证通过</option>
								<option value="20">技能培训导师认证通过</option>
							</select>
							<input id="_authenticationResult"  type="hidden"  value='${dxsAuthenticationPage.authenticationResult}'>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">认证结果</label>
						</div>
						<div class="col-xs-3 text-center">
							<b>外部标记：</b>
						</div>
						<div class="col-xs-3">
							<select  id="outSign" name="outSign"  class="form-control">

							</select>
							<input id="_outSign"  type="hidden"   value='${dxsAuthenticationPage.outSign}'>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">外部标记</label>
						</div>
					</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>备注：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="remarks" name="remarks" type="text" class="form-control"  value='${dxsAuthenticationPage.remarks}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">备注</label>
						  </div>
						  </div>


						<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>学生证/资格证扫描件：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
						  <%--<div id="_certificateId"></div>--%>
								<%--<input id="certificateId" name="certificateId" type="text" class="form-control"  value="${dxsAuthenticationPage.certificateId}"style="display: none">--%>
			          <%--</div>--%>
								<%--<div class="col-xs-3">--%>
									<%--<img id="Image" src='${dxsAuthenticationPage.certificateId}'width="70%" height="30%"/>--%>
								<%--</div>--%>
						<%--</div>--%>

						  <%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>身份证正面：</b>--%>
			          <%--</div>--%>

								<%--<div class="col-xs-3">--%>
									<%--<div id="_identify1Id"></div>--%>
									<%--<input id="identify1Id" name="identify1Id" type="text" class="form-control"  value="" style="display: none">--%>
									<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
									<%--<label class="Validform_label" style="display: none">身份证正面</label>--%>
								<%--</div>--%>
							<%--</div>--%>
			          <%----%>
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>身份证反面：</b>--%>
			          <%--</div>--%>

								<%--<div class="col-xs-3">--%>
									<%--<div id="_identify2Id"></div>--%>
									<%--<input id="identify2Id" name="identify2Id" type="text" class="form-control"  value="" style="display: none">--%>
									<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
									<%--<label class="Validform_label" style="display: none">身份证正面</label>--%>
								<%--</div>--%>
							<%--</div>--%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>个人履历：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container3" name="resumeDisplay" type="text/plain"  style="width: 800px;min-height:300px;">
                                  ${dxsAuthenticationPage.resumeDisplay}
							  </script>
						  </div>
					  </div>

					  <div class="row show-grid">
					<div class="col-xs-3 text-center">
			          	<b>培训经验：</b>
			          </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container2" name="isTrain" type="text/plain" style="width: 800px;min-height:300px;" >
											${dxsAuthenticationPage.isTrain}
										</script>
						  </div>
							</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>认证信息反馈：</b>
			          </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="authenticationMessage" type="text/plain" style="width: 800px;min-height:300px;" >
											${dxsAuthenticationPage.authenticationMessage}
										</script>
							</div>
					  </div>
			          
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsAuthenticationPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsAuthenticationPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsAuthenticationPage.isDelete}'>--%>
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
		beforeSubmit: function (curform) {
			var tag = true;
			//提交前处理
			return tag;
		},
		usePlugin: {
			passwordstrength: {
				minLen: 6,
				maxLen: 18,
				trigger: function (obj, error) {
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
		callback: function (data) {
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
					} catch (ex) {
						$.messager.alert('错误', data.responseText + '');
					}
				}
				return false;
			}
		}
	})
})
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
<script src = "webpage/com/buss/authentication/dxsAuthentication.js"></script>		
</html>