<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>포워드 된 페이지</h2>
	<ul>
		<li>이름 : <%=request.getParameter("username") %></li>
		<li>나이 : <%=request.getParameter("age") %></li>
		<li>전화 : <%=request.getParameter("tel") %></li>
	</ul>

</body>
</html>