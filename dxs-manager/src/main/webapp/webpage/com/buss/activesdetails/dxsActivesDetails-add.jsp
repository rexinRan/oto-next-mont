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
	  $('#_activeContentImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#activeContentImg'))
			  $('#activeContentImg').val(data);
			  // $('#activeContentImg').attr("src",data);
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
	  /* 文件提交 */
	  $('#_activeImage').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#activeImage'))
			  $('#activeImage').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_img1Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#img1Url'))
			  $('#img1Url').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_img2Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#img2Url'))
			  $('#img2Url').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_img3Url').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#img3Url'))
			  $('#img3Url').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })




  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $("#sctiveType2").change(function(){
		  var html=" ";
		  if( $("#sctiveType2").val()==1){
			  html +=("<option value='1'>名校名企交流学习系列</option>");
			  html +=("<option value='2'>留学生活体验式系列</option>");
			  html +=("<option value='3'>领导力精英成长系列</option>");
			  html +=("<option value='4'>特色主题扩展系列</option>");

			  $('#sctiveType3').empty().append(html);
		  }
		  if( $("#sctiveType2").val()==2){
			  html +=("<option value='5'>亲子互动系列</option>");
			  $('#sctiveType3').empty().append(html);
		  }
		  if( $("#sctiveType2").val()==3){
			  $('#sctiveType3').empty().append(html);
		  }
	  });

	  hddd();
  }
  function hddd() {
	  $("#activeCatelogId").change(function () {
		  var html = "";
		  if ($("#activeCatelogId").val() == "4") {

			  html += ("<option value='美国'>美国</option>");
			  html += ("<option value='英国'>英国</option>");
			  html += ("<option value='欧洲'>欧洲</option>");
			  html += ("<option value='澳大利亚&新西兰'>澳大利亚&新西兰</option>");
			  html += ("<option value='加拿大'>加拿大</option>");
			  html += ("<option value='亚洲'>亚洲</option>");
		  }
		  if ($("#activeCatelogId").val() == "6") {
			  html += ("<option value='东北三省'>东北三省</option>");
			  html += ("<option value='北京/天津'>北京/天津</option>");
			  html += ("<option value='内蒙/河北/山西'>内蒙/河北/山西</option>");
			  html += ("<option value='陕西/宁夏/甘肃'>陕西/宁夏/甘肃</option>");
			  html += ("<option value='江苏/上海'>江苏/上海</option>");
			  html += ("<option value='浙江/福建'>浙江/福建</option>");
			  html += ("<option value='安徽/山东'>安徽/山东</option>");
			  html += ("<option value='四川/重庆'>四川/重庆</option>");
			  html += ("<option value='广东/海南'>广东/海南</option>");
			  html += ("<option value='湖北/江西'>湖北/江西</option>");
			  html += ("<option value='湖南/广西'>湖南/广西</option>");
			  html += ("<option value='云南/贵州'>云南/贵州</option>");
			  html += ("<option value='青海/西藏'>青海/西藏</option>");

		  }
		  $('#activeCountry').empty().append(html)
	  });
  }
  </script>
