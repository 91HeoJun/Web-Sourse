<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 담아놓은 장바구니 리스트 가져오기
	// String product = (String)session.getAttribute("product");
	ArrayList<String> proList = (ArrayList<String>)session.getAttribute("proList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>장바구니 목록</h3>
<%-- 장바구니 리스트 보여주기 --%>

	<%
		out.print("<ul>");
		for(String product : proList){
			out.print("<li>" + product +"</li>");
		}
		out.print("</ul>");
	%>


<div>
	<a href="cart.html">상품선택 페이지로</a>
	<a href="cartRemove.jsp">장바구니 비우기</a>
</div>
</body>
</html>