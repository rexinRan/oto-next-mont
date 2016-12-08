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
			$('#_newImgUrl').uploadify({
				'swf' : 'plug-in/uploadify/uploadify.swf',
				'uploader' : 'files/upload.do',
				'buttonText' : '上传配图',
				'width' : 100,
				'height' : 30,
				'onUploadSuccess' : function(file, data, response) {
					alert('successfully uploaded ' + ':' + data);
					console.info($('#newImgUrl'))
					$('#newImgUrl').val(data);
					$('#Image').attr("src",data)
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
		window.onload=function()//用window的onload事件，窗体加载完毕的时候
		{
			$('#_outSign').val($('#outSign').val())
		}

	</script>
</head>

<body>

<form id="formobj" action="dxsNewsController.do?doUpdate" name="formobj" method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" name="id" value='${dxsNewsPage.id}' >

	<div class="tab-wrapper">

		<div class="con-wrapper" id="con-wrapper1" style="display: block;">
			<div class="row form-wrapper">
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻分类：</b>
					</div>
					<div class="col-xs-3" >
						<select name="newCatelogId" class="form-control">
							<c:forEach items="${dxsnewscatelogList}" var="dxsnewscatelog">
								<option value="${dxsnewscatelog.id}"
										<c:if test="${dxsnewscatelog.id==dxsNewsPage.newCatelogId}">selected="selected"</c:if>
                           >
									<t:mutiLang langKey="${dxsnewscatelog.newCatelogName}"/>
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻标题：</b>
					</div>
					<div class="col-xs-3">
						<input id="newTitle" name="newTitle" type="text" class="form-control"  value="${dxsNewsPage.newTitle}">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>

					</div>
				</div>


				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>编辑人：</b>
					</div>
					<div class="col-xs-3">
						<input id="newEditor" name="newEditor" type="text"  class="form-control" value="${dxsNewsPage.newEditor}">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>

					</div>
				</div>
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>发布时间：</b>
					</div>
					<div class="col-xs-3">
						<input id="newPublishTime"  name="newPublishTime" type="text"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="${dxsNewsPage.newPublishTime}">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>

					</div>
				</div>
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻来源：</b>
					</div>
					<div class="col-xs-3">
						<input id="newFrom" name="newFrom" type="text"  class="form-control" value="${dxsNewsPage.newFrom}">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>

					</div>
				</div>

				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>新闻发布年份：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="newPublishYear" name="newPublishYear" type="text" class="form-control"  value="${dxsNewsPage.newPublishYear}">--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">新闻发布年份</label>--%>
					<%--</div>--%>
				<%--</div>--%>
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻简介：</b>
					</div>
					<div class="col-xs-3">
						<input id="newIntroduction" name="newIntroduction" type="text" class="form-control"  value='${dxsNewsPage.newIntroduction}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">新闻简介</label>
					</div>
				</div>
				<%--<div class="row show-grid">--%>
					<%--<div class="col-xs-3 text-center">--%>
						<%--<b>编号：</b>--%>
					<%--</div>--%>
					<%--<div class="col-xs-3">--%>
						<%--<input id="newSort" name="newSort" type="text"  class="form-control" value="${dxsNewsPage.newSort}">--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
					<%--</div>--%>
					<%--</div>--%>
					<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻视频：</b>
					</div>
					<div class="col-xs-3">
						<input id="newVideoUrl" name="newVideoUrl" type="text" class="form-control"  value='${dxsNewsPage.newVideoUrl}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">新闻视频</label>
					</div>
				</div>

				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>外部标记：</b>
					</div>
					<div class="col-xs-3">
						<select name="outSign"  class="form-control" id="_outSign">
							<option value="0">请选择</option>
							<option value="1">在线招聘企业 HR 专访</option>
							<option value="2">在线招聘学生专访</option>
							<option value="3">大学生村官->报考信息</option>
							<option value="4">出国游学动态</option>
							<option value="5">精准扶贫->深度报道</option>
							<option value="6">精准扶贫->图片新闻</option>
							<option value="7">精准扶贫->热点聚焦</option>
						</select>
						<input id="outSign" type="hidden" class="form-control"  value='${dxsNewsPage.outSign}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">外部标记</label>
					</div>
					</div>
				<div class="row show-grid">
					<div class="col-xs-3 text-center">
						<b>新闻缩略图：</b>
					</div>
					<div class="col-xs-3">
						<div id="_newImgUrl"></div>
						<input id="newImgUrl" name="newImgUrl" type="text" class="form-control" value="${dxsNewsPage.newImgUrl}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">新闻缩略图</label>
					</div>
					<div class="col-xs-3">
						<img id="Image" src='${dxsNewsPage.newImgUrl}'width="70%" height="30%"/>
					</div>
				</div>
				<%-- 這裡加文本編輯器 --%>
				<div class="row show-grid">
					<div class="col-xs-3 text-center" style="border: 0px solid red;">
						<b>新闻内容：</b>
					</div>
					<div class="col-xs-9">
						<!-- 加载编辑器的容器 -->
						<script id="container" name="newContents" type="text/plain"  style="width: 800px;min-height:300px;">
								${dxsNewsPage.newContents}
							</script>
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
<script src = "webpage/com/buss/dxsnews/dxsNews.js"></script>
