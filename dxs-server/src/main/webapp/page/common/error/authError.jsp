<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setStatus(200);
	response.setHeader("Content-Type", "text/html;charset=utf-8");
	out.write("{statusCode:\"101\",data:\"lose premit\",success:false}");
%>
