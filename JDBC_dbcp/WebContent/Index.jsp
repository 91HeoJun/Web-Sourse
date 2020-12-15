<%@page import="jdbc.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "header.jsp" %>
<!-- <jsp:include page=""></jsp:include> -->

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
	<%
		UserDAO dao = new UserDAO();
		List<UserVO> list = dao.select();
		
		for(UserVO vo:list){
			// list를 UserVO 형태로 vo란 이름으로 불러옴
			// 향상된 for문 : for(데이터타입 변수명:배열명)
		
	%>
		<tr>
			<td><%=vo.getNo() %></td>
			<td><a href="select.jsp?no=<%=vo.getNo()%>"><%=vo.getUsername() %></a></td>
			<td><%=vo.getBirthyear() %></td>
			<td><%=vo.getAddr() %></td>
			<td><%=vo.getMobile() %></td>
		</tr>
	
	<%
	}
	
	%> 
  </tbody>
</table>

</div>
</body>
</html>