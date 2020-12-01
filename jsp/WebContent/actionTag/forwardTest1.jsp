<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward Test 1</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
%>

<%-- jsp 액션 태그 : 자바코드 노출 최소화 --%>
<%-- ↓ pageCotext.forward(); 와 동일한 내용 ↓ --%>
<%-- param은 옵션이므로 안올 수 있음. --%>
<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
	<jsp:param name="tel" value="010-5524-6654" />
</jsp:forward>

</body>
</html>