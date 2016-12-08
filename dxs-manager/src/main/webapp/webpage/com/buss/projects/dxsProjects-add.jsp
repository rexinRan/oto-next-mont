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
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  $.ajax({
		  url: "http://csee-china.com/dxs-server/industryController/industry.do?parentNo=0",
		  crossDomain: true,
		  dataType: 'jsonp',
		  jsonp: 'callback',
		  jsonpCallback: 'data',
		  success: function (data, textStatus) {
			  console.info(1);
			  console.info(data.data);
			  var html = "";
			  html+=("<option value='0'>-请选择-</option>");
			  for (var i = 0; i < data.data.length; i++) {
				  html += ("<option id='" + (data.data)[i].industryNo + "'>" + (data.data)[i].industryName + "</option>");
				//  alert((data.data)[i].industryName)
			  }

			  $("#projectIndustry").append(html);

			  geetcity();

		  },
		  error: function () {

		  }


	  });
	  function geetcity() {
		  $("#projectIndustry").change(function(){
			  var pid = $("#projectIndustry option:selected").attr("id");
			  $.ajax({
				  url: "http://csee-china.com/dxs-server/industryController/industry.do?parentNo=" + pid,
				  crossDomain: true,
				  dataType: 'jsonp',
				  jsonp : 'callback',
				  jsonpCallback: 'data',
				  success: function(data, textStatus){
					  console.info(data);
					  var html ="";
					  //	  html+= ("<option value='0'>-请选择-</option>");
					  for (var i=0; i<data.data.length; i++) {
						  html +=("<option id='"+(data.data)[i].industryNo+"'>"+ (data.data)[i].industryName +"</option>");

					  }
					  $("#projectType").empty().append(html);

				  },
				  error: function(){

				  }


			  });
		  });
	  }

  }

  $(function(){
	  /* 文件提交 */
	  $('#_projectImg').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#projectImg'))
			  $('#projectImg').val(data);
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
		  }
	  });
  })
  $(function(){
	  /* 文件提交 */
	  $('#_projectPlanFileurl').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do',
		  'buttonText' : '上传文件',
		  'width' : 100,
		  'height' :30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#projectPlanFileurl'))
			  $('#projectPlanFileurl').val(data);
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
  </script>
</head>

 <body>

  <form id="formobj" action="dxsProjectsController.do?doAdd" name="formobj" method="post">
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
			          	<b>用户名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control" >
							  <c:forEach items="${dxsUserList}" var="dxsUser">
								  <option value="${dxsUser.id}">
									  <t:mutiLang langKey="${dxsUser.realname}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户的id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>大赛名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="bcId" class="form-control" >
							  <c:forEach items="${dxsCompetitionList}" var="dxsCompetition">
								  <option value="${dxsCompetition.id}">
									  <t:mutiLang langKey="${dxsCompetition.competitionTitle}"/>
								  </option>
							  </c:forEach>
						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">竞赛ID</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">

								<div class="col-xs-3 text-center">
									<b>是否与高校科技结合：</b>
								</div>
								<div class="col-xs-3">
									<input type="radio" name="isSchoolTechnology" value="是">是
									<input type="radio" name="isSchoolTechnology" value="否">否
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">是否与高校科技结合</label>
								</div>

			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="projectName" name="projectName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>所属行业：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="projectIndustry" class="form-control">

						  </select>
						  <input id="_projectIndustry" name="projectIndustry" type="hidden" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属行业</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>所属类别：</b>
			          </div>
			          <div class="col-xs-3">
						  <select id="projectType"  class="form-control">

						  </select>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">所属类别</label>
			          </div>
							</div>
			          

			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>团队名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="teamName" name="teamName" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">团队名称</label>
			          </div>


								<div class="col-xs-3 text-center">
									<b>修改次数：</b>
								</div>
								<div class="col-xs-3">
									<input id="updateCount" name="updateCount" type="text" class="form-control"  >
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">修改次数</label>
								</div>
								</div>


			          
			        
							<div class="row show-grid">

			          <div class="col-xs-3 text-center">
			          	<b>项目计划书：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_projectPlanFileurl"></div>
						  <input id="projectPlanFileurl" name="projectPlanFileurl" type="text" class="form-control" value="" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目计划书</label>
			          </div>

			          <div class="col-xs-3 text-center">
			          	<b>成员人数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="userNum" name="userNum" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">成员人数</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>是否结束：</b>
			          </div>
			          <div class="col-xs-3">
						  <input type="radio" name="isEnd" value="0">否
						  <input type="radio" name="isEnd" value="1">是
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">是否结束</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>基金需求：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="foundNeed" name="foundNeed" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">基金需求</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>基地需求：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="addressNeed" name="addressNeed" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">基地需求</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>招聘需求：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="recruitNeed" name="recruitNeed" type="text" class="form-control"  >
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">招聘需求</label>
			          </div>
							</div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>是否已获投资：</b>
						  </div>
						  <div class="col-xs-3">
							  <input type="radio" name="isFound" value="0">是
							  <input type="radio" name="isFound" value="1">否
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">是否已获投资</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>是否已获基地：</b>
						  </div>
						  <div class="col-xs-3">
							  <input type="radio" name="isAddress" value="0">是
							  <input type="radio" name="isAddress" value="1">否
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">是否已获基地</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>晋级级别：</b>
						  </div>
						  <div class="col-xs-3">
							  <select id="projectClass" name="projectClass" class="form-control">
								  <option value="国家级">国家级</option>
								  <option value="大区级">大区级</option>
								  <option value="省级">省级</option>
								  <option value="市级">市级</option>
								  <option value="校级">校级</option>
							  </select>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">晋级级别</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>创建年：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="createYear" name="createYear" type="text" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">创建年</label>
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
				  </div>
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>参赛类型(给推荐预留)：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="joinType" name="joinType" type="text" class="form-control"  >--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">参赛类型(给推荐预留)</label>--%>
			          <%--</div>--%>
			          
			        
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="form-control" onClick="WdatePicker()"  type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
							<%--</div>--%>
					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>项目进展：</b>
					  </div>
					  <div class="col-xs-6">
						  <input type="radio" name="projectProgress" value="创意计划阶段">创意计划阶段
						  <input type="radio" name="projectProgress" value="已注册公司运营">已注册公司运营
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">项目进展</label>
					  </div>
						  </div>
			          
			        
							<div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>股权结构：</b>
					  </div>
					  <div class="col-xs-9">
						  <input type="radio" name="isStock" value="学校或代表学校的组织机构持有部分股权">学校或代表学校的组织机构持有部分股权
						  <input type="radio" name="isStock" value="老师持有部分股权">老师持有部分股权
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">股权结构</label>
					  </div>
								</div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>隐私设置：</b>
					  </div>
					  <div class="col-xs-6">
						  <input type="radio" name="isPrivacy" value="保密">保密
						  <input type="radio" name="isPrivacy" value="可以向投资人公开">可以向投资人公开
						  <input type="radio" name="isPrivacy" value="可以向所有人公开">可以向所有人公开
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">隐私设置</label>
					  </div>
						  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>项目所在地：</b>
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
							  <input id="projectAddress" name="projectAddress" type="hidden" class="form-control"  >
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">项目所在地</label>
						  </div>
						  </div>

					  <div class="row show-grid">
					  <div class="col-xs-3 text-center">
						  <b>项目标识图片：</b>
					  </div>
					  <div class="col-xs-3">
						  <div id="_projectImg"></div>
						  <input id="projectImg" name="projectImg" type="text" class="form-control" value="" style="display: none">
						  <span class="Validform_checktip" style="float:left;height:0px;"></span>
						  <label class="Validform_label" style="display: none">项目标识</label>
					  </div>
						  </div>

								<div class="row show-grid">
									<div class="col-xs-3 text-center">
										<b>项目介绍：</b>
									</div>
									<div class="col-xs-9">
										<!-- 加载编辑器的容器 -->
										<script id="container" name="projectIntroduce" type="text/plain"  style="width: 800px;min-height:300px;"></script>
									</div>

								</div>
			        
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
			var e=$('#projectAddress').val(a+"#"+b+"#"+c+"#"+d+"#");
			$('#_projectIndustry').val($('#projectIndustry').val()+"#"+$('#projectType').val())
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
<script src = "webpage/com/buss/projects/dxsProjects.js"></script>
<script src = "webpage/com/buss/common/lanxiao.js"></script>

</html>