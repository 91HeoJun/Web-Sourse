<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
/* 	// 세션 영역에 담기 => 로그인(아이디, 비번, 이름)
	session.setAttribute("userid", userid);
	session.setAttribute("userpw", userpw); */
	
	LoginDTO login = new LoginDTO(userid, userpw);
	session.setAttribute("login", login);
	
	response.sendRedirect("../index.jsp");
	

	
%>