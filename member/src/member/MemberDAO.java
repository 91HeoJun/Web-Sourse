package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	
	// 드라이버 로드
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			return DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 실패 시 리턴 값
		return null;
	}

	// 로그인 => userid, password가 일치해야 함
	public MemberVO isLogin(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		// select userid, name from member where userid =? and password=?;
		if (con != null) {
			try {
				String sql = "select userid, name from member where userid =? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();

				if(rs.next()) {
					member = new MemberVO();
					member.setUserid(rs.getString("userid"));
					member.setName(rs.getString("name"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}
		return member;
	}
	
	public int isJoin(MemberVO member) {
//	public int isJoin(MemberVO member String userid, String password, String name, String name, String gender, String email) {		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		if (con != null) {
			try {
				String sql = "insert into member(userid, password, name, gender, email) values(?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getUserid());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setString(5, member.getEmail());
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		return result;
		
	} // isJoin 종료

	public int isModify(String password, String userid) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		if(con != null) {
			try {
				String sql = "update member set password=? where userid=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, password);
				pstmt.setString(2, userid);
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return result;
	} // isModify 종료
	

}
