<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	// joinForm.jsp에서 넘긴 값 가져오기
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String confirm_password = request.getParameter("confirm_password");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	
	// 개별 값들을 객체에 담기
	MemberVO member = new MemberVO();
	member.setUserid(userid);
	member.setPassword(password);
	member.setName(name);
	member.setGender(gender);
	member.setEmail(email);
	
	// DB작업하기
	MemberDAO dao = new MemberDAO();
	int result = dao.isJoin(member);
	
	// 회원가입 성공되면 로그인 페이지로 이동하기
	if(result > 0){
		response.sendRedirect("loginForm.jsp");
	}
%>