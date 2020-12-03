<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../LoginServlet" method="post">
	<!-- Servlet(.java) 파일로 이동 할 경우 (.java)는 제외하고 넣을 것. -->
	<div>
		<label for="userid">아이디</label>
		<input type="text" name="userid" id="userid" />
	</div>
	<div>
		<label for="userpw">비밀번호</label>
		<input type="password" name="userpw" id="userpw" />
	</div>	
	<div>
		<button type="submit">전송</button>
	</div>
	</form>
</body>
</html>