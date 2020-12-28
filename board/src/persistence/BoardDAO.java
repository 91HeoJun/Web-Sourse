package persistence;

import static persistence.JDBCUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

public class BoardDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO(Connection con) {
		this.con = con;
	}

	// CRUD
	public int insert(BoardVO vo) {

		String sql = "insert into board(bno,name,password,title,content," + "attach,re_ref,re_lev,re_seq) "
				+ "values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";

		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getAttach());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 전체조회
//	public List<BoardVO> selectAll() {
//		String sql = "select bno, title, name, regdate, readcount, re_lev from board order by re_ref desc, re_seq asc";
//		List<BoardVO> list = new ArrayList<BoardVO>();
//
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				BoardVO vo = new BoardVO();
//
//				vo.setBno(rs.getInt("bno"));
//				vo.setTitle(rs.getString("title"));
//				vo.setName(rs.getString("name"));
//				vo.setRegdate(rs.getDate("regdate"));
//				vo.setReadcount(rs.getInt("readcount"));
//				vo.setRe_lev(rs.getInt("re_lev"));
//				
//				list.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//	}

//	// 검색기능
//	public List<BoardVO> searchAll(SearchVO searchVO){
//				
//		String sql = "select bno, title, name, regdate, readcount, re_lev from board where " + searchVO.getCriteria() + " like ? order by re_ref desc, re_seq asc";
//		List<BoardVO> search = new ArrayList<BoardVO>();
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, "%"+searchVO.getKeyword()+"%");
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				BoardVO vo = new BoardVO();
//				vo.setBno(rs.getInt("bno"));
//				vo.setTitle(rs.getString("title"));
//				vo.setName(rs.getString("name"));
//				vo.setRegdate(rs.getDate("regdate"));
//				vo.setReadcount(rs.getInt("readcount"));
//				vo.setRe_lev(rs.getInt("re_lev"));
//				
//				search.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return search;
//	}
	
	
	// 전체 행 수 가져오기
	// ex) 100개의 행 => 한페이지에 10개씩 => 1 ~ 10(1 2 3 4 5 6 7 8 9 10)
	//	    91개의 행 => 
	public int totalRows(String criteria, String keyword) {

		String sql = "";
		int totalRow = 0;

		try {
			if (!criteria.isEmpty()) {
				// 검색 조건에 맞는 행 수 구하기
				sql = "select count(*) from board where " +criteria+ " like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");

			} else {
				// 전체 게시물 대상
				sql = "select count(*) from board";
				pstmt = con.prepareStatement(sql);

			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalRow =rs.getInt(1); 
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return totalRow;
	}

	
	// search + list 구현
	public List<BoardVO> getList(SearchVO searchVO) {

//		select bno, title, name, regdate, readcount, re_lev
//		from(select rownum rnum, bno, title, name, regdate, readcount, re_lev
//				from (select bno, title, name, regdate, readcount, re_lev
//					from board
//					where bno > 0 order by re_ref desc, re_seq asc)
//			where rownum <= 20)
//		where rnum >10;

//		문자열 => String, StringBuffer, StringBuilder => append()
//				StringBuffer, StringBuilder => append()기능 들어있음

		int start = searchVO.getPage()*searchVO.getAmount();
		int limit = (searchVO.getPage()-1)*searchVO.getAmount();
		
		StringBuilder builder = new StringBuilder();
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {


			if (!searchVO.getCriteria().isEmpty()) { // 검색
//				sql = "select bno, title, name, regdate, readcount, re_lev from board where " + searchVO.getCriteria()
//						+ " like ? order by re_ref desc, re_seq asc";
				
				builder.append("select bno, title, name, regdate, readcount, re_lev");
				builder.append(" from(select rownum rnum, bno, title, name, regdate, readcount, re_lev");
				builder.append(" from (select bno, title, name, regdate, readcount, re_lev");
				builder.append(" from board");
				builder.append(" where bno > 0 and "+searchVO.getCriteria()+" like ?");
				builder.append(" order by re_ref desc, re_seq asc)");
				builder.append(" where rownum <= ?)");
				builder.append(" where rnum > ?");
				
				pstmt = con.prepareStatement(builder.toString());
				pstmt.setString(1, "%" + searchVO.getKeyword() + "%");
				pstmt.setInt(2, start); //(1-1)*10, 1*10
				pstmt.setInt(3, limit);

			} else { // 일반 리스트
				// sql = "select bno, title, name, regdate, readcount, re_lev from board order by re_ref desc, re_seq asc";

				builder.append("select bno, title, name, regdate, readcount, re_lev");
				builder.append(" from(select rownum rnum, bno, title, name, regdate, readcount, re_lev");
				builder.append(" from (select bno, title, name, regdate, readcount, re_lev");
				builder.append(" from board");
				builder.append(" where bno > 0 order by re_ref desc, re_seq asc)");
				builder.append(" where rownum <= ?)");
				builder.append(" where rnum > ?");

				pstmt = con.prepareStatement(builder.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, limit);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();

				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRe_lev(rs.getInt("re_lev"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	// 특정 번호 내용 조회
	public BoardVO select(int bno) {
		String sql = "select bno, name, title, content, attach, re_ref, re_lev, re_seq from board where bno = ?";
		BoardVO vo = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setAttach(rs.getString("attach"));

				// reply에서 필요한 값
				vo.setRe_ref(rs.getInt("re_ref"));
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setRe_seq(rs.getInt("re_seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}

	// 조회수 업데이트
	public int readCountUpdate(int bno) {
		String sql = "update board set readcount = readcount+1 where bno=?";

		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시글 삭제
	public int delete(int bno, String password) {
		String sql = "delete from board where bno=? and password=?";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 게시글 수정
	public int update(BoardVO vo) {
		int result = 0;

		try {
			if (vo.getAttach() != null) {
				String sql = "update board set title = ?, content = ?, attach = ? where bno = ? and password = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getAttach());
				pstmt.setInt(4, vo.getBno());
				pstmt.setString(5, vo.getPassword());

			} else {
				String sql = "update board set title = ?, content = ? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getBno());
				pstmt.setString(4, vo.getPassword());

			}

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 댓글
	public int reply(BoardVO vo) {
		int result = 0;

		try {
			// 원본 글 정보 가져오기
			int re_ref = vo.getRe_ref();
			int re_lev = vo.getRe_lev();
			int re_seq = vo.getRe_seq();

			// 원본 글에 달려있는 기존댓글 업데이트
			String sql = "update board set re_seq = re_seq+1 where re_ref=? and re_seq > ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();

			if (updateCount > 0) {
				commit(con);
			}
			close(pstmt);

			// 댓글 삽입
			sql = "insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)"
					+ "values(board_seq.nextval,?,?,?,?,null,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());

			pstmt.setInt(5, re_ref);
			pstmt.setInt(6, re_lev + 1);
			pstmt.setInt(7, re_seq + 1);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}