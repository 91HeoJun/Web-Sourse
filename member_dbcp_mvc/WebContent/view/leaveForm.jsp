<%@page import="domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%
	//세션 가져오기 - 필요한 요소가 있을경우 상단에서 세션 불러와서 쓰기
	MemberVO member = (MemberVO)session.getAttribute("login");
%>

<form id="leaveform" action="../leave.do" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>회원탈퇴</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="text" name="userid" id="userid" class="form-control" value="<%=member.getUserid() %>" readonly/>
			 		<small id="userid" class="text-info"></small>		
				</div>
			</div>	
			<div class="form-group row justify-content-center">
				<div class="col-sm-10">	
					<input type="password" name="current_password" id = "current_password" class="form-control" placeholder="비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>
				</div>	
			</div>				
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">탈퇴</button>
			    <button type="button" class="btn btn-secondary" id="leavecancel">취소</button>		
			</div>
		</div>
	</div>		
</form>
<%--로그인 후 메뉴 스크립트--%>
<script src='../JS/menu.js'></script>

<%--버튼 클릭 이벤트 스크립트--%>
<script src='../JS/commend.js'></script>

<%--회원탈퇴 버튼 없애기 이벤트 스크립트--%>
<script>
	$(function(){
		$("#leave").detach();
	});
</script>

<%@ include file="../layout/footer.jsp" %>