<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwc= request.getParameter("pwc");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력 정보</title>
</head>
<body>
	<h4>사용자 입력 정보</h4>
	
	<p>
		아이디 : <%=id%>
		<br>
		비밀번호 : <%=pw%>
		<br>
		비밀번호 확인 : <%=pwc%>
		<br>
		이름 : <%=name%>
		<br>
		성별 : <%=gender%>
		<br>
		이메일 : <%=email%>
	
</p>
</body>
</html>