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
	  /* 文件提交 */
	  $('#_imgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#imgUrl'))
			   $('#imgUrl').val(data);
			  $('#imgurlXian').attr("src",data);
		  }
	  });
  })


  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  var a= $('#_type').val()
	  $('#type').val(a)
//	 var ab= $('#prosonAccomplishment').val()
//	  var result=ab.split("#");
//	  alert(result[0])
//	 $('#dome1').attr("src",result[0])
//	  $('#dome2').attr("src",result[1])
//	  $('#dome3').attr("src", result[2])
  }
  $(function(){
	  /* 文件提交 */
	  $('#_prosonAccomplishment').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '多图上传',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#prosonAccomplishment'))
			//  $('#prosonAccomplishment').val(data);
			  tianjia(data)
		  }
	  });
  })
  var a="";
  function tianjia(data){

	  a=a+data+"#";
	  $('#prosonAccomplishment').val(a)
  }

   </script>
</head>

 <body>

  <form id="formobj" action="dxsLecturesPersionController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsLecturesPersionPage.id}' >
			
			
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
			          	<%--<b>用户id(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsLecturesPersionPage.userId}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">用户id(预留)</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonName" name="prosonName" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">姓名</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>职位：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonJob" name="prosonJob" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonJob}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职位</label>
			          </div>
							</div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>地点：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonAddress" name="prosonAddress" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonAddress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">地点</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>毕业院校：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonEdu" name="prosonEdu" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonEdu}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">毕业院校</label>
			          </div>
					  </div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>社会最高职位：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonTopJob" name="prosonTopJob" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonTopJob}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">社会最高职位</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>现任职单位：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonNowJob" name="prosonNowJob" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonNowJob}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">现任职单位</label>
			          </div>
					  </div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>企业经营项目：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="prosonNowProject" name="prosonNowProject" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonNowProject}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">企业经营项目</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>企业家风采视频：</b>
			          </div>
			          <div class="col-xs-3">
						  <input id="prosonStyleVideo" name="prosonStyleVideo" type="text" class="form-control"  value='${dxsLecturesPersionPage.prosonStyleVideo}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">企业家风采视频</label>
			          </div>

					  </div>
			          

							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>类别：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="type" name="type" class="form-control">
							  <option value="0">企业家</option>
							  <option value="1">名家</option>
						  </select>
								<input id="_type"  type="hidden" class="form-control"  value='${dxsLecturesPersionPage.type}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">类别</label>
			          </div>

								<div class="col-xs-3 text-center">
									<b>学历：</b>
								</div>
								<div class="col-xs-3">
									<input id="educational" name="educational" type="text" class="form-control"  value='${dxsLecturesPersionPage.educational}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">学历</label>
								</div>
							</div>
					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>缩略图：</b>
					  </div>
					  <div class="col-xs-3">
						  <div id="_imgUrl"></div>
						  <input id="imgUrl"   name="imgUrl" type="hidden" class="form-control" value="${dxsLecturesPersionPage.imgUrl}" style="display: none" >
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">缩略图</label>
					  </div>
						  <div class="col-xs-3">
							  <img id="imgurlXian" src='${dxsLecturesPersionPage.imgUrl}'width="70%" height="30%"/>
						  </div>
				  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>个人成就展：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_prosonAccomplishment"></div>
							  <%--<input id="images"  type="text" class="form-control" value="" style="display: none">--%>
							  <input id="prosonAccomplishment"   name="prosonAccomplishment" type="hidden" class="form-control" value="${dxsLecturesPersionPage.prosonAccomplishment}" style="display: none">
						  </div>
						  <%--<div class="col-xs-3">--%>
							  <%--<img id="dome1" src="" width="50%" height="20%">--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<img id="dome2" src="" width="50%" height="20%">--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<img id="dome3" src="" width="50%" height="20%">--%>
						  <%--</div>--%>
					  </div>


								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>个人履历：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container" name="prosonResumeDisplay" type="text/plain" style="width: 800px;min-height:300px;" >
           										  ${dxsLecturesPersionPage.prosonResumeDisplay}
         							</script>
									</div>
								</div>


								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>企业家风采描述：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container2" name="prosonStyle" type="text/plain" style="width: 800px;min-height:300px;" >
            										${dxsLecturesPersionPage.prosonStyle}
         							</script>
									</div>
								</div>



							<%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsLecturesPersionPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsLecturesPersionPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsLecturesPersionPage.isDelete}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
			          <%--</div>--%>
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
<script src = "webpage/com/buss/lecturespersion/dxsLecturesPersion.js"></script>		
</html>