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

//		  window.um = UM.getEditor('employedResponsibilities', {
//			  toolbar: [
//				  'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
//				  'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
//				  '| justifyleft justifycenter justifyright justifyjustify |',
//				  'link unlink | emotion image video  | map',
//				  '| horizontal print preview fullscreen', 'drafts', 'formula'
//			  ]
//
//		  });
//
//		  window.um = UM.getEditor('employedRequirements', {
//			  toolbar: [
//				  'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
//				  'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
//				  '| justifyleft justifycenter justifyright justifyjustify |',
//				  'link unlink | emotion image video  | map',
//				  '| horizontal print preview fullscreen', 'drafts', 'formula'
//			  ]
//		  });
  });
  window.onload=function()//用window的onload事件，窗体加载完毕的时候
  {
	  var obj = document.getElementsByName('employedPerks');

	  var objSelect =  $('#employedPerks').val();
	  var aa = objSelect.split(",")
	  for(var j = 0; j < aa.length; j++) {


		  for (var i = 0; i < obj.length; i++) {
			  if (obj[i].value == aa[j]) {

				  obj[i].checked = "checked";
//				alert(obj[i].value)
			  }
//		  if (obj[i].checked) s += obj[i].value + ','; //如果选中，将value添加到变量s中
		  }
	  }


	  $('#_employedSalary').val( $('#employedSalary').val())
	  $('#_employedType').val( $('#employedType').val())
	  $('#_experience').val( $('#experience').val())
	  $('#_education').val( $('#education').val())


  }

  </script>
