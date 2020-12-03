<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//로그아웃 => 로그인 세션 삭제
	session.invalidate();
	
	response.sendRedirect("Session/login.jsp");

%>