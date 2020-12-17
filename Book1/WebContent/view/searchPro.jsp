<%@page import="domain.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	// DB작업
	BookDAO dao = new BookDAO();
	List<BookVO> list = dao.bookSearch(criteria, keyword);
	
	// forward - searchAll.jsp로 이동
	request.setAttribute("list", list);
	pageContext.forward("../searchAll.jsp"); // forward, include => 상대주소로! 절대주소를 사용하지 않음!
	
%>