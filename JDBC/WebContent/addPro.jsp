<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//add.jsp에서 사용자 입력값 가져오기
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String birthyear =  request.getParameter("birthyear");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");

	//JDBC => Java와 DB를 연동하기 위한 기본구조
		
		// ↓ 스코프때문에 try 안에 있으면 con과 pstmt를 알 수 없어 선언을 try 밖에서 실행.
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
	try{
		//1. 드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		//2. 데이터베이스 연결을 위한 문자열 생성
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "javaDB";
		String password = "12345";
		//3. 커넥션
		con = DriverManager.getConnection(url, user, password);
		
		if(con != null){
		//4. sql 구문 생성
		String sql = "insert into userTBL";
		sql += " values(userTBL_seq.nextval,?,?,?,?)";
		
		/* ****************** String 안에 공백 넣을땐 제발 주의!!!!!!!!! *************** */
		
		//5. statement 생성 후 전송
		pstmt = con.prepareStatement(sql);
		// ?에 해당하는 값을 set
		pstmt.setString(1, username);
		pstmt.setInt(2, Integer.parseInt(birthyear));
		pstmt.setString(3, addr);
		pstmt.setString(4, mobile);
		
		//6. sql 구문 실행 후 결과 받기
		int result = pstmt.executeUpdate();
		
			//7. 처리 결과에 따라 페이지 이동
			if(result > 0){
				// 입력 성공
				response.sendRedirect("Index.jsp");
				
			}else {
				// 입력 실패
				response.sendRedirect("add.jsp");
			}
		}
		
	} catch(Exception e){
		e.printStackTrace();
		
	} finally{
		try{
			pstmt.close();
			con.close();
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
		
	}

%>