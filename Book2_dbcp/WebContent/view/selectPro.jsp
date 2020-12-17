<%@page import="domain.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 도서목록보기 메뉴를 클릭하면 보여줄 내용 처리
	BookDAO dao = new BookDAO();
	List<BookVO> list = dao.getList();
	
	// Scope => (request + forward), session
	request.setAttribute("list", list);
	pageContext.forward("../select.jsp");

%>