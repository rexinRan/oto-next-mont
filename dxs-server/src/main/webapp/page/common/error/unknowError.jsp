<%@ page language="java" contentType="text/html; charset=utf-8" isErrorPage="true"
    pageEncoding="utf-8"%>
<% Exception e = (Exception)request.getAttribute("ex"); %>
<H2>错误异常: <%= exception.getClass().getSimpleName()%></H2>
<hr />
<P>错误描述：</P>
<%= exception.getMessage()%>
<P>错误信息：</P>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
