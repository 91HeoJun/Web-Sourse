<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 가져오기
	String name = "";
	String value = "";
	Cookie[] cookies = request.getCookies();
for(Cookie c:cookies){
	if(c.getName().equals("name")){ //쿠키의 이름을 가져와서 비교하는 작업
		name = c.getName();
		value = c.getValue();
	}
}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>쿠키 이름 : <%=name %></p>
<p>쿠키 값 : <%=value %> </p>

</body>
</html>