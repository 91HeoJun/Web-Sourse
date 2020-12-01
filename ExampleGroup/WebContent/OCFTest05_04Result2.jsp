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
request.setCharacterEncoding("utf-8");
String Fname = (String)session.getAttribute("name");
String Fweight = (String)session.getAttribute("weight");
String Fheight = (String)session.getAttribute("height");
String FDsel = request.getParameter("Dsel");

%>

<%=Fname %>님의 결과내용을 <%=FDsel %>(으)로 발송합니다.
<br>
<hr>
<ul>
	<li>몸무게 = <%=Fweight %>kg </li>
	<li>신장 = <%=Fheight %>cm </li>
		
</ul>


</body>
</html>