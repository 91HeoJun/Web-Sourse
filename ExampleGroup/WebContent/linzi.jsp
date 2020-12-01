<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
int result;
if(Fweight <= (normal+5)) {
	result = out.print("저체중입니다.");
} else {
	result = out.print("과체중입니다.");
}
%>
<!-- 	<li><%=Fname %>님의 비만도는 <%=Fat %> 포인트로 현재 <%=result %>입니다</li>  -->



</body>
</html>