<%@page import="persistence.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	//select.jsp에서 넘긴 값 가져오기
	int no = Integer.parseInt(request.getParameter("no"));
	UserDAO dao = new UserDAO();
	int result = dao.deleteUser(no);

	if (result > 0) {
		//삭제가 성공하면 index.jsp로 이동
		response.sendRedirect("Index.jsp");
	} else {
		response.sendRedirect("select.jsp");
	}

%>