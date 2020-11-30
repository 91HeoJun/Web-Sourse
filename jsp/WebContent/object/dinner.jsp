<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String[] menu = request.getParameterValues("dinner");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 선택한 오늘의 저녁메뉴</h3>
	<ul>
		<%
			for (String str : menu) {
			out.print(" <li>" + str + "</li> ");
		}
		%>

	</ul>


	<p>
		아이디 : <%=id%>
		비밀번호 : <%=pw%>
		비밀번호 확인 : <%=pwc%>
		이름 : <%=name%>
		성별 : <%=gender%>
		이메일 : <%=email%>
		
	</p>


</body>
</html>