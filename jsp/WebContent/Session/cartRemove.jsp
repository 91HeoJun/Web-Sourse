<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//장바구니 지우기 - 세션 삭제
	session.removeAttribute("proList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>장바구니 비움</h3>
<a href="cart.html">상품선택 페이지</a>
</body>
</html>