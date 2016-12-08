<%@ page language="java" import="java.util.*"
         contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>${roomName}测试</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/plug-in/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/plug-in/ueditor/ueditor.all.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/plug-in/ueditor/third-party/jquery-1.10.2.min.js"></script>
    <style type="text/css">
        .msg {
            margin-top: 5px;
        }
        .dateString {
            margin-left:5px;
            color: #d4d4d4;
        }
    </style>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<input type="hidden" id="roomId" name="roomId" value="${roomId}" />
<input type="hidden" id="msgIds" name="msgIds"/>
<!-- 消息记录 -->
<div id="history" style="width:630px;height:300px;border:1px #d4d4d4 solid;padding:10px;overflow-y:scroll;word-wrap:break-word;word-break:break-all;text-indent:2em;" ></div>
<!-- 消息 -->
<div id="msgBox"></div>
<!-- 按钮 -->
<div style="width: 650px; text-align: right; margin-top: 2px;">
    <input type="button" id="send" name="send" value="发送" />
    <input type="button" id="clear" name="clear" value="清空" />
</div>
</body>

<script type="text/javascript">

    /*由于所有ueditor请求都通过editor对象的getActionUrl方法获取请求地址，可以直接通过复写这个方法实现*/
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadimage') {
            return 'http://'+'<%=request.getServerName()%>/hxclub/file/uploadmain.do';
        }
        else if (action == 'uploadvideo') {
            return 'http://'+'<%=request.getServerName()%>/hxclub/file/uploadmain.do';
        }
        else if (action == 'catchimage') {
            return 'http://hongxinguoji.com/group1/M00/00/0E/';
        }
        else {
            return this._bkGetActionUrl.call(this, action);
        }

//        http://hongxinguoji.com/group1/M00/00/0E/
    }

    //消息发送窗口
    var $editor = new UE.ui.Editor({
//        initialFrameHeight : 150,
//        initialFrameWidth : 650,
        scaleEnabled : true,
        emotionLocalization:true,
        enableAutoSave:false,
        elementPathEnabled:false,
        wordCount:false,
        /*
         toolbars: [
             [
             'anchor', //锚点
             'undo', //撤销
             'redo', //重做
             'bold', //加粗
             'indent', //首行缩进
             'snapscreen', //截图
             'italic', //斜体
             'underline', //下划线
             'strikethrough', //删除线
             'subscript', //下标
             'fontborder', //字符边框
             'superscript', //上标
             'formatmatch', //格式刷
             'source', //源代码
             'blockquote', //引用
             'pasteplain', //纯文本粘贴模式
             'selectall', //全选
             'print', //打印
             'preview', //预览
             'horizontal', //分隔线
             'removeformat', //清除格式
             'time', //时间
             'date', //日期
             'unlink', //取消链接
             'insertrow', //前插入行
             'insertcol', //前插入列
             'mergeright', //右合并单元格
             'mergedown', //下合并单元格
             'deleterow', //删除行
             'deletecol', //删除列
             'splittorows', //拆分成行
             'splittocols', //拆分成列
             'splittocells', //完全拆分单元格
             'deletecaption', //删除表格标题
             'inserttitle', //插入标题
             'mergecells', //合并多个单元格
             'deletetable', //删除表格
             'cleardoc', //清空文档
             'insertparagraphbeforetable', //"表格前插入行"
             'insertcode', //代码语言
             'fontfamily', //字体
             'fontsize', //字号
             'paragraph', //段落格式
             'simpleupload', //单图上传
             'insertimage', //多图上传
             'edittable', //表格属性
             'edittd', //单元格属性
             'link', //超链接
             'emotion', //表情
             'spechars', //特殊字符
             'searchreplace', //查询替换
             'map', //Baidu地图
             'gmap', //Google地图
             'insertvideo', //视频
             'help', //帮助
             'justifyleft', //居左对齐
             'justifyright', //居右对齐
             'justifycenter', //居中对齐
             'justifyjustify', //两端对齐
             'forecolor', //字体颜色
             'backcolor', //背景色
             'insertorderedlist', //有序列表
             'insertunorderedlist', //无序列表
             'fullscreen', //全屏
             'directionalityltr', //从左向右输入
             'directionalityrtl', //从右向左输入
             'rowspacingtop', //段前距
             'rowspacingbottom', //段后距
             'pagebreak', //分页
             'insertframe', //插入Iframe
             'imagenone', //默认
             'imageleft', //左浮动
             'imageright', //右浮动
             'attachment', //附件
             'imagecenter', //居中
             'wordimage', //图片转存
             'lineheight', //行间距
             'edittip ', //编辑提示
             'customstyle', //自定义标题
             'autotypeset', //自动排版
             'webapp', //百度应用
             'touppercase', //字母大写
             'tolowercase', //字母小写
             'background', //背景
             'template', //模板
             'scrawl', //涂鸦
             'music', //音乐
             'inserttable', //插入表格
             'drafts', // 从草稿箱加载
             'charts', // 图表
             ]
         ]
        */

        toolbars: [
            ['fullscreen', 'source', 'undo', 'redo','|',
                'indent', //首行缩进
                'snapscreen', //截图
                'simpleupload', //单图上传
                'insertimage', //多图上传
                'insertvideo', //视频
                'edittable', //表格属性
                'edittd', //单元格属性
                'link', //超链接
                'spechars', //特殊字符
                'searchreplace', //查询替换
                ,'|',
                'map', //Baidu地图
                'justifyleft', //居左对齐
                'justifyright', //居右对齐
                'justifycenter', //居中对齐
                'justifyjustify', //两端对齐
                'attachment', //附件
                'imagecenter', //居中
                'wordimage', //图片转存
                'lineheight', //行间距
                'edittip ', //编辑提示
            ],
            ['bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc']
        ]
    });
    $editor.render("msgBox");

    var $history = $('#history');
    var $msgBox = $('#msgBox');
    var $roomId = $('#roomId');
    var $msgIds = $('#msgIds');
    //是否自动滚动到最新消息
    var isAutoScroll = true;

    //进入该页面就先调用一次查询数据信息
    getAnalyzeMsg();
    //每隔3s获取一次解盘消息数据信息
