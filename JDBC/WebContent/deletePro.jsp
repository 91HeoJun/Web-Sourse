<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//select.jsp에서 넘긴 값 가져오기
request.setCharacterEncoding("utf-8");
int no = Integer.parseInt(request.getParameter("no"));

Class.forName("oracle.jdbc.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String user = "javaDB";
String password = "12345";
Connection con = DriverManager.getConnection(url, user, password);

PreparedStatement pstmt = null;

try {
	//no에 해당하는 user 삭제
	if (con != null) {
		String sql = "delete from userTBL where no = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);

		int result = pstmt.executeUpdate();
		if (result > 0) {

	//삭제가 성공하면 index.jsp로 이동
	response.sendRedirect("Index.jsp");

		} else {
	response.sendRedirect("select.jsp");
		}
	}

} catch (Exception e) {
	e.printStackTrace();

} finally {
	try {
		pstmt.close();
		con.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}
%>