</head>

 <body>

  <form id="formobj" action="dxsEmployedController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsEmployedPage.id}' >
			
			
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
			          	<%--<b>就业分类：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
						  <%--<select name="employedCatalogId" class="form-control">--%>
							  <%--<c:forEach items="${DxsEmployedCatalogList}" var="DxsEmployedCatalog">--%>
								  <%--<option value="${DxsEmployedCatalog.id}"--%>
										  <%--<c:if test="${DxsEmployedCatalog.id==dxsEmployedPage.employedCatalogId}">selected="selected"</c:if>--%>
								  <%-->--%>
									  <%--<t:mutiLang langKey="${DxsEmployedCatalog.employedCatalogName}"/>--%>
								  <%--</option>--%>
							  <%--</c:forEach>--%>
						  <%--</select>--%>
						<%--<label class="Validform_label" style="display: none">就业分类</label>--%>
			          <%--</div>--%>
								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>企业用户名：</b>
								</div>
								<div class="col-xs-3">
									<select name="userId" class="form-control">
										<c:forEach items="${DxsUserList}" var="DxsUser">
											<option value="${DxsUser.id}"
													<c:if test="${DxsUser.id==dxsEmployedPage.userId}">selected="selected"</c:if>
											>
												<t:mutiLang langKey="${DxsUser.empname}"/>
											</option>
										</c:forEach>
									</select>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">用户id</label>
								</div>
			        </div>
					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>职业名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="employedName" name="employedName" type="text" class="form-control"  value='${dxsEmployedPage.employedName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">职业名称</label>
			          </div>
						  <div class="col-xs-3 text-center">
							  <b>招聘岗位数目：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="employedNum" name="employedNum" type="text" class="form-control"  value='${dxsEmployedPage.employedNum}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">招聘岗位数目</label>
						  </div>
							</div>
			          
			        
							<div class="row show-grid">

			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>月薪：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="employedSalary" id="_employedSalary" class="form-control">
							  <option value="不限">不限</option>
							  <option value="3000元以下">3000元以下</option>
							  <option value="3001-4500">3001-4500</option>
							  <option value="4501-6000">4501-6000</option>
							  <option value="6001-7500">6001-7500</option>
							  <option value="7501-9000">7501-9000</option>
							  <option value="9001-10000">9001-10000</option>
							  <option value="10001-12000">10001-12000</option>
							  <option value="12001-15000">12001-15000</option>
							  <option value="15000以上">15000以上</option>
							  <option value="面议">面议</option>
						  </select>
								<input id="employedSalary"  type="hidden" class="form-control"  value='${dxsEmployedPage.employedSalary}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">月薪</label>
			          </div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			         <%----%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          <%--&lt;%&ndash;	<b>岗位职责：</b>&ndash;%&gt;--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--&lt;%&ndash;<input id="employedResponsibilities" name="employedResponsibilities" type="text" class="form-control"  value='${dxsEmployedPage.employedResponsibilities}'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">岗位职责</label>&ndash;%&gt;--%>
			          <%--</div>--%>
							<%--</div>--%>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>岗位类型：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="employedType" id="_employedType" class="form-control">
								  <option value="不限">不限</option>
								  <option value="全职招聘">全职招聘</option>
								  <option value="实习实训">实习实训</option>
								  <option value="勤工俭学">勤工俭学</option>
								  <option value="社会兼职">社会兼职</option>
							  </select>
							  <input id="employedType"  type="hidden" class="form-control"  value='${dxsEmployedPage.employedType}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">岗位类型</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>工作经验：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="experience" id="_experience" class="form-control">
								  <option value="不限">不限</option>
								  <option value="无经验">无经验</option>
								  <option value="一年以下">一年以下</option>
								  <option value="1-3年">1-3年</option>
								  <option value="3-5年">3-5年</option>
								  <option value="5-8年">5-8年</option>
								  <option value="8-10年">8-10年</option>
								  <option value="10年以上">10年以上</option>
							  </select>
							  <input id="experience"  type="hidden" class="form-control"  value='${dxsEmployedPage.experience}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">工作经验</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>学历：</b>
						  </div>
						  <div class="col-xs-3">
							  <select name="education" id="_education" class="form-control">
								  <option value="不限">不限</option>
								  <option value="博士及以上">博士及以上</option>
								  <option value="硕士">硕士</option>
								  <option value="本科">本科</option>
								  <option value="大专">大专</option>
								  <option value="中专/中技/高中">中专/中技/高中</option>
								  <option value="初中及初中以下">初中及初中以下</option>
							  </select>
							  <input id="education" type="hidden" class="form-control"  value='${dxsEmployedPage.education}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">学历</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>公司名称：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="compancyName" name="compancyName" type="text" class="form-control"  value='${dxsEmployedPage.compancyName}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">公司名称</label>
						  </div>
					  </div>

					  <%--<div class="row show-grid">--%>
						  <%--<div class="col-xs-3 text-center">
                              <b>任职要求：</b>
                          </div>--%>
						  <%--<div class="col-xs-3">
                                    <input id="employedRequirements" name="employedRequirements" type="text" class="form-control"  value='${dxsEmployedPage.employedRequirements}'>
                            <span class="Validform_checktip" style="float:left;height:0px;"></span>
                            <label class="Validform_label" style="display: none">任职要求</label>
                          </div>--%>



					  <%--</div>--%>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>联系人：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="contactName" name="contactName" type="text" class="form-control"  value='${dxsEmployedPage.contactName}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">联系人</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>电话：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="contactTel" name="contactTel" type="text" class="form-control"  value='${dxsEmployedPage.contactTel}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">电话</label>
						  </div>
					  </div>


					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>手机：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="contactPhone" name="contactPhone" type="text" class="form-control"  value='${dxsEmployedPage.contactPhone}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">手机</label>
						  </div>


						  <div class="col-xs-3 text-center">
							  <b>邮箱：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="contactMail" name="contactMail" type="text" class="form-control"  value='${dxsEmployedPage.contactMail}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">邮箱</label>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>线上招聘针对大学：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="university" name="university" type="text" class="form-control"  value='${dxsEmployedPage.university}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">线上招聘针对大学</label>
						  </div>
						  <div class="col-xs-3 text-center">
							  <b>公司网址：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="compancyAddress" name="compancyAddress" type="text" class="form-control"  value='${dxsEmployedPage.compancyAddress}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">公司网址</label>
						  </div>
					  </div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>福利待遇：</b>
						  </div>
						  <div class="col-xs-3">
							  <input  type="checkbox"  name="employedPerks" value="五险一金">五险一金
							  <input  type="checkbox"  name="employedPerks" value="年底三薪">年底三薪
							  <input  type="checkbox"  name="employedPerks" value="带薪年假">带薪年假
							  <input  type="checkbox"  name="employedPerks" value="年度旅游">年度旅游
							  <input  type="checkbox"  name="employedPerks" value="绩效奖金">绩效奖金
							  <input  type="checkbox"  name="employedPerks" value="全勤奖">全勤奖

							  <input id="employedPerks" type="hidden" class="form-control"  value='${dxsEmployedPage.employedPerks}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">福利待遇(新增)</label>
						  </div>

						  <div class="col-xs-3 text-center">
							  <b>投递人数：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="postNum" name="postNum" type="text" class="form-control"  value='${dxsEmployedPage.postNum}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">投递人数(预留)</label>
						  </div>
						  </div>
								<div class="row show-grid">
								<div class="col-xs-3 text-center">
									<b>工作地点：</b>
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
									<input id="schoolRealAddress" name="employedPosition" type="hidden" class="form-control"  value='${dxsEmployedPage.employedPosition}'>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">工作地点</label>
								</div>
									</div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>专业要求：</b>
						  </div>
						  <div class="col-xs-3">
							  <textarea id="employMajor" class="form-control" rows="6" name="employMajor">${dxsEmployedPage.employMajor}</textarea>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">专业要求</label>
						  </div>

					  </div>
			          <%-- 王腾云 --%>
					  <%-- 這裡加文本編輯器 --%>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center" style="border: 0px solid red;">
							  <b>岗位职责：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="employedResponsibilities" name="employedResponsibilities" type="text/plain" style="width: 800px;min-height:300px;">
								${dxsEmployedPage.employedResponsibilities}
							</script>
						  </div>
					  </div>
					  <div class="row show-grid">
						  <div class="col-xs-3 text-center" style="border: 0px solid red;">
							  <b>任职要求：</b>
						  </div>
						  <div class="col-xs-9">
							  <!-- 加载编辑器的容器 -->
							  <script id="employedRequirements" name="employedRequirements" type="text/plain" style="width: 800px;min-height:300px;">
								${dxsEmployedPage.employedRequirements}
							</script>
						  </div>
					  </div>


							<%--<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>创建时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEmployedPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">创建时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>更新时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsEmployedPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">更新时间</label>
			          </div>
							</div>--%>
			          
			        
							<%--<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>删除标志：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsEmployedPage.isDelete}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">删除标志</label>
			          </div>
							<div class="col-xs-2 text-center"><b></b></div>
			         		<div class="col-xs-4"></div>
							</div>--%>
			          
			        

			       
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
			if($('#diZhi').val()=="请输入详细地址"){
				$('#diZhi').val("")
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
		window.um = UM.getEditor('employedResponsibilities', {

			readonly:true

		});

		window.um = UM.getEditor('employedRequirements', {
			toolbar:[
				'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
				'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize' ,
				'| justifyleft justifycenter justifyright justifyjustify |',
				'link unlink | emotion image video  | map',
				'| horizontal print preview fullscreen', 'drafts', 'formula'
			],
			readonly:true
		});
//		window.um.getEditor("*", {readonly:true});
	} else {
		window.um = UM.getEditor('employedResponsibilities', {
			toolbar: [
				'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
				'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
				'| justifyleft justifycenter justifyright justifyjustify |',
				'link unlink | emotion image video  | map',
				'| horizontal print preview fullscreen', 'drafts', 'formula'
			]

		});

		window.um = UM.getEditor('employedRequirements', {
			toolbar: [
				'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
				'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
				'| justifyleft justifycenter justifyright justifyjustify |',
				'link unlink | emotion image video  | map',
				'| horizontal print preview fullscreen', 'drafts', 'formula'
			]
		});
	}
	
	if(location.href.indexOf("mode=read")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
alert(1)
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
<script src = "webpage/com/buss/employed/dxsEmployed.js"></script>
<script src = "webpage/com/buss/common/lanxiaoupdate.js"></script>
</html>