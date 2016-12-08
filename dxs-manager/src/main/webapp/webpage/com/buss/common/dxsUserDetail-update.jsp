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
//	  window.UMEDITOR_HOME_URL = "/com/buss/images/";
	  window.um = UM.getEditor('container', {
		  /* 传入配置参数,可配参数列表看umeditor.config.js */
		  /* toolbar: ['undo redo | bold italic underline']*/
//		  imageUrl: "E:/upload/",
//		  imageUrl:"jsp/imageUp.jsp",
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
	  $('#_headImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#headImg'))
			  $('#headImg').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_certificateId').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '文件图片',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#certificateId'))
			  $('#certificateId').val(data);
			  $('#Image').attr("src",data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_identify1Id').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  $('#identify1Id').val(data);
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_identify2Id').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  $('#identify2Id').val(data);
		  }
	  });
  })
  </script>
</head>

 <body>

  <form id="formobj" action="dxsUserDetailController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsUserDetailPage.id}' >
	  <input id="userid" name="userid" type="hidden" class="form-control"  value='${dxsUserDetailPage.userid}'>
	  <%--<input id="realname" name="realname" type="hidden" class="form-control"  value='${dxsUserDetailPage.name}'>--%>
	  <%--<input id="rolecode" name="rolecode" type="hidden" class="form-control"  value='${dxsUserPage.rolecode}'>--%>
	  <%--<input id="mphone" name="mphone" type="hidden" class="form-control"  value=' ${dxsUserDetailPage.phone}'>--%>
	  <%--<input id="email" name="email" type="hidden" class="form-control"  value='${dxsUserPage.email}'>--%>

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
			          	<b>真实姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="name" name="name" type="text" class="form-control"  value='${dxsUserDetailPage.name}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">真实姓名</label>
			          </div>

			          
			        



			          <div class="col-xs-3 text-center">
			          	<b>性别：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sex" name="sex" type="text" class="form-control"  value='${dxsUserDetailPage.sex}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">性别</label>
			          </div>

			          
			        

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>身高(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="bodyHight" name="bodyHight" type="text" class="form-control"  value='${dxsUserDetailPage.bodyHight}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">身高(预留)</label>--%>
			          <%--</div>--%>
									</div>
										<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>体重(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="bodyWeight" name="bodyWeight" type="text" class="form-control"  value='${dxsUserDetailPage.bodyWeight}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">体重(预留)</label>--%>
			          <%--</div>--%>

			          
			        

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>出生日期(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="borthday" name="borthday" type="text" class="form-control"  value='${dxsUserDetailPage.borthday}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">出生日期(预留)</label>--%>
			          <%--</div>--%>
			          <%--</div>--%>
									<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>户籍所在地(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="residence" name="residence" type="text" class="form-control"  value='${dxsUserDetailPage.residence}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">户籍所在地(预留)</label>--%>
			          <%--</div>--%>

			          
			        

			          <div class="col-xs-3 text-center">
			          	<b>手机号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="phone" name="phone" type="text" class="form-control"  value='${dxsUserDetailPage.phone}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">手机号</label>
			          </div>
                <%--</div>--%>
										<%--<div class="row show-grid">--%>
			          <div class="col-xs-3 text-center">
			          	<b>邮箱：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="email" name="email" type="text" class="form-control"  value='${dxsUserDetailPage.email}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">邮箱</label>
			          </div>
                   </div>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>民族(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="preNative" name="preNative" type="text" class="form-control"  value='${dxsUserDetailPage.preNative}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">民族(预留)</label>--%>
			          <%--</div>--%>
			          <%--</div>--%>

                        <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>身份证号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="idcard" name="idcard" type="text" class="form-control"  value='${dxsUserDetailPage.idcard}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">身份证号</label>
			          </div>

			          
			        

			          <div class="col-xs-3 text-center">
			          	<b>QQ：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="qq" name="qq" type="text" class="form-control"  value='${dxsUserDetailPage.qq}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">QQ</label>
			          </div>
			          </div>
									<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>MSN(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="msn" name="msn" type="text" class="form-control"  value='${dxsUserDetailPage.msn}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">MSN(预留)</label>--%>
			          <%--</div>--%>

			          

			          <div class="col-xs-3 text-center">
			          	<b>学校名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolName" name="schoolName" type="text" class="form-control"  value='${dxsUserDetailPage.schoolName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学校名称</label>
			          </div>
			          <%--</div>--%>

									<%--<div class="row show-grid">--%>
			          <div class="col-xs-3 text-center">
			          	<b>学校所在地：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolAddress" name="schoolAddress" type="text" class="form-control"  value='${dxsUserDetailPage.schoolAddress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学校所在地</label>
			          </div>

			          </div>
			        

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>入学时间(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="schoolAdmission" name="schoolAdmission" type="text" class="form-control"  value='${dxsUserDetailPage.schoolAdmission}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">入学时间(预留)</label>--%>
			          <%--</div>--%>
			          <%--</div>--%>
									<div class="row show-grid">
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>毕业时间(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="schoolGraduation" name="schoolGraduation" type="text" class="form-control"  value='${dxsUserDetailPage.schoolGraduation}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">毕业时间(预留)</label>--%>
			          <%--</div>--%>

			          
			        

			          <div class="col-xs-3 text-center">
			          	<b>年级：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolGrade" name="schoolGrade" type="text" class="form-control"  value='${dxsUserDetailPage.schoolGrade}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">年级</label>
			          </div>
			          <%--</div>--%>
									<%--<div class="row show-grid">--%>
			          <div class="col-xs-3 text-center">
			          	<b>专业：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolMajor" name="schoolMajor" type="text" class="form-control"  value='${dxsUserDetailPage.schoolMajor}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">专业</label>
			          </div>
                    </div>
									<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>学历：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="schoolEducation" name="schoolEducation" type="text" class="form-control"  value='${dxsUserDetailPage.schoolEducation}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">学历</label>
			          </div>

			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>证书(预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="schoolCertificate" name="schoolCertificate" type="text" class="form-control"  value='${dxsUserDetailPage.schoolCertificate}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">证书(预留)</label>--%>
			          <%--</div>--%>

			          <div class="col-xs-3 text-center">
			          	<b>个人爱好：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="hobby" name="hobby" type="text" class="form-control"  value='${dxsUserDetailPage.hobby}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">个人爱好</label>
			          </div>
								</div>

									<div class="row show-grid">
										<div class="col-xs-3 text-center">
											<b>任职院校：</b>
										</div>
										<div class="col-xs-3">
											<input id="jobSchool" name="jobSchool" type="text" class="form-control"  value='${dxsUserDetailPage.jobSchool}'>
											<span class="Validform_checktip" style="float:left;height:0px;"></span>
											<label class="Validform_label" style="display: none">任职院校</label>
										</div>


										<div class="col-xs-3 text-center">
											<b>任职职位：</b>
										</div>
										<div class="col-xs-3">
											<input id="jobSchoolPosition" name="jobSchoolPosition" type="text" class="form-control"  value='${dxsUserDetailPage.jobSchoolPosition}'>
											<span class="Validform_checktip" style="float:left;height:0px;"></span>
											<label class="Validform_label" style="display: none">任职职位</label>
										</div>
									</div>

									<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>头像：</b>
									</div>
									<%--<div class="col-xs-3">--%>
										<%--<div id="_headImg"></div>--%>
										<%--<input id="headImg" name="headImg" type="text" class="form-control" value="${dxsUserDetailPage.headImg}" style="display: none">--%>
										<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
										<%--<label class="Validform_label" style="display: none">头像(预留)</label>--%>
									<%--</div>--%>
										<div  id="divCenter3" align="center" style="position: absolute; display: none;z-index: 9;
										background-color: #eee; width:700px; height:500px;left:200px;top:200px; border:1px solid #222;">
											<img src="${dxsUserDetailPage.headImg}" width="100%" height="100%"/><a href="javascript:void(0);" onclick="picClose3();">关闭</a>
										</div>
										<div class="col-xs-3 ">
											<a href="javascript:void(0);" onclick="picBig3();"><img  src='${dxsUserDetailPage.headImg}'width="70%" height="30%"/></a>
										</div>
				                        </div>
									<div class="row show-grid">
										<div class="col-xs-3 text-center">
											<b>证件：</b>
										</div>
										<%--<div class="col-xs-3">--%>
											<%--<div id="_certificateId"></div>--%>
											<%--<input id="certificateId" name="certificateUrl" type="text" class="form-control"  value="${dxsAuthenticationPage.certificateUrl}"style="display: none">--%>
										<%--</div>--%>
										<div  id="divCenter" align="center" style="position: absolute; display: none;z-index: 9;
										background-color: #eee; width:700px; height:500px;left:200px;top:200px; border:1px solid #222;">
											<img src="${dxsAuthenticationPage.certificateUrl}" width="100%" height="100%"/><a href="javascript:void(0);" onclick="picClose();">关闭</a>
										</div>
										<div class="col-xs-3 ">
											学生证/教师证 ：
									        <a href="javascript:void(0);" onclick="picBig();"><img  src='${dxsAuthenticationPage.certificateUrl}'width="70%" height="30%"/></a>
										</div>
									<%--</div>--%>

									<%--<div class="row show-grid">--%>
										<%--<div class="col-xs-3 text-center">--%>
											<%--<b>身份证正面：</b>--%>
										<%--</div>--%>

										<%--<div class="col-xs-3">--%>
											<%--<div id="_identify1Id"></div>--%>
											<%--<input id="identify1Id" name="identify1Url" type="text" class="form-control"  value="${dxsAuthenticationPage.identify1Url}" style="display: none">--%>
											<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
											<%--<label class="Validform_label" style="display: none">身份证正面</label>--%>
										<%--</div>--%>
										<div  id="divCenter1" align="center" style="position: absolute; display: none;z-index: 9;
										background-color: #eee; width:700px; height:500px;left:200px;top:200px; border:1px solid #222;">
											<img src="${dxsAuthenticationPage.identify1Url}" width="100%" height="100%"/><a href="javascript:void(0);" onclick="picClose1();">关闭</a>
										</div>
										<div class="col-xs-3">
											身份证正面：
											<a href="javascript:void(0);" onclick="picBig1();"><img  src='${dxsAuthenticationPage.identify1Url}'width="70%" height="30%"/></a>
										</div>
									<%--</div>--%>


									<%--<div class="row show-grid">--%>
										<%--<div class="col-xs-3 text-center">--%>
											<%--<b>身份证反面：</b>--%>
										<%--</div>--%>

										<%--<div class="col-xs-3">--%>
											<%--<div id="_identify2Id"></div>--%>
											<%--<input id="identify2Id" name="identify2Url" type="text" class="form-control"  value="${dxsAuthenticationPage.identify2Url}" style="display: none">--%>
											<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
											<%--<label class="Validform_label" style="display: none">身份证正面</label>--%>
										<%--</div>--%>

										<div  id="divCenter2" align="center" style="position: absolute; display: none;z-index: 9;
										background-color: #eee; width:700px; height:500px;left:200px;top:200px; border:1px solid #222;">
											<img src="${dxsAuthenticationPage.identify2Url}" width="100%" height="100%"/>
											<a href="javascript:void(0);" onclick="picClose2();">关闭</a>
										</div>
										<div class="col-xs-3">

											身份证反面：
											<a href="javascript:void(0);" onclick="picBig2();"><img  src='${dxsAuthenticationPage.identify2Url}'width="70%" height="30%"/></a>
										</div>
									</div>
									<div class="row show-grid">
										<div class="col-xs-3 text-center">
											<b>专业履历：</b>
										</div>
										<div class="col-xs-9" style="z-index: 0">
											<!-- 加载编辑器的容器 -->
											<script id="container" name="jobSchoolResume" type="text/plain"  style="width: 800px;min-height:300px;">${dxsUserDetailPage.jobSchoolResume}</script>
										</div>
									</div>


								<%--<div class="row show-grid">--%>
									<%--<div class="col-xs-3 text-center">--%>
										<%--<b>用户加入时间：</b>--%>
									<%--</div>--%>
									<%--<div class="col-xs-3">--%>
										<%--<input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
										<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
										<%--<label class="Validform_label" style="display: none">用户加入时间</label>--%>
									<%--</div>--%>
			          
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>备注：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="remarks" name="remarks" type="text" class="form-control"  value='${dxsUserDetailPage.remarks}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">备注</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserDetailPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsUserDetailPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsUserDetailPage.isDelete}'>--%>
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
	function picBig() {
		var v = document.getElementById('divCenter');
		v.style.display = "block";
		$(v).draggable();

	}

	function picClose() {
		var v = document.getElementById('divCenter');
		v.style.display = "none";
	}
	function picBig1() {
		var v = document.getElementById('divCenter1');
		v.style.display = "block";
		$(v).draggable();

	}

	function picClose1() {
		var v = document.getElementById('divCenter1');
		v.style.display = "none";
	}
	function picBig2() {
		var v = document.getElementById('divCenter2');
		v.style.display = "block";
		$(v).draggable();

	}
	function picClose2() {
		var v = document.getElementById('divCenter2');
		v.style.display = "none";
	}

	function picBig3() {
		var v = document.getElementById('divCenter3');
		v.style.display = "block";
		$(v).draggable();

	}
	function picClose3() {
		var v = document.getElementById('divCenter3');
		v.style.display = "none";
	}

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
<script src = "webpage/com/buss/userdetail/dxsUserDetail.js"></script>		
</html>