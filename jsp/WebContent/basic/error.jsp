<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>다음과 같은 에러가 발생했습니다</h2>
	<%-- e.printStackTrace(); or e.getMessage(); --%>
	<%=exception.getMessage() %>
	
	
</body>
</html>