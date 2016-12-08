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
		//编写自定义JS代码$(function(){
		$(function(){
			/* 文件提交 */
			$('#_emoloyedImgurl').uploadify({
				'swf' : 'plug-in/uploadify/uploadify.swf',
				'uploader' : 'files/upload.do',
				'buttonText' : '上传配图',
				'width' : 100,
				'height' : 30,
				'onUploadSuccess' : function(file, data, response) {
					alert('successfully uploaded ' + ':' + data);
					console.info($('#emoloyedImgurl'))
					$('#emoloyedImgurl').val(data);
					$('#Image').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
				}
			});
		})
		$(function(){
//	  window.UMEDITOR_HOME_URL = "/com/buss/images/";
			window.um = UM.getEditor('container', {
				/* 传入配置参数,可配参数列表看umeditor.config.js */
				/* toolbar: ['undo redo | bold italic underline']*/
//		  imageUrl: "E:/upload/",
//		  imageUrl:"jsp/imageUp.jsp",
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

<form id="formobj" action="dxsEmployedArticleController.do?doUpdate" name="formobj" method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" name="id" value='${dxsEmployedArticlePage.id}' >


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
						<b>就业中心分类：</b>
					</div>
					<div class="col-xs-3">
						<select name="emoloyedCatelogId" class="form-control">
							<c:forEach items="${dxsEmployedCatalogList}" var="dxsEmployedCatalog">
								<option value="${dxsEmployedCatalog.id}"
										<c:if test="${dxsEmployedCatalog.id==dxsEmployedArticlePage.emoloyedCatelogId}">selected="selected"</c:if>
								>
									<t:mutiLang langKey="${dxsEmployedCatalog.employedCatalogName}"/>
								</option>
							</c:forEach>
						</select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">就业中心分类id</label>
					</div>
				</div>


				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>就业中心文章标题：</b>
					</div>
					<div class="col-xs-3">
						<input id="emoloyedTitle" name="emoloyedTitle" type="text" class="form-control"  value='${dxsEmployedArticlePage.emoloyedTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">就业中心文章标题</label>
					</div>
				</div>


				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>编辑人：</b>
					</div>
					<div class="col-xs-3">
						<input id="emoloyedEditor" name="emoloyedEditor" type="text" class="form-control"  value='${dxsEmployedArticlePage.emoloyedEditor}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">编辑人</label>
					</div>
				</div>


				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>发布时间：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="emoloyedPublishTime" name="emoloyedPublishTime" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEmployedArticlePage.emoloyedPublishTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">发布时间</label>--%>
					<%--</div>--%>
				<%--</div>--%>

				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>视频url：</b>
					</div>
					<div class="col-xs-3">
						<input id="emoloyedVideoUrl" name="emoloyedVideoUrl" type="text" class="form-control"  value='${dxsEmployedArticlePage.emoloyedVideoUrl}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">视频url</label>
					</div>
				</div>


				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>文章来源：</b>
					</div>
					<div class="col-xs-3">
						<input id="emoloyedFrom" name="emoloyedFrom" type="text" class="form-control"  value='${dxsEmployedArticlePage.emoloyedFrom}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">文章来源</label>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>编号：</b>
					</div>
					<div class="col-xs-3">
						<input id="emoloyedSort" name="emoloyedSort" type="text" class="form-control"  value='${dxsEmployedArticlePage.emoloyedSort}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">编号</label>
					</div>
				</div>


				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>缩略图：</b>
					</div>
					<div class="col-xs-3">
						<div id="_emoloyedImgurl"></div>
						<input id="emoloyedImgurl" name="emoloyedImgurl" type="text" class="form-control" value="${dxsEmployedArticlePage.emoloyedImgurl}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">缩略图</label>
					</div>
					<div class="col-xs-3">
						<img id="Image" src='${dxsEmployedArticlePage.emoloyedImgurl}'width="70%" height="30%"/>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>文章简介：</b>
					</div>
					<div class="col-xs-3">
						<textarea id="emoloyedIntroduction" name="emoloyedIntroduction" rows="6"  class="form-control">${dxsEmployedArticlePage.emoloyedIntroduction}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">文章简介</label>
					</div>
				</div>

			<%--<div class="row show-grid">--%>
				<%--<div class="col-xs-3 text-center">--%>
					<%--<b>外部标记：</b>--%>
				<%--</div>--%>
				<%--<div class="col-xs-3">--%>
					<%--<input id="outSign" name="outSign" type="text" class="form-control"  value='${dxsEmployedArticlePage.outSign}'>--%>
					<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
					<%--<label class="Validform_label" style="display: none">外部标记</label>--%>
				<%--</div>--%>

				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>就业中心文章内容：</b>
					</div>
					<div class="col-xs-9">

						<!-- 加载编辑器的容器 -->
						<script id="container" name="emoloyedContents" type="text/plain" style="width: 800px;min-height:300px;">
								${dxsEmployedArticlePage.emoloyedContents}
							</script>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">就业中心文章内容</label>
					</div>
				</div>





				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>createTime：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEmployedArticlePage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">createTime</label>--%>
					<%--</div>--%>
				<%--</div>--%>


				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>updateTime：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEmployedArticlePage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">updateTime</label>--%>
					<%--</div>--%>
				<%--</div>--%>


				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>删除标志：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsEmployedArticlePage.isDelete}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
					<%--</div>--%>
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
<script src = "webpage/com/buss/employedarticle/dxsEmployedArticle.js"></script>
</html>