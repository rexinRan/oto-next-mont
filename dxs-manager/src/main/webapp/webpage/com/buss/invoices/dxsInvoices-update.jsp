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
	  $('#_businessLincense').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do;jsessionid=${pageContext.session.id}',    /*后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#businessLincense'))
			  $('#businessLincense').val(data);
			  $('#wImgurl').attr("src",data);
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_taxPerson').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do;jsessionid=${pageContext.session.id}',    /*后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#taxPerson'))
			  $('#taxPerson').val(data);
			  $('#wImgurl2').attr("src",data);
		  }
	  });
  })

  $(function(){
	  /* 文件提交 */
	  $('#_generalTaxpayer').uploadify({
		  'swf' : 'plug-in/uploadify/uploadify.swf',
		  'uploader' : 'files/upload.do;jsessionid=${pageContext.session.id}',    /*后期需要传当前展示项目的ID去做更新*/
		  'buttonText' : '上传配图',
		  'width' : 100,
		  'height' : 30,
		  'onUploadSuccess' : function(file, data, response) {
			  alert('successfully uploaded ' + ':' + data);
			  console.info($('#generalTaxpayer'))
			  $('#generalTaxpayer').val(data);
			  $('#wImgurl3').attr("src",data);
		  }
	  });
  })

   </script>
</head>

 <body>

  <form id="formobj" action="dxsInvoicesController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsInvoicesPage.id}' >
			
			
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
							  <c:forEach items="${dxsUserDetailEntityList}" var="dxsUser">
								  <option value="${dxsUser.id}"
										  <c:if test="${ dxsUser.id==dxsInvoicesPage.userId }">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsUser.name}"/>
								  </option>
							  </c:forEach>
						  </select>
						  <%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsInvoicesPage.userId}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户ID</label>
			          </div>
							</div>

					  <div class="row show-grid">
						  <div class="col-xs-3 text-center">
							  <b>发票抬头：</b>
						  </div>
						  <div class="col-xs-3">
							  <input id="invoiceHeader" name="invoiceHeader" type="text" class="form-control"  value='${dxsInvoicesPage.invoiceHeader}'>
							  <span class="Validform_checktip" style="float:left;height:0px;"></span>
							  <label class="Validform_label" style="display: none">发票抬头</label>
						  </div>
					  </div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>开具类型：</b>
			          </div>
			          <div class="col-xs-3">
						  <input type="radio" name="issueType" value="1" <c:if test="${dxsInvoicesPage.issueType == 1}">checked</c:if>>企业
						  <input type="radio" name="issueType" value="0" <c:if test="${dxsInvoicesPage.issueType == 0}">checked</c:if>>个人
						  <%--<input id="issueType" name="issueType" type="text" class="form-control"  value='${dxsInvoicesPage.issueType}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">开具类型</label>
			          </div>
							</div>
			          
			        


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>发票类型：</b>
			          </div>
			          <div class="col-xs-3">
						  <input type="radio" name="invoiceType" value="1" <c:if test="${dxsInvoicesPage.invoiceType == 1}">checked</c:if>>增值税专用发票
						  <input type="radio" name="invoiceType" value="0" <c:if test="${dxsInvoicesPage.invoiceType == 0}">checked</c:if>>增值税普通发票
								<%--<input id="invoiceType" name="invoiceType" type="text" class="form-control"  value='${dxsInvoicesPage.invoiceType}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发票类型</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>税务登记账号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="taxAccount" name="taxAccount" type="text" class="form-control"  value='${dxsInvoicesPage.taxAccount}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">税务登记账号</label>
			          </div>
							</div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>基本开户银行名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="bankName" name="bankName" type="text" class="form-control"  value='${dxsInvoicesPage.bankName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">基本开户银行名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>基本开户账号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="bankAccount" name="bankAccount" type="text" class="form-control"  value='${dxsInvoicesPage.bankAccount}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">基本开户账号</label>
			          </div>
							</div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>注册场所地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="registerPalce" name="registerPalce" type="text" class="form-control"  value='${dxsInvoicesPage.registerPalce}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">注册场所地址</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>注册固定电话：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="registerPhone" name="registerPhone" type="text" class="form-control"  value='${dxsInvoicesPage.registerPhone}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">注册固定电话</label>
			          </div>
							</div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>营业执照复印件：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_businessLincense"></div>
						  <input id="businessLincense" name="businessLincense" type="text" class="form-control" value="${dxsInvoicesPage.businessLincense}" style="display: none">
						  <%--<input id="businessLincense" name="businessLincense" type="text" class="form-control"  value='${dxsInvoicesPage.businessLincense}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">营业执照复印件</label>
			          </div>
								<div class="col-xs-3">
									<img id="wImgurl" src='${dxsInvoicesPage.businessLincense}'width="70%" height="30%"/>
								</div>

							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>税务登记复印件：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_taxPerson"></div>
						  <input id="taxPerson" name="taxPerson&generalTaxpayer" type="text" class="form-control" value="${dxsInvoicesPage.taxPerson}" style="display: none">
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">税务登记复印件</label>
			          </div>
								<div class="col-xs-3">
									<img id="wImgurl2" src='${dxsInvoicesPage.taxPerson}'width="70%" height="30%"/>
								</div>
							</div>


					  <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>一般纳税人资格复印件：</b>
			          </div>
			          <div class="col-xs-3">
						  <div id="_generalTaxpayer"></div>
						  <input id="generalTaxpayer" name="generalTaxpayer" type="text" class="form-control" value="${dxsInvoicesPage.generalTaxpayer}" style="display: none">
						  <%--<input id="generalTaxpayer" name="generalTaxpayer" type="text" class="form-control"  value='${dxsInvoicesPage.generalTaxpayer}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">一般纳税人资格复印件</label>
			          </div>
						  <div class="col-xs-3">
							  <img id="wImgurl3" src='${dxsInvoicesPage.generalTaxpayer}'width="70%" height="30%"/>
						  </div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsInvoicesPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsInvoicesPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsInvoicesPage.isDelete}'>--%>
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
<script src = "webpage/com/buss/invoices/dxsInvoices.js"></script>		
</html>