</head>

 <body>

  <form id="formobj" action="dxsActivesDetailsController.do?doAdd" name="formobj" method="post">
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
							  <b>活动分类：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="activeCatelogId" class="form-control" id="activeCatelogId">
								  <option value="0">-请选择-</option>
								  <c:forEach items="${dxsactivescatelogList}" var="dxsactivescatelog">
									  <option value="${dxsactivescatelog.id}">
										  <t:mutiLang langKey="${dxsactivescatelog.activeCatelogName}"/>
									  </option>
								  </c:forEach>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  </div>
							  <div class="col-xs-3 text-center">
								  <b>活动标题：</b>
							  </div>
							  <div class="col-xs-3">
								  <input id="activeTitle" name="activeTitle" type="text" class="form-control"  >
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">活动标题</label>
							  </div>

					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>缩略图：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_activeImage"></div>
							  <input id="activeImage" name="activeImage" type="text" class="form-control" value="" style="display: none">
						  </div>


					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>内容图选：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_activeContentImg"></div>
							  <input id="activeContentImg" name="activeContentImg" type="text" class="form-control" value="" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">内容图选</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>行程天数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activesNum" name="activesNum" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">行程天数</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>出发地：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="setOutAddress" name="setOutAddress" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">出发地</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>展示菜单：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="displayMenu" class="form-control" id="_displayMenu">
								  <option >请选择菜单类型</option>
								  <option value="当前热门游学路线" >当前热门游学路线</option>
								  <option value="档期热门路线">档期热门路线</option>
							  </select>
							  <%--<input id="displayMenu" name="displayMenu" type="text" class="form-control"  >--%>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">展示菜单</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>活动地点：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="activeCountry" id="activeCountry" class="form-control" >

							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动国家</label>
						  </div>

					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>主办单位：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="hostUnit" name="hostUnit" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">主办单位</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>限报人数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="limitedNumber" name="limitedNumber" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">限报人数</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>精彩回顾：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="histaryDate" name="histaryDate" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">精彩回顾</label>
						  </div>
						  <div class="row show-grid">
							  <div class="col-xs-3 text-center">
								  <b>活动对象：</b>
							  </div>
							  <div class="col-xs-3">
								  <input id="activeUsertypeId" name="activeUsertypeId" type="text" class="form-control"  >
								  <span class="Validform_checktip" style="float:left;height:0px;"></span>
								  <label class="Validform_label" style="display: none">活动对象</label>
							  </div>
						  </div>


					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>活动开始时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activeStateTime" name="activeStateTime" type="text"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="date" pattern="yyyy-MM-dd"/>
							  <span1 class="Validform_checktip" style="float:left;height:0px;"></span1>
							  <label class="Validform_label" style="display: none">活动开始时间</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>活动结束时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activeEndTime" name="activeEndTime" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="date" pattern="yyyy-MM-dd"/>
							  <span2 class="Validform_checktip" style="float:left;height:0px;"></span2>
							  <label class="Validform_label" style="display: none">活动结束时间</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>报名截止时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="deadlineDate" name="deadlineDate" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="date" pattern="yyyy-MM-dd"/>
							  <span3 class="Validform_checktip" style="float:left;height:0px;"></span3>
							  <label class="Validform_label" style="display: none">报名截止时间</label>
						  </div>
						  <div class="col-xs-3 text-center">
							  <b>发布时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="publishTime" name="publishTime" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="date" pattern="yyyy-MM-dd"/>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">发布时间</label>
						  </div>
					  </div>
					  <div class="row show-grid">

						  <div class="col-xs-3 text-center">
							  <b>可使用鸿鑫币数量：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="maxAccountCount" name="maxAccountCount" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">可使用鸿鑫币数量</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>编辑人：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activeEditor" name="activeEditor" type="text" class="form-control" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">编辑人</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>价钱：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activePrice" name="activePrice" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">价钱</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>是否收费：</b>
						  </div>
						  <div class="col-xs-3">
							  <input  name="isCharge" type="radio" value="0" >是
							  <input  name="isCharge" type="radio"  value="1" >否
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">是否收费</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>出发时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="setOutTime" name="setOutTime" class="form-control" type="text" value="请输入2016-05这样的时间格式" onfocus="if (value =='请输入2016-05这样的时间格式'){value =''}" onblur="if (value ==''){value='请输入2016-05这样的时间格式'}"/>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">出发时间</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>备注：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="remarks" name="remarks" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">备注</label>
						  </div>
					  </div>



					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>费用包含：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="costInclude" class="form-control" rows="6" name="costInclude"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">费用包含</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>费用不包含：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="costUninclude" class="form-control" rows="6" name="costUninclude"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">费用不包含</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>签证方式：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="visaNote" class="form-control" rows="6" name="visaNote"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">签证方式</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>行前准备：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="preparation" class="form-control" rows="6" name="preparation"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">行前准备</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>付款方式：</b>
						  </div>
						  <div class="col-xs-3">
							  <input type="radio" name="paymentMethod"  value="1">支付宝
							  <input type="radio" name="paymentMethod"  value="2">微信
							  <%--<input id="paymentMethod" name="paymentMethod" type="text" class="form-control"  >--%>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">付款方式</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>常见问题(待定)：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="commonProblem" name="commonProblem" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">常见问题(待定)</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>活动分类：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="sctiveType2" name="sctiveType2" class="form-control">
								  <option value="0">-请选择-</option>
								  <option value="1">学生专区</option>
								  <option value="2">亲子专区</option>
								  <option value="3">白领专区</option>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动分类2</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>报名人数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="regNumbers" name="regNumbers" type="text" class="form-control" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">报名人数</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>活动分类选项：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="sctiveType3" name="sctiveType3" class="form-control">
								  <option value="">-请选择-</option>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动分类3</label>
						  </div>
					  </div>



					  <%--<div class="row show-grid">--%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>活动地点：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<select  id="privence" class="form-control" >--%>
								  <%--<option value="0">-请选择-</option>--%>

							  <%--</select>--%>
							  <%--<select  id="city" class="form-control" >--%>
								  <%--<option value="0">-请选择-</option>--%>

							  <%--</select>--%>
							  <%--<select id="area" class="form-control" >--%>
								  <%--<option value="0">-请选择-</option>--%>

							  <%--</select>--%>
							  <%--<input id="diZhi" class="form-control" type="text" value="请输入详细地址" onfocus="if (value =='请输入详细地址'){value =''}" onblur="if (value ==''){value='请输入详细地址'}"/>--%>
							  <%--<input id="activeAddress" name="activeAddress" type="hidden" class="form-control"  >--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">活动地点</label>--%>
						  <%--</div>--%>

					  <%--</div>--%>

					  <div class="row show-grid">
						  <%--<div class="col-xs-3 text-center">--%>
						  <%--<b>图片1id：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
						  <%--<input id="img1Fid" name="img1Fid" type="text" class="form-control"  >--%>
						  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						  <%--<label class="Validform_label" style="display: none">图片1id</label>--%>
						  <%--</div>--%>


						  <div class="col-xs-3 text-center">
							  <b>图片1地址：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_img1Url"></div>
							  <input id="img1Url" name="img1Url" type="text" class="form-control" value="" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">图片1地址</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <%--<div class="col-xs-3 text-center">--%>
						  <%--<b>图片2id：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
						  <%--<input id="img2Fid" name="img2Fid" type="text" class="form-control"  >--%>
						  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						  <%--<label class="Validform_label" style="display: none">图片2id</label>--%>
						  <%--</div>--%>


						  <div class="col-xs-3 text-center">
							  <b>图片2地址：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_img2Url"></div>
							  <input id="img2Url" name="img2Url" type="text" class="form-control" value="" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">图片2地址</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <%--<div class="col-xs-3 text-center">--%>
						  <%--<b>图片3id：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
						  <%--<input id="img3Fid" name="img3Fid" type="text" class="form-control"  >--%>
						  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						  <%--<label class="Validform_label" style="display: none">图片3id</label>--%>
						  <%--</div>--%>


						  <div class="col-xs-3 text-center">
							  <b>图片3地址：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_img3Url"></div>
							  <input id="img3Url" name="img3Url" type="text" class="form-control" value="" style="display: none">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">图片3地址</label>
						  </div>
					  </div>



					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>出发日期和团信息：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="activesStart2" class="form-control" rows="6" name="activesStart2"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">出发日期和团信息</label>
						  </div>
						  </div>

					  <div class="row show-grid">
						  <%--<div class="col-xs-3 text-center">--%>
						  <%--<b>活动id：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
						  <%--<input id="activesId" name="activesId" type="text" class="form-control"  >--%>
						  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						  <%--<label class="Validform_label" style="display: none">活动id</label>--%>
						  <%--</div>--%>


						  <div class="col-xs-3 text-center">
							  <b>推荐理由：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="recommendedReason" class="form-control" name="recommendedReason" rows="6"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">推荐理由</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>特色简介：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="activesCharacteristics" class="form-control" name="activesCharacteristics" rows="6"></textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">特色简介</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>具体活动内容：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="container" name="activeContent" type="text/plain"  style="width: 800px;min-height:300px;">

							  </script>
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
			var shijian=$('#setOutTime').val();

			if(!/^(\d{4})-(\d{2})$/.test(shijian)){
				alert("请输入正确出发时间格式")
				tag=false;
			}
				if(jQuery("#activeStateTime").val().trim()==""){
					alert("开始时间不能为空");
					tag=flag;
				}
				if(jQuery("#activeEndTime").val().trim()==""){
					alert("结束时间不能为空");
					tag=flag;
				}
				if((jQuery("#deadlineDate").val().trim()=="")){
					alert("截止时间不能为空");
					tag=flag;
				}


			if($('#activePrice').val()==""){
				$('#activePrice').val(0)
			}
			if($('#activeCatelogId').val()=="6"){
				if($('#_displayMenu').val()=="当前热门游学路线"){
					$('#activeCountry').val("东北三省")
				}
			}



//			if($('#privence').val()==0){
//				alert("请选择省份");
//				tag=false
//				return tag;
//			}
//			if($('#city').val()==0){
//				alert("请选择市");
//				tag=false
//				return tag;
//			}
//
//			if($('#area').val()==0){
//				alert("请选择县区");
//				tag=false;
//				return tag;
//			}
//			if($('#diZhi').val()=="请输入详细地址"){
//				alert("详细地址不能为空");
//				tag=false;
//				return tag;
//			}
//			var a=$('#privence').val();
//			var b=$('#city').val();
//			var c=$('#area').val();
//			var d=$('#diZhi').val();
//			if(a=="北京市"||a=="天津市"||a=="重庆市"||a=="上海市"){
//				var e=$('#schoolRealAddress').val(a+"#"+c+"#"+d+"#");
//			}else {
//			var e=$('#activeAddress').val(a+"#"+b+"#"+c+"#"+d+"#");
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
<script src = "webpage/com/buss/activesdetails/dxsActivesDetails.js"></script>
<%--<script src = "webpage/com/buss/common/lanxiao.js"></script>--%>
</html>