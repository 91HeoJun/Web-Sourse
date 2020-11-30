<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 섞어쓰기 방법 1 -->
	<h3>현재 시간은 <%=hour %> : <%=minute %> : <%=second %> </h3>
	<% if(hour >=12) { %>
		<h4>오후입니다.</h4>
	<% } else { %>
	<h4>오전입니다</h4>
	<% } %>
	
	<!-- 섞어쓰기 방법 2 -->
	<%
		if(hour >= 12) {
			out.print(" <h4>오후입니다.</h4> ");
		}else{
			out.print(" <h4>오전입니다.</h4> ");
		}
	%>
</body>
</html>
