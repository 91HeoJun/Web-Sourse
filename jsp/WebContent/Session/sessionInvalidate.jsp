<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현존하는 모든 세션 삭제
	session.invalidate();
response.sendRedirect("Test1.jsp");
	
	
%>