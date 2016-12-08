<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/5
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body div {
            margin: 0 auto;
        }
    </style>
    <script src="js/jquery-1.8.0.min.js"></script>
    <script src="js/jquery.qrcode.min.js"></script>
    <script>
        // 内容识别支持中文
        function toUtf8(str) {
            var out, i, len, c;
            out = "";
            len = str.length;
            for(i = 0; i < len; i++) {
                c = str.charCodeAt(i);
                if ((c >= 0x0001) && (c <= 0x007F)) {
                    out += str.charAt(i);
                } else if (c > 0x07FF) {
                    out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                    out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
                    out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
                } else {
                    out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
                    out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
                }
            }
            return out;
        }

        $(function(){
            var content = toUtf8("中文内容");
            $("#code").qrcode("http://www.baidu.com");


            // 轮询写法
            checkbox = function(url) {
//                var box = $('#hd .panel');
                $.getJSON(url, function(data) {
                    for (k in data[0]) {
                        if (k == 'msg') {
                            if (data[0][k] > 0)
                                    ;
//                                box.find('[data-type=' + k + ']').show().text(data[0][k]);
                            else
                                    ;
//                                box.find('[data-type=' + k + ']').hide();
                        }
                    }
                });
                setTimeout(function() {
                    checkbox(url)
                }, 10000);
            }
            checkbox('server/msg_count.php');
        });
    </script>
</head>
<body>
    <div>
        <h2>文件上传</h2>
        <div id="code"></div>
    </div>
</body>
</html>
