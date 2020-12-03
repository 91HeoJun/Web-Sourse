<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 생성 Cookie c = new Cookie(name, value)
	// 쿠키 저장 response.addCookie(c)
	
	// 쿠키 생성
	Cookie c = new Cookie("name", "heojun");
	// 쿠키 만료시간 설정
	c.setMaxAge(600);

	// 쿠키 저장
	response.addCookie(c);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 데이터가 저장되었습니다.</h3>
<a href="getCookie2.jsp">쿠키 확인</a>

</body>
</html>