package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.UserVO;
import static persistence.JDBCUtil.*;

public class UserDAO {
	// ~DAO : DB 작업을 담당하는 Class
	// jdbc : 드라이버 로드, 커넥션, CRUD(select, update, delete, insert)

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO(Connection con) {
		this.con = con;
	}

	// 3. CRUD
	// insert
	public int inset(String username, String birthyear, String addr, String mobile) {
		int result = 0;

		try {
			if (con != null) {
				// 4. sql 구문 생성
				String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";

				// 5. statement 생성 후 전송
				pstmt = con.prepareStatement(sql);
				// ?에 해당하는 값을 set
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(birthyear));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);

				// 6. sql 구문 실행 후 결과 받기
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	} // insert

	// Read
	// 전체 조회
	public List<UserVO> select() {
		ResultSet rs = null;
		List<UserVO> list = new ArrayList<UserVO>();

		try {
			if (con != null) {
				// 4. sql 구문 생성
				String sql = "select * from userTBL order by no desc";

				// 5. statement 생성 후 전송 : DB연결을 통해 sql 문을 수행해주는 클래스
				pstmt = con.prepareStatement(sql);

				// 6. sql 구문 실행 후 결과 받기 => select구문 : executeQuery() => ResultSet으로 반환
				// insert, update, delete 구문 : executeUpdate() => int로 반환
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// UserVO 객체생성
					UserVO user = new UserVO();
					user.setNo(rs.getInt("no")); // no(number) 데이터 타입 맞춰줄 것.
					user.setUsername(rs.getString("username")); // username(nchar)
					user.setBirthyear(rs.getInt("birthyear"));// birthYear(number)
					user.setAddr(rs.getString("addr")); // addr(NVARCHAR2)
					user.setMobile(rs.getString("mobile")); // mobile(NCHAR)
					list.add(user);
				} // while 종료
			} // if 종료
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	// 개별 조회

	public UserVO getUser(int no) {
		// DB 연결
		ResultSet rs = null;
		UserVO user = null;
		try {
			if (con != null) {
				String sql = "select * from userTBL where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					user = new UserVO();
					user.setNo(rs.getInt("no"));
					user.setUsername(rs.getString("username"));
					user.setBirthyear(rs.getInt("birthyear"));
					user.setAddr(rs.getString("addr"));
					user.setMobile(rs.getString("mobile"));
					
				} // if
			} // if
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}

	// Delete
	public int deleteUser(int no) {
		int result = 0;
		try {
			// no에 해당하는 user 삭제
			if (con != null) {
				String sql = "delete from userTBL where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				close(pstmt);
		}
		return result;
	}

	// Update
	public int updateUser(String addr, String mobile, int no) {
		int result = 0;

		try {
			if (con != null) {
				String sql = "update userTBL set addr = ?, mobile = ? where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, addr);
				pstmt.setString(2, mobile);
				pstmt.setInt(3, no);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
