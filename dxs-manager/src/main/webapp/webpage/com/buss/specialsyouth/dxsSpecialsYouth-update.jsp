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
	  $('#_headImgUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#headImgUrl'))
			  $('#headImgUrl').val(data);
			  $('#img6').attr("src",date);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function() {
	  $('#_detailImgUrl').uploadify({
		  'swf': 'plug-in/uploadify/uploadify.swf',
		  'uploader': 'files/upload.do',
		  'buttonText': '上传配图',
		  'width': 100,
		  'height': 30,
		  'onUploadSuccess': function (file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#detailImgUrl'))
			  $('#detailImgUrl').val(data);
			  $('#img7').attr(src, data)
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_displayImg01Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg01Url'))
			  $('#displayImg01Url').val(data);
			  $('#img5').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_displayImg02Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg02Url'))
			  $('#displayImg02Url').val(data);
			  $('#img4').attr("src",date);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_displayImg03Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg03Url'))
			  $('#displayImg03Url').val(data);
			  $('#img3').attr("src",date);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_displayImg04Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg04Url'))
			  $('#displayImg04Url').val(data);
			  $('#img2').val("src",date);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_displayImg05Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#displayImg05Url'))
			  $('#displayImg05Url').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
			  $('#img1').attr("src",date);
		  }
	  });
  })
  $(function(){

	  window.um = UM.getEditor('container', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//				imageUrl: "E:/upload/",
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

	  window.um = UM.getEditor('container1', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//				imageUrl: "E:/upload/",
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
	  $('#_type').val( $('#type').val())

  }
  </script>
</head>

 <body>

  <form id="formobj" action="dxsSpecialsYouthController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsSpecialsYouthPage.id}' >
			
			
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
			          	<b>用户：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control">
							  <c:forEach items="${DxsUserList}" var="DxsUser">
								  <option value="${DxsUser.id}"
										  <c:if test="${DxsUser.id==dxsSpecialsYouthPage.userId}">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${DxsUser.realname}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户id(预留)</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属分类：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="type" class="form-control" id="_type">
							  <option value="1">三支一扶</option>
							  <option value="2">边区支教</option>
							  <option value="3">志愿西部</option>
							  <option value="4">大学生村官</option>
						  </select>
								<input id="type"  type="hidden" class="form-control"  value='${dxsSpecialsYouthPage.type}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属分类</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>编号：</b>
								</div>
								<div class="col-xs-3">
									<input id="sort" name="sort" type="text" class="form-control"  value='${dxsSpecialsYouthPage.sort}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">编号</label>
								</div>

			          <div class="col-xs-3 text-center">
			          	<b>姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="name" name="name" type="text" class="form-control"  value='${dxsSpecialsYouthPage.name}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">姓名</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>年龄：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="age" name="age" type="text" class="form-control"  value='${dxsSpecialsYouthPage.age}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">年龄</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>政治面貌：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="political" name="political" type="text" class="form-control"  value='${dxsSpecialsYouthPage.political}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">政治面貌</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>学历：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="education" name="education" type="text" class="form-control"  value='${dxsSpecialsYouthPage.education}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学历</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>现在岗位：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="persentPost" name="persentPost" type="text" class="form-control"  value='${dxsSpecialsYouthPage.persentPost}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">现在岗位</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>工作地点：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="workPlace" name="workPlace" type="text" class="form-control"  value='${dxsSpecialsYouthPage.workPlace}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">工作地点</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>专业：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="major" name="major" type="text" class="form-control"  value='${dxsSpecialsYouthPage.major}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">专业</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>毕业院校：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="university" name="university" type="text" class="form-control"  value='${dxsSpecialsYouthPage.university}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">毕业院校</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>座右铭：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="motto" name="motto" type="text" class="form-control"  value='${dxsSpecialsYouthPage.motto}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">座右铭</label>
			          </div>
							</div>
			          
			        

			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>头像：</b>
								</div>
								<div class="col-xs-3">
									<div id="_headImgUrl"></div>
									<input id="headImgUrl" name="headImgUrl" type="text" class="form-control" value="${dxsSpecialsYouthPage.headImgUrl}" style="display: none">
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">头像</label>
								</div>
								<div class="col-xs-3">
									<img id="img6" src='${dxsSpecialsYouthPage.headImgUrl}' height="30%" width="70%"/>
								</div>
								</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>详情页图片：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_detailImgUrl"></div>
							  <input id="detailImgUrl" name="detailImgUrl" type="text" class="form-control" value="${dxsSpecialsYouthPage.detailImgUrl}" style="display: none">
						  </div>

						  <div class="col-xs-3">
							  <img id="img7" src='${dxsSpecialsYouthPage.detailImgUrl}' height="30%" width="70%"/>
						  </div>
					  </div>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSpecialsYouthPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsSpecialsYouthPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>删除标志：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsSpecialsYouthPage.isDelete}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">删除标志</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          <%----%>
			        <%----%>
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>风采展示图：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="displayImg01Fid" name="displayImg01Fid" type="text" class="form-control"  value='${dxsSpecialsYouthPage.displayImg01Fid}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">风采展示图</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>风采展示图地址：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_displayImg01Url"></div>
						  <input id="displayImg01Url" name="displayImg01Url" type="text" class="form-control" value="${dxsSpecialsYouthPage.displayImg01Url}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">风采展示图地址</label>
			          </div>
							<div class="col-xs-3">
								<img id="img5"src='${dxsSpecialsYouthPage.displayImg01Url}' height="30%" width="70%"/>
							</div>
							</div>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>风采展示图：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="displayImg02Fid" name="displayImg02Fid" type="text" class="form-control"  value='${dxsSpecialsYouthPage.displayImg02Fid}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">风采展示图</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>风采展示图地址：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_displayImg02Url"></div>
						  <input id="displayImg02Url" name="displayImg02Url" type="text" class="form-control" value="${dxsSpecialsYouthPage.displayImg02Url}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">风采展示图地址</label>
			          </div>
						<div class="col-xs-3">
							<img id="img4" src='${dxsSpecialsYouthPage.displayImg02Url}' height="30%" width="70%"/>
						</div>
							</div>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>风采展示图：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="displayImg03Fid" name="displayImg03Fid" type="text" class="form-control"  value='${dxsSpecialsYouthPage.displayImg03Fid}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">风采展示图</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>风采展示图地址：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_displayImg03Url"></div>
						  <input id="displayImg03Url" name="displayImg03Url" type="text" class="form-control" value="${dxsSpecialsYouthPage.displayImg03Url}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">风采展示图地址</label>
			          </div>
						<div class="col-xs-3">
							<img id="img3" src='${dxsSpecialsYouthPage.displayImg03Url}' width="70%" height="30%"/>
						</div>
							</div>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>风采展示图：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="displayImg04Fid" name="displayImg04Fid" type="text" class="form-control"  value='${dxsSpecialsYouthPage.displayImg04Fid}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">风采展示图</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>风采展示图地址：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_displayImg04Url"></div>
						  <input id="displayImg04Url" name="displayImg04Url" type="text" class="form-control" value="${dxsSpecialsYouthPage.displayImg04Url}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">风采展示图地址</label>
			          </div>
						<div class="col-xs-3">
							<img id="img2" src='${dxsSpecialsYouthPage.displayImg04Url}' width="70%" height="30%"/>
						</div>
							</div>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>风采展示图：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="displayImg05Fid" name="displayImg05Fid" type="text" class="form-control"  value='${dxsSpecialsYouthPage.displayImg05Fid}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">风采展示图</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>风采展示图地址：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_displayImg05Url"></div>
						  <input id="displayImg05Url" name="displayImg05Url" type="text" class="form-control" value="${dxsSpecialsYouthPage.displayImg05Url}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">风采展示图地址</label>
			          </div>
						<div class="col-xs-3">
							<img id="img1" src='${dxsSpecialsYouthPage.displayImg05Url}' height="30%" width="70%"/>
						</div>
							</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>个人简介：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container" name="profile" type="text/plain"  style="width: 800px;min-height:300px;">
                                            ${dxsSpecialsYouthPage.profile}
										</script>
									</div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>优秀事迹：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container1" name="deeds" type="text/plain"  style="width: 800px;min-height:300px;">
                                              ${dxsSpecialsYouthPage.deeds}
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
<script src = "webpage/com/buss/specialsyouth/dxsSpecialsYouth.js"></script>		
</html>