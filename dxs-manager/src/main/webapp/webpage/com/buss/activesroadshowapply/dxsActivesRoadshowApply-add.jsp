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
//           imageUrl: "E:/upload/",
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
//           imageUrl: "E:/upload/",
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
//           imageUrl: "E:/upload/",
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
	  window.um = UM.getEditor('container4', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//           imageUrl: "E:/upload/",
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
	  window.um = UM.getEditor('container5', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//           imageUrl: "E:/upload/",
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
	  window.um = UM.getEditor('container6', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//           imageUrl: "E:/upload/",
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
	  window.um = UM.getEditor('container7', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//           imageUrl: "E:/upload/",
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

  <form id="formobj" action="dxsActivesRoadshowApplyController.do?doAdd" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			
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
			          	<b>申请人姓名：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control" >
							  <c:forEach items="${dxsUserList}" var="dxsUser">
								  <option value="${dxsUser.id}">
									  <t:mutiLang langKey="${dxsUser.empname}"/>
								  </option>
							  </c:forEach>
						  </select>
								<%--<input id="userId" name="userId" type="text" class="form-control"  >--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">申请人id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>企业所在地：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="companyAddress" name="companyAddress" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">企业所在地</label>
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
									<b>文件地址：</b>
								</div>
								<div class="col-xs-3">
									<input id="fileUrl" name="fileUrl" type="text" class="form-control"  >
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">文件地址</label>
								</div>
							</div>

							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>文件id：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="fileId" name="fileId" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">文件id</label>--%>
			          <%--</div>--%>
					             <div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>处理结果：</b>
								</div>
								<div class="col-xs-3">
									<select id="result" name="result" class="form-control">
										<option value="0">申请</option>
										<option value="1">通过</option>
										<option value="2">拒绝</option>
									</select>

									<%--<input id="result" name="result" type="text" class="form-control"  >--%>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">处理结果</label>
								</div>

						  <div class="col-xs-3 text-center">
							  <b>注册资金：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="regFound" name="regFound" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">注册资金</label>
						  </div>
					  </div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>活动：</b>
					  </div>
					  <div class="col-xs-3">
						  <select name="activesId" class="form-control" >
							  <c:forEach items="${dxsActivesList}" var="dxsActives">
								  <option value="${dxsActives.id}">
									  <t:mutiLang langKey="${dxsActives.activeTitle}"/>
								  </option>
							  </c:forEach>
						  </select>
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">活动id</label>
					  </div>
						  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>企业简介：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="companyIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>团队介绍：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container2" name="companyTeamIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>项目介绍：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container3" name="projectIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>项目前景：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container4" name="projectProspect" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>行业优势：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container5" name="industryAdvantage" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
					  </div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>路演需求：</b>
			          </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container6" name="roadshowNeed" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
						  </div>
							</div>
			          
					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>处理结果说明：</b>
			          </div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="container7" name="message" type="text/plain"  style="width: 800px;min-height:300px;">

									</script>
								</div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  >--%>
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
<script src = "webpage/com/buss/activesroadshowapply/dxsActivesRoadshowApply.js"></script>		
</html>