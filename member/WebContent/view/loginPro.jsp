<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// loginForm.jsp에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	// DB작업
	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.isLogin(userid, password);

	// 존재하는 사용자일 경우 loginForm.jsp로 이동
	if(member!=null){ //로그인 작업 => 현재 정보를 session에 담기
		session.setAttribute("login", member);
		
	}else{
		out.print("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");
	}
	
	// 자바 : response.sendRedirect("loginForm.jsp");
	// 스크립트 : ↓
	out.print("<script>location.href='loginForm.jsp';</script>");




%>