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
//          $("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_bigImgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#bigImgUrl'))
			  $('#bigImgUrl').val(data);
//          $("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $('#jobIntention').val( $('#_jobIntention').val())
	  $('#templateStyle').val( $('#_templateStyle').val())
	  $('#templateLanguage').val( $('#_templateLanguage').val())
  }
  </script>
</head>

 <body>

  <form id="formobj" action="dxsResumeTemplateController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsResumeTemplatePage.id}' >
			
			
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
			          	<b>模板名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="templateName" name="templateName" type="text" class="form-control"  value='${dxsResumeTemplatePage.templateName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">模板名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>求职意向：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="jobIntention" name="jobIntention" class="form-control">
							  <option value="保险">保险</option>
							  <option value="材料">材料</option>
							  <option value="财务">财务</option>
							  <option value="电气">电气</option>
							  <option value="电商">电商</option>
							  <option value="电子">电子</option>
							  <option value="化工">化工</option>
							  <option value="会展">会展</option>
							  <option value="机械">机械</option>
							  <option value="记者">记者</option>
							  <option value="教师">教师</option>
							  <option value="客服">客服</option>
							  <option value="猎头">猎头</option>
							  <option value="律师">律师</option>
							  <option value="人力">人力</option>
							  <option value="生物">生物</option>
							  <option value="市场">市场</option>
							  <option value="通信">通信</option>
							  <option value="通用">通用</option>
							  <option value="投行">投行</option>
							  <option value="土木">土木</option>
							  <option value="外贸">外贸</option>
							  <option value="物流">物流</option>
							  <option value="销售">销售</option>
							  <option value="行政">行政</option>
							  <option value="医护">医护</option>
							  <option value="影视">影视</option>
							  <option value="其他">其他</option>
						  </select>
								<input id="_jobIntention"  type="hidden" class="form-control"  value='${dxsResumeTemplatePage.jobIntention}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">求职意向</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>模板风格：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="templateStyle" name="templateStyle" class="form-control">
							  <option value="黑白简历模板">黑白简历模板</option>
							  <option value="彩色简历模板">彩色简历模板</option>
						  </select>
								<input id="_templateStyle"  type="hidden" class="form-control"  value='${dxsResumeTemplatePage.templateStyle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">模板风格</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>模板语言：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="templateLanguage" name="templateLanguage" class="form-control">
							  <option value="中文简历模板">中文简历模板</option>
							  <option value="英文简历模板">英文简历模板</option>
						  </select>
								<input id="_templateLanguage" type="hidden" class="form-control"  value='${dxsResumeTemplatePage.templateLanguage}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">模板语言</label>
			          </div>
							</div>
			          
			        

			          
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>模板分类：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="templateCatelog" name="templateCatelog" type="text" class="form-control"  value='${dxsResumeTemplatePage.templateCatelog}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">模板分类</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>模板访问地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="templateUrl" name="templateUrl" type="text" class="form-control"  value='${dxsResumeTemplatePage.templateUrl}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">模板访问地址</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>价格：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="price" name="price" type="text" class="form-control"  value='${dxsResumeTemplatePage.price}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">价格</label>
			          </div>
								</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>模板图片：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_imgUrl"></div>
							  <input id="imgUrl" name="imgUrl" type="text" class="form-control" value="${dxsResumeTemplatePage.imgUrl}" style="display: none" align="center">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">模板图片</label>
						  </div>
                      </div>
					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>大图：</b>
					  </div>
					  <div class="col-xs-3">
						  <div id="_bigImgUrl"></div>
						  <input id="bigImgUrl" name="bigImgUrl" type="text" class="form-control" value="${dxsResumeTemplatePage.bigImgUrl}" style="display: none" align="center">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">大图</label>
					  </div>
				  </div>
						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>模板特点：</b>
							  </div>
							  <div class="col-xs-9">
								  <!-- 加载编辑器的容器 -->
								  <script id="container" name="templateFeature" type="text/plain"  style="width: 800px;min-height:300px;">
                                      ${dxsResumeTemplatePage.templateFeature}
								  </script>
							  </div>
						  </div>
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsResumeTemplatePage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsResumeTemplatePage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsResumeTemplatePage.isDelete}'>--%>
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
<script src = "webpage/com/buss/resumetemplate/dxsResumeTemplate.js"></script>		
</html>