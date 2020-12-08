<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//select.jsp에서 넘긴 값 가져오기(no)
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
	//DB작업 - no에 해당하는 사람정보 가져오기
	Class.forName("oracle.jdbc.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "javaDB";
	String password = "12345";
	con = DriverManager.getConnection(url, user, password);
	if(con != null){
		String sql = "select * from userTBL where no =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();
			if(rs.next()){
				//가져온 정보를 form 안에 보여주기
				no = rs.getInt("no");
				String username = rs.getString("username");
				int birthyear = rs.getInt("birthyear");
				String addr = rs.getString("addr");
				String mobile = rs.getString("mobile");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style>
	.container{
		margin-top: 30px
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
  <a class="navbar-brand" href="#">JDBC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="Index.jsp">User 조회 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="add.jsp">User 추가</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="update.jsp">User 수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="delete.jsp">User 삭제</a>
      </li>
   
    </ul>
  </div>
</nav> <!--  nav 종료 -->

<div class="container">
<form action="updatePro.jsp" method="post">
  <div class="form-group">
    <label for="username">번호</label>
    <input type="text" class="form-control" name="no" id="no" autofocus value="<%=no %>" readonly>
  </div>
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" name="username" id="username" value="<%=username %>" readonly>
  </div>
  <div class="form-group">
    <label for="birthyear">태어난 연도</label>
    <input type="text" class="form-control" name="birthyear" id="birthyear" value="<%=birthyear %>" readonly>
  </div>
   <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" name="addr" id="addr" placeholder="변경할 주소를 입력하세요">
  </div>
   <div class="form-group">
    <label for="mobile">휴대폰 번호</label>
    <input type="text" class="form-control" name="mobile" id="mobile" placeholder="휴대폰 번호를 입력하세요">
  </div>
<button type="submit" class="btn btn-dark">수정</button>
<button type="button" class="btn btn-light">취소</button>

</form>
</div>
<%
			}		
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e){
		e.printStackTrace();
	}
}	

%>
</body>
</html>