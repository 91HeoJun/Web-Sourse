<%@page import="member.MemberDAO"%>
<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// leaveForm.jsp에서 넘긴 값 가져요기
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	// DB작업
	MemberDAO dao = new MemberDAO();
	int result = dao.isTerminate(userid, password);
	
	// 1. 성공 시 delete, 세션해제, index.jsp로 이동

		if(result > 0) {
			session.invalidate();
			response.sendRedirect("../index.jsp");
	} else {
	// 2. 실패시 leaveForm.jsp로 재이동
		response.sendRedirect("leaveForm.jsp");
	}
%>