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
	  /* 文件提交 */
	  $('#_cgImgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do;jsessionid=${pageContext.session.id}',    /*后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#cgImgUrl'))
			  $('#cgImgUrl').val(data);
			  $('#cgImgUrlImgurl').attr("src",data);
		  }
	  });
  })
//  window.onload=function()//用window的onload事件，窗体加载完毕的时候
//  {
//	  //单选按钮的回显
//	  var obj = document.getElementsByName('isSpecial');
//	  var aa=$('#isSpecial').val()
//	  for (var i = 0; i < obj.length; i++) {
//		  if (obj[i].value == aa) {
//
//			  obj[i].checked = "checked";
//
//		  }
//
//	  }
//  }
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $('#outSign').val($('#_outSign').val())
  }
   </script>
</head>

 <body>

  <form id="formobj" action="dxsCareerGuidanceController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsCareerGuidancePage.id}' >
			
			
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
			          	<b>职场引导分类：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="cgCatelogId" class="form-control" >
							  <c:forEach items="${dxsCareerGuidanceCatalogList}" var="dxsCareerGuidanceCatalog">
								  <option value="${dxsCareerGuidanceCatalog.id}"
										  <c:if test="${ dxsCareerGuidanceCatalog.id==dxsCareerGuidancePage.cgCatelogId }">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsCareerGuidanceCatalog.cgCatelogName}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职场引导分类id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>职场引导标题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgTitle" name="cgTitle" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职场引导标题</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>编辑人：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgEditor" name="cgEditor" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgEditor}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">编辑人</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>发布时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgPublishTime" name="cgPublishTime" type="text"  class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCareerGuidancePage.cgPublishTime}' type="date" pattern="yyyy-MM-dd"/>'/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发布时间</label>
			          </div>
							</div>


							<%--<div class="row show-grid">--%>
			        <%----%>

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>职场引导发布年份：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="cgPublishYear" name="cgPublishYear" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgPublishYear}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">职场引导发布年份</label>--%>
			          <%--</div>--%>

							<%--</div>--%>
			          <%----%>
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>职场引导发布月份：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="cgPublicMonth" name="cgPublicMonth" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgPublicMonth}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">职场引导发布月份</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>是否特别关注：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
						  <%--<input type="radio" value="0" name="isSpecial">是--%>
						  <%--<input type="radio" value="1" name="isSpecial">否--%>
								<%--<input id="isSpecial"  type="hidden"  value='${dxsCareerGuidancePage.isSpecial}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">是否特别关注</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>职场引导来源：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="cgFrom" name="cgFrom" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgFrom}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职场引导来源</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>外部标记：</b>
			          </div>
			          <div class="col-xs-3">
						  <select  id="outSign" name="outSign" class="form-control">
							  <option value="0">-请选择-</option>
							  <option value="1">精彩推选</option>
						  </select>
								<input id="_outSign" type="hidden"  value='${dxsCareerGuidancePage.outSign}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">外部标记</label>
			          </div>
							</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导视频：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="cgVideoUrl" name="cgVideoUrl" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgVideoUrl}'>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>编号：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="cgSort" name="cgSort" type="text" class="form-control"  value='${dxsCareerGuidancePage.cgSort}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">编号</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导缩略图：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_cgImgUrl"></div>
							  <input id="cgImgUrl" name="cgImgUrl" type="text" class="form-control"  value="${dxsCareerGuidancePage.cgImgUrl}" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">职场引导缩略图</label>
						  </div>
						  <div class="col-xs-3">
							  <img id="cgImgUrlImgurl" src='${dxsCareerGuidancePage.cgImgUrl}'width="70%" height="30%"/>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导简介：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="cgIntroduction" name="cgIntroduction" rows="6" class="form-control" >${dxsCareerGuidancePage.cgIntroduction}</textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">职场引导简介</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>职场引导内容：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="cgContents" type="text/plain" style="width: 800px;min-height:300px;" >
            										${dxsCareerGuidancePage.cgContents}
         							</script>
						  </div>
					  </div>


				  <%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>createTime：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCareerGuidancePage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">createTime</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>updateTime：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsCareerGuidancePage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">updateTime</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          <%----%>
			        <%----%>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsCareerGuidancePage.isDelete}'>--%>
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
			if($('#cgPublishTime').val()==""){
				alert("发布时间不能为空")
				tag=false;
			}
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
<script src = "webpage/com/buss/careerguidance/dxsCareerGuidance.js"></script>		
</html>