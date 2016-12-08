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
        $('#_activeCatelogImg').uploadify({
            'swf' : 'plug-in/uploadify/uploadify.swf',
            'uploader' : 'files/upload.do',
            'buttonText' : '上传视频',
            'width' : 100,
            'height' : 50,
            'onUploadSuccess' : function(file, data, response) {
//                alert('successfully uploaded ' + ':' + data);
//                data = JSON.parse(data);
                console.info($('#activeCatelogImg'))
                $('#activeCatelogImg').val(data);
                $('ul').append("<li>"+"<input value='"+data+"' width='500'/> "+"</li>")
//				$("#activeCatelogImg-queue").css("overflow","hidden").html("<img src=\"" + data + "\" />");
            }
        });



    })
    function goSummit() {
        alert(0)
        $("form").submit();
        alert(1)
    }
</script>
</head>

<body>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <%--<t:datagrid name="dxsUserList" checkbox="true" fitColumns="false" title="" actionUrl="" idField="id" fit="true" queryMode="group">--%>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <%--<t:dgDelOpt title="删除" url="dxsUserController.do?doDel&id={id}" />--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="dxsUserController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="dxsUserController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--&lt;%&ndash;--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="dxsUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="dxsUserController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <%--&ndash;%&gt;--%>
  <%--</t:datagrid>--%>
      <div id="_activeCatelogImg"></div>
      <input id="activeCatelogImg" name="activeCatelogImg" type="text" class="form-control" value="" style="display: none">
        <ul>
            <li>视频的ID</li>
        </ul>
  </div>
 </div>
<div>
    <form action="files/uploadvideo.do" enctype="multipart/form-data" method="post">
        <input type="file" name="upfile">
        <input type="button" onclick="goSummit()" value="提交">
    </form>
</div>
</body>

