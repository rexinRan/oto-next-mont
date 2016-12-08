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
  </script>
</head>

 <body>

  <form id="formobj" action="dxsInvoiceOrdersController.do?doUpdate" name="formobj" method="post">
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${dxsInvoiceOrdersPage.id}' >
			
			
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
			          	<b>发票名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="invoiceId" class="form-control" >
							  <c:forEach items="${dxsInvoicesEntityList}" var="dxsInvoices">
								  <option value="${dxsInvoices.id}"
										  <c:if test="${ dxsInvoices.id==dxsInvoiceOrdersPage.invoiceId }">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsInvoices.invoiceHeader}"/>
								  </option>
							  </c:forEach>
						  </select>
								<%--<input id="invoiceId" name="invoiceId" type="text" class="form-control" datatype="*" value='${dxsInvoiceOrdersPage.invoiceId}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发票信息id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>用户名称：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="userId" class="form-control" >
							  <c:forEach items="${dxsUserDetailEntityList}" var="dxsUser">
								  <option value="${dxsUser.id}"
										  <c:if test="${ dxsUser.id==dxsInvoiceOrdersPage.userId }">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsUser.name}"/>
								  </option>
							  </c:forEach>
						  </select>
								<%--<input id="userId" name="userId" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.userId}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">用户id</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>订单编号：</b>
			          </div>
			          <div class="col-xs-3">
						  <select name="orderId" class="form-control" >
							  <c:forEach items="${dxsOrdersList}" var="dxsOrders">
								  <option value="${dxsOrders.id}"
										  <c:if test="${ dxsOrders.id==dxsInvoiceOrdersPage.orderId }">selected="selected"</c:if>
								  >
									  <t:mutiLang langKey="${dxsOrders.orderNum}"/>
								  </option>
							  </c:forEach>
						  </select>
								<%--<input id="orderId" name="orderId" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.orderId}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">订单id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>发票金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="invoiceValue" name="invoiceValue" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.invoiceValue}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发票金额</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>发票标号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="invoiceLabels" name="invoiceLabels" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.invoiceLabels}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发票标号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>申请时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="applyTime" name="applyTime" type="text"  class="form-control" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsInvoiceOrdersPage.applyTime}' type="date" pattern="yyyy-MM-dd"/>'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">申请时间</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>发票状态：</b>
			          </div>
			          <div class="col-xs-3">
						  <input type="radio" name="invoiceStatus" value="1" <c:if test="${dxsInvoiceOrdersPage.invoiceStatus == 1}">checked</c:if>>已开发票
						  <input type="radio" name="invoiceStatus" value="0" <c:if test="${dxsInvoiceOrdersPage.invoiceStatus == 0}">checked</c:if>>申请成功
						  <%--<input id="invoiceStatus" name="invoiceStatus" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.invoiceStatus}'>--%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">发票状态</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收件人：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="recipient" name="recipient" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.recipient}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收件人</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收取地址：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="recipientAddress" name="recipientAddress" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.recipientAddress}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收取地址</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>邮编：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="postNum" name="postNum" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.postNum}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">邮编</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>联系电话：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="phone" name="phone" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.phone}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">联系电话</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>物流公司：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="logisticsCompany" name="logisticsCompany" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.logisticsCompany}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">物流公司</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>快递编号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="expressNumber" name="expressNumber" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.expressNumber}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">快递编号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>开票订单号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="invoiceOrderNum" name="invoiceOrderNum" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.invoiceOrderNum}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">开票订单号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>产品名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="productName" name="productName" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.productName}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">产品名称</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收取方式：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="collectionType" name="collectionType" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.collectionType}'>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收取方式</label>
			          </div>
							</div>
			          
			        
							<%--<div class="row show-grid">--%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>创建时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsInvoiceOrdersPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
						<%--<span class="Validform_checktip" style="float:left;height:0px;"></span>--%>
						<%--<label class="Validform_label" style="display: none">创建时间</label>--%>
			          <%--</div>--%>
			          <%----%>
			        <%----%>
			          <%--<div class="col-xs-3 text-center">--%>
			          	<%--<b>更新时间：</b>--%>
			          <%--</div>--%>
			          <%--<div class="col-xs-3">--%>
								<%--<input id="updateTime" name="updateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${dxsInvoiceOrdersPage.updateTime}' type="date" pattern="yyyy-MM-dd"/>'>--%>
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
								<%--<input id="isDelete" name="isDelete" type="text" class="form-control"  value='${dxsInvoiceOrdersPage.isDelete}'>--%>
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
<script src = "webpage/com/buss/invoiceorders/dxsInvoiceOrders.js"></script>		
</html>