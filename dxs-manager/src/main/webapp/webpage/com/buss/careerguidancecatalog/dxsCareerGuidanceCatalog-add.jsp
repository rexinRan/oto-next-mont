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
	  $('#_cgCatelogImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传项目配图',
		  'width' : 100,
		  'height' : 50,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#cgCatelogImg'))
			  $('#cgCatelogImg').val(data);
//          $("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })

   </script>
</head>

 <body>

  <form id="formobj" action="dxsCareerGuidanceCatalogController.do?doAdd" name="formobj" method="post">
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
							  <b>父id：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="pid" class="form-control" >
								  <option value="0">根目录</option>
								  <c:forEach items="${dxsCareerGuidanceCatalogList}" var="dxsCareerGuidanceCatalog">
									  <option value="${dxsCareerGuidanceCatalog.id}">
										  <t:mutiLang langKey="${dxsCareerGuidanceCatalog.cgCatelogName}"/>
									  </option>
								  </c:forEach>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">父id</label>
						  </div>
					  </div>
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>职场引导的名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgCatelogName" name="cgCatelogName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职场引导的名称</label>
			          </div>
								</div>
								<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>职场引导分类显示位置：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgCatelogPosition" name="cgCatelogPosition" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职场引导分类显示位置</label>
			          </div>
						</div>
			          
			        

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>职场引导分类的创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">职场引导分类的创建时间</label>--%>
			          <%--</div>--%>

			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>职场引导分类的修改时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">职场引导分类的修改时间</label>--%>
			          <%--</div>--%>

								<div class="col-xs-3 text-center">
									<b>排序：</b>
								</div>
								<div class="col-xs-3">
									<input id="sort" name="sort" type="text" class="form-control"  >
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">排序</label>
								</div>
						</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导分类的配图：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_cgCatelogImg"></div>
							  <input id="cgCatelogImg" name="cgCatelogImg" type="text" class="form-control" style="display: none" align="center" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">职场引导分类的配图</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导的描述：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="cgCatelogDescribe" name="cgCatelogDescribe" rows="6" class="form-control"  ></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">职场引导的描述</label>
						  </div>
					  </div>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  >--%>
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
<script src = "webpage/com/buss/careerguidancecatalog/dxsCareerGuidanceCatalog.js"></script>		
</html>