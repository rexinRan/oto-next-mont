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
  <script type="text/javascript" src="plug-in/umeditor/umeditor.js"></script>
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
	  window.um = UM.getEditor('container2', {
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
	  window.um = UM.getEditor('container3', {
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
	  window.um = UM.getEditor('container4', {
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
	  window.um = UM.getEditor('container5', {
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
	  window.um = UM.getEditor('container6', {
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
	  window.um = UM.getEditor('container7', {
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
	  window.um = UM.getEditor('container8', {
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
	  window.um = UM.getEditor('container9', {
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
	  window.um = UM.getEditor('container10', {
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
	  window.um = UM.getEditor('container11', {
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
	  window.um = UM.getEditor('container12', {
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
	  window.um = UM.getEditor('container13', {
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
	  window.um = UM.getEditor('container14', {
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
	  window.um = UM.getEditor('container15', {
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
	  window.um = UM.getEditor('container2', {
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
	  window.um = UM.getEditor('container3', {
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
	  window.um = UM.getEditor('container4', {
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
	  window.um = UM.getEditor('container5', {
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
	  window.um = UM.getEditor('container6', {
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
	  window.um = UM.getEditor('container7', {
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
	  window.um = UM.getEditor('container8', {
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
	  window.um = UM.getEditor('container9', {
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
	  window.um = UM.getEditor('container10', {
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
	  window.um = UM.getEditor('container11', {
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
	  window.um = UM.getEditor('container12', {
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
	  window.um = UM.getEditor('container13', {
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
	  window.um = UM.getEditor('container14', {
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
	  $('#_hiringEnclosureUrl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传文件',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#hiringEnclosureUrl'))
			  $('#hiringEnclosureUrl').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  var html = "";
		  if( $('#fenlei').val()==1){
			  html +=("<option value='支教'>支教</option>");
			  html +=("<option value='支医'>支医</option>");
			  html +=("<option value='支农'>支农</option>");
			  html +=("<option value='精准扶贫'>精准扶贫</option>");
			  $('#hiringJob').append(html)

	  }
	  if( $('#fenlei').val()==2){
		  html +=("<option value='小学'>小学</option>");
		  html +=("<option value='初中'>初中</option>");
		  html +=("<option value='高中'>高中</option>");
		  html +=("<option value='特殊教育'>特殊教育</option>");
		  html +=("<option value='心理导师'>心理导师</option>");
		  $('#hiringJob').append(html)

	  }
	  if( $('#fenlei').val()==3){
		  html +=("<option value='去工作'>去工作</option>");
		  html +=("<option value='去创业'>去创业</option>");
		  html +=("<option value='精准扶贫'>精准扶贫</option>");
		  html +=("<option value='三支（支教、支医、支农）'>三支（支教、支医、支农）</option>");
		  $('#hiringJob').append(html)

	  }
	  if( $('#fenlei').val()==4){
		  html +=("<option value='1'>名校名企交流学习系列</option>");
		  html +=("<option value='2'>留学生活体验式系列</option>");
		  html +=("<option value='3'>领导力精英成长系列</option>");
		  html +=("<option value='4'>特色主题扩展系列</option>");
		  $('#hiringJob').append(html)

	  }

  }
  </script>
</head>

 <body>

  <form id="formobj" action="dxsSpecialsHiringController.do?doAdd" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
	  <input  name="specialsId" type="hidden" value="${specialsId}"  >
	  <input  id="fenlei" type="hidden" value="${type}"  >
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
			          	<%--<b>专项就业id：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="specialsId" name="specialsId" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">专项就业id</label>--%>
			          <%--</div>--%>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>标题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="title" name="title" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">标题</label>
			          </div>

						  <div class="col-xs-3 text-center">
							  <b>志愿项目：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="hiringJob" name="hiringJob" class="form-control">

							  </select>
							  <%--<input id="hiringJob" name="hiringJob" type="text" class="form-control"  >--%>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">志愿项目</label>
						  </div>
							</div>
			          

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>选聘数量：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="hiringNum" name="hiringNum" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">选聘数量</label>
			          </div>

						  <div class="col-xs-3 text-center">
							  <b>编号：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="sort" name="sort" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">编号</label>
						  </div>


					  </div>


					  <%--<div class="row show-grid">--%>
						<%----%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>附件：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="hiringEnclosureFid" name="hiringEnclosureFid" type="text" class="form-control"  >--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">附件</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>



						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>选聘项目(预留)：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<input id="hiringProject" name="hiringProject" type="text" class="form-control"  >--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">选聘项目(预留)</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>发布单位：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="publishCompany" name="publishCompany" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">发布单位</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>发布时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <%--  style="width: 150px"  --%>
							  <input id="publishTime" name="publishTime" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="date" pattern="yyyy-MM-dd"/>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">发布时间</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>附件地址：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_hiringEnclosureUrl"></div>
							  <input id="hiringEnclosureUrl" name="hiringEnclosureUrl" type="text" class="form-control" value="" style="display: none" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">附件地址</label>
						  </div>


							  <div class="col-xs-3 text-center">
								  <b>选聘专业：</b>
							  </div>
							  <div class="col-xs-3">
								  <!-- 加载编辑器的容器 -->
								  <input id="hiringMajor" name="hiringMajor" type="text" class="form-control" >
								  <%--<textarea name="hiringMajor" rows="6" id="hiringMajor" class="form-control"></textarea>--%>

							  </div>
							  <%--<textarea id="hiringMajor" class="form-control" rows="6" name="hiringMajor"></textarea>--%>

						  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>选聘地点：</b>
						  </div>
						  <div class="col-xs-3" >
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
							  <input id="hiringPlace" name="hiringPlace" type="hidden" value="">
						  </div>
						  <%--<div class="col-xs-9">--%>
						  <%--<!-- 加载编辑器的容器 -->--%>
						  <%--<script id="container5" name="hiringPlace" type="text/plain" style="width: 270%">--%>

						  <%--</script>--%>
						  <%--</div>--%>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>联系人及联系电话：</b>
						  </div>
						  <div class="col-xs-6">
							  <!-- 加载编辑器的容器 -->
							  <textarea name="hiringContact" id="hiringContact"  rows="6" class="form-control"></textarea>
							  <%--<input id="hiringContact" name="hiringContact" type="text" class="form-control"  >--%>

						  </div>

					  </div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>选聘范围：</b>
					  </div>
					  <div class="col-xs-6">
						  <!-- 加载编辑器的容器 -->
						  <%--<script id="container" name="hiringRange" type="text/plain" style="width: 800px;min-height:300px;">--%>

						  <%--</script>--%>
						  <textarea name="hiringRange" rows="6" id="hiringRange" class="form-control"></textarea>

					  </div>
					  <%--<textarea id="hiringRange" class="form-control" rows="6"  name="hiringRange"></textarea>--%>
				  </div>



					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>选聘条件：</b>
			          </div>
					<div class="col-xs-6">
						<!-- 加载编辑器的容器 -->
						<textarea name="hiringCondition" rows="6" id="hiringCondition" class="form-control"></textarea>

					</div>
					<%--<textarea id="hiringCondition" class="form-control" rows="6" name="hiringCondition"></textarea>--%>
					  </div>



					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>网上报名时间及要求：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringNet" rows="6" id="hiringNet" class="form-control"></textarea>

						</div>
					</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>笔试时间及要求：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringExam" rows="6" id="hiringExam" class="form-control"></textarea>
							<%--<script id="container7" name="hiringExam" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>

					</div>

					<div class="row show-grid">
					<div class="col-xs-3 text-center">
			          	<b>资格初审内容及标准：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringStandard" rows="6" id="hiringStandard" class="form-control"></textarea>
							<%--<script id="container8" name="hiringStandard" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>
					</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>面试时间及相关事宜：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringInterview" rows="6" id="hiringInterview" class="form-control"></textarea>
							<%--<script id="container9" name="hiringInterview" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>

					</div>

					<div class="row show-grid">
					<div class="col-xs-3 text-center">
			          	<b>确定拟聘用人员时间及标准：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringPlan" rows="6" id="hiringPlan" class="form-control"></textarea>
							<%--<script id="container10" name="hiringPlan" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>
					</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>体检和心理测试：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringExperience" rows="6" id="hiringExperience" class="form-control"></textarea>
							<%--<script id="container11" name="hiringExperience" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>

					</div>

					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>资格复审：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringRetest" rows="6" id="hiringRetest" class="form-control"></textarea>
							<%--<script id="container12" name="hiringRetest" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>
					</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>办理报到手续及签订劳动合同：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringReport" rows="6" id="hiringReport" class="form-control"></textarea>
							<%--<script id="container13" name="hiringReport" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>

					</div>

					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>岗前培训：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringJobTraining" rows="6" id="hiringJobTraining" class="form-control"></textarea>
							<%--<script id="container14" name="hiringJobTraining" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>
					</div>

					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>持证上岗：</b>
			          </div>
						<div class="col-xs-6">
							<!-- 加载编辑器的容器 -->
							<textarea name="hiringCertiticates" rows="6" id="hiringCertiticates" class="form-control"></textarea>
							<%--<script id="container15" name="hiringCertiticates" type="text/plain" style="width: 800px;min-height:300px;">--%>

							<%--</script>--%>
						</div>
					</div>

					<div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>简介：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <%--<textarea name="introduce" rows="6" id="introduce" class="form-control"></textarea>--%>
							  <script id="container" name="introduce" type="text/plain" style="width: 800px;min-height:300px;"></script>
						  </div>
					  </div>
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  >--%>
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
			if($('#privence').val()==0){
				alert("请选择省份");
				tag=false
				return tag;
			}
			if($('#city').val()==0){
				alert("请选择市");
				tag=false
				return tag;
			}

			if($('#area').val()==0){
				alert("请选择县区");
				tag=false;
				return tag;
			}
			if($('#diZhi').val()=="请输入详细地址"){
				alert("详细地址不能为空");
				tag=false;
				return tag;
			}
			var a=$('#privence').val();
			var b=$('#city').val();
			var c=$('#area').val();
			var d=$('#diZhi').val();
//			if(a=="北京市"||a=="天津市"||a=="重庆市"||a=="上海市"){
//				var e=$('#schoolRealAddress').val(a+"#"+c+"#"+d+"#");
//			}else {
			var e=$('#hiringPlace').val(a+"#"+b+"#"+c+"#"+d+"#");
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
<script src = "webpage/com/buss/specialshiring/dxsSpecialsHiring.js"></script>
<script src = "webpage/com/buss/common/lanxiao.js"></script>
</html>