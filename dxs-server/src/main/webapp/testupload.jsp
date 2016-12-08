<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <form action="fileUpload/fileUpload.do" enctype ="multipart/form-data" method="post">
        <label>文件</label><input type="file" name="mf"> <br>
        <lable>上传人</lable> <input type="text" name="userid" value="123456789">
        <input type="submit" value="提交">
    </form>
</body>
</html>
