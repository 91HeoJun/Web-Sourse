package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import domain.MemberVO;

import static persistence.JDBCUtil.*;

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	// 로그인 => userid, password가 일치해야 함
	public MemberVO isLogin(String userid, String password) {
		MemberVO member = null;

		// select userid, name from member where userid =? and password=?;
		if (con != null) {
			try {
				String sql = "select userid, name from member where userid =? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					member = new MemberVO();
					member.setUserid(rs.getString("userid"));
					member.setName(rs.getString("name"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return member;
	}

	public int isJoin(MemberVO member) {
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
				close(pstmt);
			}

		}
		return result;

	} // isJoin 종료

	public int isModify(String password, String userid) {
		int result = 0;

		if (con != null) {
			try {
				String sql = "update member set password=? where userid=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, password);
				pstmt.setString(2, userid);
				result = pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		return result;
	} // isModify 종료

	public int isTerminate(String userid, String password) {

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
				close(pstmt);
			}
		}
		return result;
	} // isTerminate 종료
	
	public boolean checkID(String userid) {
		boolean result = false;
		
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
				close(rs);
				close(pstmt);
		}
		return result;
	}
}
