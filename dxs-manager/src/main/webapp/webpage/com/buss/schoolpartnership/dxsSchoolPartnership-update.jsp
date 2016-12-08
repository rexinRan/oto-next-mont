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
	  $('#_logoBigImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#logoBigImg'))
			  $('#logoBigImg').val(data);
			  $('#BigImg').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_logoImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#logoImg'))
			  $('#logoImg').val(data);
			  $('#Img').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_schoolScenery').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#schoolScenery'))
			  $('#schoolScenery').val(data);
			  $('#school').attr("src",data);

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


  $.ajax({
	  url: "http://csee-china.cn/dxs-server/dxsDistProvinceController/list.do",
	  crossDomain: true,
	  dataType: 'jsonp',
	  jsonp: 'callback',
	  jsonpCallback: 'data',
	  success: function (data, textStatus) {
		  console.info(data);
		  var html = "";
		  for (var i = 0; i < data.data.length; i++) {
			  html += ("<option id='" + (data.data)[i].provinceid + "'>" + (data.data)[i].pname + "</option>");
		  }

		  $("#privence").append(html);
		  $("#city").empty().append("<option value='0'>-请选择-</option>");
		  $("#area").empty().append("<option value='0'>-请选择-</option>");
		  geetcity();
		  geetarea();
		  getall();
	  },
	  error: function () {

	  }


  });

  function geetcity() {
	  $("#privence").change(function(){
		  var pid = $("#privence option:selected").attr("id");
		  $.ajax({
			  url: "http://csee-china.cn/dxs-server/dxsDistCityController/provinceLinkageCity.do?provinceid=" + pid,
			  crossDomain: true,
			  dataType: 'jsonp',
			  jsonp : 'callback',
			  jsonpCallback: 'data',
			  success: function(data, textStatus){
				  console.info(data);
				  var html = "";
				  html+= ("<option value='0'>-请选择-</option>");
				  for (var i=0; i<data.data.length; i++) {
					  html +=("<option id='"+(data.data)[i].cityid+"'>"+ (data.data)[i].city +"</option>");

				  }


				  $("#city").empty().append(html);

				  geetarea();
			  },
			  error: function(){

			  }


		  });
	  });
  }

  function geetarea() {
	  $("#city").change(function(){
		  var pida = $("#city option:selected").attr("id");
		  $.ajax({
			  url: "http://csee-china.cn/dxs-server/dxsDistAreaController/CityLinkageArea.do?cityid=" + pida,
			  crossDomain: true,
			  dataType: 'jsonp',
			  jsonp : 'callback',
			  jsonpCallback: 'data',
			  success: function(data, textStatus){
//				  console.info(data);
				  var html = "";
				  for (var i=0; i<data.data.length; i++) {
					  html +=("<option id='(data.data)[i].areaid'>"+ (data.data)[i].area +"</option>");
				  }

//				   $("#privence").append(html);
//				  $("#city").empty().append(html);
				  $("#area").empty().append(html);
			  },
			  error: function(){

			  }


		  });
	  });
  }


  function getall() {
		  var objSelect = $("#schoolRealAddress").val();
		  var aa = objSelect.split("#")
	  $("#privence").val(aa[0]);
	  var pid = $("#privence option:selected").attr("id");
	  $.ajax({
		  url: "http://csee-china.cn/dxs-server/dxsDistCityController/provinceLinkageCity.do?provinceid=" + pid,
		  crossDomain: true,
		  dataType: 'jsonp',
		  jsonp : 'callback',
		  jsonpCallback: 'data',
		  async: false,
		  success: function(data, textStatus){
			  console.info(data);
			  var html = "";
			  html+= ("<option value='0'>-请选择-</option>");
			  for (var i=0; i<data.data.length; i++) {
				  html +=("<option id='"+(data.data)[i].cityid+"'>"+ (data.data)[i].city +"</option>");

			  }


			  $("#city").empty().append(html);

			  getallcity();
		  },
		  error: function(){

		  }


	  });

  }
  function getallcity() {
	  var objSelect = $("#schoolRealAddress").val();
	  var aa = objSelect.split("#")
	  $("#city").val(aa[1]);
	  var pida = $("#city option:selected").attr("id");
	  $.ajax({
		  url: "http://csee-china.cn/dxs-server/dxsDistAreaController/CityLinkageArea.do?cityid=" + pida,
		  crossDomain: true,
		  dataType: 'jsonp',
		  jsonp : 'callback',
		  jsonpCallback: 'data',
		  success: function(data, textStatus){
//				  console.info(data);
			  var html = "";
			  for (var i=0; i<data.data.length; i++) {
				  html +=("<option id='(data.data)[i].areaid'>"+ (data.data)[i].area +"</option>");
			  }

//				   $("#privence").append(html);
//				  $("#city").empty().append(html);
			  $("#area").empty().append(html);
			  getallarea();
		  },
		  error: function(){

		  }


	  });
  }

  function getallarea() {
	  var objSelect = $("#schoolRealAddress").val();
	  var aa = objSelect.split("#")
	  $("#area").val(aa[2]);
	  $("#diZhi").val(aa[3]);
  }



  $(function(){
	  /* 文件提交 */
	  $('#_schoolVideoUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传视频',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#schoolVideoUrl'))
			  $('#schoolVideoUrl').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })

  </script>
</head>

 <body>

  <form id="formobj" action="dxsSchoolPartnershipController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsSchoolPartnershipPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);"></a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>用户id(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.userId}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">用户id(预留)</label>--%>
			          <%--</div>--%>


			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>学院名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolName" name="schoolName" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.schoolName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学院名称</label>
			          </div>
                </div>

						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>校址：</b>
							  </div>
							  <div class="col-xs-3">
								  <select  id="privence" class="form-control" >
									  <option value="0">-请选择-</option>

								  </select>
								  <select  id="city" class="form-control" >
									  <option value="0">-请选择-</option>

								  </select>
								  <select id="area" class="form-control" >
									  <option value="0">-请选择-</option>

								  </select>
								  <input id="diZhi" class="form-control" type="text" value="请输入详细地址" onfocus="if (value =='请输入详细地址'){value =''}" onblur="if (value ==''){value='请输入详细地址'}"/>
								  <input id="schoolRealAddress" name="schoolRealAddress" type="hidden" class="form-control"  value='${dxsSchoolPartnershipPage.schoolRealAddress}'>
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">校址</label>
							  </div>
                          </div>
							  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>网址：</b>
							  </div>
							  <div class="col-xs-3">
								  <input id="schoolNetAddress" name="schoolNetAddress" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.schoolNetAddress}'>
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">网址</label>
							  </div>
						  </div>


						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>联系电话：</b>
							  </div>
							  <div class="col-xs-3">
								  <input id="schoolPhone" name="schoolPhone" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.schoolPhone}'>
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">联系电话</label>
							  </div>
                          </div>
						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>学校logo：</b>
							  </div>
							  <div class="col-xs-3">
								  <div id="_logoImg"></div>
								  <input id="logoImg" name="logoImg" type="text" class="form-control" value="${dxsSchoolPartnershipPage.logoImg}" style="display: none">
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">学校logo</label>
							  </div>

							  <div class="col-xs-3">
								  <img id="Img" src='${dxsSchoolPartnershipPage.logoImg}'width="70%" height="30%"/>
							  </div>
						  </div>

						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>大缩略图：</b>
							  </div>
							  <div class="col-xs-3">
								  <div id="_logoBigImg"></div>
								  <input id="logoBigImg" name="logoBigImg" type="text" class="form-control" value="${dxsSchoolPartnershipPage.logoBigImg}" style="display: none">
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">大缩略图</label>
							  </div>
							  <div class="col-xs-3">
								  <img id="BigImg" src='${dxsSchoolPartnershipPage.logoBigImg}'width="70%" height="30%"/>
							  </div>
							  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>校园风景：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_schoolScenery"></div>
							  <input id="schoolScenery" name="schoolScenery" type="text" class="form-control" value="${dxsSchoolPartnershipPage.schoolScenery}" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">校园风景</label>
						  </div>
						  <div class="col-xs-3">
							  <img id="school" src='${dxsSchoolPartnershipPage.schoolScenery}'width="70%" height="30%"/>
						  </div>
					  </div>

						  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>视频播放地址：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="schoolVideoUrl" name="schoolVideoUrl" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.schoolVideoUrl}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">视频播放地址</label>
						  </div>
							  <div class="col-xs-3">
							  <div id="_schoolVideoUrl"></div>
								  </div>
							  </div>

								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>学校简介：</b>
			          </div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="container" name="schoolIntroduce" type="text/plain" style="width: 800px;min-height:300px;">
                                      ${dxsSchoolPartnershipPage.schoolIntroduce}
									</script>
								</div>

							</div>
			          
			        

								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>特色展示：</b>
			          </div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="_container" name="schoolDisplay" type="text/plain" style="width: 800px;min-height:300px;">
                                     ${dxsSchoolPartnershipPage.schoolDisplay}
									</script>
								</div>
							</div>
			          
			        

			          
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSchoolPartnershipPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSchoolPartnershipPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsSchoolPartnershipPage.isDelete}'>--%>
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
			var a=$('#privence').val();
			var b=$('#city').val();
			var c=$('#area').val();
			var d=$('#diZhi').val();
			var e=$('#schoolRealAddress').val(a+"#"+b+"#"+c+"#"+d+"#");
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
<script src = "webpage/com/buss/schoolpartnership/dxsSchoolPartnership.js"></script>		
</html>