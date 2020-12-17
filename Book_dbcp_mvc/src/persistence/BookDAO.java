package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domain.BookVO;
import static persistence.JDBCUtil.*;

public class BookDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BookDAO(Connection con) {
		this.con = con;
	}

	// book insert
	public int bookInsert(BookVO vo) {
		int result = 0;
		try {
			if (con != null) {
				String sql = "insert into bookTBL(code, title, writer, price) values(?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getCode());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getWriter());
				pstmt.setInt(4, vo.getPrice());

				result = pstmt.executeUpdate();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	} // insert 종료

	// 전체조회
	public List<BookVO> getList() {
		List<BookVO> list = new ArrayList<>();

		try {
			if (con != null) {

				String sql = "select * from bookTBL order by code desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					BookVO vo = new BookVO();
					vo.setCode(rs.getInt("code"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setPrice(rs.getInt("price"));

					list.add(vo);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;

	} // 전체조회 종료

	// delete form BookTBL where code = ?
	public int bookDelete(int code) {
		int result = 0;
		try {
			if (con != null) {
				String sql = "delete from BookTBL where code = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	} // delete 종료

	public int bookUpdate(BookVO vo) {
		int result = 0;
		try {
			if (con != null) {
				String sql = "update BookTBL set price=? where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getPrice());
				pstmt.setInt(2, vo.getCode());
				result = pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	} // Update 종료

	public List<BookVO> bookSearch(String criteria, String keyword) {
		// 코드 2001 검색하기 / 작가 홍길동 검색
		// select * from bookTBL where code(int) / writer(String) = ? -> 필드명은 무조건
		// 기입해야함!!
		// String sql = "select * from bookTBL where " + criteria + "= ?";

		String sql = "";
		List<BookVO> list = new ArrayList<BookVO>();

		try {
			if (con != null) {
				if (criteria.equals("writer")) {
					sql = "select * from bookTBL where writer = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, keyword);

				} else {
					sql = "select * from bookTBL where code = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(keyword));
				}
				rs = pstmt.executeQuery();

				while (rs.next()) {
					BookVO vo = new BookVO();
					vo.setCode(rs.getInt("code"));
					vo.setTitle(rs.getString("title"));
					vo.setWriter(rs.getString("writer"));
					vo.setPrice(rs.getInt("price"));
					list.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
