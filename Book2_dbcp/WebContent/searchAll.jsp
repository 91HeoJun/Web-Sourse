<%@page import="domain.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BookVO> list = (List<BookVO>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">JDBC / Book</h1>
    <p class="lead">JDBC 기반의 Book(Model1)</p>
  </div>
</div>

<div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link" id="" data-toggle="pill" href="#insert" role="tab" aria-controls="v-pills-home" aria-selected="true">도서 정보 입력</a>
      <a class="nav-link" id="" data-toggle="pill" href="#all" role="tab" aria-controls="v-pills-profile" aria-selected="false">도서 목록 보기</a>
      <a class="nav-link" id="" data-toggle="pill" href="#delete" role="tab" aria-controls="v-pills-messages" aria-selected="false">도서 정보 삭제</a>
      <a class="nav-link active" id="v" data-toggle="pill" href="#search" role="tab" aria-controls="v-pills-settings" aria-selected="false">도서 정보 검색</a>
      <a class="nav-link" id="v" data-toggle="pill" href="#modify" role="tab" aria-controls="v-pills-settings" aria-selected="false">도서 정보 수정</a>
    </div>
  </div>
  
    <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade" id="insert" role="tabpanel" aria-labelledby="v-pills-home-tab"><jsp:include page="view/insert.jsp"></jsp:include></div>
      <div class="tab-pane fade" id="all" role="tabpanel" aria-labelledby="v-pills-home-tab"></div>
	  
  
      <div class="tab-pane fade" id="delete" role="tabpanel" aria-labelledby="v-pills-messages-tab"><jsp:include page="view/delete.jsp"></jsp:include></div>
      <div class="tab-pane fade show active" id="search" role="tabpanel" aria-labelledby="v-pills-settings-tab">
      	<table class="table">
	  	<thead class="table table-dark">
	    	<tr>
		      <th scope="col">code</th>
		      <th scope="col">제목</th>
		      <th scope="col">저자</th>
		      <th scope="col">가격</th>
		    </tr>
		  </thead>
		  <tbody>
		  <% for(BookVO vo:list){ %>
			  <tr>
			  	<td><%=vo.getCode() %></td>
			  	<td><%=vo.getTitle() %></td>
			  	<td><%=vo.getWriter() %></td>
			  	<td><%=vo.getPrice() %></td>
			  </tr>
		
		  <% } %>
		  </tbody>
		  </table>
	      
      </div>
      <div class="tab-pane fade" id="modify" role="tabpanel" aria-labelledby="v-pills-settings-tab"><jsp:include page="view/modify.jsp"></jsp:include></div>
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

<%-- <%@include file = "footer.jsp" %> --%>