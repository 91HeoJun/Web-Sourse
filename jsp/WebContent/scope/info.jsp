<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//info.html에서 넘김 값 가져오기
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String age = request.getParameter("age");
		
	//request영역 객체에 값 담기
	request.setAttribute("username", username);
	request.setAttribute("age", age);
	
	
	pageContext.forward("infoPro.jsp");

	
%>
