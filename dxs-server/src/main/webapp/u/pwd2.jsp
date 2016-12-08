<!-- 
加密解密
-->
<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:directive.page import="org.jweb.core.util.PasswordUtil"/>
<jsp:directive.page import="org.jweb.core.util.StringUtil"/>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
String pwd2 = request.getParameter("pwd2");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css" />
  </head>
  <body>
    <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
  		<tr><td align="left" class="font_blue_14px_bold">当前位置：快捷查询</td></tr>
		<tr><td height="2" bgcolor="#EBEBED"></td></tr>
		<tr><td height="10"></td></tr>
  	</table>
  	<form action="${pageContext.request.contextPath}/u/pwd2.jsp" method="post">
  	<table width="100%"  align="center" border="0" cellpadding="0" cellspacing="0">
  		<tr>
  			<td align="center">
  				<textarea rows="2" cols="50" id="pwd2" name="pwd2" ><%=pwd2 == null ? "" : pwd2 %></textarea><br />
  				<input type="submit" value="查询"/><font color="red"></font>
  			</td>
  		</tr>
  	</table>
  	</form>
  	<br />
	<%
	if(pwd2 != null && !"".equals(pwd2)){
	%>
    <table width="80%" align="center" border="1" cellpadding="0" cellspacing="0" id="chx_panel" class="DoublecolorTable">
    	<tr class="bluetrbg">
    	<%
    		//String pwd2Str = PasswordUtil.encrypt(pwd2, "123456", PasswordUtil.getStaticSalt());
	    	String pwd2Str = PasswordUtil.decrypt(pwd2);
	    %>
	   		<td align="center"><%=StringUtil.filterNullValue(pwd2Str) %></td>
    	</tr>
    </table>
    <%}%>
  </body>
</html>
