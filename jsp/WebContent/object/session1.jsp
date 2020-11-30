<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션의 유효시간
	session.setMaxInactiveInterval(10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 내장 객체 - session : 연결성
	// http 프로토콜 : stateless(요청 -> 응답하고 연결 끊기) 
%>

<h2>세션 테스트</h2>
isNew() : <%= session.isNew() %> <br />
생성시간 : <%= session.getCreationTime() %> <br />
최종접속시간 : <%= session.getLastAccessedTime() %> <br />
세션ID : <%= session.getId() %> <br />

</body>
</html>