﻿<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css">
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <link rel="stylesheet" href="plug-in/umeditor/themes/default/css/umeditor.css" type="text/css">
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
			  $('#ContentImg').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
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
			  $('#Image').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  if($("#fenlei1").val()==1){
		  var html=" ";
		  html +=("<option value='1'>名校名企交流学习系列</option>");
		  html +=("<option value='2'>留学生活体验式系列</option>");
		  html +=("<option value='3'>领导力精英成长系列</option>");
		  html +=("<option value='4'>特色主题扩展系列</option>");
		  $('#sctiveType3').empty().append(html);
		  $('#sctiveType2').val(1)
	  }
	  if($("#fenlei1").val()==2){
		  var html=" ";
		  html +=("<option value='5'>亲子互动系列</option>");
		  $('#sctiveType3').empty().append(html);
		  $('#sctiveType2').val(2)
	  }
	  if($("#fenlei1").val()==3){
		  var html=" ";
		  $('#sctiveType3').empty().append(html);
		  $('#sctiveType2').val(3)
	  }

	  $('#sctiveType3').val($("#fenlei2").val())
	  $('#activeCountry').val($('#guojia').val())

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
  }
  </script>
</head>

 <body>

  <form id="formobj" action="dxsActivesController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsActivesPage.id}' >
			
			
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
					<select name="activeCatelogId" class="form-control" >
						<c:forEach items="${dxsactivescatelogList}" var="dxsactivescatelog">
							<option value="${dxsactivescatelog.id}"
									<c:if test="${dxsactivescatelog.id==dxsActivesPage.activeCatelogId}">selected="selected"</c:if>
							>
								<t:mutiLang langKey="${dxsactivescatelog.activeCatelogName}"/>
							</option>
						</c:forEach>
					</select>
					<span class="Validform_checktip" style="float:left;height:0px;"></span>
				</div>

								<div class="col-xs-3 text-center">
									<b>行程天数：</b>
								</div>
								<div class="col-xs-3">
									<input id="activesNum" name="activesNum" type="text" class="form-control"  value='${dxsActivesPage.activesNum}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">行程天数</label>
								</div>
								</div>
								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>缩略图：</b>
								</div>
								<div class="col-xs-3">
									<div id="_activeImage"></div>
									<input id="activeImage" name="activeImage" type="text" class="form-control" value="${dxsActivesPage.activeImage}" style="display: none">
								</div>

									<div class="col-xs-3">
										<img id="Image" src='${dxsActivesPage.activeImage}'width="70%" height="30%"/>
									</div>
									</div>
					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>内容图选：</b>
					  </div>
					  <div class="col-xs-3">
						  <div id="_activeContentImg"></div>
						  <input id="activeContentImg" name="activeContentImg" type="text" class="form-control" value="${dxsActivesPage.activeContentImg}" style="display: none">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">内容图选</label>
					  </div>
						  <div class="col-xs-3">
							  <img id="ContentImg" src='${dxsActivesPage.activeContentImg}'width="70%" height="30%"/>
						  </div>
				  </div>
									<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>活动标题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="activeTitle" name="activeTitle" type="text" class="form-control"  value='${dxsActivesPage.activeTitle}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动标题</label>
			          </div>

										<div class="col-xs-3 text-center">
											<b>出发地：</b>
										</div>
										<div class="col-xs-3">
											<input id="setOutAddress" name="setOutAddress" type="text" class="form-control" value="${dxsActivesPage.setOutAddress}" >
											<span class="Validform_checktip" style="float:left;height:0px;"></span>
											<label class="Validform_label" style="display: none">出发地</label>
										</div>
							</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>展示菜单：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="displayMenu" name="displayMenu" type="text" class="form-control"  value='${dxsActivesPage.displayMenu}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">展示菜单</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>报名人数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="regNumbers" name="regNumbers" type="text" class="form-control"  value='${dxsActivesPage.regNumbers}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">报名人数</label>
						  </div>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>活动国家：</b>--%>
						  <%--</div>--%>
						  <%--<div class="col-xs-3">--%>
							  <%--<select name="activeCountry" id="activeCountry" class="form-control" >--%>
								  <%--<option value="美国">美国</option>--%>
								  <%--<option value="英国">英国</option>--%>
								  <%--<option value="欧洲">欧洲</option>--%>
								  <%--<option value="澳洲">澳洲</option>--%>
								  <%--<option value="新西兰">新西兰</option>--%>
								  <%--<option value="加拿大">加拿大</option>--%>
								  <%--<option value="亚洲">亚洲</option>--%>
							  <%--</select>--%>
							  <%--<input id="guojia"  type="hidden" class="form-control"  value="${dxsActivesPage.activeCountry}">--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">活动国家</label>--%>
						  <%--</div>--%>

					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>主办单位：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="hostUnit" name="hostUnit" type="text" class="form-control"  value='${dxsActivesPage.hostUnit}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">主办单位</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>限报人数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="limitedNumber" name="limitedNumber" type="text" class="form-control"  value='${dxsActivesPage.limitedNumber}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">限报人数</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>精彩回顾：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="histaryDate" name="histaryDate" type="text" class="form-control"  value='${dxsActivesPage.histaryDate}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">精彩回顾</label>
						  </div>
						  <div class="col-xs-3 text-center">
							  <b>活动对象：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activeUsertypeId" name="activeUsertypeId" type="text" class="form-control"  value='${dxsActivesPage.activeUsertypeId}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动对象</label>
						  </div>
						  </div>


							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>活动开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="activeStateTime" name="activeStateTime" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value='<fmt:formatDate value='${dxsActivesPage.activeStateTime}' type="date" pattern="yyyy-MM-dd HH:mm:ss" />'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动开始时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>活动结束时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="activeEndTime" name="activeEndTime" type="text"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value='<fmt:formatDate value='${dxsActivesPage.activeEndTime}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">活动结束时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>报名截止时间：</b>
								</div>
								<div class="col-xs-3">
									<input id="deadlineDate" name="deadlineDate" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value='<fmt:formatDate value='${dxsActivesPage.deadlineDate}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/>'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">报名截止时间</label>
								</div>
								<div class="col-xs-3 text-center">
									<b>发布时间：</b>
								</div>
								<div class="col-xs-3">
									<input id="publishTime" name="publishTime" type="text"   class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value='<fmt:formatDate value='${dxsActivesPage.publishTime}' type="date" pattern="yyyy-MM-dd HH:mm:ss"/>'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">发布时间</label>
								</div>
							</div>



					  <div class="row show-grid">

						  <div class="col-xs-3 text-center">
							  <b>可使用鸿鑫币数量：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="maxAccountCount" name="maxAccountCount" type="text" class="form-control"  value='${dxsActivesPage.maxAccountCount}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">可使用鸿鑫币数量</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>编辑人：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activeEditor" name="activeEditor" type="text" class="form-control"  value='${dxsActivesPage.activeEditor}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">编辑人</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>出发时间：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="setOutTime" name="setOutTime" type="text" class="form-control"  value='${dxsActivesPage.setOutTime}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">出发时间</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>备注：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="remarks" name="remarks" type="text" class="form-control"  value='${dxsActivesPage.remarks}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">备注</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>价钱：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="activePrice" name="activePrice" type="text" class="form-control"  value='${dxsActivesPage.activePrice}'>
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
							  <b>活动分类：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="sctiveType2" name="sctiveType2" class="form-control">
								  <option value="1">学生专区</option>
								  <option value="2">亲子专区</option>
								  <option value="3">白领专区</option>
							  </select>
							  <input id="fenlei1"  type="hidden" value="${dxsActivesPage.sctiveType2}" >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动分类2</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>活动分类选项：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="sctiveType3" name="sctiveType3" class="form-control">
							  </select>
							  <input id="fenlei2"  type="hidden" class="form-control"  value="${dxsActivesPage.sctiveType3}">
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动分类3</label>
						  </div>
					  </div>



					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>活动地点：</b>
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
							  <input id="schoolRealAddress" name="activeAddress" type="hidden" class="form-control"  value='${dxsActivesPage.activeAddress}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">活动地点</label>
						  </div>

					  </div>




					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>特色简介：</b>
						</div>
						<div class="col-xs-6">
							<textarea id="activesCharacteristics" class="form-control" name="activesCharacteristics" rows="6">${dxsActivesPage.activesCharacteristics}</textarea>
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
					<script id="container" name="activeContent" type="text/plain" style="width: 800px;min-height:300px;" >
								${dxsActivesPage.activeContent}
							</script>
				</div>
							</div>
			          
			        


			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsActivesPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsActivesPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsActivesPage.isDelete}'>--%>
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
			if(jQuery("#activeStateTime").val().trim()==""){
				alert("开始时间不能为空");
				tag=false;
				return tag;
			}
			if(jQuery("#activeEndTime").val().trim()==""){
				alert("结束时间不能为空");
				tag=false;
				return tag;
			}
			if((jQuery("#deadlineDate").val().trim()=="")){
				alert("截止时间不能为空");
				tag=false;
				return tag;
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
<script src = "webpage/com/buss/actives/dxsActives.js"></script>
<script src = "webpage/com/buss/common/lanxiaoupdate.js"></script>
</html>