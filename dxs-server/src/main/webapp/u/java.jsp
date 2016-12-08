<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="org.jweb.core.util.ResourceUtil" %>
<%@ page import="org.jweb.core.util.extend.SystemProperty" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.jweb.core.web.listener.AppInitListener" %>
<%!	
String projectName(){
	String str = "";
	ApplicationContext ctx = AppInitListener.getCtx();
	//System.out.println("ctx="+ctx);
	if (ctx==null) {
		return str;
	}
	str = ctx.getApplicationName();
	return str;
}
%>
<%
out.println("应用程序名: " + projectName() + "</br>");
out.println("文件分隔符: " + ResourceUtil.getSeparator() + "</br>");
out.println("项目根目录: " + ResourceUtil.getPorjectPath() + "</br>");
out.println("类访问路径: " + ResourceUtil.getClassPath() + "</br>");
out.println("##项目路径: " + ResourceUtil.getSysPath() + "</br>");
out.println("##临时目录: " + ResourceUtil.getSystempPath() + "</br>");
out.println("##请求路径: " + ResourceUtil.getRequestPath(request) + "</br>");
%>
<hr />
请求方式：<%=request.getMethod()%><br>
请求的资源：<%=request.getRequestURI()%><br>
请求用的协议：<%=request.getProtocol()%><br>
请求的文件名：<%=request.getServletPath()%><br>
请求的服务器的IP：<%=request.getServerName()%><br>
请求服务器的端口：<%=request.getServerPort()%><br>
客户端IP地址：<%=request.getRemoteAddr()%><br>
客户端主机名：<%=request.getRemoteHost()%><br>
表单提交来的值：<%=request.getParameter("qwe")%><br>

<hr />
<pre>
<%
out.println(SystemProperty.getSystemContent().toString() + "</br>");
%>
</pre>