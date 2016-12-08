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
	  window.um = UM.getEditor('container3', {
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
	  window.um = UM.getEditor('container4', {
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
	  window.um = UM.getEditor('container5', {
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
	  window.um = UM.getEditor('container6', {
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
	  window.um = UM.getEditor('container7', {
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
		  'buttonText' : '上传项目配图',
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

   </script>
</head>

 <body>

  <form id="formobj" action="dxsTrainOutlineCourseController.do?doAdd" name="formobj" method="post">
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
			          	<b>线下培训分类：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="tccId" class="form-control" >
							  <c:forEach items="${dxsTrainCourseCatalogList}" var="dxsTrainCourseCatalog">
								  <option value="${dxsTrainCourseCatalog.id}">
									  <t:mutiLang langKey="${dxsTrainCourseCatalog.catalogName}"/>
								  </option>
							  </c:forEach>
						  </select>
								<%--<input id="tccId" name="tccId" type="text" class="form-control"  >--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">分类id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>显示分类：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="catalogDisplayNum" name="catalogDisplayNum" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">显示分类</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>导师分类：</b>
								</div>
								<div class="col-xs-3">
									<select id="daoshifenlei" class="form-control">
										<option value="0">-请选择-</option>
										<option value="8">创业导师</option>
										<option value="11">就业导师</option>
										<option value="14">创客导师</option>
										<option value="17">学习导师</option>
										<option value="20">技能培训导师</option>
									</select>
								</div>

			          <div class="col-xs-3 text-center">
			          	<b>导师：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control" id="userId">
							  <%--<c:forEach items="${dxsUserList}" var="dxsUser">--%>
								  <%--<option value="${dxsUser.id}">--%>
									  <%--<t:mutiLang langKey="${dxsUser.realname}"/>--%>
								  <%--</option>--%>
							  <%--</c:forEach>--%>
						  </select>
						  <%--<input id="userId" name="userId" type="text" class="form-control"  >--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">导师id</label>
			          </div>

							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>总学习数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="courseMinutesAll" name="courseMinutesAll" type="text" class="form-control"  datatype="n" errormsg="请输入数字类型" >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">总学习数</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>招生人数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="number" name="number" type="text" class="form-control"  datatype="n" errormsg="请输入数字类型" >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">招生人数</label>
			          </div>
							</div>
			          

							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>课程价格：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="coursePrices" name="coursePrices" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">课程价格</label>--%>
			          <%--</div>--%>

						  <div class="col-xs-3 text-center">
							  <b>城市：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="address" name="address" type="text" class="form-control" >
								  <option value="北京">北京</option>
								  <option value="石家庄">石家庄</option>
								  <option value="兰州">兰州</option>
								  <option value="成都">成都</option>
								  <option value="南京">南京</option>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">具体地点</label>
						  </div>

								<div class="col-xs-3 text-center">
									<b>适用学员：</b>
								</div>
								<div class="col-xs-3">
									<input id="courseObj" name="courseObj" type="text" class="form-control"  >
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">适用学员</label>
								</div>
							</div>


			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>培训课题：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="title" name="title" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">培训课题</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>外部标记：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="outSign" name="outSign" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">外部标记</label>
			          </div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>

			          
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>授课方式：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="courseType" name="courseType" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">授课方式</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          
			        
							<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>培训方式：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="trainType" name="trainType" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">培训方式</label>--%>
			          <%--</div>--%>
						  <div class="col-xs-3 text-center">
							  <b>班号：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="classNum" name="classNum" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">班号</label>
						  </div>
			        
			          <div class="col-xs-3 text-center">
			          	<b>学费：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="price" name="price" type="text" class="form-control"  datatype="n" errormsg="请输入数字类型" >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学费</label>
			          </div>
							</div>
			          

			        
							<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>开班时间：</b>
								</div>
								<div class="col-xs-3">
									<input id="openingTime" name="openingTime" type="text" class="form-control"  >
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">openingTime</label>
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

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>备注：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="remarks" name="remarks" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">备注</label>
						  </div>
						  <div class="col-xs-3 text-center">
							  <b>赠送鸿鑫币数量：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="account" name="account" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">赠送鸿鑫币数量</label>
						  </div>

					  </div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>总课时数：</b>
					  </div>
					  <div class="col-xs-3">
						  <input id="courseNumAll" name="courseNumAll" type="text" class="form-control"   datatype="n" errormsg="请输入数字类型">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">总课时数</label>
					  </div>
						  </div>

					  <%--<div class="row show-grid">--%>
						  <%--<div class="col-xs-3 text-center">--%>
							  <%--<b>具体地点：</b>--%>
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
							  <%--<input id="addressShort" name="addressShort" type="hidden" class="form-control"  >--%>
							  <%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
							  <%--<label class="Validform_label" style="display: none">地点简称</label>--%>
						  <%--</div>--%>
					  <%--</div>--%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>缩略图：</b>
						  </div>
						  <div class="col-xs-3">
							  <div id="_imgUrl"></div>
							  <input id="imgUrl" name="imgUrl" type="text" class="form-control" value="" style="display: none" align="center">
							  <%--<input id="imgUrl" name="imgUrl" type="text" class="form-control"  >--%>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">缩略图</label>
						  </div>
					  </div>


					  <div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>教学目标：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container4" name="trainObj" type="text/plain"  style="width: 800px;min-height:300px;"></script>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">教学目标</label>
									</div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>授课内容：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container5" name="trainContent" type="text/plain"  style="width: 800px;min-height:300px;"></script>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">授课内容</label>
									</div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>课程特色：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container6" name="courseSpecial" type="text/plain"  style="width: 800px;min-height:300px;"></script>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">课程特色</label>
									</div>
								</div>


								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>开班规律：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container7" name="startClassRule" type="text/plain"  style="width: 800px;min-height:300px;"></script>
										<span class="Validform_checktip" style="float:left;height:0px;"></span>
										<label class="Validform_label" style="display: none">开班规律</label>
									</div>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>课程介绍：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container" name="courseIntroduce" type="text/plain"  style="width: 800px;min-height:300px;"></script>
									</div>
									<%--<div class="col-xs-3">--%>
										<%--<textarea id="courseIntroduce" class="form-control" rows="6" name="courseIntroduce"></textarea>--%>
										<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
										<%--<label class="Validform_label" style="display: none">课程介绍</label>--%>
									<%--</div>--%>
								</div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>课程体系：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container2" name="courseDir" type="text/plain"  style="width: 800px;min-height:300px;"></script>
									</div>
									<%--<div class="col-xs-3">--%>
										<%--<textarea id="courseDir" class="form-control" rows="6" name="courseDir"></textarea>--%>
										<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
										<%--<label class="Validform_label" style="display: none">课程体系</label>--%>
									<%--</div>--%>
								</div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>其他：</b>
					  </div>
					  <div class="col-xs-9">
						  <script id="container3" name="others" type="text/plain"  style="width: 800px;min-height:300px;"></script>
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">其他</label>
					  </div>
						  </div>

							<%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">更新时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
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
	$("#daoshifenlei").change(function() {
		$.ajax({
			type: "POST",
			url: "dxsTrainOnlineCourseController.do?fenLeiFind",
			data: "type=" + $('#daoshifenlei').val(),
			async: false,
			dataType: "json",
			success: function (data) {
				var html="";
				for (var i=0; i<data.length; i++) {
					html +=("<option value='"+data[i].id+"'>"+ data[i].realname +"</option>");

				}

				$('#userId').empty().append(html)
				//var json = eval('(' + data + ')');

			}
		});
	})

$(function() {
    $("#formobj").Validform({
        tiptype: 1,
        btnSubmit: "#btn_sub",
        btnReset: "#btn_reset",
        ajaxPost: true,
		beforeSubmit: function(curform) {
            var tag = true;
			//提交前处理
			if($('#price').val()==""){
				$('#price').val(0)
			}

			if($('#activePrice').val()==""){
				$('#activePrice').val(0)
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
//				$('#diZhi').val("")
//			}
//			var a=$('#privence').val();
//			var b=$('#city').val();
//			var c=$('#area').val();
//			var d=$('#diZhi').val();
//			var e=$('#addressShort').val(a+"#"+b+"#"+c+"#"+d+"#");
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
<script src = "webpage/com/buss/trainoutlinecourse/dxsTrainOutlineCourse.js"></script>
<script src = "webpage/com/buss/common/lanxiao.js"></script>
</html>