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
  $(function(){
	  /* 文件提交 */
	  $('#_voteImage').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#voteImage'))
			  $('#voteImage').val(data);
			  $('#Img').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  </script>
</head>

 <body>

  <form id="formobj" action="dxsVoteController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsVotePage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);"></a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>用户id(admin)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsVotePage.userId}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">用户id(admin)</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>投票分类的id：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="voteId" name="voteId" type="text" class="form-control"  value='${dxsVotePage.voteId}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">投票分类的id</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>投票标题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="voteTitle" name="voteTitle" type="text" class="form-control"  value='${dxsVotePage.voteTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">投票标题</label>
			          </div>
			          
			        

							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--&lt;%&ndash;<div class="col-xs-3 text-center">&ndash;%&gt;--%>
			          	<%--&lt;%&ndash;<b>展示菜单：</b>&ndash;%&gt;--%>
			          <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
			          <%--&lt;%&ndash;<div class="col-xs-3">&ndash;%&gt;--%>
								<%--&lt;%&ndash;<input id="displayMenu" name="displayMenu" type="text" class="form-control"  value='${dxsVotePage.displayMenu}'>&ndash;%&gt;--%>
						<%--&lt;%&ndash;<span class="Validform_checktip" style="float:left;height:0px;"></span>&ndash;%&gt;--%>
						<%--&lt;%&ndash;<label class="Validform_label" style="display: none">展示菜单</label>&ndash;%&gt;--%>
			          <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
			          <%----%>
			        <%----%>
			      <%----%>
							<%--</div>--%>
			          <%----%>
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>主办单位：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="hostUnit" name="hostUnit" type="text" class="form-control"  value='${dxsVotePage.hostUnit}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">主办单位</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>限报人数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="limitedNumber" name="limitedNumber" type="text" class="form-control"  value='${dxsVotePage.limitedNumber}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">限报人数</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>精彩回顾：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="histaryDate" name="histaryDate" type="text" class="form-control"  value='${dxsVotePage.histaryDate}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">精彩回顾</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>截止投票时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="deadlineDate" name="deadlineDate" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.deadlineDate}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">截止投票时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>活动开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="voteStateTime" name="voteStateTime" type="text"  class="form-control"  onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.voteStateTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动开始时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>活动结束时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="voteEndTime" name="voteEndTime" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.voteEndTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动结束时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>活动对象：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="voteUsertypeId" name="voteUsertypeId" type="text" class="form-control"  value='${dxsVotePage.voteUsertypeId}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动对象</label>
			          </div>
			          

			        
			          <div class="col-xs-3 text-center">
			          	<b>投票总人数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="voteNum" name="voteNum" type="text" class="form-control"  value='${dxsVotePage.voteNum}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">投票总人数</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>是否收费：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
						  <%--<input  name="isCharge" type="radio" value="0">是--%>
						  <%--<input  name="isCharge" type="radio" value="1">否--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">是否收费 0收费 1不收费</label>--%>
			          <%--</div>--%>
						  <div class="col-xs-3 text-center">
							  <b>投票地点：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="voteAddress" name="voteAddress" type="text" class="form-control"  value='${dxsVotePage.voteAddress}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">投票地点</label>
						  </div>
			        
			          <div class="col-xs-3 text-center">
			          	<b>可得到鸿鑫币数量：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="maxAccountCount" name="maxAccountCount" type="text" class="form-control"  value='${dxsVotePage.maxAccountCount}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">可得到鸿鑫币数量</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>发布时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="publishTime" name="publishTime" type="text"   class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.publishTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发布时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>编辑人：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="activeEditor" name="activeEditor" type="text" class="form-control"  value='${dxsVotePage.activeEditor}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">编辑人</label>
			          </div>
							</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>备注：</b>
									</div>
									<div class="col-xs-3">
										<input id="remarks" name="remarks" type="text" class="form-control"  value='${dxsVotePage.remarks}'>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">备注</label>
									</div>
									</div>

								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>投票活动缩略图：</b>
								</div>
								<div class="col-xs-3">
									<div id="_voteImage"></div>
									<input id="voteImage" name="voteImage" type="text" class="form-control" value="${dxsVotePage.voteImage}" style="display: none">
								</div>
									<div class="col-xs-3">
										<img id="Img" src='${dxsVotePage.voteImage}' width="70%" height="30%"/>
									</div>
			          </div>
								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>活动内容：</b>
								</div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="container" name="voteIntroduce" type="text/plain"  style="width: 800px;min-height:300px;">${dxsVotePage.voteIntroduce}</script>
								</div>
									</div>
								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>投票规则：</b>
								</div>
								<div class="col-xs-9">
									<!-- 加载编辑器的容器 -->
									<script id="_container" name="voteRule" type="text/plain"  style="width: 800px;min-height:300px;">${dxsVotePage.voteRule}</script>
								</div>
									</div>
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsVotePage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsVotePage.isDelete}'>--%>
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
<script src = "webpage/com/buss/vote/dxsVote.js"></script>		
</html>