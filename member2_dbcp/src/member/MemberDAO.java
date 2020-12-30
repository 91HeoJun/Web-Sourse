package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
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
	
	public int isTerminate(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		if (con != null) {
			try {
			String sql = "delete from member where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);

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
	} //isTerminate 종료
	
	// 중복 아이디
	public boolean checkID(String userid) {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid from member where userid=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
}
