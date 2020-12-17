package sevice;

import java.sql.Connection;
import java.util.List;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;


public class BookServiceImpl implements BookService {

	Connection con;
	BookDAO dao;
	
	public BookServiceImpl() {
		con = getConnection();
		dao = new BookDAO(con);
	}
	
	@Override
	public boolean insertBook(BookVO vo) {
		int result = dao.bookInsert(vo);
		
		boolean insertFlag = false;
		
		if (result > 0) {
			insertFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateBook(BookVO vo) {
		int result = dao.bookUpdate(vo);
		boolean updateFlag = false;
		
		if (result > 0) {
			updateFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

	@Override
	public boolean deleteBook(int code) {
		int result = dao.bookDelete(code);
		boolean deleteFlag = false;
		
		if (result > 0) {
			deleteFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleteFlag;
	}

	@Override
	public List<BookVO> getRows(String criteria, String keyword) {
		List<BookVO> list = dao.bookSearch(criteria, keyword);
		close(con);
		return list;

	}

	@Override
	public List<BookVO> getlList() {
		List<BookVO> list = dao.getList();
		close(con);
		return list;
	}

}
