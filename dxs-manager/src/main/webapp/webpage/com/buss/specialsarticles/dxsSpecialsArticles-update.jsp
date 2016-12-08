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
	  $('#_imgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  /*;jsessionid=${pageContext.session.id}' 后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 50,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#imgUrl'))
			  $('#imgUrl').val(data);
			  $('#imgUrlImg').attr("src",data);
		  }
	  });
  })

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

  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  var a= $('#_cateLog').val()
	  $('#cateLog').val(a)

	  $.ajax({
		  type: "Post",
		  url: "dxsSpecialsArticlesController.do?zhuanXiang",
		  success: function(data) {
			  var json = eval('(' + data + ')');
			  var html = "";
			  for (var i = 0; i < json.data.length; i++) {
				  var aa = (json.data)[i].type==4? '大学生村官' : (json.data)[i].type==3? '志愿西部': (json.data)[i].type==2? '边区支教' : (json.data)[i].type==1? '三支一扶':'其他';

				  if ($('#spid').val() == (json.data[i].id)){

					  html += ("<option value='" + (json.data)[i].id + "' selected='selected'>" +aa+"</option>");
				  }

	  else {
					  html += ("<option value='" + (json.data)[i].id + "'>" +aa+"</option>");
  }
			  }
			  //alert((json.data)[0].id)
			  $('#specialId').append(html)
		  },
		  error: function(err) {
			  alert(err);
		  }
	  });
  }

   </script>
</head>

 <body>

  <form id="formobj" action="dxsSpecialsArticlesController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsSpecialsArticlesPage.id}' >
			
			
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
			          	<b>专项就业：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="specialId" class="form-control" id="specialId">

						  </select>
						  <input id="spid"  type="hidden"   value='${dxsSpecialsArticlesPage.specialId}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">专项就业id</label>
			          </div>
			        
			          <div class="col-xs-3 text-center">
			          	<b>标题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="title" name="title" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.title}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">标题</label>
			          </div>

							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>作者：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="autor" name="autor" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.autor}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">作者</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>来源：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sources" name="sources" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.sources}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">来源</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>发表时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="publishTime" name="publishTime" type="text"  class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSpecialsArticlesPage.publishTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发表时间</label>
			          </div>
			          
			        

							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>年份：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="timeYear" name="timeYear" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.timeYear}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">年份</label>
			          </div>
								<div class="col-xs-3 text-center">
									<b>编号：</b>
								</div>
								<div class="col-xs-3">
									<input id="sort" name="sort" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.sort}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">编号</label>
								</div>

							</div>

							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>视频地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="videoUrl" name="videoUrl" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.videoUrl}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">视频地址</label>
			          </div>
								<div class="col-xs-3 text-center">
									<b>分类：</b>
								</div>
								<div class="col-xs-3">
									<select id="cateLog" name="cateLog" class="form-control">
										<option value="1">大学生村官政策</option>
										<option value="2">大学生村官工作</option>
										<option value="3">大学生村官风采</option>
										<option value="4">报考条件</option>
									</select>
									<input id="_cateLog"  type="hidden" class="form-control"  value='${dxsSpecialsArticlesPage.cateLog}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">分类</label>
								</div>
							</div>
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSpecialsArticlesPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSpecialsArticlesPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsSpecialsArticlesPage.isDelete}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
			          <%--</div>--%>
							<%--</div>--%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>缩略图：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_imgUrl"></div>
							  <input id="imgUrl" name="imgUrl" type="hidden" class="form-control"  value="${dxsSpecialsArticlesPage.imgUrl}" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">略略图</label>
						  </div>
						  <div class="col-xs-3">
							  <img id="imgUrlImg" src='${dxsSpecialsArticlesPage.imgUrl}'width="70%" height="30%"/>
						  </div>

					  </div>
					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>区域：</b>
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
						  <input id="schoolRealAddress" name="addressArea" type="hidden" class="form-control"  value='${dxsSpecialsArticlesPage.addressArea}'>
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">区域</label>
					  </div>
						  </div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>简介：</b>
									</div>
									<div class="col-xs-3">
										<textarea id="summary" name="summary" rows="6" class="form-control" >${dxsSpecialsArticlesPage.summary}</textarea>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">简介</label>
									</div>
								</div>


								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>内容：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container" name="content" type="text/plain" style="width: 800px;min-height:300px;" >
            					${dxsSpecialsArticlesPage.content}
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
			if($('#diZhi').val()=="请输入详细地址"){
				$('#diZhi').val("");
			}
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
<script src = "webpage/com/buss/specialsarticles/dxsSpecialsArticles.js"></script>
<script src = "webpage/com/buss/common/lanxiaoupdate.js"></script>
</html>