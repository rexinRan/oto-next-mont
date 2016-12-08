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
	  $('#_displayBigImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayBigImg'))
			  $('#displayBigImg').val(data);
			  $('#BigImg').attr("src",data);
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
	  /* 文件提交 */
	  $('#_displayImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg'))
			  $('#displayImg').val(data);
			  $('#disImg').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_compancyImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#compancyImg'))
			  $('#compancyImg').val(data);
			  $('#Img').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  </script>
</head>

 <body>

  <form id="formobj" action="dxsUserCompancyController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsUserCompancyPage.id}' >
	  <%--<input id="userId" name="userId" type="hidden"   value='${dxsUserCompancyPage.userId}'>--%>
	  <%--<input id="rolecode" name="rolecode" type="hidden" class="form-control"  value='${dxsUserPage.rolecode}'>--%>
	  <%--<input id="empname" name="empname" type="hidden" class="form-control"  value='${dxsUserCompancyPage.compancyName}'>--%>
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);"></a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<%--<div class="row show-grid">--%>


								<%--&lt;%&ndash;<div class="col-xs-3 text-center">&ndash;%&gt;--%>
									<%--&lt;%&ndash;<b>真实姓名：</b>&ndash;%&gt;--%>
								<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
								<%--&lt;%&ndash;<div class="col-xs-3">&ndash;%&gt;--%>
									<%--&lt;%&ndash;<input id="realname" name="realname" type="text" class="form-control"  value='${dxsUserPage.realname}'>&ndash;%&gt;--%>
									<%--&lt;%&ndash;<span class="Validform_checktip" style="float:left;height:0px;"></span>&ndash;%&gt;--%>
									<%--&lt;%&ndash;<label class="Validform_label" style="display: none">真实姓名</label>&ndash;%&gt;--%>
								<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
							<%--</div>--%>


					  <%--<div class="row show-grid">--%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>用户角色：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="rolecode" name="rolecode" type="text" class="form-control"  value='${dxsUserPage.rolecode}'>--%>
						  <%--</div>--%>

						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>手机号：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="mphone" name="mphone" type="text" class="form-control"  value='${dxsUserPage.mphone}'>--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">手机号(老师/学生登录账号)</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>

					  <%--
                              <div class="row show-grid">
                        <div class="col-xs-3 text-center">
                            <b>密码：</b>
                        </div>
                        <div class="col-xs-3">
                                  <input id="pwd" name="pwd" type="text" class="form-control"  value='${dxsUserPage.pwd}'>
                          <span class="Validform_checktip" style="float:left;height:0px;"></span>
                          <label class="Validform_label" style="display: none">密码</label>
                        </div>
                          </div>
                        --%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>电子邮箱：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="email" name="email" type="text" class="form-control"  value='${dxsUserPage.email}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">电子邮箱(企业登录账号)</label>
						  </div>

						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>企业名称：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="empname" name="empname" type="text" class="form-control"  value='${dxsUserPage.empname}'>--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">企业名称</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>



						  <div class="col-xs-3 text-center">
							  <b>企业组织代码证号：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="empcode" name="empcode" type="text" class="form-control"  value='${dxsUserPage.empcode}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">企业组织代码证号</label>
						  </div>
</div>
					  <%--<div class="row show-grid">--%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>核审状态：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="checkstatus" name="checkstatus" type="text" class="form-control"  value='${dxsUserPage.checkstatus}'>--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">核审状态(预留判断企业)</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>

					  <%--
                              <div class="row show-grid">
                        <div class="col-xs-3 text-center">
                            <b>是否删除：</b>
                        </div>
                        <div class="col-xs-3">
                                  <input id="isdelete" name="isdelete" type="text" class="form-control"  value='${dxsUserPage.isdelete}'>
                          <span class="Validform_checktip" style="float:left;height:0px;"></span>
                          <label class="Validform_label" style="display: none">是否删除</label>
                        </div>
                          </div>
                        --%>


						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>用户加入时间：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">用户加入时间</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>

								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>公司名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="compancyName" name="compancyName" type="text" class="form-control"  value='${dxsUserCompancyPage.compancyName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">公司名称</label>
			          </div>




			          <div class="col-xs-3 text-center">
			          	<b>公司官网：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="compancyAddress" name="compancyAddress" type="text" class="form-control"  value='${dxsUserCompancyPage.compancyAddress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">公司官网</label>
			          </div>
			          </div>



								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>联系人：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="contactName" name="contactName" type="text" class="form-control"  value='${dxsUserCompancyPage.contactName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">联系人</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>联系人电话：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="contactTel" name="contactTel" type="text" class="form-control"  value='${dxsUserCompancyPage.contactTel}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">联系人电话</label>
			          </div>
                   </div>
									<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>公司规模：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="compancyNum" name="compancyNum" type="text" class="form-control"  value='${dxsUserCompancyPage.compancyNum}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">公司规模</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>公司地点：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="compancyPositation" name="compancyPositation" type="text" class="form-control"  value='${dxsUserCompancyPage.compancyPositation}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">公司地点</label>
			          </div>
			          </div>
								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>公司视频展示：</b>
									</div>
									<div class="col-xs-3">
										<input id="displayVideo" name="displayVideo" type="text" class="form-control" value="${dxsUserCompancyPage.displayVideo}" >
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">公司视频展示</label>
									</div>

			          <div class="col-xs-3 text-center">
			          	<b>所属行业：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="compancyType" name="compancyType" type="text" class="form-control"  value='${dxsUserCompancyPage.compancyType}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属行业</label>
			          </div>
			          </div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>公司详情页展示图：</b>
									</div>
									<div class="col-xs-3">
										<div id="_compancyImg"></div>
										<input id="compancyImg" name="compancyImg" type="text" class="form-control" value="${dxsUserCompancyPage.compancyImg}" style="display: none">

									</div>
									<div class="col-xs-3">
										<img id="Img" src='${dxsUserCompancyPage.compancyImg}'width="70%" height="30%"/>
									</div>
								</div>
								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>公司缩略图：</b>
									</div>
									<div class="col-xs-3">
										<div id="_displayImg"></div>
										<input id="displayImg" name="displayImg" type="text" class="form-control" value="${dxsUserCompancyPage.displayImg}" style="display: none">
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">公司展示图</label>
									</div>
									<div class="col-xs-3">
										<img id="disImg" src='${dxsUserCompancyPage.displayImg}'width="70%" height="30%"/>
									</div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>公司大缩略图：</b>
									</div>
									<div class="col-xs-3">
										<div id="_displayBigImg"></div>
										<input id="displayBigImg" name="displayBigImg" type="text" class="form-control" value="${dxsUserCompancyPage.displayBigImg}" style="display: none">
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">displayBigImg</label>
									</div>
									<div class="col-xs-3">
										<img id="BigImg" src='${dxsUserCompancyPage.displayBigImg}'width="70%" height="30%"/>
									</div>
									</div>

								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>公司介绍：</b>
								</div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="container" name="compancyIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">
                                               ${dxsUserCompancyPage.compancyIntroduce}
										</script>
								</div>
			        </div>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserCompancyPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          <%----%>
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserCompancyPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsUserCompancyPage.isDelete}'>--%>
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
<script src = "webpage/com/buss/usercompancy/dxsUserCompancy.js"></script>		
</html>