//    var timer = window.setInterval(getAnalyzeMsg, 3000);

    //清空按钮
    $('#clear').click(function() {
        //清空编辑器内容
        $editor.execCommand('cleardoc');
    });

    $('#send').click(function() {
        if (!$editor.hasContents()) {
            alert('待发送消息为空!');
            return;
        }
        var content = $editor.getContent();
        if(content.length > 5000){
            alert('内容长度过大！');
            return;
        }
        //添加到数据库
        var uri = "../admin/article/save.do";

        $('#send').attr("disabled","disabled");
        $.ajax({
            type : 'POST',
            url : uri,
            data : {roomId:$('#roomId').val(),content:content},
            success : function(data) {
                var jsonData = eval('(' + data + ')');
                if(!jsonData.success){
                    alert(jsonData.msg);
                    return;
                }
// 				getAnalyzeMsg();
                //清空编辑器内容
                $editor.execCommand('cleardoc');
            },
            complete : function() {
                $('#send').removeAttr("disabled");
            }
        });
    });

    //从库中取出消息
    function getAnalyzeMsg() {
        var msgIdVal = $msgIds.val();
        var msgIdArr = msgIdVal.split(",");
        if(msgIdArr.length > 20){
            //剔除超过20条信息的ID
            msgIdVal = msgIdArr.slice(0,20).join(",");
        }
        var uri = "../admin/article/list.do?page=1&rows=30";
        $.ajax({
            url : uri,
//            data : {roomId:$roomId.val(),msgIds:msgIdVal},
            success : function(data) {
                var jsonData = eval('(' + data + ')');
                console.log(jsonData.rows[0]);
                $history.append(jsonData.rows[0].title);
//                $msgIds.val(jsonData.attributes.msgIds);
                if(isAutoScroll){
                    $history.scrollTop($history[0].scrollHeight);
                }
            },
            error : function(){
                clearInterval(timer);
            }
        });
    }

    $history.scroll(function(){
        var htmlHeight = $history[0].scrollHeight;
        var clientHeight = $history[0].clientHeight;
        var scrollTop = $history[0].scrollTop;
        if((scrollTop+clientHeight) < htmlHeight){
            isAutoScroll = false;
        }else{
            isAutoScroll = true;
        }
    });
</script>