<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>response1.jsp</h1>
	<%
		// 페이지 전환
		response.sendRedirect("send.jsp");
	%>
	
	<!-- <h3>response 객체</h3> => 실제로는 의미가 없는 코드가 됨 -->

</body>
</html>