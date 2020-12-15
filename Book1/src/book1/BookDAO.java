package book1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

// connection, CRUD

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javaDB";
			String password = "12345";
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// book insert
	public int bookInsert(int code, String title, String writer, int price) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if (con != null) {
			String sql = "insert into bookTBL(code, title, writer, price) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setString(2, title);
			pstmt.setString(3, writer);
			pstmt.setInt(4, price);
			
			result = pstmt.executeUpdate();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	} // insert 종료
	
	// 전체조회
	public List<BookVO> getList(){
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BookVO> list = new ArrayList<>();
			
		try {
			if (con != null) {
				
				String sql = "select * from bookTBL order by code desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
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
			try {
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;

		
	} // 전체조회 종료
	
	// delete form BookTBL where code = ?
	public int bookDelete(int code) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
				
		try {
			if(con != null) {
				String sql = "delete from BookTBL where code = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				result = pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	} // delete 종료
	
	public int bookUpdate(int price, int code) {
		// update BookTBL set price=? where code=?
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			if(con != null) {
				String sql = "update BookTBL set price=? where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, price);
				pstmt.setInt(2, code);
				result = pstmt.executeUpdate();
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
		return result;
	} // Update 종료
	
	public List<BookVO> bookSearch(String criteria, String keyword) {
		// 코드 2001 검색하기 / 작가 홍길동 검색
		// select * from bookTBL where code(int) / writer(String) = ? -> 필드명은 무조건 기입해야함!!
		// String sql = "select * from bookTBL where " + criteria + "= ?";
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="";
		List<BookVO> list = new ArrayList<BookVO>();
		
		try {
			if(con != null) {
					if(criteria.equals("writer")) {
						sql = "select * from bookTBL where writer = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, keyword);
				
					}else {
						sql = "select * from bookTBL where code = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(keyword));
					}
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	return list;

	}
	
}
