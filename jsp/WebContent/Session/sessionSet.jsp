<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//세션 영역에 값 담기
	session.setAttribute("name", "session Test!");
	session.setAttribute("age", 25);
	//페이지 이동
	response.sendRedirect("Test1.jsp");
	
%>