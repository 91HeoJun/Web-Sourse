<%@page import="domain.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="persistence.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
		//List<UserVO> list = (List<UserVO>)request.getAttribute("list");
	%>

<div class="container">
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">이름t</th>
      <th scope="col">태어난 해</th>
      <th scope="col">주소</th>
      <th scope="col">핸드폰</th>
    </tr>
  </thead>
  <tbody>
  
    <c:forEach var="vo" items="${list}">
	<%
		//for(UserVO vo:list){
	%>
		<tr>
			<td>${vo.no}</td>
			<td><a href="select.do?no=${vo.no}">${vo.username}</a></td>
			<td>${vo.birthyear}</td>
			<td>${vo.addr}</td>
			<td>${vo.mobile}</td>
		</tr>
	<%
		//}
	%> 
	</c:forEach>
  </tbody>
</table>

</div>
</body>
</html>