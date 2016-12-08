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

  var a="";
  $(function(){
	  /* 文件提交 */
	  $('#_lectureContentImgs').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '多图上传',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#lectureContentImgs'))
			 // $('#lectureContentImgs').val(data);
			  // $('#activeContentImg').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
			  tianjia(data);
		  }
	  });
  })
  function tianjia(data){

	  a=a+data+"#";
	  $('#lectureContentImgs').val(a)
  }
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $('#outSign').val($('#_outSign').val())
  }
   </script>
</head>

 <body>

  <form id="formobj" action="dxsLecturesController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsLecturesPage.id}' >
			
			
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
			          	<b>活动名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="acitveId" class="form-control" >
							  <c:forEach items="${dxsActivesList}" var="dxsActives">
								  <option value="${dxsActives.id}"
										  <c:if test="${dxsActives.id==dxsLecturesPage.acitveId}">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsActives.activeTitle}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>名家/企业家的名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="lpId" class="form-control" >
							  <c:forEach items="${dxsLecturesPersionList}" var="dxsLecturesPersion">
								  <option value="${dxsLecturesPersion.id}"
										  <c:if test="${dxsLecturesPersion.id==dxsLecturesPage.lpId}">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsLecturesPersion.prosonName}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span cl	ass="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">名家/企业家的id</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>主题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lectureTitle" name="lectureTitle" type="text" class="form-control"  value='${dxsLecturesPage.lectureTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">主题</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所在站名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lectureAddressShort" name="lectureAddressShort" type="text" class="form-control"  value='${dxsLecturesPage.lectureAddressShort}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所在站名</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>演讲地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lectureAddress" name="lectureAddress" type="text" class="form-control"  value='${dxsLecturesPage.lectureAddress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">演讲地址</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>演讲时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lectureTime" name="lectureTime" type="text"  class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsLecturesPage.lectureTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">演讲时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>所属场次：</b>
								</div>
								<div class="col-xs-3">
									<select name="lgId" class="form-control" >
										<c:forEach items="${dxsLecturesGroupsList}" var="dxsLecturesGroups">
											<option value="${dxsLecturesGroups.id}"
													<c:if test="${dxsLecturesGroups.id==dxsLecturesPage.lgId}">selected="selected"</c:if>
											>
												<t:mutiLang langKey="${dxsLecturesGroups.title}"/>
											</option>
										</c:forEach>
									</select>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">所属场次</label>
								</div>


									<div class="col-xs-3 text-center">
										<b>学校名称：</b>
									</div>
									<div class="col-xs-3">
										<input id="schoolName" name="schoolName" type="text" class="form-control"  value='${dxsLecturesPage.schoolName}'>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">学校名称</label>
									</div>

							</div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>外部标记：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="outSign" name="outSign"  class="form-control" >
								  <option  value="0">-请选择-</option>
								  <option  value="1">banner右列</option>
							  </select>
							  <input id="_outSign" type="hidden" class="form-control"  value='${dxsLecturesPage.outSign}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">外部标记</label>
						  </div>
						  </div>

					    <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>三张图片：</b>
					  </div>
					  <div class="col-xs-3">
						  <div id="_lectureContentImgs"></div>
						  <input id="lectureContentImgs" name="lectureContentImgs" type="text" class="form-control"  value="${dxsLecturesPage.lectureContentImgs}" style="display: none">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">图片地址</label>
					  </div>
					  <%--<div class="col-xs-3">--%>
						  <%--<img id="imgurl" src='${dxsLecturesPage.lectureContentImgs}'width="70%" height="30%"/>--%>
					  <%--</div>--%>
							</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>主题内容简介：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="lectureContentSummary" name="lectureContentSummary" rows="6" class="form-control" >${dxsLecturesPage.lectureContentSummary}</textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">主题内容简介</label>
						  </div>

					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>主题内容详解：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="lectureContent" type="text/plain" style="width: 800px;min-height:300px;" >
           								 ${dxsLecturesPage.lectureContent}
        						</script>
						  </div>
					  </div>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsLecturesPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsLecturesPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsLecturesPage.isDelete}'>--%>
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
<script src = "webpage/com/buss/lectures/dxsLectures.js"></script>		
</html>