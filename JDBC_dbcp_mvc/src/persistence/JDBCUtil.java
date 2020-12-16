package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {

	// 커넥션
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle");
			con = ds.getConnection();
			con.setAutoCommit(false); // 오토커밋 해제

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	} // 커넥션 종료

	// commit / rollback => DML(insert, update, delete)
	// 커밋
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 커밋 종료

	// 롤백
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 롤백 종료

	// 자원(Connection, PrepraredStatement, ResultSet) close 시작
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // Connection 종료

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // PrepraredStatement 종료

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // ResultSet 종료

}
