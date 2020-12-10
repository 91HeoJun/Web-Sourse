<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 성공하면 index.jsp로 이동
	// update 테이블명 set addr=수정값, mobile=수정값
	// where no = 12 
	request.setCharacterEncoding("utf-8");

// update.jsp에서 넘긴값 가져와서(no, addr, mobile) 수정 후
	int no = Integer.parseInt(request.getParameter("no"));
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	UserDAO dao = new UserDAO();
	int result = dao.updateUser(addr, mobile, no);
	
	if(result > 0){
		response.sendRedirect("Index.jsp");
	}

%>