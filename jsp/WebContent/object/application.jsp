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
// 내장객체 - application 객체(각 웹 어플리케이션 당 오직 하나만 생성)
//		 - 전체 어플리케이션 영역에서 공유해야 하는 정보를 처리
%>

	<ul>
		<li>JSP 버전 : <%=application.getMajorVersion() %>.<%=application.getMinorVersion() %> </li>
		<li>컨테이너 정보 : <%=application.getServerInfo() %></li>
		<li>웹 어플리케이션의 실제 파일시스템 경로 : <%=application.getRealPath("/") %></li>
	</ul>


</body>
</html>