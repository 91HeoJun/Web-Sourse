<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 세션 해제
	session.invalidate();
	
	//loginForm.jsp로 이동
	response.sendRedirect("../index.jsp");
	//response.sendRedirect("loginForm.jsp");
%>