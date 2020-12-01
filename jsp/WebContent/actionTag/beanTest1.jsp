<%@ page import="exam.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//User Class 사용 => 객체 생성
	User user = new User();
	user.setName("고길동");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=user.getName() %></h1>

</body>
</html>