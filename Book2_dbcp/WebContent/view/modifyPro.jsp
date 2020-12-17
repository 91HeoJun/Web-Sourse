<%@page import="persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// modify.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	int price = Integer.parseInt(request.getParameter("price"));
	int code = Integer.parseInt(request.getParameter("code"));
	
	// DB작업
	BookDAO dao = new BookDAO();
	int result = dao.bookUpdate(price, code);

	// 성공하면 인덱스로 이동
	if(result == 0){
		response.sendRedirect("../index.jsp?tab=modify");
	} else {
		response.sendRedirect("selectPro.jsp");
	}
%>