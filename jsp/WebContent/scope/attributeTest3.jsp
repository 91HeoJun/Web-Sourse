<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>영역과 속성 테스트</h2>
		<h3>Application 영역에 저장한 내용</h3>
		<%-- 유효기간 : 컨테이너의 주기와 동일(컨테이너 종료시 소멸) --%>
		<%-- 잘 안씀 --%>
		<ul> 
			<li>이름 : <%=application.getAttribute("name") %></li>
			<li>아이디 : <%=application.getAttribute("id") %></li>
		</ul>
		<h3>Session 영역에 저장한 내용</h3>
		<%-- 유효기간 : 브라우저 연결하고있는 동안 --%>
		<ul>
			<li>이메일 : <%=session.getAttribute("email") %></li>
			<li>주소 : <%=session.getAttribute("addr") %></li>
			<li>전화번호 : <%=session.getAttribute("tel") %></li>
		</ul>

</body>
</html>