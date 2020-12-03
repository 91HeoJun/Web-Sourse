<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 가져오기
	Cookie[] cookies = request.getCookies();
	
%>
<%!
	private String getCookieValue(Cookie[] cookies, String name){
	if(cookies == null){
		return null;
	}
	for(Cookie c:cookies){
		if(c.getName().equals(name)){ //쿠키의 이름을 가져와서 비교하는 작업
			return c.getValue();
		}
	}
	return null;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>이름 : <%=getCookieValue(cookies, "name") %></p>
<p>성별 : <%=getCookieValue(cookies, "gender") %></p>
<p>나이 : <%=getCookieValue(cookies, "age") %></p>

</body>
</html>