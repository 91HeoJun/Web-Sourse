<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int selNum1 = Integer.parseInt(request.getParameter("num1"));
int selNum2 = Integer.parseInt(request.getParameter("num2"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>덧셈 결과</h2>

	<%
		int result = selNum1 + selNum2;

	out.print("<p>" + selNum1 + "+" + selNum2 + "=" + result + "</p>");

	
	%>
		<h3> <%=selNum1%> + <%=selNum2%> = <%=selNum1+selNum2%> </h3>

</body>
</html>