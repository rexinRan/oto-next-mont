<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="ctx" scope="application" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Redis Keys列表</title>
    <%--<link rel="stylesheet" href="/js/main.css"/>--%>
    <style type="text/css">
        a:link {font-size: 12px;color: #06482A;text-decoration: none;}
        a:visited {font-size: 12px;color: #06482A;text-decoration: none;}
        a:hover {font-size: 12px;color: #e60039;text-decoration: underline;}
        a:active {font-size: 12px;color: #e60039;text-decoration: none;}
        /** list */
        .searchbar {border: 1px solid #CCCCCC; width: 70%; text-align: left;font-size: 13px;border-bottom: none;}
        .searchitem {line-height: 42px;margin-left: 15px;}
        .searchitem2 {margin-left: 15px;padding-top: 8px;padding-bottom: 7px;}
        .listcont {border: 1px solid #99BBE8; width: 70%; text-align: left;}
        .listcont tbody tr:hover td{background: #ECF8FD;}
        .title {background-color: #E2EEFE;height: 30px;line-height: 30px;font-size: 13px;border-bottom: 1px solid #99BBE8;padding-left: 15px;font-weight: bolder;color: #15428B;text-align: center;}
        .contss {font-size: 13px;text-align: left;height: 30px;background: #FFFFFF;padding-left: 7px;}
        .conttt {font-size: 13px;text-align: center;height: 30px;background: #FFFFFF;background: #FAFAFA;}
        .contcc {font-size: 13px;text-align: center;height: 30px;background: #FFFFFF;}
        .contoneri {font-size: 13px;height: 30px;background: #FFFFFF;text-align: left;padding-left: 10px;}

        .toolbar {background-color: #EFEFEF;height: 31px;line-height:31px;font-size: 13px; border-bottom: 1px solid #CCCCCC;padding: 1px 0px 2px 15px;}
        .toolbar a{padding: 6px 8px;border: 1px solid #EFEFEF;margin-right: 5px;}
        .toolbar a:hover {border: 1px solid #99BBE8;text-decoration: none;background-color: #E4EDFE;color: #06482A;}

        .footbar {background-color: #EFEFEF;height: 31px;line-height: 31px;font-size: 13px;border-top: 1px solid #CCCCCC;padding: 1px 0px 2px 15px;}
        .footbar a{padding: 6px 8px;border: 1px solid #EFEFEF;margin-right: 5px;}
        .footbar a:hover {border: 1px solid #99BBE8;text-decoration: none;background-color: #E4EDFE;color: #06482A;}
    </style>
    <script src="http://oss.devcp.org/js/jquery/jquery-1.8.3.min.js"></script>
    <%--<script src="js/jquery-1.8.3.min.js"></script>--%>
    <%--<script src="${ctx}/js/template.js"></script>--%>
    <script type="text/javascript" language="javascript">
        // TODO 进页面默认加载
        /*
        $(function () {
            $.ajax({
                type: "POST",
                url: "${ctx}/redis/getkey.do",
                success: function (data) {
                    var $varietyContent = $('#templateid'), varietyHtml = template('templatecontent', data);
                    $varietyContent.html(varietyHtml);
                }
            });
        });
        */
        // TODO 页面事件监听
        $(function () {
            $("#select").on("click", function () {
                if ($("#key").val() != "") {
                    window.location.href = "${ctx}/redis.do?key=" + escape($("#key").val());
                } else {
                    window.location.href = "${ctx}/redis.do";
                }
            });

            $("#flushDB").on("click", function () {
                if (confirm("确认删除全部？")) {
                    $.ajax({
                        type: "POST",
                        url: "${ctx}/redis/flushDB.do",
                        success: function (data) {
                            if (data == 0) {
                                alert("清空所有数据失败！");
                            } else {
                                alert("清空所有数据成功！");
                                window.location.href = "${ctx}/redis.do";
                            }
                        }
                    });
                }
            });

        });

        // TODO 删除key
        function deletekey(key) {
            /*if (confirm("确认删除全部？")) {*/
            $.ajax({
                type: "POST",
                url: "${ctx}/redis/delete.do",
                data: "key=" + escape(key),
                success: function (data) {
                    if (data == 0) {
//                            alert("删除失败!");
                    } else {
//                            alert("删除成功!");
                        window.location.href = "${ctx}/redis.do";
                    }
                }
            });
            /*}*/
        }

    </script>
</head>
<body>
<div align="center" style="margin-top: 20px;min-width: 400px;">
    <div class="searchbar">
        <div class="searchitem" style="text-align: center;">
            Key名称:&nbsp;&nbsp;<input id="key" class="textInput" type="text" value=""
            style="width:400px;"/>&nbsp;&nbsp;<a href="javascript:void(0);" id="select">查询</a>
        </div>
    </div>
</div>
<div align="center" style="min-width: 1000px;">

    <div class="listcont">
        <div class="title">&nbsp;&nbsp;keys列表&nbsp;&nbsp; <a href="javascript:void(0);" id="flushDB">删除全部</a></div>
        <div>
            <table width="100%" border="0" bgcolor="#EFEFEF" align="center" cellspacing="1" cellpadding="0">
                <thead>
                <tr>
                    <th class="conttt" style="width:50px;">编号</th>
                    <th class="conttt">key名称</th>
                    <th class="conttt">操作</th>
                </tr>
<c:forEach items="${result.data}" var="u">
    <tr>
        <th>${ u.sid }</th>
        <th>${ u.key }</th>
        <th><a href="${ctx}/redis/getvalue.do?key=${u.key}">查看</a> |
            <a href="javascript:;" onclick="deletekey('${u.key}')">删除</a> | ${ u.sid }
        </th>
    </tr>
</c:forEach>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>

        <div class="footbar" id="templateid"></div>

    </div>
</div>
</body>
</html>

<%--
<script id="templatecontent" type="text/html">
    {{each data as value i}}
    <p>{{i}}</p> -
    <p>{{value}}</p>
    {{/each}}
</script>
--%>
