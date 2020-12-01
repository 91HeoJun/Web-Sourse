<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String weight = request.getParameter("weight");
String height = request.getParameter("height");
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> <%=name %>님의 결과  </h2>

<%
	if (name != null && weight != null && height != null){
		session.setAttribute("name", name);
		session.setAttribute("weight", weight);
		session.setAttribute("height", height);	
	}
%>

<ul>
	<li>몸무게 = <%=weight %>kg </li>
	<li>신장 = <%=height %>cm </li>
</ul>
<hr>
	<form action="OCFTest05_04Result2.jsp">
		<div>
			<label for="">비만도 측정 결과 포함 발송방법 선택</label>
			<input type="radio" name="Dsel" value="우편"/>우편
			<input type="radio" name="Dsel" value="휴대폰 문자"/>휴대폰 문자
			<input type="radio" name="Dsel" value="이메일"/>이메일
		</div>
		<input type="submit" value="확인" />
	
	</form>
</body>
</html>