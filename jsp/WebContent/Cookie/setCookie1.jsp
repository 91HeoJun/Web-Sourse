<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// cookie3.jsp에서 설정한 값 가져오기
		String language = request.getParameter("language");
	
	// 쿠키 설정하기
		Cookie c = new Cookie("language", language);
	// 유효시간 설정
		c.setMaxAge(60*60*24); // 24시간
	// 응답 헤더에 쿠키 추가
		response.addCookie(c);

	// 처음 페이지로 돌아가기
	response.sendRedirect("cookie3.jsp");
	
	
%>